package com.next.micrm_module_3.view.fragments;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.adapters.ListEntidadAdapter;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.ModelEntidadList;
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
public class FragmentListEntidades extends Fragment implements ListEntidades, View.OnClickListener, OnQueryTextListener{
    RecyclerView adapter;
    ModelInteractor mModel = ModelPresenter.getInstances();
    FloatingActionButton add=null;
     List<ModelEntidadList> mModelList ;
    ListEntidadAdapter eAdapter;
    public FragmentListEntidades() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_listitemview,container,false);
        adapter = (RecyclerView) rootView.findViewById(R.id.listView);
        mModelList = new ArrayList<>(createListString());
        createAdapter(mModelList);
        add = (FloatingActionButton) rootView.findViewById(R.id.add);
        add.setOnClickListener(this);
        setHasOptionsMenu(true);
        return rootView;
    }
    @TargetApi(Build.VERSION_CODES.ECLAIR_MR1)
    @Override
    public void createAdapter(List<ModelEntidadList> l) {
       eAdapter= new ListEntidadAdapter(getContext(),l , new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemSelected(v);
            }
        });
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        adapter.setLayoutManager(mLayoutManager);
        adapter.setHasFixedSize(true);
        adapter.setAdapter(eAdapter);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.mian_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public List<ModelEntidadList> createListString() {
        List<ModelEntidadList> aux = new ArrayList<ModelEntidadList>();
        int i = getArguments().getInt(ConstantGeneral.SELECTED_ITEM_MENU);
      switch (i){
          case ConstantGeneral.ITEM_MENU_ACTIVITY:
              for (ActivityAction item: mModel.getActivitys()){
                ModelEntidadList m = new ModelEntidadList(item.getDescription());
                  aux.add(m);
              }
              break;
          case ConstantGeneral.ITEM_MENU_COMMERCE:
              for (Commerce item: mModel.getCommerces()){
                  ModelEntidadList m = new ModelEntidadList(item.getTitle());
                  aux.add(m);
              }
              break;
          case ConstantGeneral.ITEM_MENU_ORGANIZATION:
              for (Organization item: mModel.getOrganizations()){
                  ModelEntidadList m = new ModelEntidadList(item.getName());
                  aux.add(m);
              }
              break;
          case ConstantGeneral.ITEM_MENU_PEOPLE:
              for (People item: mModel.getPeoples()){
                  ModelEntidadList m = new ModelEntidadList(item.getName());
                  aux.add(m);
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


    @Override
    public void onClick(View v) {
        FragmentTransaction ft=  getActivity().getSupportFragmentManager().beginTransaction();
        switch (getArguments().getInt(ConstantGeneral.SELECTED_ITEM_MENU)){
            case ConstantGeneral.ITEM_MENU_ACTIVITY:
                ft.replace(R.id.fragment_section,new FragmentActivityAction()).commit();
                break;
            case ConstantGeneral.ITEM_MENU_COMMERCE:
                ft.replace(R.id.fragment_section,new FragmentCommerceCreate()).commit();

                break;
            case ConstantGeneral.ITEM_MENU_ORGANIZATION:
                ft.replace(R.id.fragment_section,new FragmentOrganizationCreate()).commit();

                break;
            case ConstantGeneral.ITEM_MENU_PEOPLE:
                ft.replace(R.id.fragment_section,new FragmentPeopleCreate()).commit();
                break;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<ModelEntidadList> filteredModelList = filter(mModelList, newText);
        eAdapter.animateTo(filteredModelList);
        adapter.scrollToPosition(0);
        return true;
    }

    private List<ModelEntidadList> filter(List<ModelEntidadList> models, String query) {
        query = query.toLowerCase();

        final List<ModelEntidadList> filteredModelList = new ArrayList<>();
        for (ModelEntidadList model : models) {
            final String text = model.getText().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
