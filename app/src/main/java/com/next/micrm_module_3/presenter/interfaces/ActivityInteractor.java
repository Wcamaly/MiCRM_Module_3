package com.next.micrm_module_3.presenter.interfaces;

import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.interfaces.Entidad;

/**
 * Created by wcamaly on 29/06/2016.
 */
public interface ActivityInteractor {

    interface onActivityAction{
        void onErrorType();
        void onErrorDescription();
        void onErrorAsign();
        void onErrorDate();
        void onErrorHour();
    }
    boolean createNewActivity(String t, String d, Entidad entidad,String date, String hour,onActivityAction listener);
    ActivityAction getActivityChange(int i);
    void deleteActivity(int i);

}
