package com.example.mylink_10;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mylink_10.gameRelated.GameConf;
import com.example.mylink_10.util.ToastUtil;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homePage extends Fragment {

    private static final String[] dif = {"难度选择：简单", "难度选择：普通", "难度选择：困难"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SharedPreferences sharedPreferences;
    private Spinner sp_difSel_home;

    public homePage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homePage.
     */
    // TODO: Rename and change types and number of parameters
    public static homePage newInstance(String param1, String param2) {
        homePage fragment = new homePage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("option-config", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        sp_difSel_home = getActivity().findViewById(R.id.sp_difSel_home);
        getActivity().findViewById(R.id.btn_playGame).setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(),NewGameActivity.class);
            startActivity(intent);
        });
        ArrayAdapter difSelAdapter = new ArrayAdapter(getActivity(),R.layout.item_selector,dif);
        sp_difSel_home.setAdapter(difSelAdapter);
        sp_difSel_home.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                edit.putInt("dif",i);
                GameConf.update(i);
                edit.commit();
                ToastUtil.show(getActivity(),"现在选择的难度为：" + dif[i].substring(5,7));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        getActivity().findViewById(R.id.btn_rulesDesc).setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("规则说明");
            builder.setMessage("XXXXXXXXXXXXXXXXXXXX");
            builder.setPositiveButton("我明白了",(dialogInterface, i) -> {});
            builder.setNegativeButton("了解了",(dialogInterface, i) -> {});
            builder.create().show();
        });
        reload();
    }

    private void reload() {
        int d = sharedPreferences.getInt("dif",0);
        sp_difSel_home.setSelection(d);
    }
}