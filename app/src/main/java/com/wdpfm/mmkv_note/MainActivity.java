package com.wdpfm.mmkv_note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=findViewById(R.id.editText);

        MMKV.initialize(this);//MMKV初始化
        final MMKV kv = MMKV.defaultMMKV();//获取MMKV对象

        String str = kv.decodeString("note");//读取MMKV的note
        editText.setText(str);//显示在输入框

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kv.encode("note", editText.getText().toString());//获取输入框内容写入MMKV的note
            }
        });
        findViewById(R.id.buttonExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
