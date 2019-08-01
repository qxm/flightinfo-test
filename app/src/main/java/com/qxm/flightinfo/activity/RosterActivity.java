package com.qxm.flightinfo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.qxm.flightinfo.BR;
import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.R;
import com.qxm.flightinfo.adapter.SimpleAdapter;
import com.qxm.flightinfo.databinding.ActivityRosterBinding;
import com.qxm.flightinfo.model.Roster;
import com.qxm.flightinfo.viewmodel.RosterListViewModel;

import java.util.ArrayList;
import java.util.List;

public class RosterActivity extends AppCompatActivity {
    private RosterListViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRosterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_roster);
        vm = ViewModelProviders.of(this).get(RosterListViewModel.class);
        //vm.onFirstLoad((FlightInfoApplication)getApplication());

        List<Roster> rosters =  new ArrayList<>();
        Roster roster = new Roster(100,"TR237","12:30","18:00","waiting","waiting","standard");
        rosters.add(roster);
        SimpleAdapter<Roster> adapter = new SimpleAdapter<Roster>(rosters,R.layout.layout_roster_item, BR.data);
        binding.rv.setAdapter(adapter);
        //vm.onFirstLoad((FlightInfoApplication) getApplication());
    }

    @BindingAdapter({"onRefresh"})
    public static void onRefresh(RecyclerView view, List<Roster> data) {
        SimpleAdapter<Roster> adapter = (SimpleAdapter<Roster>) view.getAdapter();
        android.util.Log.d("RosterActivity","--------------------------------onRefresh,count:");
        if (data!=null)
           adapter.refreshData(data);
    }
}
