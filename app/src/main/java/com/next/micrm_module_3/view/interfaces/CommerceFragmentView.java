package com.next.micrm_module_3.view.interfaces;

import android.view.View;
import android.widget.Spinner;

import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wcamaly on 21/06/2016.
 */
public interface CommerceFragmentView {
    void setErrorTitle();
    void setErrorDescription();
    void setErrorDate();
    void setErrorStatus();
    void setErrorValue();
    void setErrorAsign();
    void evalAsign();
    void loadAsign(Spinner v, List<?> list, int as);
    void actionCreatePeople();
    void actionCreateOrganization();
    void actionCancel();
    void actionOk();
    void actionDelete();
    void change(int i);
}
