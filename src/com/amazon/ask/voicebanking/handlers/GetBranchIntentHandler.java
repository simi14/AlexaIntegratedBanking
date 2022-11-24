package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

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
import com.amazon.ask.voicebanking.utils.BaseMethods;

public class GetBranchIntentHandler implements RequestHandler {

	 public static final String AREA_KEY = "AREA";
	    public static final String AREA_SLOT = "Area";
	    
	 @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("GetBranchIntent"));
	    }
	 @Override
	    public Optional<Response> handle(HandlerInput input) {
	    	 Request request = input.getRequestEnvelope().getRequest();
		        IntentRequest intentRequest = (IntentRequest) request;
		        Intent intent = intentRequest.getIntent();
		        Map<String, Slot> slots = intent.getSlots();
		        // Get the color slot from user input.
		        Slot areaSlot = slots.get(AREA_SLOT);

	       /* boolean noAnswerProvided = false;*/
	        System.out.println("value::::::::::"+areaSlot.getValue());
	        String area = areaSlot.getValue();
	        String speechText="",repromptText="";
	        Database obj=new Database();
	        List<BranchVO> listofBranch=obj.searchBranch(area);
	        if(listofBranch!=null)
	        {
	        	speechText=speechText+"The address of branches in "+area+" are ";
	        for(int i=0;i<listofBranch.size();i++)
	    	{
	        	if(i!=listofBranch.size()-1)
	        	{
	        	speechText=speechText+listofBranch.get(i).getBranchAddress()+"; ";
	        	}
	        	else
	        	{
	        		speechText=speechText+listofBranch.get(i).getBranchAddress()+". ";
	        	}
	    	}
	    	repromptText="How can I help you? ";
	        }
	 		
	        else {
	            // Since the user's name is not set render an error message.
	            speechText =
	                    "Our bank has no branch in this area.";
	            repromptText="Our bank has no branch in this area.";
	            /*noAnswerProvided = true;*/
	        }

	        return input.getResponseBuilder()
	                .withSimpleCard("EmailSession", speechText)
	                .withSpeech(speechText)
	                .withShouldEndSession(false)
	                .build();

	    }

}
