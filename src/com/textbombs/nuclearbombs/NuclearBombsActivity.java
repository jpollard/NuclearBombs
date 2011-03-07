package com.textbombs.nuclearbombs;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NuclearBombsActivity extends Activity {
	private EditText contactsEditText;
	private EditText numberEditText;
	private EditText messageEditText;
	private Button sendButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        contactsEditText = (EditText) findViewById(R.id.contactsEditText);
        numberEditText = (EditText) findViewById(R.id.numberEditText);
        messageEditText = (EditText) findViewById(R.id.messageEditText);
        sendButton = (Button) findViewById(R.id.sendButton);
        
        // TODO setup contacts list when adding to contactsEditText
        sendButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String contactsNumber = contactsEditText.getText().toString();
				String message = messageEditText.getText().toString();
				String numberOfSms = numberEditText.getText().toString();
				int numberOfSmsInt = 0;
				
				/*
				 *  Convert the numberOfSms string to int
				 */
				try{
					numberOfSmsInt = Integer.parseInt(numberOfSms.trim());
				} catch(NumberFormatException e){
					// TODO setup a toast for the exception
				}
				
				if(contactsNumber.length() > 0 && message.length() > 0 && numberOfSms.length() > 0){
					sendSms(contactsNumber, message, numberOfSmsInt);
				}	
			}
        });
    }

    private void sendSms(String contactsNumber, String message, int numberOfSms){
    	// TODO start a new thread to send the SMS
    	SmsManager sms = SmsManager.getDefault();
    	
    	for(int i = 0; i < numberOfSms; i++){
       		sms.sendTextMessage(contactsNumber, null, message, null, null);
    	}
    }
}