package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.presenter.interfaces.OrganizationInteractor;
import com.next.micrm_module_3.presenter.interfaces.OrganizationPresenter;
import com.next.micrm_module_3.view.interfaces.OrganizationCreateFragmentView;

/**
 * This class is the mind that is responsible for managing the view of creating Organization
 */
public class OrganizationPresenterImpl implements OrganizationPresenter, OrganizationInteractor.onOrganization {
    OrganizationCreateFragmentView mView;
    OrganizationInteractor mInteractor;
    public OrganizationPresenterImpl(OrganizationCreateFragmentView view) {
        mView = view;
        mInteractor = new OrganizationInteractorImpl();
    }

    @Override
    public boolean addOrganization(String name, String tel, String addres) {
        if(mView != null)
            return  mInteractor.createOrganization(name,tel,addres,this);
        return true;
    }

    @Override
    public Organization getChangeOrganization(int i) {
        return mInteractor.getOrganiation(i);
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void delete(int i) {
        mInteractor.delteOrganization(i);
    }


    @Override
    public void onErrorName() {
        if(mView !=null){
            mView.setErrorName();
        }
    }

    @Override
    public void onErrorTel() {
        if(mView !=null){
            mView.setErrorTel();

        }
    }

    @Override
    public void onErrorAddres() {
        if(mView !=null){
            mView.setErrorAddres();
        }
    }
}
