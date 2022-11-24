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

public class AccountDocsIntentHandler implements RequestHandler {

	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("AccountDocsIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	        Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        HashMap<String,Integer> map= (HashMap<String, Integer>) input.getAttributesManager().getSessionAttributes().get("AccountNameKey");
	        String speechText="", repromptText="";

	        int accountId=map.get("ACCOUNTKEY");
	        System.out.println("Account ID details::::::::::::"+accountId);
	        if(accountId!=0)
	        {
	        Database db=new Database();
	        List<DocumentsVO> accountDocsList=db.searchAccountdocs(accountId);
	        speechText=speechText+"Documents required to open Account are ";
	    	for(int i=0;i<accountDocsList.size();i++)
	    	{
	    		if(i!=accountDocsList.size()-1)
	    		{
	    			speechText=speechText+accountDocsList.get(i).getDocument_name()+", ";
	    		}
	    		else
	    		{
	    			speechText=speechText+accountDocsList.get(i).getDocument_name()+". ";
	    		}
	    	}
	    	speechText=speechText+"To open account say 'Open Account'.";
	    	repromptText="How can I help you? ";
	        }
	        else
	        {
	        	speechText="Please enter account name";
         	repromptText ="Please enter account name";
	        }
	        return input.getResponseBuilder()
	                .withSimpleCard("EmailSession", speechText)
	                .withSpeech(speechText)
	                .withReprompt(repromptText)
	                .withShouldEndSession(false)
	                .build();
	    }
}
