package com.example.tallerlabo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.tallerlabo.Adapters.DataBaseHelper;
import com.example.tallerlabo.Adapters.Utilidades;
import com.example.tallerlabo.vistas.AutoridadesFragment;
import com.example.tallerlabo.vistas.CarrerasFragment;
import com.example.tallerlabo.vistas.ContactosFragment;
import com.example.tallerlabo.vistas.DatosFragment;
import com.example.tallerlabo.vistas.DptoFragment;
import com.example.tallerlabo.vistas.FceFragment;
import com.example.tallerlabo.vistas.InstitutoFragment;
import com.example.tallerlabo.vistas.ItemCarreraFragment;
import com.example.tallerlabo.vistas.RedesFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,InstitutoFragment.OnFragmentInteractionListener,
        CarrerasFragment.OnFragmentInteractionListener,RedesFragment.OnFragmentInteractionListener,
        ContactosFragment.OnFragmentInteractionListener, FceFragment.OnFragmentInteractionListener,
        AutoridadesFragment.OnFragmentInteractionListener, DptoFragment.OnFragmentInteractionListener,
        DatosFragment.OnFragmentInteractionListener, ItemCarreraFragment.OnFragmentInteractionListener {

    private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DataBaseHelper(this,"Carreras",null,1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(Utilidades.crearBase==true){
            crearCarreras();
            Utilidades.crearBase=false;
        }


        //Fragmento de inicio
        if(Utilidades.validaPantalla==true){
            Fragment fragment = new InstitutoFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            Utilidades.validaPantalla=false;
        }


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    public void crearCarreras(){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nombre","Ingenieria en Agrimensura");
        valores.put("dpto","Dpto de Agrimensura");
        valores.put("pagina","http://fce.unse.edu.ar/?q=ingenieria-en-agrimensura");
        valores.put("duracion","5 años");

        long resultadoInsert = db.insert("carrera", String.valueOf(0), valores);

        valores = new ContentValues();
        valores.put("nombre","Ingenieria Electronica");
        valores.put("dpto","Dpto de Electronica");
        valores.put("pagina","http://fce.unse.edu.ar/?q=ingenieria-electronica");
        valores.put("duracion","5 años");

        resultadoInsert = db.insert("carrera", String.valueOf(1), valores);

        valores = new ContentValues();
        valores.put("nombre","Profesorado en Fisica");
        valores.put("dpto","Dpto. de Fisica");
        valores.put("pagina","http://fce.unse.edu.ar/?q=profesorado-en-fisica");
        valores.put("duracion","4 años");

        resultadoInsert = db.insert("carrera", String.valueOf(2), valores);

        valores = new ContentValues();
        valores.put("nombre","Lic. en Sistemas de Informatica");
        valores.put("dpto","Dpto. de Informatica");
        valores.put("pagina","http://fce.unse.edu.ar/?q=licenciatura-en-sistemas-de-informacion");
        valores.put("duracion","5 años");

        resultadoInsert = db.insert("carrera", String.valueOf(3), valores);

        valores = new ContentValues();
        valores.put("nombre","Profesorado en Informatica");
        valores.put("dpto","Dpto. de Informatica");
        valores.put("pagina","http://fce.unse.edu.ar/?q=profesorado-en-informatica");
        valores.put("duracion","4 años");

        resultadoInsert = db.insert("carrera", String.valueOf(4), valores);

        valores = new ContentValues();
        valores.put("nombre","Prog. Universitario en Informatica");
        valores.put("dpto","Dpto. de Informatica");
        valores.put("pagina","http://fce.unse.edu.ar/?q=programador-universitario-en-informatica");
        valores.put("duracion","3 años");

        resultadoInsert = db.insert("carrera", String.valueOf(5), valores);

        valores = new ContentValues();
        valores.put("nombre","Lic. en Matematicas");
        valores.put("dpto","Dpto. de Matematica");
        valores.put("pagina","http://fce.unse.edu.ar/?q=lic-en-matematica");
        valores.put("duracion","4 años");

        resultadoInsert = db.insert("carrera", String.valueOf(6), valores);

        valores = new ContentValues();
        valores.put("nombre","Profesorado en Matematica");
        valores.put("dpto","Dpto. de Matematicas");
        valores.put("pagina","http://fce.unse.edu.ar/?q=profesorado-en-matematica");
        valores.put("duracion","4 años");

        resultadoInsert = db.insert("carrera", String.valueOf(7), valores);

        valores = new ContentValues();
        valores.put("nombre","Ingenieria Vial");
        valores.put("dpto","Dpto. de Obras Viales");
        valores.put("pagina","http://fce.unse.edu.ar/?q=ingenieria-vial");
        valores.put("duracion","5 años");

        resultadoInsert = db.insert("carrera", String.valueOf(8), valores);

        valores = new ContentValues();
        valores.put("nombre","Ingenieria Civil");
        valores.put("dpto","Dpto. de Obras Viales");
        valores.put("pagina","http://fce.unse.edu.ar/?q=ingenieria-civil");
        valores.put("duracion","5 años");

        resultadoInsert = db.insert("carrera", String.valueOf(9), valores);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        Fragment items = null;
        boolean fragSeleccionado= false;

        if (id == R.id.nav_home) {
            miFragment=new InstitutoFragment();
            fragSeleccionado=true;
        } else if (id == R.id.nav_carreras) {
            miFragment=new CarrerasFragment();
            items = new ItemCarreraFragment();
            fragSeleccionado=true;

        } else if (id == R.id.nav_redes) {
            miFragment=new RedesFragment();
            fragSeleccionado=true;

        } else if (id == R.id.nav_contacto) {
            miFragment=new ContactosFragment();
            fragSeleccionado=true;

        }

        if(fragSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
