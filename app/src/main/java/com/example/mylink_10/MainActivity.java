package com.example.mylink_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> list;
    private MyAdapter adapter;
    private final int[] titles = {R.string.tab_home, R.string.tab_community, R.string.tab_my};
    private final int[] images = {R.drawable.home, R.drawable.classify, R.drawable.me};
    private Spinner sp_difSel;
    private Button btn_login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle mBundle = new Bundle();
        initView(mBundle);

//        sp_difSel = findViewById(R.id.sp_difSel);
//        ArrayAdapter<String> difAdapter = new ArrayAdapter<>(this, R.layout.item_difsel, dif);
//        sp_difSel.setAdapter(difAdapter);
//        sp_difSel.setSelection(0);

//        findViewById(R.id.btn_login).setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//            startActivity(intent);
//        });

    }

    private void initView(Bundle mBundle) {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        //页面，数据源
        list = new ArrayList<>();
        list.add(new homePage());
        list.add(new community());
        list.add(new myMessage());
        //Activity向Fragment传递信息
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setArguments(mBundle);
        }
        adapter = new MyAdapter(getSupportFragmentManager(), this); //ViewPager的适配器
        viewPager.setAdapter(adapter);     ///使用适配器将ViewPager与Fragment绑定在一起
        tabLayout.setupWithViewPager(viewPager);   //将TabLayout与ViewPager绑定
        InitTabBar(); //初始化自定义标签视图
        //添加标签监听
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {//选中图片操作
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    if (tab == tabLayout.getTabAt(i)) {
                        viewPager.setCurrentItem(i);
                    }
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

    class MyAdapter extends FragmentPagerAdapter {

        private Context context;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

    }

    public void InitTabBar() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                View v = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
                TextView textView = (TextView) v.findViewById(R.id.tv_title);
                ImageView imageView = (ImageView) v.findViewById(R.id.iv_icon);
                textView.setText(titles[i]);
                imageView.setImageResource(images[i]);
                tab.setCustomView(v);  //为标签tab设置视图v
            }
        }
    }
}