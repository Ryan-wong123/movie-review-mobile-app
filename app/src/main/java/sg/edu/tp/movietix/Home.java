package sg.edu.tp.movietix;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener{
    ViewFlipper simpleViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         // Viewflipper for popular movies banner
        int images[] = {R.drawable.slide1,R.drawable.slide2, R.drawable.slide3};

        simpleViewFlipper = findViewById(R.id.simpleViewFlipper);

        for (int image: images){
            flipperImages(image);
        }

        //sliding tab for 3 category which is popular, upcoming and recent
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Popular"));
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"));
        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    //banner on the top to show popular movies
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        simpleViewFlipper.addView(imageView);
        simpleViewFlipper.setFlipInterval(4000);
        simpleViewFlipper.setAutoStart(true);

        simpleViewFlipper.setInAnimation( this , android.R.anim.slide_in_left);
        simpleViewFlipper.setOutAnimation( this, android.R.anim.slide_out_right);
    }

    //intent to black panther page
    public void moveToMovie1(View view){
        Intent blackpanther = new Intent(this, ReviewBlackPanther.class);
        startActivity(blackpanther);

    }

    //intent to profile page
    public void moveToProfile(View view){
        Intent profile = new Intent(this, Profile.class);
        startActivity(profile);
    }

    //intent to wreck it ralph page
    public void moveToMovie2 (View view){
        Intent wreckitralph = new Intent(this, ReviewWreckItRalph.class);
        startActivity(wreckitralph);
    }

    //intent to antman page
    public void moveToMovie3(View view){
        Intent intent = new Intent(this, ReviewAntman.class);
        startActivity(intent);
    }

    //intent to soundtrack page
    public void moveToSoundTrack(View view){
        Intent intent = new Intent(this, SoundTrackMenu.class);
        startActivity(intent);
    }

    //intent to search page
    public void moveToSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    // for sliding tabs
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
