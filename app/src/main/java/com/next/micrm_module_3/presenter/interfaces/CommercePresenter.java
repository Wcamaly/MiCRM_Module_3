package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;

import java.util.List;

/**
 * Created by wcamaly on 21/06/2016.
 */
public interface CommercePresenter {
    void addCommerce(String t, String d, double v, String s, String date, People pe, Organization or);
    Commerce getCommerceChange(int i);
    List<People> getListPoples();
    List<Organization> getListOrganization();
    void onDestroy();
    void delete(int i);

}
