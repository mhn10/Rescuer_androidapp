package com.android.mhn.rescuer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class robbery extends AppCompatActivity {
     CheckBox prop_loss, personal_injury, armed;
     EditText susnum,desc;
    Button submit_robbery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robbery);

/*
        Spinner suspect_count_spinner = (Spinner) findViewById(R.id.suspect_count);
        ArrayAdapter<Integer> suspect_count = new ArrayAdapter<Integer>(robbery.this, android.R.layout.simple_list_item_1, getResources().getIntArray(R.array.suspect_count));
        suspect_count.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        suspect_count_spinner.setAdapter(suspect_count);
*/
/*

         final CheckBox prop_loss = findViewById(R.id.loss_prop);
        final CheckBox personal_injury = findViewById(R.id.personal_injury);
        final CheckBox armed= findViewById(R.id.suspect_armed);
          final EditText susnum = findViewById(R.id.suspect_count);
        final EditText desc = findViewById(R.id.robbery_desc);
*/
        submit_robbery= findViewById(R.id.report_rob_button);

        submit_robbery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String loss= prop_loss.getText().toString();
               // String inj= personal_injury.getText().toString();


                Intent robberyintent = new Intent(robbery.this, robbery_details.class);
                //getIntent().putExtra("LOSS",loss);
               // getIntent().putExtra("INJ",inj);
                //getIntent().putExtra("LOSS",loss);
                startActivity(robberyintent);
            }
        });


    }
}
