package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.presenter.interfaces.CommerceInteractor;
import com.next.micrm_module_3.presenter.interfaces.CommercePresenter;
import com.next.micrm_module_3.view.interfaces.CommerceFragmentView;

import java.util.List;

/**
 * Created by wcamaly on 21/06/2016.
 */
public class CommercePresenterImpl implements CommercePresenter, CommerceInteractor.onCommerce {
   CommerceFragmentView view;
    public CommercePresenterImpl(CommerceFragmentView v) {
        this.view = v;
    }

    @Override
    public void addCommerce(String t, String d, double v, String s, String date, People pe, Organization or) {

    }

    @Override
    public Commerce getCommerceChange(int i) {
        return null;
    }

    @Override
    public List<People> getListPoples() {
        return null;
    }

    @Override
    public List<Organization> getListOrganization() {
        return null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDelete() {

    }

    @Override
    public void onErrorTitle() {

    }

    @Override
    public void onErrorDescription() {

    }

    @Override
    public void onErrorAsign() {

    }

    @Override
    public void onErrorValue() {

    }

    @Override
    public void onErrorStatus() {

    }

    @Override
    public void onErrorDate() {

    }
}
