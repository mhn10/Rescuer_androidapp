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

        prop_loss = (CheckBox)findViewById(R.id.loss_prop);
         personal_injury = (CheckBox)findViewById(R.id.personal_injury);
         armed = (CheckBox)findViewById(R.id.suspect_armed);
         desc= (EditText)findViewById(R.id.robbery_desc);
         susnum= (EditText)findViewById(R.id.suspect_count);

        submit_robbery= findViewById(R.id.report_rob_button);

        submit_robbery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String loss= prop_loss.getText().toString();
               // String inj= personal_injury.getText().toString();


                Intent robberyintent = new Intent(robbery.this, robbery_details.class);
                robberyintent.putExtra("loss", prop_loss.isChecked());
                robberyintent.putExtra("injury", personal_injury.isChecked());
                robberyintent.putExtra("armed", armed.isChecked());
                robberyintent.putExtra("descriptor", desc.getText().toString());
                robberyintent.putExtra("no", susnum.getText().toString());
                startActivity(robberyintent);
            }
        });


    }
}
