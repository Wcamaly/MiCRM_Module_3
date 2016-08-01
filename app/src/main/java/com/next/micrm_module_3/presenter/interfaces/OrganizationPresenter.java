package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.Organization;

/**
 * Created by Wally1 on 11/06/2016.
 */
public interface OrganizationPresenter {
    void addOrganization(String name, String tel,String addres);
    Organization getChangeOrganization(int i);
    void onDestroy();
    void delete(int i);
}
