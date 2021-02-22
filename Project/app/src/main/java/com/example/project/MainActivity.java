package com.example.project;

import androidx.annotation.DrawableRes;
import androidx.annotation.Size;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    View dialogView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //타이틀 설정
        setTitle("Jump Into MJ Bistro");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //로그인 버튼 연결
        loginBtn=(Button)findViewById(R.id.btn_Login);

        //버튼 컨트롤러 구현
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 연결
                dialogView = (View)View.inflate(getApplicationContext(),R.layout.log_in, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("Join In");
                dlg.setIcon(R.drawable.icon);
                dlg.setView(dialogView);
                dlg.create();

               //입력 버튼 구현
               dlg.setPositiveButton("입력", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText pw = (EditText)dialogView.findViewById(R.id.editText_pw);
                        //비밀번호가 맞을시
                        if(pw.getText().toString().equals("Dlatlqjsgh7862!")){
                            Toast.makeText(getApplicationContext(),"Welcome MJ Bistro",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),ReadDBActivity.class);
                            startActivity(intent);
                        }
                        //비밀번호가 틀리면 토스트메시지 출력 후 다이얼로그 재호출
                        else{
                            Toast.makeText(getApplicationContext(),"비밀번호가 틀렸습니다.",Toast.LENGTH_LONG).show();
                            v.callOnClick();
                        }
                    }
                });
               //취소버튼
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
    }

}