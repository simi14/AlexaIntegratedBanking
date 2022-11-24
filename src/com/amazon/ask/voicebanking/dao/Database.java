package com.amazon.ask.voicebanking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.ask.voicebanking.model.AccountDocumentVO;
import com.amazon.ask.voicebanking.model.AccountVO;
import com.amazon.ask.voicebanking.model.BankingFormVO;
import com.amazon.ask.voicebanking.model.BranchVO;
import com.amazon.ask.voicebanking.model.DocumentsVO;
import com.amazon.ask.voicebanking.model.LoanDocumentVO;
import com.amazon.ask.voicebanking.model.LoanRateVO;
import com.amazon.ask.voicebanking.model.LoanTypeVO;


public class Database {

	static Connection cn=null;
	//configure database accordingly
	static final String HOSTNAME="---database---";
	static final String USERNAME="-----";
	static final String PASSWORD="--------";
	
	public static Statement connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
			Statement s = cn.createStatement();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//  :::::::::::::::::::::::::::ACCOUNT DETAILS:::::::::::::::::::::::::::::::::::
//  :::::::::::::::::::::::::::ACCOUNT DETAILS:::::::::::::::::::::::::::::::::::
	public List searchAccountname() {
		List listForaccountname = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from account where account_status = true");

			while (rs.next()) {
				AccountVO accountVO = new AccountVO();
				String account_name = rs.getString("account_name");

				accountVO.setAccount_name(account_name);
				listForaccountname.add(accountVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listForaccountname;
	}
	
	public boolean searchByAccountname(String account) {
		List listForaccountname = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from account where account_status = true AND account_name='" + account + "' ");

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int accountidByName(String account_name) {
		System.out.println("::::::::::: accountidByName ::::::::: " + account_name);
		int accountid = 0;
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select account_id from account where account_name='" + account_name + "'");

			while (rs.next()) {
				accountid = rs.getInt("account_id");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("::::::::::: accountidByName ::::::::: " + accountid);
		return accountid;
	}
	
	public String accountNameById(int account_id) {
		System.out.println("::::::::::: accountNameById ::::::::: " + account_id);
		String account_name = "";
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from account where account_id=" + account_id);

			while (rs.next()) {
				account_name = rs.getString("account_name");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("::::::::::: accountNameById ::::::::: " + account_name);
		return account_name;
	}
	
	public BankingFormVO formByName(String name) {
		System.out.println("::::::::::: Form of ::::::::: " + name);
		BankingFormVO bankingFormVO=new BankingFormVO();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from bankingforms where bankingForm_name='" + name+"'");

			while (rs.next()) {
				String fileLink = rs.getString("bankingForm_link");
				System.out.println(fileLink);
				bankingFormVO.setBankingFormlink(fileLink);
				bankingFormVO.setBankingFormName(name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bankingFormVO;
	}
	
	public List searchAccountdetails(int accountid) {
		List listforaccountdetails = new ArrayList();

		System.out.println(":::::::::::: searchAccountdetails :::::::::: "+accountid);

		try {

			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from account where (account_status = true AND account_id='" + accountid + "') ");

			while (rs.next()) {

				AccountVO accountVO = new AccountVO();
				String accountDetails = rs.getString("account_description");
				String accountRate = rs.getString("account_rate");
				String accountName=rs.getString("account_name");
				String accountMinBalance =rs.getString("account_minBalance");
				String debitCard = rs.getString("account_debitCardCharge");
				String cashDeposit = rs.getString("account_cashDepositLimit");
				String smsCharge = rs.getString("account_smsCharge");
				
				accountVO.setAccount_name(accountName);
				accountVO.setAccount_cashDepositLimit(cashDeposit);;
				accountVO.setAccount_debitCardCharge(debitCard);
				accountVO.setAccount_description(accountDetails);
				accountVO.setAccount_rate(accountRate);
				accountVO.setAccount_minBalance(accountMinBalance);
				accountVO.setAccount_smsCharge(smsCharge);
				
				listforaccountdetails.add(accountVO);
				

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(":::::::::::: searchAccountSize :::::::::: "+listforaccountdetails.size());
		return listforaccountdetails;
	}
	public List searchAccountdocs(int id) {
		List listforaccountdocs = new ArrayList();

		System.out.println(":::::::::::: searchAccountdocs :::::::::: "+id);

		try {

			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from accountdocuments where accountDocument_status = true AND account_id=" + id );

			while (rs.next()) {

				AccountDocumentVO accountDocumentVO = new AccountDocumentVO();
				int doc_id = rs.getInt("document_id");
				
				DocumentsVO documentsVO=new DocumentsVO();
				documentsVO.setDocument_id(doc_id);
				String doc_name=searchByDocumentId(doc_id);
				System.out.println(doc_name);
				documentsVO.setDocument_name(doc_name);
				listforaccountdocs.add(documentsVO);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(":::::::::::: searchAccountdocs :::::::::: "+listforaccountdocs.size());
		return listforaccountdocs;
	}
	public String loanNameById(int loan_id) {
		System.out.println("::::::::::: loanNameById ::::::::: " + loan_id);
		String loan_name = "";
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from loantype where loantype_status=true and loantype_id=" + loan_id);

			while (rs.next()) {
				loan_name = rs.getString("loantype_name");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("::::::::::: loanName ::::::::: " + loan_name);
		return loan_name;
	}
	public List searchLoanname() {
		List listForloanname = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from loantype where loantype_status = true");

			while (rs.next()) {
				LoanTypeVO loanTypeVO = new LoanTypeVO();
				String loantype_name = rs.getString("loantype_name");

				loanTypeVO.setLoantype_name(loantype_name);
				listForloanname.add(loanTypeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listForloanname;
	}

	public boolean searchByLoanName(String loan) {
		
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from loantype where loantype_status = true AND loantype_name='" + loan + "' ");

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int loanidByName(String loan_name) {
		System.out.println("::::::::::: loanidByName ::::::::: " + loan_name);
		int id = 0;
		try {
			Statement s = connection();
			System.out.println("select loantype_id from loantype where loantype_name='"+loan_name+"'");
			ResultSet rs = s.executeQuery("select loantype_id from loantype where loantype_name='"+loan_name+"'");

			while (rs.next()) {
				id = rs.getInt("loantype_id");
				System.out.println("Inside result set::::::::::"+id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("::::::::::: loanidByName ::::::::: " + id);
		return id;
	}
	
	public String loanDescriptionById(int loan_id) {
		System.out.println("::::::::::: loanid ::::::::: " + loan_id);
		String desc = "";
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select loantype_description from loantype where loantype_id=" +loan_id);

			while (rs.next()) {
				desc = rs.getString("loantype_description");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;
	}
	
	public List searchLoandetails(int id) {
		List listforloandetails = new ArrayList();

		System.out.println(":::::::::::: searchLoandetails :::::::::: "+id);

		try {

			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from loanrate where (loanRate_status = true AND loantype_id='" + id + "') ");

			while (rs.next()) {

				LoanRateVO loanRateVO = new LoanRateVO();
				String loaninterest = rs.getString("loanRate_rate");
				String tenure =rs.getString("loanRate_tenure");
				String max_amount = rs.getString("loanRate_maxAmount");
				
				loanRateVO.setLoanRate_rate(loaninterest);
				loanRateVO.setLoanRate_tenure(tenure);
				loanRateVO.setLoanRate_maxAmount(max_amount);
				
				listforloandetails.add(loanRateVO);
				

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(":::::::::::: searchLoandetails :::::::::: "+listforloandetails.size());
		return listforloandetails;
	}
	
	public List searchLoandocs(int id) {
		List listforloandocs = new ArrayList();

		System.out.println(":::::::::::: searchLoandocs :::::::::: "+id);

		try {

			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from loandocuments where loanDocument_status = true AND loanType_id=" + id );

			while (rs.next()) {

				LoanDocumentVO loanDocumentVO = new LoanDocumentVO();
				int doc_id = rs.getInt("document_id");
				
				DocumentsVO documentsVO=new DocumentsVO();
				documentsVO.setDocument_id(doc_id);
				String doc_name=searchByDocumentId(doc_id);
				System.out.println(doc_name);
				documentsVO.setDocument_name(doc_name);
				listforloandocs.add(documentsVO);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(":::::::::::: searchLoandocs :::::::::: "+listforloandocs.size());
		return listforloandocs;
	}
	
	public String searchByDocumentId(int id) {
		System.out.println(":::::::::::: DocumentId :::::::::: "+id);

		String doc_name="";
		try {

			Statement s = connection();
			ResultSet rs = s.executeQuery("select document_name from documents where document_status = true AND document_id=" + id );

			while (rs.next()) {

				doc_name = rs.getString("document_name");
				return doc_name;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return doc_name;
	}
	
	public List searchBranch(String area) {
		System.out.println("::::::::::::Area:::::::::: "+area);
		List listofbranch = new ArrayList();

		try {

			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from branch where branch_status = true AND branch_name='" + area+"'" );

			while (rs.next()) {

				BranchVO branchVO=new BranchVO();
				String branch_address=rs.getString("branch_address");
				branchVO.setBranchAddress(branch_address);
				listofbranch.add(branchVO);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return listofbranch;
	}
	
	public static void main(String[] args){
		Database jdbcMethod = new Database();
		List<DocumentsVO> list1=jdbcMethod.searchLoandocs(6);
		
		
		 String speech = "";
	        
	        
	        for(int i=0;i<list1.size();i++)
	        {
	        	
					speech = speech + " , "+ list1.get(i).getDocument_name();	
					//System.out.println("in get i"+speech);
	        }

	        System.out.println("DATA ::::: " + speech);
		
	}
	
}
