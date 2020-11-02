 package com.example.design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView ;
    private Toolbar toolbar;

//    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        //----slideable image view code starts
//        viewPager=findViewById(R.id.viewpager);
//
//        List<Integer> imageList =new ArrayList<>();
//        imageList.add(R.drawable.slider);
//        imageList.add(R.drawable.slider22);
//        imageList.add(R.drawable.slider23);
//
//
//
//        MyAdapter myAdapter = new MyAdapter(imageList);
//        viewPager.setAdapter(myAdapter);



        toolbar=findViewById(R.id.myToolBar);
        bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();


//       setSupportActionBar(toolbar);


    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater inflater = getMenuInflater();
         inflater .inflate(R.menu.bottom_navigation, menu);
         return true;
     }

     private void setSupportActionBar(Toolbar toolbar) {
         setSupportActionBar(toolbar);
     }


     private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment fragment = null;

            switch (menuItem.getItemId())
            {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.nav_notification:
                    fragment = new NotificationFragment();
                    break;

                case R.id.nav_profile:
                    fragment = new ProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            return true;
        }
    };




}