package com.next.micrm_module_3.model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wally1 on 08/06/2016.
 */
public interface ModelInteractor {

    interface  onModelListener{
        void onAddActivity();
        void onAddPeople();
        void onAddOrganization();
        void onCommerce();
        void onDestroy();
    }
    List<ActivityAction> activitys = new ArrayList<ActivityAction>();
    List<People> peoples = new ArrayList<People>();
    List<Commerce> commerces = new ArrayList<Commerce>();
    List<Organization> organizations = new ArrayList<Organization>();

    public ModelInteractor getInstances();
    public ActivityAction getActivityAction(int i);
    public void setActivitys(ActivityAction a);
    public People getPeoples(int i);
    public void setPeoples(People people);
    public Commerce getCommerces(int i);
    public void setCommerces(Commerce commerce);
    public Organization getOrganizations(int i);
    public void setOrganizations(Organization organization);
}
