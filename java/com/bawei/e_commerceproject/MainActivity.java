package com.bawei.e_commerceproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.e_commerceproject.activity.LoginActivity;
import com.bawei.e_commerceproject.base.BaseActivity;
import com.bawei.e_commerceproject.base.BasePresenter;
import com.bawei.e_commerceproject.presenter.Presenter;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText log_in_phone_number;
    private EditText log_in_login_password;
    private CheckBox log_in_Remember_password;
    private TextView log_in_registered;
    private Button log_in_button;
    private SharedPreferences.Editor editor;


    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    public void initView() {
        log_in_phone_number = (EditText) findViewById(R.id.log_in_phone_number);
        log_in_login_password = (EditText) findViewById(R.id.log_in_login_password);
        log_in_Remember_password = (CheckBox) findViewById(R.id.log_in_Remember_password);
        log_in_registered = (TextView) findViewById(R.id.log_in_registered);
        log_in_button = (Button) findViewById(R.id.log_in_button);
        log_in_registered.setOnClickListener(this);
        log_in_button.setOnClickListener(this);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_in_registered:
                Intent intent = new Intent(MainActivity.this, RegisteredActivity.class);
                startActivityForResult(intent,100);
                break;
            case R.id.log_in_button:
                Intent intentlogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentlogin);
                finish();
                break;
        }
    }


    @Override
    public void onSuccess(Object o) {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        boolean ischehck = sharedPreferences.getBoolean("ischeck",false);
        if(ischehck){

            String name = sharedPreferences.getString("name", null);
            String pass = sharedPreferences.getString("pass", null);
            log_in_phone_number.setText(name);
            log_in_login_password.setText(pass);

            log_in_Remember_password.setChecked(true);
        }

    }

    @Override
    public void onError(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
