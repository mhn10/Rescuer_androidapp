package com.android.mhn.rescuer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class repoPage extends AppCompatActivity {
    RadioButton robbery,fire,assault,location;
    String selected;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_page);
        robbery= findViewById(R.id.robbery);
        assault= findViewById(R.id.assault);
        fire= findViewById(R.id.fire);
        location = findViewById(R.id.Location);
        submit= findViewById(R.id.submitbutton);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(robbery.isChecked()){
                    Intent robberyIntent = new Intent(repoPage.this, robbery.class);
                    startActivity(robberyIntent);

                } else if(assault.isChecked()){
                    Intent assualtIntent = new Intent(repoPage.this, assault.class);
                    startActivity(assualtIntent);

                }else if(fire.isChecked()){
                    Intent fireIntent = new Intent(repoPage.this, fire.class);
                    startActivity(fireIntent);

                }
                else if(location.isChecked()){
                    Intent locationIntent = new Intent(repoPage.this, location.class);
                    startActivity(locationIntent);

                }
            }
        });




    }
}
