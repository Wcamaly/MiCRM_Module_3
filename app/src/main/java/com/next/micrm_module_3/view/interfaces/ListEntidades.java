package com.next.micrm_module_3.view.interfaces;

import android.view.View;

import com.next.micrm_module_3.model.ModelEntidadList;
import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.List;

/**
 * Created by wcamaly on 06/07/2016.
 */
public interface ListEntidades {
    void createAdapter(List<ModelEntidadList> l);
    List<ModelEntidadList> createListString();
    void onClickItemSelected(View v);
}
