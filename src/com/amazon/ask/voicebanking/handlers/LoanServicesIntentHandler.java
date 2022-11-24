package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.voicebanking.dao.Database;
import com.amazon.ask.voicebanking.model.LoanTypeVO;

public class LoanServicesIntentHandler implements RequestHandler {

	   
		 @Override
		    public boolean canHandle(HandlerInput input) {
		        return input.matches(intentName("LoanServicesIntent"));
		    }

		    @Override
		    public Optional<Response> handle(HandlerInput input) {
		    	Database db=new Database();
		    	List<LoanTypeVO> loanNameList=db.searchLoanname();
		    	String speechText="Our banks works with ";
		    	for(int i=0;i<loanNameList.size();i++)
		    	{
		    		if(i!=loanNameList.size()-1)
		    		{
		    		speechText=speechText+loanNameList.get(i).getLoantype_name()+",";
		    		}
		    		else
		    		{
		    			speechText=speechText+loanNameList.get(i).getLoantype_name();
		    		}
		    	}
		    	speechText=speechText+" Services. How can i help you? To know about specific Loan, say 'About **Loan Name' ";
		    	 
	         String repromptText = " How can i help you? To know about specific Loan, say 'About **Loan Name'";
		         return input.getResponseBuilder()
		                 .withSimpleCard("BankingSession", speechText)
		                 .withSpeech(speechText)
		                 .withReprompt(repromptText)
		                 .build();
		    }
}
