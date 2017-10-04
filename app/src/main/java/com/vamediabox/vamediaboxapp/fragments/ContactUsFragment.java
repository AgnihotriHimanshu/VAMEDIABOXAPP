package com.vamediabox.vamediaboxapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vamediabox.vamediaboxapp.R;
import com.vamediabox.vamediaboxapp.activities.QueryActivity;
import com.vstechlab.easyfonts.EasyFonts;

/**
 * Created by HP 101 on 8/9/2017.
 */

public class ContactUsFragment  extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView address,address1,contactdetails,contactdetails1;
    Button message;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ContactUsFragment.OnFragmentInteractionListener mListener;

    public ContactUsFragment() {

    }

    public static ContactUsFragment newInstance(String param1, String param2) {
        ContactUsFragment fragment = new ContactUsFragment();
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
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        address = (TextView)v.findViewById(R.id.tv_address);
        address1=(TextView)v.findViewById(R.id.tv_address1);
        contactdetails=(TextView)v.findViewById(R.id.tv_contactus);
        contactdetails1=(TextView)v.findViewById(R.id.tv_contactus1);
        message=(Button)v.findViewById(R.id.btnmessage);
        address.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));
        address1.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));
        contactdetails1.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));
        contactdetails.setTypeface(EasyFonts.droidSerifRegular(this.getActivity()));

        message.setOnClickListener(this);




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

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this.getActivity(), QueryActivity.class);
        startActivity(i);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}