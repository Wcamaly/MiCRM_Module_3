package com.next.micrm_module_3.presenter;

import com.next.micrm_module_3.model.People;
import com.next.micrm_module_3.presenter.interfaces.PeopleInteractor;
import com.next.micrm_module_3.presenter.interfaces.PeoplePresenter;
import com.next.micrm_module_3.view.interfaces.PeopleFrgmentView;

/**
 * Created by wcamaly on 10/06/2016.
 */
public class PeoplePresenterImpl implements PeoplePresenter, PeopleInteractor.onPeople  {
    PeopleFrgmentView mView;
    PeopleInteractor mInteractor;
    public PeoplePresenterImpl(PeopleFrgmentView fragmentPeopleCreate) {
        this.mView = fragmentPeopleCreate;
        this.mInteractor = new PeopleInteractorImpl();
    }


    @Override
    public void onErrorName() {
       if(mView != null)
        mView.setErrorName();
    }

    @Override
    public void onErrorTel() {
        if(mView != null)
            mView.setErrorTel();
    }

    @Override
    public void onErrorEmail() {
        if(mView != null)
            mView.setErrorEmail();
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onDelete(int i) {
        mInteractor.deletePeople(i);
    }

    @Override
    public void addPeople(String name, String tel, String email) {
        mInteractor.createPeople(name,email,tel, this);
    }

    @Override
    public People getChangePeople(int i) {
        if (mInteractor != null)
            return mInteractor.getChangePeople(i);
        return null;
    }

}