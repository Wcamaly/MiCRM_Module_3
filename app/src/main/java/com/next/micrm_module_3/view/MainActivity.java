package com.next.micrm_module_3.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.view.interfaces.MainViewInteractor;

public class MainActivity extends AppCompatActivity implements MainViewInteractor {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
