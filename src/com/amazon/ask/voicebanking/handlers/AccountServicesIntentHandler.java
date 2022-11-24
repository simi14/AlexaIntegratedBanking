package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.voicebanking.dao.Database;
import com.amazon.ask.voicebanking.model.AccountVO;

public class AccountServicesIntentHandler implements RequestHandler{
	    
	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("AccountServicesIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	    	Database db=new Database();
	    	List<AccountVO> accountNameList=db.searchAccountname();
	    	String speechText="Our banks works with ";
	    	for(int i=0;i<accountNameList.size();i++)
	    	{
	    		if(i!=accountNameList.size()-1)
	    		{
	    		speechText=speechText+accountNameList.get(i).getAccount_name()+", ";
	    		}
	    		else
	    		{
	    			speechText=speechText+accountNameList.get(i).getAccount_name();
	    		}
	    	}
	    	speechText=speechText+" . How can i help you? To know about specific account, say 'I want to know about account name'";
	    	 
         String repromptText = "How can i help you? To know about specific account, say 'I want to know about account name'";
	         return input.getResponseBuilder()
	                 .withSimpleCard("BankingSession", speechText)
	                 .withSpeech(speechText)
	                 .withReprompt(repromptText)
	                 .build();
	    }
}
