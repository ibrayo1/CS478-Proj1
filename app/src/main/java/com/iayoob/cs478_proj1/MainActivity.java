package com.iayoob.cs478_proj1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String userInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // address and map buttons
        Button addressBtn = (Button) findViewById(R.id.address_btn);
        Button mapBtn = (Button) findViewById(R.id.map_btn);

        // open address activity for a result when address button is pressed by user
        addressBtn.setOnClickListener((v) -> {
            Intent i = new Intent(this, AddressActivity.class);
            startActivityForResult(i , 1);
        });

        // open map activity when user clicks map button
        mapBtn.setOnClickListener((v) -> {
            if(userInput.length() > 0) {
                // start intent
                Intent i = new Intent(MainActivity.this, MapActivity.class);
                i.putExtra("address", userInput);
                startActivity(i);
            }
            else
                Toast.makeText(MainActivity.this, "failed to enter address", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {
                    userInput = data.getStringExtra("inputFromUser");
                    // Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show();
                } else if (resultCode == Activity.RESULT_CANCELED){
                    userInput = "";
                    // Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
