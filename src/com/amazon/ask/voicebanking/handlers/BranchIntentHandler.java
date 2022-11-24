package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.HashMap;
import java.util.List;
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
import com.amazon.ask.voicebanking.model.BranchVO;
import com.amazon.ask.voicebanking.model.LoanRateVO;

public class BranchIntentHandler implements RequestHandler{

	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("BranchIntent"));
	    }
	 @Override
	    public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		String speechText = "", repromptText = "";
		speechText = "Please enter area by saying '*** Area'";

		repromptText = "Please enter area by saying '*** Area'";

		return input.getResponseBuilder().withSimpleCard("EmailSession", speechText).withSpeech(speechText)
				.withShouldEndSession(false) 
				.build();

	    }

}
