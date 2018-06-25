package com.milog.myannotation;

import android.app.Activity;
import android.os.Bundle;

import com.milog.annotation.MiloConfig3;
import com.milog.myannotation.annnotation.MiloConfig;

@MiloConfig3
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
