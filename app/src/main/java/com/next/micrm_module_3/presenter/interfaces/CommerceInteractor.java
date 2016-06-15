package com.next.micrm_module_3.presenter.interfaces;


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
    }
    void createCommerce(String t, String d, String v, String s, String date, onCommerce listener, Entidad... entidads);
    void getCommerceChange(int i);
    void deleteCommerce(int i);
}
