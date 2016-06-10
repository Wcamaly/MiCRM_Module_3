package com.next.micrm_module_3.presenter;

import android.graphics.AvoidXfermode;

import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.interfaces.PeopleInteractor;
import com.next.micrm_module_3.view.MainViewInteractor;

/**
 * Created by Wally1 on 10/06/2016.
 */
public class PeopleInteractorImpl implements PeopleInteractor {
    MainViewInteractor mView=null;
    ModelInteractor mModel = ModelPresenter.getInstances();
    public PeopleInteractorImpl(MainViewInteractor v) {
        this.mView = v;
    }

    @Override
    public void createPeople() {

    }

    @Override
    public void changePeople() {

    }

    @Override
    public void deletePeople() {

    }
}
