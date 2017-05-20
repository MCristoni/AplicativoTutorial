package com.matheuscristoni.tutoriais.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.matheuscristoni.tutoriais.R;

public class TesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        ((TextView)findViewById(R.id.test2)).setText(R.string.test);
    }
}
