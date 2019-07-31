package com.qxm.flightinfo.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.qxm.flightinfo.BR;
import com.qxm.flightinfo.FlightInfoApplication;
import com.qxm.flightinfo.model.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserProfileViewModel extends BaseObservable {
    private String userId = "bob";
    private String userName ;//= "Bob";
    private String contactNumber;// = "66778899";
    private String email;// = "bob@aa.com";

    public void load(FlightInfoApplication app) {
        app.getAppDatabase().userDao().loadUserProfile().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        android.util.Log.d("UserProfileViewModel","userName:"+user.userName+" contact number:"+user.contactNumber);
                         setUserId(user.userId);
                         setUserName(user.userName);
                         setContactNumber(user.contactNumber);
                         setEmail(user.email);

                    }
                });
    }

    @Bindable
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        notifyPropertyChanged(BR.userId);
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        notifyPropertyChanged(BR.contactNumber);
    }
}
