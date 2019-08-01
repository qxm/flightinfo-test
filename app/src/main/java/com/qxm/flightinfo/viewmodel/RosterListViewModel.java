package com.qxm.flightinfo.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.qxm.flightinfo.BR;
import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.model.Roster;
import com.qxm.flightinfo.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RosterListViewModel extends BaseObservable {
    public List<Roster> rosterList = new ArrayList<>();
    public final ObservableInt refreshCount = new ObservableInt(0);

    @Bindable
    public List<Roster> getRosterList() {
        return rosterList;
    }

    public void setRosterList(List<Roster> rosterList) {
        this.rosterList = rosterList;
        notifyPropertyChanged(BR.rosterList);
    }

    public void load (FlightInfoApplication app) {
        android.util.Log.d("RosterListViewModel","----------------------load");

        app.getAppDatabase().rosterDao().loadRosters().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Roster>>() {
                    @Override
                    public void accept(List<Roster> rosters) throws Exception {
                        android.util.Log.d("RosterListViewModel","----------rosters size:"+rosters.size());
                        setRosterList(rosters);
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
