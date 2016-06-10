package com.next.micrm_module_3.presenter.interfaces;

/**
 * Created by wcamaly on 09/06/2016.
 */
public interface PeopleInteractor {
    interface onPeople{
        void onChangePeople();
        void onCreatePeople();
        void onDestroy();
    }
    void createPeople();
    void changePeople();
    void deletePeople();
}
