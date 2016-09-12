package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.People;

/**
 * Created by wcamaly on 09/06/2016.
 */
public interface PeopleInteractor {
    interface onPeople{
        void onErrorName();
        void onErrorTel();
        void onErrorEmail();
        void onDestroy();
        void onCreate(boolean s);
    }
    boolean createPeople(String name,String email,String tel, final onPeople listener);
    People getChangePeople(int i);
    void deletePoeple(int i);

}
