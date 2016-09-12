package com.next.micrm_module_3.presenter.interfaces;


import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;

/**
 * Created by Wally1 on 11/06/2016.
 */
public interface CommerceInteractor
{
    interface onCommerce{
        void onErrorTitle();
        void onErrorDescription();
        void onErrorAsign();
        void onErrorValue();
        void onErrorStatus();
        void onErrorDate();
        void onCreate(boolean s);
    }
    boolean createCommerce(String t, String d, double v, String s, String date, onCommerce listener, People pe, Organization or);
    Entidad getCommerceChange(int i);
    void delteCommerce(int i);
}
