package com.bawei.chenxiaoxu.zk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.chenxiaoxu.zk.R;
import com.bawei.chenxiaoxu.zk.di.IView;
import com.bawei.chenxiaoxu.zk.ui.IPesenterImp;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private EditText ed_name;
    private EditText ed_password;
    private Button btn_login;
    private Button btn_regirect;
    private String name;
    private String password;
    private IPesenterImp iPesenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onclick();
    }

    private void onclick() {
        btn_login.setOnClickListener(this);
        btn_regirect.setOnClickListener(this);
    }

    private void init() {
        ed_name = findViewById(R.id.ed_name);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        btn_regirect = findViewById(R.id.btn_regirect);

        iPesenter = new IPesenterImp(this);

    }

    @Override
    public void onClick(View v) {
        name = ed_name.getText().toString();
        password = ed_password.getText().toString();
        switch (v.getId()){
            case R.id.btn_regirect:
                iPesenter.getData(name,password);
                break;
            case R.id.btn_login:
                iPesenter.getreData(name,password);
                break;
        }
    }

    @Override
    public void errorr(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void success(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void errorr2(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void success2(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
