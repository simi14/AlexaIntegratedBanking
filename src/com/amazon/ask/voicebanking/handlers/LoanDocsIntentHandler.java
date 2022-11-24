package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.voicebanking.dao.Database;
import com.amazon.ask.voicebanking.model.DocumentsVO;

public class LoanDocsIntentHandler implements RequestHandler{

	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("LoanDocsIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	        Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        HashMap<String,Integer> map= (HashMap<String, Integer>) input.getAttributesManager().getSessionAttributes().get("LoanTypeKey");
	        String speechText="", repromptText="";

	        int loanTypeId=map.get("LOANTYPEKEY");
	        if(loanTypeId!=0)
	        {
	        System.out.println("Loan ID details::::::::::::"+loanTypeId);
	        Database db=new Database();
	        List<DocumentsVO> loanDocsList=db.searchLoandocs(loanTypeId);
	        speechText=speechText+"Documents required to get Loan are ";
	    	for(int i=0;i<loanDocsList.size();i++)
	    	{
	    		if(i!=loanDocsList.size()-1)
	    		{
	    			speechText=speechText+loanDocsList.get(i).getDocument_name()+", ";
	    		}
	    		else
	    		{
	    			speechText=speechText+loanDocsList.get(i).getDocument_name()+". ";
	    		}
	    	}
	    	speechText=speechText+"To get loan say Get Loan.";
	    	repromptText="How can I help you ?";
	        }
	        else
	        {
	        	speechText="Please enter loan type";
         	repromptText ="Please enter loan type";
	        	
	        }
	        return input.getResponseBuilder()
	                .withSimpleCard("EmailSession", speechText)
	                .withSpeech(speechText)
	                .withReprompt(repromptText)
	                .withShouldEndSession(false)
	                .build();
	    }

}
