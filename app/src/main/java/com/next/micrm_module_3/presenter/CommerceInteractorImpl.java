package com.next.micrm_module_3.presenter;

import android.text.TextUtils;

import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.interfaces.CommerceInteractor;

/**
 * Created by wcamaly on 21/06/2016.
 */
public class CommerceInteractorImpl implements CommerceInteractor {
    ModelInteractor mModel = ModelPresenter.getInstances();
    @Override
    public void createCommerce(String t, String d, double v, String s, String date, onCommerce listener, People pe, Organization or) {
        boolean error = false;
        if (TextUtils.isEmpty(t)){
            listener.onErrorTitle();
            error = true;
        }
        if (TextUtils.isEmpty(d)){
            listener.onErrorDescription();
            error = true;
        }
        if (v == 0){
            listener.onErrorValue();
            error = true;
        }
        if (TextUtils.isEmpty(s)){
            listener.onErrorStatus();
            error = true;
        }
        if (TextUtils.isEmpty(date)){
            listener.onErrorDate();
            error = true;
        }
        if (pe == null && or == null ){
            listener.onErrorAsign();
            error = true;
        }

        if (!error){
            Commerce come = new Commerce();
            come.setTitle(t);
            come.setDescription(d);
            come.setDateFinish(date);
            come.setStatus(s);
            come.setValue(v);
            if(pe != null)
                come.setPeoples(pe);
            if(or != null)
                come.setOrg(or);
            mModel.setCommerce(come);
        }
    }

    @Override
    public Entidad getCommerceChange(int i) {
        return mModel.getOrganization(i);
    }

    @Override
    public void deleteCommerce(int i) {
        mModel.deleteCommerce(i);
    }
}
