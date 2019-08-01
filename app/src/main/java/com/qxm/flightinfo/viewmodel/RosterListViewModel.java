package com.qxm.flightinfo.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.model.Roster;
import com.qxm.flightinfo.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RosterListViewModel extends ViewModel {
    public ObservableArrayList<Roster> rosterList = new ObservableArrayList<>();
    public final ObservableInt refreshCount = new ObservableInt(0);

    public ObservableArrayList<Roster> getRosterList() {
        return rosterList;
    }

    public void setRosterList(ObservableArrayList<Roster> rosterList) {
        this.rosterList = rosterList;
    }

    public void load (FlightInfoApplication app) {
        android.util.Log.d("RosterListViewModel","----------------------load");
        List<Roster> rosters =  new ArrayList<Roster>();
        Roster roster = new Roster(100,"KM207","12:30","18:00","waiting","waiting","standard");
        rosters.add(roster);
        rosterList.clear();
        rosterList.addAll(rosters);
        app.getAppDatabase().rosterDao().loadRosters().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Roster>>() {
                    @Override
                    public void accept(List<Roster> rosters) throws Exception {
                        android.util.Log.d("RosterListViewModel","rosters size:"+rosters.size());
                        rosterList.clear();
                        rosterList.addAll(rosters);
                        refreshCount.set(refreshCount.get()+1);
                    }

                });

    }

    public void onRefresh() {
        android.util.Log.d("RosterListViewModel","onRefresh"+refreshCount.get());
        int count = refreshCount.get();
        refreshCount.set(count+1);
    }
    public void onFirstLoad(FlightInfoApplication app) {
        load(app);
    }
}
