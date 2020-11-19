package com.ol4juwon.tarift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    Deque<Integer> interQue = new ArrayDeque<>(4);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        mBottomNavigationView = findViewById(R.id.bottom_nav);

        interQue.push(R.id.bn_dash);
        mBottomNavigationView.setSelectedItemId(R.id.bn_dash);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();

                        if(interQue.contains(id)){
                            if(id == R.id.bn_dash){
                                if(interQue.size() != 1){
                                    if(flag){
                                        interQue.addFirst(R.id.bn_dash);
                                        flag = false;
                                    }

                                }
                            }
                            interQue.remove(id);
                        }

                        interQue.push(id);
                        loadFragment(getFragment(item.getItemId()));
                        return false;
                    }

                    private Fragment getFragment(int itemId) {

                        switch (itemId){
                            case R.id.bn_dash:
                                mBottomNavigationView.getMenu().findItem(R.id.bn_dash).setChecked(true);
                                return new DashboardFragment();
                            case R.id.bn_profile:
                                mBottomNavigationView.getMenu().findItem(R.id.bn_profile).setChecked(true);
                                return  new ProfileFragment();
                            case R.id.bn_transfer:
                                mBottomNavigationView.getMenu().findItem(R.id.bn_transfer).setChecked(true);
                                return new TransferFragment();
                            case R.id.bn_add_card:
                                mBottomNavigationView.getMenu().findItem(R.id.bn_add_card).setChecked(true);
                                return new addCardFragment();

                        }
                        mBottomNavigationView.getMenu().findItem(1).setChecked(true);
                        return new DashboardFragment();
                    }
                }
        );

        loadFragment(new DashboardFragment());
//        interQue.push(R.id.bn_dash);
//        interQue.push(R.id.bn_transfer);
//        interQue.push(R.id.bn_add_card);


    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,fragment,fragment.getClass().getSimpleName())
                .commit();

    }
}