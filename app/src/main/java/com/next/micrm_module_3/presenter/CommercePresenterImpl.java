package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.interfaces.CommerceInteractor;
import com.next.micrm_module_3.presenter.interfaces.CommercePresenter;
import com.next.micrm_module_3.view.interfaces.CommerceFragmentView;

import java.util.List;

/**
 * This class is the mind that is responsible for managing the view of creating Commerce
 */
public class CommercePresenterImpl implements CommercePresenter, CommerceInteractor.onCommerce {
   CommerceFragmentView view;
   CommerceInteractor cIteractor;
    public CommercePresenterImpl(CommerceFragmentView v) {
        this.view = v;
     cIteractor = new CommerceInteractorImpl();
    }

    @Override
    public void addCommerce(String t, String d, double v, String s, String date, People pe, Organization or) {
       if(view != null)
        cIteractor.createCommerce(t,d,v,s,date,this,pe,or);

    }

    @Override
    public Commerce getCommerceChange(int i) {
        return (Commerce) cIteractor.getCommerceChange(i);
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
    public void onDestroy() {
     this.view = null;

    }

    @Override
    public void delete(int i) {
        cIteractor.delteCommerce(i);
    }


    @Override
    public void onErrorTitle() {
        if(view != null){
          view.setErrorTitle();
        }
    }

    @Override
    public void onErrorDescription() {
       if(view != null){
          view.setErrorDescription();
       }
    }

    @Override
    public void onErrorAsign() {
     if(view != null){
        view.setErrorAsign();
     }
    }

    @Override
    public void onErrorValue() {
     if(view != null){
        view.setErrorValue();
     }
    }

    @Override
    public void onErrorStatus() {
     if(view != null){
        view.setErrorStatus();
     }
    }

    @Override
    public void onErrorDate() {
     if(view != null){
        view.setErrorDate();
     }
    }
}
