package com.next.micrm_module_3.presenter;

import android.view.View;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.ModelInteractor;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.view.MainViewInteractor;

import java.util.List;

/**
 * Created by Wally1 on 08/06/2016.
 */
public class ModelPresenter implements ModelPresenterInteractor {

    private ModelInteractor nModel;
    private MainViewInteractor nMainView;

    @Override
    public void onCreate(MainViewInteractor v, ModelInteractor m) {
        this.nModel = m;
        this.nMainView = v;
    }

    @Override
    public void addActivityAcction(ActivityAction a) {

    }

    @Override
    public void addPople(People p) {

    }

    @Override
    public void addCommerce(Commerce c) {

    }

    @Override
    public void addOrganization(Organization o) {

    }

    @Override
    public List<People> getArrayPeoples() {
        return null;
    }

    @Override
    public List<Organization> getArrayOrganization() {
        return null;
    }

    @Override
    public List<Commerce> getArrayCommerce() {
        return null;
    }

    @Override
    public List<ActivityAction> getActivitysAction() {
        return null;
    }

    @Override
    public void changePeople(int i) {

    }

    @Override
    public void changeOrganization(int i) {

    }

    @Override
    public void changeActivitysAction(int i) {

    }

    @Override
    public void changeCommerce(int i) {

    }
}
