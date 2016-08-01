package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.List;

/**
 * Created by wcamaly on 29/06/2016.
 */
public interface ActivityPresenter {
    void addActivity(String t, String d, String h, String date,Entidad e);
    ActivityAction getActivityChange(int i);
    List<People> getListPoples();
    List<Organization> getListOrganization();
    List<Commerce> getListCommerce();
    void onDestroy();
    void delete(int i);


}
