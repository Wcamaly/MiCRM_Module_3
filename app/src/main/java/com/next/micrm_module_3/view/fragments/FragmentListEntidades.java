package com.next.micrm_module_3.view.fragments;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.adapters.ListEntidadAdapter;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.ModelPresenter;
import com.next.micrm_module_3.view.interfaces.ListEntidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcamaly on 06/07/2016.
 */
public class FragmentListEntidades extends Fragment implements ListEntidades {
    RecyclerView adapter;
    ModelInteractor mModel = ModelPresenter.getInstances();
    public FragmentListEntidades() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_listitemview,container,false);
        adapter = (RecyclerView) rootView.findViewById(R.id.listView);
        createAdapter(createListString());
        return rootView;
    }
    @TargetApi(Build.VERSION_CODES.ECLAIR_MR1)
    @Override
    public void createAdapter(List<String> l) {
        ListEntidadAdapter eAdapter = new ListEntidadAdapter(getContext(), l, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemSelected(v);
            }
        });
        adapter.setAdapter(eAdapter);

    }

    @Override
    public List<String> createListString() {
        List<String> aux = new ArrayList<String>();
      switch (getArguments().getInt(ConstantGeneral.SELECTED_ITEM_MENU)){
          case ConstantGeneral.ITEM_MENU_ACTIVITY:
              for (ActivityAction item: mModel.getActivitys()){
                aux.add(item.getDescription());
              }
              break;
          case ConstantGeneral.ITEM_MENU_COMMERCE:
              for (Commerce item: mModel.getCommerces()){
                  aux.add(item.getTitle());
              }
              break;
          case ConstantGeneral.ITEM_MENU_ORGANIZATION:
              for (Organization item: mModel.getOrganizations()){
                  aux.add(item.getName());
              }
              break;
          case ConstantGeneral.ITEM_MENU_PEOPLE:
              for (People item: mModel.getPeoples()){
                  aux.add(item.getName());
              }
              break;
      }
         return aux;
    }

    @Override
    public void onClickItemSelected(View v) {
        FragmentTransaction ft=  getActivity().getSupportFragmentManager().beginTransaction();
        int itemPosition = adapter.indexOfChild(v);
        switch (getArguments().getInt(ConstantGeneral.SELECTED_ITEM_MENU)){
            case ConstantGeneral.ITEM_MENU_ACTIVITY:
                getArguments().putInt(ConstantGeneral.ARG_ID_ACTIVITY, itemPosition);
                ft.replace(R.id.fragment_section,new FragmentActivityAction()).commit();
                break;
            case ConstantGeneral.ITEM_MENU_COMMERCE:
                getArguments().putInt(ConstantGeneral.ARG_ID_COMMERCE, itemPosition);
                ft.replace(R.id.fragment_section,new FragmentCommerceCreate()).commit();

                break;
            case ConstantGeneral.ITEM_MENU_ORGANIZATION:
                getArguments().putInt(ConstantGeneral.ARG_ID_ORGANIZATION, itemPosition);
                ft.replace(R.id.fragment_section,new FragmentOrganizationCreate()).commit();

                break;
            case ConstantGeneral.ITEM_MENU_PEOPLE:
                getArguments().putInt(ConstantGeneral.ARG_ID_PEOPLE, itemPosition);
                ft.replace(R.id.fragment_section,new FragmentPeopleCreate()).commit();
                break;
        }


    }


}
