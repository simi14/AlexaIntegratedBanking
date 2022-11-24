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

public class AccountTypeIntentHandler implements RequestHandler{
	public static final String ACCOUNTID_KEY ="ACCOUNTKEY" ;
    public static final String ACCOUNTNAME_SLOT = "AccountName";
    
 @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AccountTypeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        // Get the color slot from user input.
        Slot accountNameSlot = slots.get(ACCOUNTNAME_SLOT);
        String speechText, repromptText;

        // Check for favorite color and create output to user.
       
            // Store the user's favorite color in the Session and create response.
           String accountName = accountNameSlot.getValue();
           System.out.println("Account Type Name::::::::::::"+accountName);
            if(accountName != null && !accountName.isEmpty()){
            	Database db1=new Database();
            	
            	HashMap<String,Integer> map=new HashMap<String,Integer>();
            int accountId=db1.accountidByName(accountName);
            System.out.println("Account Type Id:::::::::"+accountId);
        	map.put(ACCOUNTID_KEY, accountId);
        	
            System.out.println("Account Name: ::::: "+ accountName);
            boolean flag=db1.searchByAccountname(accountName);
            if(flag==true)
            {		
            	input.getAttributesManager().setSessionAttributes(Collections.singletonMap("AccountNameKey", map));
            speechText =
                    String.format("For "+accountName+", To open account, say 'Open Account', To know all about it, say 'Account Details', for interest rate, say 'Interest rate', for Minimum Balance Required say 'Minimum Balance', for documents required say 'Account Documents'.");
            repromptText =
                    " To know all about it, say 'Account Details', for interest rate, say 'Interest rate', for Minimum Balance Required say 'Minimum Balance', for documents required say 'Account Documents'.";

            }
            else
            {
            	speechText="Please enter valid account name";
            	repromptText ="Please enter valid account name";
            }
        }else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "Please provide account name";
            repromptText =
            		"Please provide account name ";
        }

        return input.getResponseBuilder()
                .withSimpleCard("EmailSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
