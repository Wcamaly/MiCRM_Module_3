package com.next.micrm_module_3.view.interfaces;

import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import java.util.List;

/**
 * Interface to Create Activity
 */
public interface ActivityFragmentView {
    void setErrorType();
    void setErrorDescription();
    void setErrorDate();
    void setErrorHour();
    void setErrorAsign();
    void selectedAsign(List<?> list, int ty);
    void actionCancel();
    void actionOk();
    void change(int i);
}
