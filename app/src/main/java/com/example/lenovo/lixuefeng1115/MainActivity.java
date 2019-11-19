package com.example.lenovo.lixuefeng1115;

import android.os.Bundle;
import android.view.animation.Transformation;

import com.example.lenovo.lixuefeng1115.fragment.ClientFragment;
import com.example.lenovo.lixuefeng1115.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import javax.xml.transform.sax.TransformerHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRec;
    private TabLayout myTab;
    private HomeFragment homeFragment;
    private ClientFragment clientFragment;
    private ArrayList<Fragment> list;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTab();
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        clientFragment = new ClientFragment();
        list = new ArrayList<>();
        list.add(R.id.myRec,homeFragment);
        list.add(R.id.myRec,clientFragment);
        myTab.addTab(myTab.newTab().setIcon(R.mipmap.ic_launcher).setText("首页"));
        myTab.addTab(myTab.newTab().setIcon(R.mipmap.ic_launcher).setText("收藏"));
        fm = getSupportFragmentManager();
        FragmentTransaction trn = fm.beginTransaction();
        trn.hide(clientFragment);
        trn.show(homeFragment);
        trn.commit();
    }

    private void initTab() {
        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    FragmentTransaction trn1 = fm.beginTransaction();
                    trn1.show(homeFragment);
                    trn1.hide(clientFragment);
                    trn1.commit();
                }else {
                    FragmentTransaction trn2 = fm.beginTransaction();
                    trn2.show(clientFragment);
                    trn2.hide(homeFragment);
                    trn2.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView() {
        myRec = (RecyclerView) findViewById(R.id.myRec);
        myTab = (TabLayout) findViewById(R.id.myTab);
    }
}
