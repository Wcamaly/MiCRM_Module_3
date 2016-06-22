package com.next.micrm_module_3.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.presenter.CommercePresenterImpl;
import com.next.micrm_module_3.presenter.interfaces.CommercePresenter;
import com.next.micrm_module_3.view.interfaces.CommerceFragmentView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wcamaly on 21/06/2016.
 */
public class FragmentCommerceCreate extends Fragment implements CommerceFragmentView, View.OnClickListener {

    Button cPeople,cOrganization,ok,cancel;
    Spinner lPeoples,lOrganization;
    TextView tTitle,tDescription,tValue,tDate,tStatus;
    CommercePresenter pCommerce;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_commerce, container,false);
        pCommerce = new CommercePresenterImpl(this);
        lPeoples = (Spinner) rootView.findViewById(R.id.spinnerPeople);
        lOrganization = (Spinner) rootView.findViewById(R.id.spinnerOrganization);
        tTitle = (TextView) rootView.findViewById(R.id.titleCommerce);
        tDescription = (TextView) rootView.findViewById(R.id.descriptionCommerce);
        tValue = (TextView) rootView.findViewById(R.id.valorCommerce);
        tDate = (TextView) rootView.findViewById(R.id.valorCommerce);
        tStatus = (TextView) rootView.findViewById(R.id.statusCommerce);
        cPeople = (Button) rootView.findViewById(R.id.createPeople);
        cPeople.setOnClickListener(this);
        cOrganization = (Button) rootView.findViewById(R.id.createOrganization);
        cOrganization.setOnClickListener(this);
        ok = (Button) rootView.findViewById(R.id.okCommerce);
        ok.setOnClickListener(this);
        cancel= (Button) rootView.findViewById(R.id.cancelCommerce);
        cancel.setOnClickListener(this);
        evalAsign();


        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void setErrorTitle() {

    }

    @Override
    public void setErrorDescription() {

    }

    @Override
    public void setErrorDate() {

    }

    @Override
    public void setErrorStatus() {

    }

    @Override
    public void setErrorValue() {

    }

    @Override
    public void setErrorAsign() {

    }

    @Override
    public void evalAsign() {
       if(pCommerce.getListPoples() != null)
           loadAsign(lPeoples,pCommerce.getListPoples());
       else{
           lPeoples.setVisibility(View.GONE);
           cPeople.setVisibility(View.VISIBLE);
       }
        if(pCommerce.getListOrganization() != null)
            loadAsign(lOrganization,pCommerce.getListOrganization());
        else{
            lOrganization.setVisibility(View.GONE);
            cOrganization.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void loadAsign(Spinner v, List<?> list) {
        List<String> l = new ArrayList<String>();
        for(int i=0;i< list.size();i++){
            l.add(list.get(i).getClass().getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,l);
        v.setAdapter(adapter);
    }

    @Override
    public void actionCreatePeople() {
        FragmentTransaction fragmentTransaction=  getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section, new FragmentPeopleCreate()).commit();
    }

    @Override
    public void actionCreateOrganization() {
        FragmentTransaction fragmentTransaction=  getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section, new FragmentCommerceCreate()).commit();
    }

    @Override
    public void actionCancel() {

    }

    @Override
    public void actionOk() {

    }

    @Override
    public void actionDelete() {

    }

    @Override
    public void change(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okCommerce:
                actionOk();
                break;
            case R.id.cancelCommerce:
                actionCancel();
                break;
            case R.id.createPeople:
                actionCreatePeople();
                break;
            case R.id.createOrganization:
                actionCreateOrganization();
                break;
        }

    }
}
