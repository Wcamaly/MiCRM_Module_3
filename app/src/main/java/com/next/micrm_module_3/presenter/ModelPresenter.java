package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.model.ModelInteractorImpl;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.presenter.interfaces.ModelPresenterInteractor;
import com.next.micrm_module_3.view.MainViewInteractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wally1 on 08/06/2016.
 */
public class ModelPresenter implements ModelPresenterInteractor, ModelInteractor.onModelListener {

    private ModelInteractor nModel;
    private MainViewInteractor nMainView;

    @Override
    public void onCreate(MainViewInteractor v) {
        this.nModel = ModelInteractorImpl.getInstances();
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
        return (ArrayList) nModel.getPeoples();
    }

    @Override
    public List<Organization> getArrayOrganization() {
        return (ArrayList) nModel.getOrganizations();
    }

    @Override
    public List<Commerce> getArrayCommerce() {
        return (ArrayList) nModel.getCommerces();
    }

    @Override
    public List<ActivityAction> getActivitysAction() {
        return nModel.getActivitys();
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

    @Override
    public void onAddActivity() {

    }

    @Override
    public void onAddPeople() {

    }

    @Override
    public void onAddOrganization() {

    }

    @Override
    public void onCommerce() {

    }

    @Override
    public void onDestroy() {

    }
}
