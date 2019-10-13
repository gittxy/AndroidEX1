package com.example.e_learning_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        EditText account=(EditText) findViewById(R.id.account);
        EditText pwd=(EditText) findViewById(R.id.pwd);
        String username = account.getText().toString();
        String userpassword = pwd.getText().toString();


        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(userpassword)){
            Toast toast = Toast.makeText(MainActivity.this,R.string.message1, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();//事件触发,显示用户名或者密码为空
        }
        else if(username.equals("txy")&&userpassword.equals(""+123456)) {
            Toast toast = Toast.makeText(MainActivity.this,R.string.press_login_button1, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();//事件触发,显示欢迎信息

            //下面跳转课程界面
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else if(!username.equals("txy")){
            Toast toast = Toast.makeText(MainActivity.this,R.string.press_login_button2, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();//事件触发,显示用户名不存在
        }
        else {
            Toast toast = Toast.makeText(MainActivity.this,R.string.press_login_button3, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();//事件触发,显示密码错误
        }


    }

}
