package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;

import java.util.List;

/**
 * Created by Wally1 on 08/06/2016.
 */
class ModelPresenter implements ModelInteractor {
    private static ModelInteractor model = null ;
    private ModelPresenter() {}

    public static ModelInteractor getInstances() {
        if(model != null)
            return model;
        return new ModelPresenter();
    }
    @Override
    public List<ActivityAction> getActivitys() {
        return activitys;
    }
    @Override
    public List<People> getPeoples() {
        return peoples;
    }
    @Override
    public List<Commerce> getCommerces() {
        return commerces;
    }
    @Override
    public List<Organization> getOrganizations() {
        return organizations;
    }
    @Override
    public ActivityAction getActivityAction(int i) {
        if(activitys != null)
            return activitys.get(i);
        return  null;
    }
    @Override
    public void setActivity(ActivityAction a) {
        if (a != null)
            activitys.add(a);
    }
    @Override
    public People getPeople(int i) {
        if(peoples != null)
            return peoples.get(i);
        return null;
    }
    @Override
    public void setPeople(People people) {
        if(people != null)
            peoples.add(people);
    }
    @Override
    public Commerce getCommerce(int i) {
        if(commerces != null)
            return commerces.get(i);
        return null;
    }
    @Override
    public void setCommerce(Commerce commerce) {
        if(commerce != null)
            commerces.add(commerce);
    }
    @Override
    public Organization getOrganization(int i) {
        if(organizations != null)
            return organizations.get(i);
        return null;
    }
    @Override
    public void setOrganization(Organization organization) {
        if (organization != null)
            organizations.add(organization);
    }
    @Override
    public void deleteOrganization(int i) {
        organizations.remove(i);
    }
    @Override
    public void deleteCommerce(int i) {
        commerces.remove(i);
    }
    @Override
    public void deletePeople(int i) {
        peoples.remove(i);
    }
    @Override
    public void deleteActivity(int i) {
        activitys.remove(i);
    }
}
