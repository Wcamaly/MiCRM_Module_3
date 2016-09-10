package com.next.micrm_module_3.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.presenter.OrganizationPresenterImpl;
import com.next.micrm_module_3.presenter.interfaces.OrganizationPresenter;
import com.next.micrm_module_3.view.interfaces.OrganizationCreateFragmentView;

/**
 * This class is the create new Organization
 */
public class FragmentOrganizationCreate extends Fragment implements OrganizationCreateFragmentView, View.OnClickListener {
    private EditText name,tel,addres;
    private OrganizationPresenter mPresenter;
    private Button cancel,ok;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_organiztion_create,container,false);
        initializeView(rootView);
        setOnListener();
        return  rootView;
    }
    @Override
    public void onDestroy(){
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setErrorName() {
        name.setError(getString(R.string.error_Name));
    }

    @Override
    public void setErrorAddres() {
        addres.setError(getString(R.string.error_addres));
    }

    @Override
    public void setErrorTel() {
        tel.setError(getString(R.string.error_Tel));
    }

    @Override
    public void actionCancel() {
        backFragment();
    }

    @Override
    public void actionOk() {
       if (! mPresenter.addOrganization(name.getText().toString(),
                tel.getText().toString(),
                addres.getText().toString()))
            backFragment();


    }
    @Override
    public void onClick(View v) {
        //Lineas para ocultar el teclado virtual (Hide keyboard)
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(addres.getWindowToken(), 0);
        switch (v.getId()){
            case R.id.okOrganization:
                actionOk();
                break;
            case R.id.cancelOrganization:
                actionCancel();
                break;
        }

    }

    private void initializeView(View rootView) {
        name = (EditText) rootView.findViewById(R.id.nameOrganization);
        tel = (EditText) rootView.findViewById(R.id.numberOrganization);
        addres = (EditText) rootView.findViewById(R.id.addresOrganization);
        ok = (Button) rootView.findViewById(R.id.okOrganization);
        cancel = (Button) rootView.findViewById(R.id.cancelOrganization);


    }

    private void backFragment() {
        FragmentTransaction ft =  getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = new FragmentListEntidades();
        Bundle arg = new Bundle();
        arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_ORGANIZATION);
        fragment.setArguments(arg);
        ft.replace(R.id.fragment_section, fragment)
                .commit();
    }

    private void setOnListener() {
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        mPresenter = new OrganizationPresenterImpl(this);
    }
}
