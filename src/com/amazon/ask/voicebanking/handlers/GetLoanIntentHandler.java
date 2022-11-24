package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.HashMap;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;

public class GetLoanIntentHandler implements RequestHandler{
	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("GetLoanIntent"));
	    }

	 @Override
	    public Optional<Response> handle(HandlerInput input) {
	        Request request = input.getRequestEnvelope().getRequest();
	        IntentRequest intentRequest = (IntentRequest) request;
	        Intent intent = intentRequest.getIntent();
	        HashMap<String,Integer> map= (HashMap<String, Integer>) input.getAttributesManager().getSessionAttributes().get("LoanTypeKey");
	        String speechText="", repromptText="";

	        int loanTypeId=map.get("LOANTYPEKEY");
	        System.out.println("Loan ID details::::::::::::"+loanTypeId);
	        if(loanTypeId!=0)
	        {
	        	speechText="Please enter your mail id by saying '**** is my email'";
	        	repromptText ="Please enter your mail id by saying '**** is my email'";
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
