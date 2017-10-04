package com.vamediabox.vamediaboxapp.activities;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vamediabox.vamediaboxapp.R;
import com.vamediabox.vamediaboxapp.fragments.AboutUsFragment;
import com.vamediabox.vamediaboxapp.fragments.ContactUsFragment;
import com.vamediabox.vamediaboxapp.fragments.HomeFragment;
import com.vamediabox.vamediaboxapp.fragments.PortfolioFragment;
import com.vamediabox.vamediaboxapp.fragments.ServicesFragment;

import java.lang.reflect.Field;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView mTitle;
    Button chatButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigationView();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (ImageView) toolbar.findViewById(R.id.toolbar_title);
        chatButton = (Button)findViewById(R.id.chat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatButton();;
            }
        });


    }


    private void chatButton(){

        Intent chatIntent = new Intent(MainActivity.this,ChatActivity.class);
        startActivity(chatIntent);


    }




    private void setupNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        disableShiftMode(bottomNavigationView);
        if (bottomNavigationView != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }

    /**
     * Perform action when any item is selected.
     *
     * @param item Item that is selected.
     */
    protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                // Action to perform when Home Menu item is selected.
                pushFragment(new HomeFragment());

                break;
            case R.id.navigation_aboutus:
                // Action to perform when about us Menu item is selected.
                pushFragment(new AboutUsFragment());
                break;
            case R.id.navigation_services:
                // Action to perform when services Menu item is selected.
                pushFragment(new ServicesFragment());
                break;

            case R.id.navigation_portfolio:
                // Action to perform when portfolio Menu item is selected.
                pushFragment(new PortfolioFragment());
                break;

            case R.id.navigation_contactus:
                // Action to perform when contact us  Menu item is selected.
                pushFragment(new ContactUsFragment());
                break;
        }
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */

    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getFragmentManager();

        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.content, fragment);
                ft.commit();
            }
        }
    }


    public void disableShiftMode(BottomNavigationView view) {

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            //Timber.e(e, "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            //Timber.e(e, "Unable to change value of shift mode");
        }
    }



}
