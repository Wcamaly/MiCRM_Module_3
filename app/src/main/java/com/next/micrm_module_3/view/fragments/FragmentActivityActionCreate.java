package com.next.micrm_module_3.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * This class is the view controller to create/change new Activity
 */
public class FragmentActivityActionCreate extends Fragment implements ActivityFragmentView, View.OnClickListener,AdapterView.OnItemSelectedListener  {
    private ActivityPresenter pActivity;
    private Button ok,cancel;
    private TextView tType,tDescription,tDate,tHour;
    private Spinner sAsignTo,sAsigning;
    private int asign = -1;
    private Entidad enti = null;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_action_create,container,false);
        initializeView(rootView);
        setOnListener();
        return rootView;
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
        backFragment();
    }

    @Override
    public void actionOk() {
        pActivity.addActivity(tType.getText().toString(),
                tDescription.getText().toString(),
                tHour.getText().toString(),
                tDate.getText().toString(),
                enti);
        backFragment();


    }

    @Override
    public void change(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okAcitvity:
                actionOk();
                break;
            case R.id.cancelactivity:
                actionCancel();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       switch (view.getId()){
           case R.id.asignTo:
               asign = position+1;
               break;
           case R.id.selectedType:
               if (asign == 1){
                   enti = pActivity.getListPoples().get(position);
               }
               if(asign == 2){
                  enti = pActivity.getListOrganization().get(position);
               }
               if(asign == 3){
                   enti = pActivity.getListCommerce().get(position);
               }
               break;
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initializeView(View rootView){
        pActivity = new ActivityPresenterImpl(this);
        tType  = (TextView) rootView.findViewById(R.id.typeActivity);
        tDescription = (TextView) rootView.findViewById(R.id.descriptionActivity);
        tDate = (TextView) rootView.findViewById(R.id.dateActivity);
        tHour = (TextView) rootView.findViewById(R.id.hourActivity);
        ok = (Button) rootView.findViewById(R.id.okAcitvity);
        cancel = (Button) rootView.findViewById(R.id.cancelactivity);
        sAsignTo = (Spinner) rootView.findViewById(R.id.asignTo);
        sAsigning = (Spinner) rootView.findViewById(R.id.selectedType);
    }

    private void setOnListener(){
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        sAsignTo.setOnItemSelectedListener(this);
        setAdapterAsigTo();
        sAsigning.setOnItemSelectedListener(this);
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

    private void backFragment() {
        FragmentTransaction ft =  getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = new FragmentListEntidades();
        Bundle arg = new Bundle();
        arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_ACTIVITY);
        fragment.setArguments(arg);
        ft.replace(R.id.fragment_section, fragment)
                .commit();
    }
}
