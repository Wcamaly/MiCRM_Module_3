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
import android.widget.EditText;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.presenter.PeoplePresenterImpl;
import com.next.micrm_module_3.presenter.interfaces.PeoplePresenter;
import com.next.micrm_module_3.view.interfaces.PeopleCreateFrgmentView;

/**
 * This class is the create new people
 */
public class FragmentPeopleCreate extends Fragment implements PeopleCreateFrgmentView, View.OnClickListener {
    private EditText name, tel, email;
    private PeoplePresenter mPresenter;
    private Button ok,cancel;
    public FragmentPeopleCreate() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people_create,container,false);

        initializeView(rootView);
        setOnListener();

        return rootView;
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if(getArguments().getInt(ConstantGeneral.ARG_ID_PEOPLE) != -1)
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
    public void setErrorName() {
        name.setError(getString(R.string.error_Name));

    }
    @Override
    public void setErrorEmail() {
        email.setError(getString(R.string.error_email));
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
        mPresenter.addPeople(name.getText().toString(),
                tel.getText().toString(),
                email.getText().toString());
        backFragment();


    }



    @Override
    public void actionDelete() {
        mPresenter.onDelete(getArguments().getInt(ConstantGeneral.ARG_ID_PEOPLE));
    }

    @Override
    public void change(int i) {
        People p = mPresenter.getChangePeople(i);
        name.setText(p.getName());
        tel.setText(p.getTel());
        email.setText(p.getEmail());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okPeople:
                 actionOk();
                break;
            case R.id.cancelPeople:
                actionCancel();
                break;
        }
    }

    private void initializeView(View rootView) {
        name = (EditText) rootView.findViewById(R.id.namePeople);
        tel  = (EditText) rootView.findViewById(R.id.numberPeople);
        email = (EditText) rootView.findViewById(R.id.emailPeople);
        cancel = (Button) rootView.findViewById(R.id.cancelPeople);
        ok = (Button) rootView.findViewById(R.id.okPeople);
        if(getArguments() != null && getArguments().getInt(ConstantGeneral.ARG_ID_PEOPLE) != -1){
            change(getArguments().getInt(ConstantGeneral.ARG_ID_PEOPLE));
            setHasOptionsMenu(true);
        }
    }

    private void backFragment() {
        FragmentTransaction ft =  getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = new FragmentListEntidades();
        Bundle arg = new Bundle();
        arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_PEOPLE);
        fragment.setArguments(arg);
        ft.replace(R.id.fragment_section, fragment)
                .commit();
    }

    private void setOnListener() {
        cancel.setOnClickListener(this);
        ok.setOnClickListener(this);
        mPresenter = new PeoplePresenterImpl(this);
    }
}
