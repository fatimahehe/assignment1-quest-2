package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ImageView arrowImageView = findViewById(R.id.arrowImageView);

        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        TabLayout tabLayout = findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.chat).setText("Chats"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.call).setText("Calls"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.arrow).setText("Updates"));

        ViewPager viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatsFragment(), "Chats");
        adapter.addFragment(new CallsFragment(), "Calls");

        adapter.addFragment(new UpdatesFragment(),"Updates");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}

