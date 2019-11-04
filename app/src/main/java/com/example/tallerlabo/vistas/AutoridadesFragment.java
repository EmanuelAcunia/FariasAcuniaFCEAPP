package com.example.tallerlabo.vistas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import com.example.tallerlabo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AutoridadesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AutoridadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AutoridadesFragment extends Fragment{


    private OnFragmentInteractionListener mListener;
    View vista;
    private List<Map<String, Object>> autoridades;
    private ListView lvAuto;

    public AutoridadesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AutoridadesFragment newInstance(String param1, String param2) {
        AutoridadesFragment fragment = new AutoridadesFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_autoridades, container, false);

        Intent intent= getActivity().getIntent();

        autoridades = (List<Map<String, Object>>) intent.getSerializableExtra("autoridades");
        lvAuto = (ListView) vista.findViewById(R.id.list_autoridad);

        String[] datos = {"cargo", "foto", "nombre", "icoEm","email","icoTel","telefono"};
        int[] vistas = {R.id.cargo,R.id.foto,R.id.nombre,R.id.icoEm,R.id.email,R.id.icoTel,R.id.telefono};

        SimpleAdapter adaptador = new SimpleAdapter(getActivity(), listadoAutoridades(), R.layout.item_autoridades, datos, vistas);
        //autoridades.setAdapter(adaptador);
        lvAuto.setAdapter(adaptador);

        return vista;
    }

    private List<Map<String, Object>> listadoAutoridades() {
        autoridades = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("cargo", "Decano");
        item.put("foto", R.drawable.decano);
        item.put("nombre", "Ing. Pedro Juvenal Basualdo");
        item.put("icoEm", R.drawable.email);
        item.put("email", "basualdo@unse.edu.ar");
        item.put("icoTel", R.drawable.telefono);
        item.put("telefono", "385 450 9560  Int 1831");
        autoridades.add(item);

        item = new HashMap<String, Object>();
        item.put("cargo", "Vicedecano");
        item.put("foto", R.drawable.vicedecano);
        item.put("nombre", "Dr. Ing. Carlos Ramón Juárez");
        item.put("icoEm", R.drawable.email);
        item.put("email", "cjuarez@unse.edu.ar");
        item.put("icoTel", R.drawable.telefono);
        item.put("telefono", "385 450 9560  Int 1842");
        autoridades.add(item);

        item = new HashMap<String, Object>();
        item.put("cargo", "Secretaria Academica");
        item.put("foto", R.drawable.secretaria);
        item.put("nombre", "Dra. María Fernanda Mellano");
        item.put("icoEm", R.drawable.email);
        item.put("email", "fermellano@unse.edu.ar");
        item.put("icoTel", R.drawable.telefono);
        item.put("telefono", "385 450 9560   Int 1840");
        autoridades.add(item);

        item = new HashMap<String, Object>();
        item.put("cargo", "Secretaria de Administracion");
        item.put("foto", R.drawable.administracion);
        item.put("nombre", "Lic. Juan Carlos Coronel Gallardo");
        item.put("icoEm", R.drawable.email);
        item.put("email", "jccgall@unse.edu.ar");
        item.put("icoTel", R.drawable.telefono);
        item.put("telefono", "385 450 9560   Int 1833");
        autoridades.add(item);

        return autoridades;
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
