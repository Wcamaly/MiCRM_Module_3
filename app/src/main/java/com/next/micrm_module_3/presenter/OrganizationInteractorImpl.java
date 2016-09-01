package com.next.micrm_module_3.presenter;

import android.text.TextUtils;

import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.interfaces.OrganizationInteractor;

/**
 * This class is el interactor to OrganizartioPresenter to Model
 */
public class OrganizationInteractorImpl implements OrganizationInteractor {
    ModelInteractor mModel = ModelPresenter.getInstances();
    @Override
    public boolean createOrganization(String name, String tel, String dir,onOrganization listener) {
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
        return error;
    }

    @Override
    public Organization getOrganiation(int i) {
        return mModel.getOrganization(i);
    }

    @Override
    public void delteOrganization(int i) {
        mModel.getOrganizations().remove(i);
    }


}
