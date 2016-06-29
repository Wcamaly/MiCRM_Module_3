package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.presenter.interfaces.ActivityInteractor;
import com.next.micrm_module_3.presenter.interfaces.ActivityPresenter;
import com.next.micrm_module_3.view.interfaces.ActivityFragmentView;

/**
 * Created by wcamaly on 29/06/2016.
 */
public class ActivityPresenterImpl implements ActivityPresenter, ActivityInteractor.onActivityAction {
    ActivityFragmentView view;
    public ActivityPresenterImpl(ActivityFragmentView a) {
        this.view = a;
    }

    @Override
    public void onErrorType() {

    }

    @Override
    public void onErrorDescription() {

    }

    @Override
    public void onErrorAsign() {

    }

    @Override
    public void onErrorDate() {

    }

    @Override
    public void onErrorHour() {

    }
}
