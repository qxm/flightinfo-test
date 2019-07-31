package com.qxm.flightinfo.viewmodel;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class LoginViewModel  {
    private static final String TAG = "LoginViewModel";
    public ObservableField<String> userName =  new ObservableField<>();
    public ObservableField<String> password =  new ObservableField<>();
    public final ObservableInt loginSuccess = new ObservableInt(0);

    public void setUserName(String username) {
        this.userName.set(username);
    }

    public String getUserName() {
        return this.userName.get();
    }
    public void login() {
        android.util.Log.d(TAG, "login clicked"+userName.get());
        String name = userName.get();
        if ("bob".equals(name)) {
            if ("12345".equals(password.get())) {
                int count = loginSuccess.get();
                loginSuccess.set(count + 1);
            }
            password.set("");
        }
    }
}
