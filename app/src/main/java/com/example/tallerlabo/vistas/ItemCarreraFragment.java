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
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tallerlabo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ItemCarreraFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ItemCarreraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemCarreraFragment extends Fragment implements AdapterView.OnItemClickListener{


    View vista;
    private List<Map<String, Object>> itemCar;
    private ListView lvItemCar;
    private TextView tvNomCar;

    private OnFragmentInteractionListener mListener;

    public ItemCarreraFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ItemCarreraFragment newInstance(String param1, String param2) {
        ItemCarreraFragment fragment = new ItemCarreraFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_item_carrera, container, false);


        Intent intent= getActivity().getIntent();

        String nom= getArguments().getString("nombre");

        String dur= getArguments().getString("duracion");
        String per= getArguments().getString("perfil");

        itemCar = (List<Map<String, Object>>) intent.getSerializableExtra("itemCar");

        tvNomCar = (TextView) vista.findViewById(R.id.nomCarre);
        lvItemCar = (ListView) vista.findViewById(R.id.datos_carrera);

        String[] datos = {"iconolink", "nomlink"};
        int[] vistas = {R.id.iconolink,R.id.nomlink};

        SimpleAdapter adaptador = new SimpleAdapter(getActivity(), Carrera(dur), R.layout.item_links, datos, vistas);
        lvItemCar.setAdapter(adaptador);
        tvNomCar.setText(nom);

        lvItemCar.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        return vista;
    }


    private List<Map<String, Object>> Carrera(String dur){

        itemCar = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.icomapa);
        item.put("nomlink", "Avda. Belgrano (Sud) N° 1912");
        itemCar.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.telefono);
        item.put("nomlink", "385 450 9560");
        itemCar.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.iconav);
        item.put("nomlink", "Perfil Profesional");
        itemCar.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.reloj);
        item.put("nomlink",dur);
        itemCar.add(item);

        return itemCar;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String pag= getArguments().getString("pagina");

        switch (position){
            case 0: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.ar/maps/place/UNSE%2FUniversidad+Nacional+de+Santiago+del+Estero/@-27.8015276,-64.2523176,18z/data=!4m5!3m4!1s0x943b4df913f0ac29:0x6d7da993ed25f896!8m2!3d-27.8015324!4d-64.2512233")));
                break;
            case 1: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:3854509560")));
                break;
            case 2: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(pag)));
                break;
        }

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
