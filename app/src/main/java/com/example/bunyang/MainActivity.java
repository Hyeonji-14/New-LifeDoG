package com.example.bunyang;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bunyang.fragment.HomeFragment;
import com.example.bunyang.fragment.MypageFragment;
import com.example.bunyang.fragment.NoticeFragment;
import com.example.bunyang.fragment.PostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;

    /*프래그먼트*/
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private NoticeFragment noticeFragment = new NoticeFragment();
    private MypageFragment mypageFragment = new MypageFragment();
    private long backpressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelay, homeFragment).commitAllowingStateLoss();

        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        transaction.replace(R.id.framelay, homeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.notice:
                        transaction.replace(R.id.framelay, noticeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.mypage:
                        Bundle bundle = new Bundle();
                        bundle.putString("emailId", getIntent().getStringExtra("emailId"));
                        mypageFragment.setArguments(bundle);
                        transaction.replace(R.id.framelay, mypageFragment).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });

    }
}