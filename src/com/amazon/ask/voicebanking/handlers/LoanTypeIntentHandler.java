package com.amazon.ask.voicebanking.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Collections;
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

public class LoanTypeIntentHandler implements RequestHandler{
	public static final String LOANTYPEID_KEY ="LOANTYPEKEY" ;
    public static final String LOANTYPENAME_SLOT = "LoanType";
    
 @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("LoanTypeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        // Get the color slot from user input.
        Slot loanTypeSlot = slots.get(LOANTYPENAME_SLOT);
        String speechText, repromptText;

        // Check for favorite color and create output to user.
       
            // Store the user's favorite color in the Session and create response.
           String loanType = loanTypeSlot.getValue();
           System.out.println("Loan Type Name::::::::::::"+loanType);
            if(loanType != null && !loanType.isEmpty()){
            	Database db1=new Database();
            	
            	HashMap<String,Integer> map=new HashMap<String,Integer>();
            int loanTypeId=db1.loanidByName(loanType);
            System.out.println("Loan Type Id:::::::::"+loanTypeId);
        	map.put(LOANTYPEID_KEY, loanTypeId);
        	
        	
            System.out.println("Loan Type: ::::: "+ loanType);

            boolean flag=db1.searchByLoanName(loanType);
            if(flag==true)
            {
            	input.getAttributesManager().setSessionAttributes(Collections.singletonMap("LoanTypeKey", map));
            speechText =
                    String.format("For "+loanType+", To get loan say 'Get Loan', To know all about it say 'Loan Details', for loan rate say 'Loan Rate', for documents required say 'Loan Documents'.");
            repromptText =
                    "To get loan say 'Get Loan', To know all about it say 'Loan Details', for loan rate say 'Loan Rate', for documents required say 'Loan Documents'.";

            }
            else
            {
            	speechText="Please enter valid loan type";
            	repromptText ="Please enter valid loan type";
            }
        }else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "Please provide loan type";
            repromptText =
            		"Please provide loan type ";
        }

        return input.getResponseBuilder()
                .withSimpleCard("EmailSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
