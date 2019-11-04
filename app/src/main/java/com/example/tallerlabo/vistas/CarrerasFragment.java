package com.example.tallerlabo.vistas;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import com.example.tallerlabo.Adapters.DataBaseHelper;
import com.example.tallerlabo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CarrerasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CarrerasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarrerasFragment extends Fragment implements AdapterView.OnItemClickListener{
    
    View vista;
    private List<Map<String, Object>> carreras;
    private ListView lvCarrera;
    private DataBaseHelper helper;
    private DataBaseHelper helper1;
    private EditText buscar;

    private OnFragmentInteractionListener mListener;

    public CarrerasFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CarrerasFragment newInstance(String param1, String param2) {
        CarrerasFragment fragment = new CarrerasFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = new DataBaseHelper(getContext(),"Carreras",null,1);
        helper1 = new DataBaseHelper(getContext(),"Carreras",null,1);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_carreras, container, false);

        Intent intent= getActivity().getIntent();

        carreras = (List<Map<String, Object>>) intent.getSerializableExtra("carreras");

        lvCarrera = (ListView) vista.findViewById(R.id.list_carrera);
        buscar = (EditText) vista.findViewById(R.id.etBuscar);

        String[] datos = {"nomcarrera", "dpto","tvduracion"};
        int[] vistas = {R.id.nomcarrera,R.id.dpto,R.id.tvduracion};
        //lvCarrera.

        SimpleAdapter adaptador = new SimpleAdapter(getActivity(), listadoCarrera(), R.layout.item_carrera, datos, vistas);
        lvCarrera.setAdapter(adaptador);

        lvCarrera.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        return vista;
    }

    private List<Map<String, Object>> listadoCarrera() {

        carreras = new ArrayList<Map<String, Object>>();


            Map<String, Object> item = new HashMap<String, Object>();
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT _id,nombre,dpto,duracion FROM carrera",null);
            cursor.moveToFirst();

            for (int i=0; i < cursor.getCount(); i++){
                item = new HashMap<String, Object>();
                item.put("nomcarrera", cursor.getString(1));
                item.put("dpto", cursor.getString(2));
                item.put("tvduracion",cursor.getString(3));
                carreras.add(item);
                cursor.moveToNext();
            }

            cursor.close();
            helper.close();
            return carreras;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fragment fragmento = new ItemCarreraFragment();
        Bundle datosAEnviar = new Bundle();

        SQLiteDatabase db = helper1.getReadableDatabase();

        Cursor cursor1 = db.rawQuery("SELECT _id,nombre,pagina,duracion FROM carrera",null);

        cursor1.moveToFirst();

        for (int i=0; i < cursor1.getCount(); i++){
            if(i==position){
                datosAEnviar.putString("nombre", cursor1.getString(1));
                datosAEnviar.putString("pagina", cursor1.getString(2));
                datosAEnviar.putString("duracion", cursor1.getString(3));

                fragmento.setArguments(datosAEnviar);
            }
            cursor1.moveToNext();
        }

        cursor1.close();
        helper.close();

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragmento).commit();

    }


    @Override
    public void onDestroy(){
        helper.close();
        super.onDestroy();
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
