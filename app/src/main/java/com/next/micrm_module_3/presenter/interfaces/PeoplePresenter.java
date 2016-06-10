package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.People;

/**
 * Created by wcamaly on 10/06/2016.
 */
public interface PeoplePresenter {
    void addPeople(String name, String tel,String email);
    People getChangePeople(int i);

}
