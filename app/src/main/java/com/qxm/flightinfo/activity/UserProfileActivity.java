package com.qxm.flightinfo.activity;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.R;
import com.qxm.flightinfo.databinding.ActivityMainBinding;
import com.qxm.flightinfo.databinding.ActivityUserProfileBinding;
import com.qxm.flightinfo.viewmodel.LoginViewModel;
import com.qxm.flightinfo.viewmodel.UserProfileViewModel;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);
        UserProfileViewModel vm = new UserProfileViewModel();
        binding.setViewModel(vm);
        vm.load((FlightInfoApplication) getApplication());
    }
}
