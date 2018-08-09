package com.rilu.resumecreator;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private String currentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLayout();


    }

    private void setupLayout() {
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        drawerLayout.closeDrawers();
                        currentTitle = item.getTitle().toString();
                        getSupportActionBar().setTitle(currentTitle);
                        return handleMenuItem(item);
                    }
                });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_closed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(getString(R.string.steps));
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(currentTitle);
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private boolean handleMenuItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_personal_info:
                //openFragment(PersonalInfoFragment.newInstance(resume));
                break;
            case R.id.action_essentials:
               // openFragment(EssentialsFragment.newInstance(resume));
                break;
            case R.id.action_projects:
              //  openFragment(ProjectsFragment.newInstance(resume));
                break;
            case R.id.action_education:
              //  openFragment(EducationFragment.newInstance(resume));
                break;
            case R.id.action_experience:
               // openFragment(ExperienceFragment.newInstance(resume));
                break;
            case R.id.action_preview:
               // openFragment(PreviewFragment.newInstance(resume));
                break;
            default:
                return false;
        }
        return true;
    }
}
