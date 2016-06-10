package com.next.micrm_module_3.model.interfaces;

import android.app.Activity;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wally1 on 08/06/2016.
 */
public interface ModelInteractor {

    List<ActivityAction> activitys = new ArrayList<ActivityAction>();
    List<People> peoples = new ArrayList<People>();
    List<Commerce> commerces = new ArrayList<Commerce>();
    List<Organization> organizations = new ArrayList<Organization>();
    List<ActivityAction> getActivitys();
    List<People> getPeoples();
    List<Commerce> getCommerces();
    List<Organization> getOrganizations();
    public ActivityAction getActivityAction(int i);
    public void setActivity(ActivityAction a);
    public People getPeople(int i);
    public void setPeople(People people);
    public Commerce getCommerce(int i);
    public void setCommerce(Commerce commerce);
    public Organization getOrganization(int i);
    public void setOrganization(Organization organization);
    void deleteOrganization(int i);
    void deleteCommerce(int i);
    void deletePeople(int i);
    void deleteActivity(int i);



}
