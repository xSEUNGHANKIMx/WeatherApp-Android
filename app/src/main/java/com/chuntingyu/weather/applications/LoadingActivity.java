package com.chuntingyu.weather.applications;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.chuntingyu.weather.R;
import com.chuntingyu.weather.tools.coredata.DataManager;
import com.chuntingyu.weather.activities.login.LoginActivity;
import com.chuntingyu.weather.activities.main.MainActivity;

public class LoadingActivity extends Activity implements LoadingMvpView {

    private static final int MY_PERMISSIONS_FINE_LOCATION = 0;
    LoadingPresenterBase mSplashPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoadingActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DataManager dataManager = ((WeatherApp) getApplication()).getDataManager();

        mSplashPresenter = new LoadingPresenterBase(dataManager);

        mSplashPresenter.onAttach(this);

        mSplashPresenter.choiceActivity();
    }

    @Override
    public void startMain() {
        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void startLoging() {
        Intent intent = LoginActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}