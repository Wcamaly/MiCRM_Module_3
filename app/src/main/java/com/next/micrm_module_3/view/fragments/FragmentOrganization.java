package com.next.micrm_module_3.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.ModelPresenter;
import com.next.micrm_module_3.view.interfaces.ShowEntidadFragmanetView;

/**
 * Created by wcamaly on 17/08/2016.
 */
public class FragmentOrganization  extends Fragment implements ShowEntidadFragmanetView, View.OnClickListener {
    Button back,change;
    ModelInteractor mModel = ModelPresenter.getInstances();
    int pos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_organization,container,false);
        InitializerView(rootView);
        setOnListenerClick();
        return rootView;
    }

    private void setOnListenerClick() {
        back.setOnClickListener(this);
        change.setOnClickListener(this);
    }

    private void InitializerView(View rootView) {
        back = (Button) rootView.findViewById(R.id.organizationBack);
        change = (Button) rootView.findViewById(R.id.organizationChange);
        if(getArguments() != null)
            pos = getArguments().getInt(ConstantGeneral.ARG_ID_ORGANIZATION);
        else
            Toast.makeText(getContext(),"Se produjo un error",Toast.LENGTH_LONG).show();
        Organization org = mModel.getOrganization(pos);
        TextView name = (TextView) rootView.findViewById(R.id.organizationName);
        name.setText(org.getName());
        TextView tel = (TextView) rootView.findViewById(R.id.organizationTel);
        tel.setText(org.getTel());
        TextView addr = (TextView) rootView.findViewById(R.id.organizationAddres);
        addr.setText(org.getAddress());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragments,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                actionDelete();
                break;
        }
        return true;
    }

    @Override
    public void actionDelete() {
        /** It's not Required to task.**/
        Toast.makeText(getContext(),"It's not required to this task",Toast.LENGTH_LONG).show();
    }

    @Override
    public void actionBack() {
        FragmentTransaction ft =  getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = new FragmentListEntidades();
        Bundle arg = new Bundle();
        arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_ORGANIZATION);
        fragment.setArguments(arg);
        ft.replace(R.id.fragment_section, fragment)
                .commit();
    }

    @Override
    public void actionChange() {
        /** It's not Required to task.**/
        Toast.makeText(getContext(),"It's not required to this task",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.organizationBack:
                actionBack();
                break;
            case R.id.organizationChange:
                actionChange();
                break;
        }
    }
}