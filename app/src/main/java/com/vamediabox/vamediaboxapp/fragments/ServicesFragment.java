package com.vamediabox.vamediaboxapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vamediabox.vamediaboxapp.R;
import com.vstechlab.easyfonts.EasyFonts;

/**
 * Created by HP 101 on 8/9/2017.
 */

public class ServicesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ServicesFragment.OnFragmentInteractionListener mListener;

    public ServicesFragment() {

    }

    public static ServicesFragment newInstance(String param1, String param2) {
        ServicesFragment fragment = new ServicesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_services, container, false);
        tv1=(TextView)v.findViewById(R.id.tv1);
        tv1.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv2=(TextView)v.findViewById(R.id.tv2);
        tv2.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv3=(TextView)v.findViewById(R.id.tv3);
        tv3.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv4=(TextView)v.findViewById(R.id.tv4);
        tv4.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv5=(TextView)v.findViewById(R.id.tv5);
        tv5.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv6=(TextView)v.findViewById(R.id.tv6);
        tv6.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv7=(TextView)v.findViewById(R.id.tv7);
        tv7.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv8=(TextView)v.findViewById(R.id.tv8);
        tv8.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv9=(TextView)v.findViewById(R.id.tv9);
        tv9.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv10=(TextView)v.findViewById(R.id.tv10);
        tv10.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv11=(TextView)v.findViewById(R.id.tv11);
        tv11.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv12=(TextView)v.findViewById(R.id.tv12);
        tv12.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv13=(TextView)v.findViewById(R.id.tv13);
        tv13.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv14=(TextView)v.findViewById(R.id.tv14);
        tv14.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv15=(TextView)v.findViewById(R.id.tv15);
        tv15.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv16=(TextView)v.findViewById(R.id.tv16);
        tv16.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv17=(TextView)v.findViewById(R.id.tv17);
        tv17.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        tv18=(TextView)v.findViewById(R.id.tv18);
        tv18.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        return v;

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


    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
