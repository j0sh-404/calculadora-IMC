package com.nrj_clinica.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Examen3 extends AppCompatActivity {
    BottomNavigationView mBotonNavigation;
    private RecyclerView recyclerViewPersonas;
    private RecyclerViewAdaptador aaptadorPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen3);
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
                        startActivity(new Intent(getApplicationContext(),Examen2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu_examen3:
                        return true;


                }
                return false;
            }
        });
         BasedeDatos bd = new BasedeDatos(getApplicationContext());
        recyclerViewPersonas=(RecyclerView)findViewById(R.id.recyclerViewPersonas);
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(this));

        aaptadorPersonas=new RecyclerViewAdaptador(bd.mostrarPersonas());
        recyclerViewPersonas.setAdapter(aaptadorPersonas);
    }


    }
