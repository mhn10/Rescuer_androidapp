package com.android.mhn.rescuer;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;

public class SosPage extends AppCompatActivity {
     ImageButton callb;
     ImageButton reportb;
     ImageButton camera;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
boolean last = false;
    TapTargetSequence sequence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_page);


       // final Drawable rect = ResourcesCompat.getDrawable(getResources(), R.drawable.rectangle, null);



         final TapTargetSequence sequence = new TapTargetSequence(this)
                .targets(

                        TapTarget.forView(findViewById(R.id.callButton),"Press here to make a direct call to 911", "try it! ")
                                .tintTarget(true)
                                .outerCircleColor(R.color.holo_blue)
                                .outerCircleAlpha(.75f)
                                .dimColor(R.color.black)
                                .targetRadius(85)
                                .cancelable(true)
                                .transparentTarget(true),
                        TapTarget.forView(findViewById(R.id.camera)," press here to open camera","save pics directly to your library.")
                                 .tintTarget(true)
                                .outerCircleAlpha(.85f)
                                .outerCircleColor(R.color.colorPrimary)
                                .dimColor(R.color.black)
                                .targetRadius(85)
                                .cancelable(true)
                                .drawShadow(true)
                                .transparentTarget(true),
                        TapTarget.forView(findViewById(R.id.reportButton),"Press here to report an incident", "try it! ")
                                 .tintTarget(true)
                                .outerCircleAlpha(.75f)
                                .outerCircleColor(R.color.green)
                                .dimColor(R.color.black)
                                .targetRadius(85)
                                .cancelable(true)
                                .transparentTarget(true))
                    .listener(new TapTargetSequence.Listener() {
                                    // This listener will tell us when interesting(tm) events happen in regards
                                    // to the sequence
                                    @Override
                                    public void onSequenceFinish() {
                                        // Yay
                                    }

                                    @Override
                                    public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                                        // Perfom action for the current target
                                         Log.d("TapTargetView", "Clicked on " + lastTarget.id());

                                    }



                                    @Override
                                    public void onSequenceCanceled(TapTarget lastTarget) {
                                         final AlertDialog dialog = new AlertDialog.Builder(SosPage.this)
                                        .setTitle("Uh oh")
                                        .setMessage("You canceled the sequence")
                                        .setPositiveButton("Oops", null).show();
                                    TapTargetView.showFor(dialog,
                                        TapTarget.forView(dialog.getButton(DialogInterface.BUTTON_POSITIVE), "Uh oh!", "You canceled the sequence at step " + lastTarget.id())
                                            .cancelable(false)
                                            .tintTarget(false), new TapTargetView.Listener() {
                                          @Override
                                          public void onTargetClick(TapTargetView view) {
                                            super.onTargetClick(view);
                                            dialog.dismiss();

                                            }

                                            });
                                    }


                    });







/*


        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.callButton), "Press here to make a direct call to 911", "try it! ")
                        .tintTarget(true)
                        .outerCircleColor(R.color.holo_blue)
                        .outerCircleAlpha(.45f)
                        .dimColor(R.color.black)
                        .targetRadius(70)
                        .cancelable(true)
                        .transparentTarget(true)

        );
        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.reportButton), "Press here to report an incident", "try it! ")
                        .tintTarget(true)
                        .outerCircleAlpha(.75f)
                        .outerCircleColor(R.color.green)
                        .dimColor(R.color.black)
                        .targetRadius(80)
                        .cancelable(true)
                        .transparentTarget(true)


        );
        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.camera), " press here to open camera\",\"save pics directly to your library.")
                        .tintTarget(true)
                        .outerCircleAlpha(.85f)
                        .outerCircleColor(R.color.colorPrimary)
                        .dimColor(R.color.black)
                        .targetRadius(85)
                        .cancelable(true)
                        .drawShadow(true)
                        .transparentTarget(true)




        );
*/

        callb = findViewById(R.id.callButton);

        reportb = findViewById(R.id.reportButton);
        camera = findViewById((R.id.camera));
        sequence.start();


        callb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:911"));
                startActivity(callIntent);


            }
        });


        reportb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent reportIntent = new Intent(SosPage.this, repoPage.class);
                        startActivity(reportIntent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent cameraIntent = new Intent(SosPage.this, cameraPage.class);

                startActivity(cameraIntent);
            }

        });


    }


}
