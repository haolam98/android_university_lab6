package com.codepath.nytimes;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.codepath.nytimes.ui.books.BestSellerBooksFragment;
import com.codepath.nytimes.ui.home.HomeFragment;
import com.codepath.nytimes.ui.search.ArticleResultFragment;
import com.codepath.nytimes.ui.settings.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private static String HOME_TAG = "home";
    private static String BOOKS_TAG = "books";
    private static String ARTICLES_TAG = "articles";
    private static String SETTINGS_TAG = "settings";
    private static String ACTIVITY_TAG = "MainActivity";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Log.i(ACTIVITY_TAG, "Goto Home Fragment");
                        // Replace the contents of the container with the new fragment
                        ft.replace(R.id.fl_placeholder, new HomeFragment(), HOME_TAG);
                        break;
                    case R.id.menu_bestseller:
                        // Replace the contents of the container with the new fragment
                        Log.i(ACTIVITY_TAG, "Goto Bestseller Fragment");
                        ft.replace(R.id.fl_placeholder, new BestSellerBooksFragment(), BOOKS_TAG);
                        break;
                    case R.id.menu_searchArticle:
                        Log.i(ACTIVITY_TAG, "Goto Search Article Fragment");
                        // Replace the contents of the container with the new fragment
                        ft.replace(R.id.fl_placeholder, new ArticleResultFragment(), ARTICLES_TAG);
                        break;
                    case R.id.menu_settings:
                        Log.i(ACTIVITY_TAG, "Goto Settings Fragment");
                        // Replace the contents of the container with the new fragment
                        ft.replace(R.id.fl_placeholder, new SettingFragment(),SETTINGS_TAG);
                        break;
                }
                // Complete the changes added above
                ft.commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.menu_home); // init to Home page first
    }

}
