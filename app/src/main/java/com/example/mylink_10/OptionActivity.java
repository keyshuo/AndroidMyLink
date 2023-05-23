package com.example.mylink_10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mylink_10.util.ToastUtil;

public class OptionActivity extends AppCompatActivity{

    private static final Integer defOpt = 0;

    private static final String[] musicDir = {"音乐-1", "音乐-2", "音乐-3"};

    private static final String[] UIDir = {"UI-1", "UI-2", "UI-3"};

    private static final String[] backgroundDir = {"背景-1", "背景-2", "背景-3"};
    private Spinner sp_music;
    private Spinner sp_ui_opt;
    private Spinner sp_background_opt;
    private SharedPreferences optionConfig;

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        //获取之前选择的选项
        optionConfig = getSharedPreferences("option-config", Context.MODE_PRIVATE);
        SharedPreferences.Editor optEdit = optionConfig.edit();

        //music related
        sp_music = findViewById(R.id.sp_music_opt);
        ArrayAdapter<String> musicAdapter = new ArrayAdapter<>(this, R.layout.item_selector, musicDir);
        sp_music.setAdapter(musicAdapter);
        sp_music.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                optEdit.putInt("music",i);
                optEdit.commit();
                ToastUtil.show(OptionActivity.this,"现在选择的的音乐为：音乐" + (i + 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //UI related
        sp_ui_opt = findViewById(R.id.sp_UI_opt);
        ArrayAdapter<String> UIAdapter = new ArrayAdapter<>(this, R.layout.item_selector, UIDir);
        sp_ui_opt.setAdapter(UIAdapter);
        sp_ui_opt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                optEdit.putInt("UI",i);
                optEdit.commit();
                ToastUtil.show(OptionActivity.this,"现在选择的的UI为：UI" + (i + 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //background related
        sp_background_opt = findViewById(R.id.sp_background_opt);
        ArrayAdapter<String> backgroundAdapter = new ArrayAdapter<>(this, R.layout.item_selector, backgroundDir);
        sp_background_opt.setAdapter(backgroundAdapter);
        sp_background_opt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                optEdit.putInt("background",i);
                optEdit.commit();
                ToastUtil.show(OptionActivity.this,"现在选择的的背景为：背景" + (i + 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        reload();
    }

    /**
     * 重载所有已选择选项
     */
    private void reload() {
        int musicOpt = optionConfig.getInt("music", defOpt);
        int UIOpt = optionConfig.getInt("UI", defOpt);
        int backgroundOpt = optionConfig.getInt("background", defOpt);
        sp_music.setSelection(musicOpt);
        sp_ui_opt.setSelection(UIOpt);
        sp_background_opt.setSelection(backgroundOpt);
    }
}