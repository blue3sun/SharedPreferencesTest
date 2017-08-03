package com.android.emmy.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        createSharedPreferences();
    }

    private void initView() {
        mTvInfo = (TextView)findViewById(R.id.tv_info);
    }

    private void createSharedPreferences() {
        SharedPreferences sp = getSharedPreferences("MainActivity",MODE_PRIVATE);
        //putString(sp,"first","one");
        putString(sp,"seconde","two");
        putString(sp,"third","three");
        putString(sp,"seconde","2222");
        mTvInfo.setText(getString(sp,"first","none"));//one
        mTvInfo.append(getString(sp,"seconde","none"));//2222
        mTvInfo.append(getString(sp,"third","none"));//three
    }


    private void putString(SharedPreferences sp,String key,String value){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }

    private String getString(SharedPreferences sp,String key,String defvalue){
        return sp.getString(key,defvalue);
    }
}
