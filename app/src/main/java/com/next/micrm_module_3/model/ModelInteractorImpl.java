package com.next.micrm_module_3.model;

/**
 * Created by Wally1 on 08/06/2016.
 */
public class ModelInteractorImpl implements ModelInteractor {
    ModelInteractor model= new ModelInteractorImpl();
    private ModelInteractorImpl() {}
    @Override
    public ModelInteractor getInstances() {
        return model;
    }
    @Override
    public ActivityAction getActivityAction(int i) {
        if(activitys != null)
            return activitys.get(i);
        return  null;
    }
    @Override
    public void setActivitys(ActivityAction a) {
        if (a != null)
            activitys.add(a);
    }
    @Override
    public People getPeoples(int i) {
        if(peoples != null)
            return peoples.get(i);
        return null;
    }
    @Override
    public void setPeoples(People people) {
        if(people != null)
            peoples.add(people);
    }
    @Override
    public Commerce getCommerces(int i) {
        if(commerces != null)
            return commerces.get(i);
        return null;
    }
    @Override
    public void setCommerces(Commerce commerce) {
        if(commerce != null)
            commerces.add(commerce);
    }
    @Override
    public Organization getOrganizations(int i) {
        if(organizations != null)
            return organizations.get(i);
        return null;
    }
    @Override
    public void setOrganizations(Organization organization) {
       if (organization != null)
            organizations.add(organization);
    }
}
