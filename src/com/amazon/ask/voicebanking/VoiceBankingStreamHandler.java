/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.voicebanking;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.voicebanking.handlers.AccountDetailsIntentHandler;
import com.amazon.ask.voicebanking.handlers.AccountDocsIntentHandler;
import com.amazon.ask.voicebanking.handlers.AccountRateIntentHandler;
import com.amazon.ask.voicebanking.handlers.AccountServicesIntentHandler;
import com.amazon.ask.voicebanking.handlers.AccountTypeIntentHandler;
import com.amazon.ask.voicebanking.handlers.BranchIntentHandler;
import com.amazon.ask.voicebanking.handlers.CancelandStopIntentHandler;
import com.amazon.ask.voicebanking.handlers.FallbackIntentHandler;
import com.amazon.ask.voicebanking.handlers.GetBranchIntentHandler;
import com.amazon.ask.voicebanking.handlers.GetLoanIntentHandler;
import com.amazon.ask.voicebanking.handlers.HelpIntentHandler;
import com.amazon.ask.voicebanking.handlers.LaunchRequestHandler;
import com.amazon.ask.voicebanking.handlers.LoanDetailsIntentHandler;
import com.amazon.ask.voicebanking.handlers.LoanDocsIntentHandler;
import com.amazon.ask.voicebanking.handlers.LoanRateIntentHandler;
import com.amazon.ask.voicebanking.handlers.LoanServicesIntentHandler;
import com.amazon.ask.voicebanking.handlers.LoanTypeIntentHandler;
import com.amazon.ask.voicebanking.handlers.OpenAccountIntentHandler;
import com.amazon.ask.voicebanking.handlers.SendAccountFormIntentHandler;
import com.amazon.ask.voicebanking.handlers.SendLoanFormIntentHandler;
import com.amazon.ask.voicebanking.handlers.SessionEndedRequestHandler;

public class VoiceBankingStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                		new AccountDetailsIntentHandler(),
                		new AccountServicesIntentHandler(),
                		new AccountTypeIntentHandler(),
                		new AccountRateIntentHandler(),
                		new AccountDocsIntentHandler(),
                		new OpenAccountIntentHandler(),
                		new SendAccountFormIntentHandler(),
                		new BranchIntentHandler(),
                		new GetBranchIntentHandler(),
                		new GetLoanIntentHandler(),
                		new SendLoanFormIntentHandler(),
                		new LoanRateIntentHandler(),
                		new LoanDocsIntentHandler(),
                		new LoanDetailsIntentHandler(),
                		new LoanServicesIntentHandler(),
                		new LoanTypeIntentHandler(),
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler())
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public VoiceBankingStreamHandler() {
        super(getSkill());
    }

}
