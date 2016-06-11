package com.next.micrm_module_3.presenter;

import android.text.TextUtils;

import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.interfaces.OrganizationInteractor;

/**
 * Created by Wally1 on 11/06/2016.
 */
public class OrganizationInteractorImpl implements OrganizationInteractor {
    ModelInteractor mModel = ModelPresenter.getInstances();
    @Override
    public void createOrganization(String name, String tel, String dir,onOrganization listener) {
        boolean error = false;
        if (TextUtils.isEmpty(name)){
            listener.onErrorName();
            error = true;
        }
        if (TextUtils.isEmpty(dir)){
            listener.onErrorAddres();
            error = true;
        }
        if (TextUtils.isEmpty(tel)){
            listener.onErrorTel();
            error = true;
        }
        if (!error){
            Organization o = new Organization();
            o.setName(name);
            o.setAddress(dir);
            o.setTel(tel);
            mModel.setOrganization(o);

        }
    }

    @Override
    public Organization getOrganiationPeople(int i) {
        return mModel.getOrganization(i);
    }

    @Override
    public void deleteOrganization(int i) {
        mModel.deleteOrganization(i);
    }
}
