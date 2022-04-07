package com.nourmedhat.testpaymob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.paymob.acceptsdk.IntentConstants;
import com.paymob.acceptsdk.PayActivity;
import com.paymob.acceptsdk.PayActivityIntentKeys;
import com.paymob.acceptsdk.PayResponseKeys;
import com.paymob.acceptsdk.SaveCardResponseKeys;
import com.paymob.acceptsdk.ThreeDSecureWebViewActivty;
import com.paymob.acceptsdk.ToastMaker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;

    // Arbitrary number and used only in this activity. Change it as you wish.
    static final int ACCEPT_PAYMENT_REQUEST = 10;

    // Replace this with your actual payment key
    final String paymentKey = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SjFjMlZ5WDJsa0lqb3pOVFUxTENKdmNtUmxjbDlwWkNJNk5qRXpNams0TUN3aVkzVnljbVZ1WTNraU9pSkZSMUFpTENKcGJuUmxaM0poZEdsdmJsOXBaQ0k2TkRnMU9Dd2liRzlqYTE5dmNtUmxjbDkzYUdWdVgzQmhhV1FpT21aaGJITmxMQ0ppYVd4c2FXNW5YMlJoZEdFaU9uc2labWx5YzNSZmJtRnRaU0k2SWtOc2FXWm1iM0prSWl3aWJHRnpkRjl1WVcxbElqb2lUbWxqYjJ4aGN5SXNJbk4wY21WbGRDSTZJa1YwYUdGdUlFeGhibVFpTENKaWRXbHNaR2x1WnlJNklqZ3dNamdpTENKbWJHOXZjaUk2SWpReUlpd2lZWEJoY25SdFpXNTBJam9pT0RBeklpd2lZMmwwZVNJNklrcGhjMnR2YkhOcmFXSjFjbWRvSWl3aWMzUmhkR1VpT2lKVmRHRm9JaXdpWTI5MWJuUnllU0k2SWtOU0lpd2laVzFoYVd3aU9pSmpiR0YxWkdWMGRHVXdPVUJsZUdFdVkyOXRJaXdpY0dodmJtVmZiblZ0WW1WeUlqb2lLemcyS0RncE9URXpOVEl4TURRNE55SXNJbkJ2YzNSaGJGOWpiMlJsSWpvaU1ERTRPVGdpTENKbGVIUnlZVjlrWlhOamNtbHdkR2x2YmlJNklrNUJJbjBzSW1WNGNDSTZNell3TURBd01EQXdNREF3TVRZd01ESTJNakF3T1N3aVlXMXZkVzUwWDJObGJuUnpJam8xTURBd01EQXNJbkJ0YTE5cGNDSTZJalF4TGpJek5pNHhOREF1TWpFMEluMC5yTXdsRXhiWF8xbFZsVHBIanhwaFNscDlLd3V1YzVnRVBfRy1xTFgtdHRnWW83SWJQNXpsTDFfS2RlYkxUeGlXMHl6WEM2Z29LbnVoQVAxMjV5RWExUQ==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.Button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.Button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.Button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button1:
                startPayActivityNoToken(true);
                break;
            case R.id.Button2:
                startPayActivityNoToken(false);
                break;
            case R.id.Button3:
                startPayActivityToken();
                break;
        }
    }

    private void startPayActivityNoToken(Boolean showSaveCard) {

        Intent pay_intent = new Intent(this, PayActivity.class);
        putNormalExtras(pay_intent);
        pay_intent.putExtra(PayActivityIntentKeys.SAVE_CARD_DEFAULT, false);
        pay_intent.putExtra(PayActivityIntentKeys.SHOW_SAVE_CARD, showSaveCard);
        pay_intent.putExtra(PayActivityIntentKeys.THEME_COLOR,getResources().getColor(R.color.black));
        pay_intent.putExtra("ActionBar",true);
       // pay_intent.putExtra("language","ar");
        startActivityForResult(pay_intent, ACCEPT_PAYMENT_REQUEST);
        Intent secure_intent = new Intent(this, ThreeDSecureWebViewActivty.class);
        secure_intent.putExtra("ActionBar",true);
    }

    private void startPayActivityToken() {
        Intent pay_intent = new Intent(this, PayActivity.class);

        putNormalExtras(pay_intent);
        // replace this with your actual card token
        pay_intent.putExtra("language","ar");
        pay_intent.putExtra(PayActivityIntentKeys.TOKEN, "6088c38c19705a495f1727561d4f4814b2ed7e45e9cd80c72f233253");
        pay_intent.putExtra(PayActivityIntentKeys.MASKED_PAN_NUMBER, "xxxx-xxxx-xxxx-1234");
        pay_intent.putExtra(PayActivityIntentKeys.SAVE_CARD_DEFAULT, false);
        pay_intent.putExtra(PayActivityIntentKeys.SHOW_SAVE_CARD, false);
        pay_intent.putExtra("ActionBar",true);
        pay_intent.putExtra(PayActivityIntentKeys.THEME_COLOR,getResources().getColor(R.color.black));

        pay_intent.putExtra( PayActivityIntentKeys.FIRST_NAME, "Cliffo");
        pay_intent.putExtra(PayActivityIntentKeys.LAST_NAME, "Nicol");
        pay_intent.putExtra(PayActivityIntentKeys.BUILDING,"8028");
        pay_intent.putExtra(PayActivityIntentKeys.FLOOR, "42");
        pay_intent.putExtra(PayActivityIntentKeys.APARTMENT, "803");
        pay_intent.putExtra(PayActivityIntentKeys.CITY, "Jask");
        pay_intent.putExtra(PayActivityIntentKeys.STATE, "Uta");
        pay_intent.putExtra(PayActivityIntentKeys.COUNTRY,"CR" );
        pay_intent.putExtra(PayActivityIntentKeys.EMAIL, "claudette09@exa.com");
        pay_intent.putExtra(PayActivityIntentKeys.PHONE_NUMBER, "+86(8)9135210487");
        pay_intent.putExtra(PayActivityIntentKeys.POSTAL_CODE,  "01898");




        startActivityForResult(pay_intent, ACCEPT_PAYMENT_REQUEST);
    }

    private void putNormalExtras(Intent intent) {
        intent.putExtra(PayActivityIntentKeys.PAYMENT_KEY, paymentKey);
        intent.putExtra(PayActivityIntentKeys.THREE_D_SECURE_ACTIVITY_TITLE, "Verification");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle extras = data.getExtras();

        if (requestCode == ACCEPT_PAYMENT_REQUEST) {

            if (resultCode == IntentConstants.USER_CANCELED) {
                // User canceled and did no payment request was fired
                ToastMaker.displayShortToast(this, "User canceled!!");
            } else if (resultCode == IntentConstants.MISSING_ARGUMENT) {
                // You forgot to pass an important key-value pair in the intent's extras
                ToastMaker.displayShortToast(this, "Missing Argument == " + extras.getString(IntentConstants.MISSING_ARGUMENT_VALUE));
            } else if (resultCode == IntentConstants.TRANSACTION_ERROR) {
                // An error occurred while handling an API's response
                ToastMaker.displayShortToast(this, "Reason == " + extras.getString(IntentConstants.TRANSACTION_ERROR_REASON));
            } else if (resultCode == IntentConstants.TRANSACTION_REJECTED) {
                // User attempted to pay but their transaction was rejected

                // Use the static keys declared in PayResponseKeys to extract the fields you want
                ToastMaker.displayShortToast(this, extras.getString(PayResponseKeys.DATA_MESSAGE));
            } else if (resultCode == IntentConstants.TRANSACTION_REJECTED_PARSING_ISSUE) {
                // User attempted to pay but their transaction was rejected. An error occured while reading the returned JSON
                ToastMaker.displayShortToast(this, extras.getString(IntentConstants.RAW_PAY_RESPONSE));
            } else if (resultCode == IntentConstants.TRANSACTION_SUCCESSFUL) {
                // User finished their payment successfully

                // Use the static keys declared in PayResponseKeys to extract the fields you want
                ToastMaker.displayShortToast(this, extras.getString(PayResponseKeys.DATA_MESSAGE));
            } else if (resultCode == IntentConstants.TRANSACTION_SUCCESSFUL_PARSING_ISSUE) {
                // User finished their payment successfully. An error occured while reading the returned JSON.
                ToastMaker.displayShortToast(this, "TRANSACTION_SUCCESSFUL - Parsing Issue");

                // ToastMaker.displayShortToast(this, extras.getString(IntentConstants.RAW_PAY_RESPONSE));
            } else if (resultCode == IntentConstants.TRANSACTION_SUCCESSFUL_CARD_SAVED) {
                // User finished their payment successfully and card was saved.

                // Use the static keys declared in PayResponseKeys to extract the fields you want
                // Use the static keys declared in SaveCardResponseKeys to extract the fields you want
                ToastMaker.displayShortToast(this, "Token == " + extras.getString(SaveCardResponseKeys.TOKEN));
            } else if (resultCode == IntentConstants.USER_CANCELED_3D_SECURE_VERIFICATION) {
                ToastMaker.displayShortToast(this, "User canceled 3-d scure verification!!");

                // Note that a payment process was attempted. You can extract the original returned values
                // Use the static keys declared in PayResponseKeys to extract the fields you want
                ToastMaker.displayShortToast(this, extras.getString(PayResponseKeys.PENDING));
            } else if (resultCode == IntentConstants.USER_CANCELED_3D_SECURE_VERIFICATION_PARSING_ISSUE) {
                ToastMaker.displayShortToast(this, "User canceled 3-d scure verification - Parsing Issue!!");

                // Note that a payment process was attempted.
                // User finished their payment successfully. An error occured while reading the returned JSON.
                ToastMaker.displayShortToast(this, extras.getString(IntentConstants.RAW_PAY_RESPONSE));
            }
        }
    }
}
