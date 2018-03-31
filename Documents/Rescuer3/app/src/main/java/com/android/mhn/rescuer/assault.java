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

         ass_loss = (CheckBox)findViewById(R.id.loss_prop_assault);
         per_injury = (CheckBox)findViewById(R.id.personal_injury_assault);
         armed = (CheckBox)findViewById(R.id.suspect_armed_assault);
         desc= (EditText)findViewById(R.id.assault_desc);
         susnum= (EditText)findViewById(R.id.suspect_count_assault);

        submit_assault= findViewById(R.id.assault_submit);

        submit_assault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent assaultintent = new Intent(assault.this, assault_details.class);
                assaultintent.putExtra("loss", ass_loss.isChecked());
                assaultintent.putExtra("injury", per_injury.isChecked());
                assaultintent.putExtra("armed", armed.isChecked());
                assaultintent.putExtra("descriptor", desc.getText().toString());
                assaultintent.putExtra("no", susnum.getText().toString());
                startActivity(assaultintent);
            }
        });
    }
}
