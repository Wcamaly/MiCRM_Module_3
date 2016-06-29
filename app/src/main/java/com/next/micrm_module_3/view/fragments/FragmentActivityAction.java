package com.next.micrm_module_3.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.Commerce;
import com.next.micrm_module_3.model.Organization;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.model.interfaces.Entidad;
import com.next.micrm_module_3.presenter.ActivityPresenterImpl;
import com.next.micrm_module_3.presenter.interfaces.ActivityPresenter;
import com.next.micrm_module_3.view.interfaces.ActivityFragmentView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcamaly on 22/06/2016.
 */
public class FragmentActivityAction extends Fragment implements ActivityFragmentView, View.OnClickListener,AdapterView.OnItemSelectedListener  {
    private ActivityPresenter pActivity;
    private Button ok,cancel;
    private TextView tType,tDescription,tDate,tHour;
    private Spinner sAsignTo,sAsigning;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_action,container,false);
        pActivity = new ActivityPresenterImpl(this);
        tType  = (TextView) rootView.findViewById(R.id.typeActivity);
        tDescription = (TextView) rootView.findViewById(R.id.descriptionActivity);
        tDate = (TextView) rootView.findViewById(R.id.dateActivity);
        tHour = (TextView) rootView.findViewById(R.id.hourActivity);
        ok = (Button) rootView.findViewById(R.id.okAcitvity);
        ok.setOnClickListener(this);
        cancel = (Button) rootView.findViewById(R.id.cancelactivity);
        cancel.setOnClickListener(this);
        sAsignTo = (Spinner) rootView.findViewById(R.id.asignTo);
        sAsignTo.setOnItemSelectedListener(this);
        setAdapterAsigTo();
        sAsigning = (Spinner) rootView.findViewById(R.id.selectedType);
        sAsigning.setOnItemSelectedListener(this);


        return rootView;
    }

    private void setAdapterAsigTo() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                new String[]{
                        getActivity().getString(R.string.peoples),
                        getActivity().getString(R.string.commerce),
                        getActivity().getString(R.string.organizations)
                }
        );
        sAsignTo.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if(getArguments().getInt(ConstantGeneral.ARG_ID_ACTIVITY) != -1)
            inflater.inflate(R.menu.menu_fragments, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                actionDelete();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void setErrorType() {
        tType.setError(getActivity().getString(R.string.Error_type));
    }

    @Override
    public void setErrorDescription() {
        tDescription.setError(getActivity().getString(R.string.error_description));
    }

    @Override
    public void setErrorDate() {
        tDate.setError(getActivity().getString(R.string.error_date));
    }

    @Override
    public void setErrorHour() {
        tHour.setError(getActivity().getString(R.string.error_hour));
    }

    @Override
    public void setErrorAsign() {
        Toast.makeText(getActivity(),R.string.error_asign,Toast.LENGTH_LONG).show();
    }

    @Override
    public void selectedAsign(List<?> list, int ty) {
        List<String> l = new ArrayList<String>();
        for(int i=0;i< list.size();i++){
            if (ty == 1){
                l.add(((People) list.get(i)).getName());
            }
            if(ty == 2){
                l.add(((Organization) list.get(i)).getName());
            }
            if(ty == 3){
                l.add(((Commerce) list.get(i)).getTitle());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,l);
        sAsigning.setAdapter(adapter);

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

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
