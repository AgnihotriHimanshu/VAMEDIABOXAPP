package com.vamediabox.vamediaboxapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vamediabox.vamediaboxapp.R;
import com.vamediabox.vamediaboxapp.adapters.SlidingImage_Adapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.vstechlab.easyfonts.EasyFonts;
import java.util.ArrayList;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by HP 101 on 7/26/2017.
 */

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView tv_slider, tv_button;
    RelativeLayout dummyView;
    AutoScrollViewPager mViewPager;



    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.ecommerce, R.drawable.digital_marketing, R.drawable.explainer, R.drawable.it_services,
            R.drawable.mobile_app, R.drawable.seo, R.drawable.software, R.drawable.webdesign};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
         View v = inflater.inflate(R.layout.fragment_home, container, false);

         tv_slider=(TextView)v.findViewById(R.id.tv_slider);
         tv_slider.setTypeface(EasyFonts.robotoLight(this.getActivity()));
         tv_button=(TextView)v.findViewById(R.id.tv_button);
         tv_button.setTypeface(EasyFonts.robotoLight(this.getActivity()));



        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);



        mViewPager = (AutoScrollViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(new SlidingImage_Adapter(getActivity(),ImagesArray));
        mViewPager.setOffscreenPageLimit(1);


        CirclePageIndicator indicator = (CirclePageIndicator)
                v.findViewById(R.id.indicator);

        indicator.setViewPager(mViewPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(3 * density);

        NUM_PAGES =IMAGES.length;

        mViewPager.startAutoScroll();
        mViewPager.setInterval(3000);

        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        Log.w("touched","down");
                        mViewPager.stopAutoScroll();
                        return true;
                    //break;

                    case MotionEvent.ACTION_UP:
                        Log.w("touched","up");
                        mViewPager.startAutoScroll();
                        return true;
                    //break;
                }



                return true;
            }
        });




//        // Auto start of viewpager
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == NUM_PAGES) {
//                    currentPage = 0;
//                }
//                mViewPager.setCurrentItem(currentPage++, true);
//
//            }
//        };
//
//                Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 3000, 3000);
//
//        mViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                mViewPager.setPagingEnabled(false);
//
//                return false;
//            }
//        });


        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }



            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

                switch (pos){

                    case 0:
                        tv_slider.setText(getString(R.string.es_content));
                        break;

                    case 1:
                        tv_slider.setText(getString(R.string.dm_content));
                        break;

                    case 2:
                        tv_slider.setText(getString(R.string.ev_content));
                        break;

                    case 3:
                        tv_slider.setText(getString(R.string.it_content));
                        break;

                    case 4:
                        tv_slider.setText(getString(R.string.md_content));
                        break;

                    case 5:
                        tv_slider.setText(getString(R.string.seo_content));
                        break;

                    case 6:
                        tv_slider.setText(getString(R.string.sd_content));
                        break;

                    case 7:
                        tv_slider.setText(getString(R.string.wd_content));
                        break;

                }



            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });


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
