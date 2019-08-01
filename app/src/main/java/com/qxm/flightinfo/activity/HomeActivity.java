package com.qxm.flightinfo.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qxm.flightinfo.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onUserProfileClick(View view) {
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    public void onFlightDetailsClick(View view) {

        Intent intent = new Intent(this, FlightDetailActivity.class);
        startActivity(intent);
    }

    public void onRostersClick(View view) {

        Intent intent = new Intent(this, RosterActivity.class);
        startActivity(intent);
    }
}
