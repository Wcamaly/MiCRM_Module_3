package com.next.micrm_module_3.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.presenter.PeoplePresenterImpl;
import com.next.micrm_module_3.presenter.interfaces.PeoplePresenter;
import com.next.micrm_module_3.view.interfaces.PeopleFrgmentView;

/**
 * Created by wcamaly on 10/06/2016.
 */
public class FragmentPeopleCreate extends Fragment implements PeopleFrgmentView, View.OnClickListener {
    private EditText name;
    private EditText tel;
    private EditText email;
    private PeoplePresenter mPresenter;
    public FragmentPeopleCreate() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people,container,false);
        name = (EditText) rootView.findViewById(R.id.namePeople);
        tel  = (EditText) rootView.findViewById(R.id.numberPeople);
        email = (EditText) rootView.findViewById(R.id.emailPeople);
        rootView.findViewById(R.id.cancelPeople).setOnClickListener(this);
        rootView.findViewById(R.id.okPeople).setOnClickListener(this);
        mPresenter = new PeoplePresenterImpl(this);
        if(getArguments().getInt(ConstantGeneral.ARG_ID_PEOPLE) != -1){
            change(savedInstanceState.getInt(ConstantGeneral.ARG_ID_PEOPLE));
        }
        return rootView;
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
        getFragmentManager().popBackStack();
    }
    @Override
    public void actionOk() {
        mPresenter.addPeople(name.getText().toString(),
                tel.getText().toString(),
                email.getText().toString());
        getFragmentManager().popBackStack();
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
}
