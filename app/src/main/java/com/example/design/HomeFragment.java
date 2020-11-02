package com.example.design;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class HomeFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }


    //variable declare
    ViewPager viewPager;
    CircleIndicator circleIndicator;

    Timer timer;
    Handler handler;


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_home, container, false);

        //----slideable image view code starts
        viewPager=view.findViewById(R.id.viewpager);
        circleIndicator=view.findViewById(R.id.circleIndicator);

        List<Integer> imageList =new ArrayList<>();
        imageList.add(R.drawable.slider);
        imageList.add(R.drawable.slider22);
        imageList.add(R.drawable.slider23);



        MyAdapter myAdapter = new MyAdapter(imageList);
        viewPager.setAdapter(myAdapter);


        circleIndicator.setViewPager(viewPager);

        handler = new Handler();
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int i = viewPager.getCurrentItem();
                        if(i==imageList.size()-1){
                            i=0;
                            viewPager.setCurrentItem(i,true);
                        }
                        else {
                            i++;
                            viewPager.setCurrentItem(i,true);
                        }
//
//                        i++;
//                        viewPager.setCurrentItem(i,true);
                    }
                });
            }
        } ,5000,5000);

        return view;

    }
}





















