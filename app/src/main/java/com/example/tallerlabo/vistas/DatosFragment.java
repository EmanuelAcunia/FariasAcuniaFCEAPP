package com.example.tallerlabo.vistas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
 * {@link DatosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DatosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatosFragment extends Fragment implements AdapterView.OnItemClickListener{


    private OnFragmentInteractionListener mListener;

    View vista;
    private List<Map<String, Object>> datos;
    private ListView lvDatos;

    public DatosFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DatosFragment newInstance(String param1, String param2) {
        DatosFragment fragment = new DatosFragment();
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
        vista = inflater.inflate(R.layout.fragment_datos, container, false);

        Intent intent= getActivity().getIntent();

        datos = (List<Map<String, Object>>) intent.getSerializableExtra("datos");
        lvDatos = (ListView) vista.findViewById(R.id.list_dato);

        String[] datos1 = {"iconolink", "nomlink"};
        int[] vistas = {R.id.iconolink,R.id.nomlink};

        SimpleAdapter adaptador = new SimpleAdapter(getActivity(), listadoDatos(), R.layout.item_links, datos1, vistas);
        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener((AdapterView.OnItemClickListener) this);


        return vista;
    }

    private List<Map<String, Object>> listadoDatos() {
        datos = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.agenda);
        item.put("nomlink", "Agenda Telefonica");
        datos.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.logopdf);
        item.put("nomlink", "Calendario Academico");
        datos.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.reloj);
        item.put("nomlink", "Horarios de Clases");
        datos.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.logosiu);
        item.put("nomlink", "Acceso al Siu");
        datos.add(item);

        return datos;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://fce.unse.edu.ar/?q=agenda-telefonica-fceyt")));
            break;
            case 1: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://fce.unse.edu.ar/?q=calendario-academico")));
                break;
            case 2: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://fce.unse.edu.ar/?q=horarios_de_clases")));
                break;
            case 3: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://autogestion.guarani.unse.edu.ar/unse/acceso")));
                break;
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
