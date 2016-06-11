package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.presenter.interfaces.OrganizationInteractor;
import com.next.micrm_module_3.presenter.interfaces.OrganizationPresenter;
import com.next.micrm_module_3.view.interfaces.MainViewInteractor;
import com.next.micrm_module_3.view.interfaces.OrganizationFragmentView;

/**
 * Created by Wally1 on 11/06/2016.
 */
public class OrganizationPresenterImpl implements OrganizationPresenter, OrganizationInteractor.onOrganization {
    OrganizationFragmentView mView;
    OrganizationInteractor mInteractor;
    public OrganizationPresenterImpl(OrganizationFragmentView view) {
        mView = view;
        mInteractor = new OrganizationInteractorImpl();
    }

    @Override
    public void addOrganization(String name, String tel, String addres) {
       if(mView != null)
            mInteractor.createOrganization(name,tel,addres,this);
    }

    @Override
    public Organization getChangeOrganization(int i) {
        return null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDelete(int i) {

    }

    @Override
    public void onErrorName() {

    }

    @Override
    public void onErrorTel() {

    }

    @Override
    public void onErrorAddres() {

    }
}
