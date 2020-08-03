package com.iayoob.cs478_proj1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        // get edit text object by id
        EditText userInput = (EditText) findViewById(R.id.edit_text);

        // editor action listener
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    // create new intent and put the input from user in extra
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("inputFromUser", userInput.getText().toString());

                    // get result_ok or result_canceled, set the result, and finish address activity
                    int result = userInput.getText().length() > 0 ?  Activity.RESULT_OK : Activity.RESULT_CANCELED;
                    setResult(result, resultIntent);
                    finish();

                    return true;
                }
                return false;
            }
        });
    }
}
