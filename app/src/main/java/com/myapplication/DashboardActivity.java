package com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private ViewFlipper simpleViewFlipper;
    int[] images = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4};
    // array of images
    LinearLayout lyDash1,lyDash2,lyDash3,lyDash4,lyDash5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
     setSupportActionBar(toolbar);

     lyDash1=(LinearLayout)findViewById(R.id.dash_1);
        lyDash1.setOnClickListener(this);

        lyDash2=(LinearLayout)findViewById(R.id.dash_2);
        lyDash2.setOnClickListener(this);
        lyDash3=(LinearLayout)findViewById(R.id.dash_3);
        lyDash3.setOnClickListener(this);
        lyDash4=(LinearLayout)findViewById(R.id.dash_4);
        lyDash4.setOnClickListener(this);
        FloatingActionButton fab = findViewById(R.id.fab);

        /*flipper code----------------------------------*/

        // get The references of ViewFlipper
        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper); // get the reference of ViewFlipper

        // loop for creating ImageView's
        for (int i = 0; i < images.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]); // set image in ImageView
            simpleViewFlipper.addView(imageView); // add the created ImageView in ViewFlipper
        }
        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);
        // set interval time for flipping between views
        simpleViewFlipper.setFlipInterval(3000);
        // set auto start for flipping between views
simpleViewFlipper.setAutoStart(true);

        /*flipper code end---------------------------------------*/






        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.d("#333", "On Click");
        switch (v.getId()) {


            case R.id.dash_1:
                Intent dRTI = new Intent(this, Calculator.class);
                startActivity(dRTI);
                Log.d("#333", "RI");
                break;

            case R.id.dash_2:
             Intent dRTIProblem = new Intent(this, TicTacToe.class);
                startActivity(dRTIProblem);
                Log.d("#333", "RI");
                break;
            case R.id.dash_3:
            Intent dRTINews = new Intent(this, ActivityWebview.class);
            startActivity(dRTINews);
            Log.d("#333", "RI");
            break;
            case R.id.dash_4:
                Intent dRTIShare = new Intent(this, AboutDeveloper.class);
                startActivity(dRTIShare);
                Log.d("#333", "RI");
                break;

          /*  c/

         /*   */
          /*  case R.id.dash_5:
                Intent dFileRTIe = new Intent(this, OrderActivity.class);
                startActivity(dFileRTIe);
                Log.d(TAG, "RI");
                break;*/


            //   =========================== Drawer Menu Start ===========================

           /* case R.id.d1:
                Intent iProject = new Intent(this, ActivityCategorylist.class);
                startActivity(iProject);
                break;

            *//*case R.id.d2:
               Intent InDrawerRTISolution = new Intent(this, ActivityBrandlist.class);
                startActivity(InDrawerRTISolution);
                break;*//*
            case R.id.d3:
                Intent InDrawerRTINews = new Intent(this, ActivityMyItems.class);
                startActivity(InDrawerRTINews);
                break;
            *//*case R.id.d4:
             *//**//*Intent InDrawerRTIShare = new Intent(this, CartActivity.class);
                startActivity(InDrawerRTIShare);*//**//*
                break;*//*
            case R.id.d5:
                Intent InDrawerRTIShare = new Intent(this, OrderActivity.class);
                startActivity(InDrawerRTIShare);
                break;
                *//*AllConstants.webViewUrl = "http://sarthisevasamiti.in/m-offices-list.php";
                AllConstants.webViewTitle = "Office Branches";
                Intent next_Offices = new Intent(this, ActivityWebview.class);
                next_Offices.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next_Offices);*//*

            case R.id.d6:
               *//* AllConstants.webViewUrl = "http://www.sarthisevasamiti.in/m-about-us.php";
                AllConstants.webViewTitle = "Org. List";
                Intent next_instiute = new Intent(this, ActivityWebview.class);
                next_instiute.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next_instiute);*//*
                break;


            case R.id.d7:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=udai360.training"));
                startActivity(intent);
              *//*  AllConstants.webViewUrl = "http://www.sarthisevasamiti.in/sarthi/";
                AllConstants.webViewTitle = " Rate US";*//*

               *//* Intent next_rateus = new Intent(this, ActivityWebview.class);
                next_rateus.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next_rateus);*//*
                break;

            case R.id.d8:
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT, "My application name Fraud App");
                intent1.putExtra(Intent.EXTRA_TEXT, "Hey check out my app at: https://play.google.com/store/apps/details?id=udai360.training");
                startActivity(Intent.createChooser(intent1, "choose one"));
                break;*/


/*
            case R.id.dfb:

               *//* AllConstants.webViewUrl = "https://www.facebook.com/udai360";
                AllConstants.webViewTitle = "FACEBOOK FAN PAGE";
                Intent next_dfb = new Intent(this, ActivityWebview.class);
                next_dfb.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next_dfb);*//*
                break;
            case R.id.dtwi:
                *//*AllConstants.webViewUrl = "https://twitter.com/sarthi_ngo";
                AllConstants.webViewTitle = "TWITTER FAN PAGE";
                Intent next_dtwi = new Intent(this, ActivityWebview.class);
                next_dtwi.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next_dtwi);*//*
                break;

            case R.id.dytb:
               *//* AllConstants.webViewUrl = "http://www.sarthisevasamiti.in/sarthi/";
                AllConstants.webViewTitle = "Youtube FAN PAGE";
                Intent next_dytb = new Intent(this, ActivityWebview.class);
                next_dytb.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next_dytb);*//*
                break;*/


            //   =========================== Drawer Menu End ===========================

        }
    }
}
