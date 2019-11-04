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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tallerlabo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RedesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RedesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class RedesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private OnFragmentInteractionListener mListener;

    View vista;
    private List<Map<String, Object>> redes;
    private ListView lvRedes;

    public RedesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RedesFragment newInstance(String param1, String param2) {
        RedesFragment fragment = new RedesFragment();
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
        vista = inflater.inflate(R.layout.fragment_redes, container, false);

        Intent intent= getActivity().getIntent();

        redes = (List<Map<String, Object>>) intent.getSerializableExtra("redes");
        lvRedes = (ListView) vista.findViewById(R.id.list_red);

        String[] datos = {"iconolink", "nomlink"};
        int[] vistas = {R.id.iconolink,R.id.nomlink};

        SimpleAdapter adaptador = new SimpleAdapter(getActivity(), listadoRedes(), R.layout.item_links, datos, vistas);
        lvRedes.setAdapter(adaptador);
        lvRedes.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        return vista;
    }



    private List<Map<String, Object>> listadoRedes() {
        redes = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.logoface);
        item.put("nomlink", "Fceyt Unse");
        redes.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.logoinsta);
        item.put("nomlink", "Fceyt Unse");
        redes.add(item);

        item = new HashMap<String, Object>();
        item.put("iconolink", R.drawable.logotwitter);
        item.put("nomlink", "Twitter");
        redes.add(item);

        return redes;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Facultad-de-Ciencias-Exactas-y-Tecnolog%C3%ADas-UNSE-389558071235685/")));
            break;
            case 1: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/fceytunse/")));
            break;
            case 2: Toast.makeText(getContext(),"La FCE no tiene Twitter",Toast.LENGTH_LONG).show();
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
