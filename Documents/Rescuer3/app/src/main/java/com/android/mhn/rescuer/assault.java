package com.android.mhn.rescuer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class assault extends AppCompatActivity {
    CheckBox ass_loss, per_injury, armed;
    EditText susnum,desc;
    Button submit_assault;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assault);

        submit_assault= findViewById(R.id.assault_submit);

        submit_assault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent assaultintent = new Intent(assault.this, assault_details.class);
                startActivity(assaultintent);
            }
        });
    }
}
