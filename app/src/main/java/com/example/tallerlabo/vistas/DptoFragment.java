package com.example.tallerlabo.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.tallerlabo.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DptoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DptoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DptoFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    View vista;
    private String[] departamentos;
    private ListView lvDpto;

    public DptoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DptoFragment newInstance(String param1, String param2) {
        DptoFragment fragment = new DptoFragment();
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
        vista = inflater.inflate(R.layout.fragment_dpto, container, false);

        lvDpto = (ListView) vista.findViewById(R.id.list_dpto);
        departamentos= getResources().getStringArray(R.array.departamento);

        lvDpto.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, departamentos));

        return vista;
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
