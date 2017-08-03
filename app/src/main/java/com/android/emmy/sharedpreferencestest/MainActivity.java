package com.android.emmy.sharedpreferencestest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvInfo;
    private Button mBtnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createSharedPreferences();
    }

    private void initView() {
        mBtnSwitch = (Button)findViewById(R.id.btn_switch);
        mTvInfo = (TextView)findViewById(R.id.tv_info);
        mBtnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createSharedPreferences() {
        //MODE_PRIVATE 代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容，
        // 如果想把新写入的内容追加到原文件中，可以使用MODE_APPEND
        //SharedPreferences sp = getSharedPreferences("sp_first",MODE_PRIVATE);
        //SharedPreferences sp = getSharedPreferences("sp_first",MODE_APPEND);
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        putString(sp,"first","one");
        putString(sp,"seconde","two");
        putString(sp,"third","three");
        putString(sp,"first","1111");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        mTvInfo.setText(getString(sp,"first","none"));//111
        mTvInfo.append(getString(sp,"seconde","none"));//two
        mTvInfo.append(getString(sp,"third","none"));//three
    }

    private void putString(SharedPreferences sp, String key, String value){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }

    private String getString(SharedPreferences sp,String key,String defvalue){
        return sp.getString(key,defvalue);
    }
}
