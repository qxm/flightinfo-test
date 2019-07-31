package com.qxm.flightinfo.activity;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qxm.flightinfo.R;
import com.qxm.flightinfo.databinding.ActivityMainBinding;
import com.qxm.flightinfo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel vm = new LoginViewModel();
        binding.setViewModel(vm);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @BindingAdapter({"loginSuccess"})
    public static void loginSuccess(View view, int success) {
        android.util.Log.d(TAG,"login success:" + success);
        if (success>0) {
            Context context = view.getContext();
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);

        }
    }
}
