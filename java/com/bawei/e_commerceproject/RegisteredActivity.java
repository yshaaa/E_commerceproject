package com.bawei.e_commerceproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.e_commerceproject.base.BaseActivity;
import com.bawei.e_commerceproject.base.BasePresenter;
import com.bawei.e_commerceproject.presenter.Presenter;
import com.bawei.e_commerceproject.url.MyUrl;

import java.util.HashMap;
import java.util.regex.Pattern;

public class RegisteredActivity extends BaseActivity implements View.OnClickListener {
    private String isPhone = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    private String isPwd = "^[a-zA-Z0-9]\\w{5,17}$";
    private EditText registered_phone_number;
    private EditText registered_Verification_code;
    private Button registered_get_Verification_code;
    private EditText registered_login_password;
    private TextView registered_Fanhui;
    private Button registered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initView();
    }

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    public void initView() {
        registered_phone_number = (EditText) findViewById(R.id.registered_phone_number);
        registered_Verification_code = (EditText) findViewById(R.id.registered_Verification_code);
        registered_get_Verification_code = (Button) findViewById(R.id.registered_get_Verification_code);
        registered_login_password = (EditText) findViewById(R.id.registered_login_password);
        registered_Fanhui = (TextView) findViewById(R.id.registered_Fanhui);
        registered = (Button) findViewById(R.id.registered);
        registered_Fanhui.setOnClickListener(this);
        registered_get_Verification_code.setOnClickListener(this);
        registered.setOnClickListener(this);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_registered;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registered_Fanhui:
                finish();
                break;
            case R.id.registered_get_Verification_code:

                break;
            case R.id.registered:
                String name = registered_phone_number.getText().toString().trim();
                String pwd = registered_login_password.getText().toString().trim();
                //判断是否为空
                if(name.isEmpty()){
                    Toast.makeText(this, "手机号为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pwd.isEmpty()){
                    Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //进行正则判断
                boolean matches = Pattern.matches(isPhone, name);
                boolean matches1 = Pattern.matches(isPwd, pwd);
                if(matches&&matches1){
                    HashMap map = new HashMap();
                    map.put("name",name);
                    map.put("pwd",pwd);


                    Intent intent = getIntent();
                    intent.putExtra("name",name);
                    intent.putExtra("pwd",pwd);
                    setResult(100,intent);
                    finish();
                }else {
                    Toast.makeText(this, "手机号或者密码格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }

                break;
        }
    }


    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
