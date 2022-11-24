package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.voicebanking.dao.Database;
import com.amazon.ask.voicebanking.utils.BaseMethods;

public class SendLoanFormIntentHandler implements RequestHandler{

	public static final String MAIL_KEY = "MAILKEY";
	public static final String MAIL_SLOT = "Mail";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SendLoanFormIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		// Get the color slot from user input.
		Slot emailSlot = slots.get(MAIL_SLOT);
		String speechText = "", repromptText = "";
		String email = emailSlot.getValue();
		String finalEmail="";
		System.out.println("Email::::::::::::" + email);
		if (email != null && !email.isEmpty()) {
			String email1[]=email.split(" ");
			for(int i=0;i<email1.length;i++)
			{
				System.out.println(email1[i]);
				if(email1[i].equalsIgnoreCase("at"))
				{
					finalEmail=finalEmail+"@";
				}
				else if(email1[i].equalsIgnoreCase("dot"))
				{
					finalEmail=finalEmail+".";
				}
				else
				{
					finalEmail=finalEmail+email1[i];
				}
			}
			finalEmail=finalEmail.toLowerCase();
			System.out.println("FinalEmailId::::::::::"+finalEmail);
			Database db1 = new Database();
			HashMap<String, Integer> map = (HashMap<String, Integer>) input.getAttributesManager().getSessionAttributes().get("LoanTypeKey");
			int loanTypeId = map.get("LOANTYPEKEY");
			System.out.println("::::::::::::::loanTypeId::::::::"+loanTypeId);
			String loanType = db1.loanNameById(loanTypeId);
			System.out.println("::::::::loanType::::::::"+loanType);
			if (loanTypeId != 0) {
				BaseMethods b=new BaseMethods();
		        b.sendMail(finalEmail,loanType);
				speechText = "Please check your mail box";
				repromptText = "Please check your mail box";
			} else {

				speechText = "Please provide account name";
				repromptText = "Please provide account name ";
			}
		} else {
			// Render an error since user input is out of list of color defined
			// in interaction model.
			speechText = "Please provide your email id";
			repromptText = "Please provide your email id ";
		}

		return input.getResponseBuilder().withSimpleCard("EmailSession", speechText).withSpeech(speechText)
				.withReprompt(repromptText).withShouldEndSession(false).build();
	}
}
