package com.chuntingyu.weather.applications;

import com.chuntingyu.weather.tools.coredata.DataManager;

/**
 * Created by Kevin on 2018/3/14.
 */

public class LoadingPresenterBase<V extends LoadingMvpView> extends BasePresenterBase<V> implements LoadingBaseMvpPresenter<V> {

    public LoadingPresenterBase(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void choiceActivity() {
        if (getDataManager().getLoggedInMode()) {
            getMvpView().startMain();
        } else {
            getMvpView().startLoging();
        }
    }
}