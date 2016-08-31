package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;
import com.next.micrm_module_3.presenter.interfaces.ActivityInteractor;
import com.next.micrm_module_3.presenter.interfaces.ActivityPresenter;
import com.next.micrm_module_3.view.interfaces.ActivityCreateFragmentView;

import java.util.List;

/**
 * This class is the mind that is responsible for managing the view of creating Activitys
 */
public class ActivityPresenterImpl implements ActivityPresenter, ActivityInteractor.onActivityAction {
    ActivityCreateFragmentView view;

    ActivityInteractor mAction ;
    public ActivityPresenterImpl(ActivityCreateFragmentView a) {
        this.view = a;
        mAction = new ActivityInteractorImpl();
    }

    @Override
    public void onErrorType() {
      if (view != null)
          view.setErrorType();
    }

    @Override
    public void onErrorDescription() {
        if (view != null)
            view.setErrorDescription();
    }

    @Override
    public void onErrorAsign() {
        if (view != null)
            view.setErrorAsign();
    }

    @Override
    public void onErrorDate() {
        if (view != null)
            view.setErrorDate();
    }

    @Override
    public void onErrorHour() {
        if (view != null)
            view.setErrorHour();
    }

    @Override
    public  boolean addActivity(String t, String d, String h, String date, Entidad e) {
       return mAction.createNewActivity(t,d,e,date,h,this);
    }

    @Override
    public ActivityAction getActivityChange(int i) {
        return mAction.getActivityChange(i);
    }

    @Override
    public List<People> getListPoples() {
        return ModelPresenter.getInstances().getPeoples();
    }

    @Override
    public List<Organization> getListOrganization() {
        return ModelPresenter.getInstances().getOrganizations();
    }

    @Override
    public List<Commerce> getListCommerce() {
        return ModelPresenter.getInstances().getCommerces();
    }

    @Override
    public void onDestroy() {
        view = null;
    }
    @Override
    public void delete(int i) {
        mAction.deleteActivity(i);
    }

}
