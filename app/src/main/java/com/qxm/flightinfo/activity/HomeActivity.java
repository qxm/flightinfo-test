package com.qxm.flightinfo.activity;

import android.content.Context;
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
        Context context = view.getContext();
        Intent intent = new Intent(context, UserProfileActivity.class);
        context.startActivity(intent);
    }
}
