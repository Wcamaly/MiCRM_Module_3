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
import com.next.micrm_module_3.model.ActivityAction;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.ModelInteractor;
import com.next.micrm_module_3.presenter.ModelPresenter;
import com.next.micrm_module_3.view.interfaces.ShowEntidadFragmanetView;

/**
 * This class, It is responsible for displaying the data of an Commerce.
 */
public class FragmentCommerce extends Fragment implements ShowEntidadFragmanetView, View.OnClickListener {
    Button back,change;
    ModelInteractor mModel = ModelPresenter.getInstances();
    int pos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_commerce,container,false);
        InitializerView(rootView);
        setOnListenerClick();
        return rootView;
    }

    private void setOnListenerClick() {
        back.setOnClickListener(this);
        change.setOnClickListener(this);
    }

    private void InitializerView(View rootView) {
        back = (Button) rootView.findViewById(R.id.CommerceBack);
        change = (Button) rootView.findViewById(R.id.CommerceChange);
        if(getArguments() != null)
            pos = getArguments().getInt(ConstantGeneral.ARG_ID_COMMERCE);
        else
            Toast.makeText(getContext(),"Se produjo un error",Toast.LENGTH_LONG).show();Commerce comm = mModel.getCommerce(pos);
        TextView des = (TextView) rootView.findViewById(R.id.CommerceDescription);
        des.setText(comm.getDescription());
        TextView tit = (TextView) rootView.findViewById(R.id.CommerceTitle);
        tit.setText(comm.getTitle());
        TextView date = (TextView) rootView.findViewById(R.id.CommerceDate);
        date.setText(comm.getDateFinish());
        TextView status = (TextView) rootView.findViewById(R.id.CommerceStatus);
        status.setText(comm.getStatus());
        TextView valor = (TextView) rootView.findViewById(R.id.CommerceValue);
        valor.setText(Double.toString(comm.getValue()));
        TextView asig = (TextView) rootView.findViewById(R.id.CommerceComponen);
        String as = new String();
        if(mModel.getOrganizations() != null) {
            for (Organization com : mModel.getOrganizations()) {
                as.concat(com.getName().concat("\n"));
            }
        }
        if(mModel.getPeoples() != null){
            for(People peo : mModel.getPeoples() ){
                as.concat(peo.getName().concat("\n"));
            }
        }
        asig.setText(as);
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
        arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_COMMERCE);
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
            case R.id.CommerceBack:
                actionBack();
                break;
            case R.id.CommerceChange:
                actionChange();
                break;
        }
    }
}