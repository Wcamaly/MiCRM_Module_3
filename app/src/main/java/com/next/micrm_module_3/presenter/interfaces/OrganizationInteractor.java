package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.Organization;

/**
 * Created by Wally1 on 11/06/2016.
 */
public interface OrganizationInteractor {
    interface onOrganization{
        void onErrorName();
        void onErrorTel();
        void onErrorAddres();
    }
    void createOrganization(String name,String tel,String dir, onOrganization listener);
    Organization getOrganiation(int i);
    void delteOrganization(int i);
}
