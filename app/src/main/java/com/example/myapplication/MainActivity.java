package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_infor;
    Button button_login;
    EditText editText_userID;
    EditText editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LayoutInflater factory = LayoutInflater.from(this);
        final View LoginView = factory.inflate(R.layout.login_dialog, null);

        button_infor = (Button) findViewById(R.id.button_infor);
        button_login = (Button) findViewById(R.id.button_login);
        //在这指定了两个textview的取值的view，否则系统将自动去activity_main里面找，造成程序崩溃
        editText_userID = (EditText) LoginView.findViewById(R.id.et_userID);
        editText_password = (EditText) LoginView.findViewById(R.id.et_password);


        button_infor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("请登陆来了解更多信息");
                        builder.setTitle("消息");

                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                                    }
                                }

                        );

                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "忽略", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.show();
                    }
                }
        );

        button_login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        //这里需要传入的值是之前生成的view（这里是LoginView），而不是新生成的view。这可以解决取到的值一直为空字符串的问题。
                        builder.setView(LoginView)
                                .setTitle("登陆")
                                .setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //edittixt的gettext方法返回的是一个类似于字符数组的东西，使用其tostring方法转换为字符串，才能使用equals比较
                                        if ((editText_userID.getText().toString().equals("abc"))&&(editText_password.getText().toString().equals("123"))) {
                                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                        builder.show();
                    }
                }
        );
    }
}