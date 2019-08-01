package com.qxm.flightinfo.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.qxm.flightinfo.BR;
import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.model.FlightDetail;
import com.qxm.flightinfo.model.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FlightDetailViewModel extends BaseObservable {

    public FlightDetail flightDetail;
    private String flightNo;

    public void load(FlightInfoApplication app) {

        app.getAppDatabase().flightDetailDao().loadFlightDetail().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FlightDetail>() {
                    @Override
                    public void accept(FlightDetail detail) {
                        android.util.Log.d("FlightDetailViewModel","FlightNo:"+detail.flightNo);
                        setFlightDetail(detail);
                        //setFlightNo(detail.getFlightNo());


                    }
                });
    }

    @Bindable
    public FlightDetail getFlightDetail() {
        return flightDetail;
    }


    public void setFlightDetail(FlightDetail flight) {
        this.flightDetail = flight;
        notifyPropertyChanged(BR.flightDetail);
    }


}
