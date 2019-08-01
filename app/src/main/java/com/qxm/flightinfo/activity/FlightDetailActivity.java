package com.qxm.flightinfo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.R;
import com.qxm.flightinfo.databinding.ActivityFlightDetailsBinding;
import com.qxm.flightinfo.viewmodel.FlightDetailViewModel;


public class FlightDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFlightDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_flight_details);
        FlightDetailViewModel  vm = new FlightDetailViewModel();
        binding.setViewModel(vm);
        vm.load((FlightInfoApplication) getApplication());

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
