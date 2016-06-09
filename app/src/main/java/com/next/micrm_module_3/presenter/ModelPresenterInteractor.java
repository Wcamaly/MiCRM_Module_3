package com.next.micrm_module_3.presenter;

import android.view.View;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.ModelInteractor;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.view.MainViewInteractor;

import java.util.List;

/**
 * Created by Wally1 on 08/06/2016.
 */
public interface ModelPresenterInteractor {

    void onCreate(MainViewInteractor v, ModelInteractor m);
    void addActivityAcction(ActivityAction a);
    void addPople(People p);
    void addCommerce(Commerce c);
    void addOrganization (Organization o);
    List<People> getArrayPeoples();
    List<Organization> getArrayOrganization();
    List<Commerce> getArrayCommerce();
    List<ActivityAction> getActivitysAction();
    void changePeople(int i);
    void changeOrganization(int i);
    void changeActivitysAction(int i);
    void changeCommerce(int i);
}
