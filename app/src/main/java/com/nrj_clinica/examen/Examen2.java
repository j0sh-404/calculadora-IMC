package com.nrj_clinica.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Examen2 extends AppCompatActivity {
    BottomNavigationView mBotonNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen2);
        mBotonNavigation= findViewById(R.id.bottom_navigation);
        mBotonNavigation.setSelectedItemId(R.id.menu_examen2);
        mBotonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_examenBase:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu_examen2:
                        return true;
                    case R.id.menu_examen3:
                        startActivity(new Intent(getApplicationContext(),Examen3.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });
    }
}