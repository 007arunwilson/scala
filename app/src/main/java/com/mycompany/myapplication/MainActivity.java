package com.mycompany.myapplication;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = LayoutInflater.from(this).inflate(R.layout.activity_welcome, null);
        view.postDelayed(new Runnable() { public void run() { view.setVisibility(View.GONE); } }, 3000);

        //setContentView(R.layout.activity_main);
    }

    public void sendFeedback(View button) {
        // Do click handling here

        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
        String feedback = feedbackField.getText().toString();




        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // ...

                            Double last_known_location_lat = location.getLatitude();
                            Double last_known_location_lng = location.getLongitude();

                            CharSequence text = "Your last known location, Lat : "+last_known_location_lat+" Lng : "+last_known_location_lng;
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(MainActivity.this, text, duration);
                            toast.show();

                        }
                    }
                });

    }
}
