package com.webakruti.tuitionplus.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.fragment.StudentDetailsFragment;
import com.webakruti.tuitionplus.models.Details;
import com.webakruti.tuitionplus.models.Student;
import com.webakruti.tuitionplus.utils.SharedPreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView toolbarStudentDetailsHomeTitle;
    public static TextView textViewUserName;
    public static TextView textViewEmailId;
    public static ImageView imageViewProfile;
    private List<Details> detailsList = new ArrayList<Details>();
    private FragmentManager fragManager;
    public static RelativeLayout headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        toolbarStudentDetailsHomeTitle = (TextView) findViewById(R.id.toolbarStudentDetailsHomeTitle);


        // for navigation view
        SharedPreferenceManager.setApplicationContext(StudentDetailsActivity.this);
        Student user = SharedPreferenceManager.getUserObjectFromSharedPreference();

        View headerLayout = navigationView.getHeaderView(0);
        headerView = (RelativeLayout) headerLayout.findViewById(R.id.headerView);
        textViewUserName = (TextView) headerLayout.findViewById(R.id.textViewUserName);
        textViewEmailId = (TextView) headerLayout.findViewById(R.id.textViewEmailId);
        imageViewProfile = (ImageView) headerLayout.findViewById(R.id.imageViewProfile);

        Menu menu = navigationView.getMenu();

        MenuItem navigationLogout = menu.findItem(R.id.navigationLogout);

      /*  if (user != null) {
            textViewEmailId.setVisibility(View.VISIBLE);
            textViewUserName.setText(user.getFname() + " " + user.getLname());
            textViewEmailId.setText(user.getEmail());
            navigationLogout.setVisible(true);
        } else {
            textViewEmailId.setVisibility(View.INVISIBLE);

            textViewUserName.setText("Welcome, Guest");
            navigationLogout.setVisible(true);

        }*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.navigationStudentDetails:
                        // toolbarStudentDetailsHomeTitle.setText("My details");
                        // HomeFragment fragment = new HomeFragment();
                        fragManager.beginTransaction().replace(R.id.dashboard_container, new StudentDetailsFragment()).commit();
                        break;

                    case R.id.navigationLogout:
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(StudentDetailsActivity.this);
                        // Setting Dialog Title
                        alertDialog.setTitle("Logout");
                        // Setting Dialog Message
                        alertDialog.setMessage("Are you sure to logout?");
                        // Setting Icon to Dialog
                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferenceManager.clearPreferences();

                                Intent intent = new Intent(StudentDetailsActivity.this, WorkspaceActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });
                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        // Showing Alert Message
                        alertDialog.show();

                        break;
                }
                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.dashboard_container, new StudentDetailsFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }




}
