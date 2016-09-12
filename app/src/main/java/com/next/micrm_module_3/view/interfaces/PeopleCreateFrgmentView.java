package com.next.micrm_module_3.view.interfaces;

/**
 * Created by wcamaly on 10/06/2016.
 */
public interface PeopleCreateFrgmentView {
    void setErrorName();
    void setErrorEmail();
    void setErrorTel();
    void notificationCreate(boolean s);
    void actionCancel();
    void actionOk();
    void change(int i);
}
