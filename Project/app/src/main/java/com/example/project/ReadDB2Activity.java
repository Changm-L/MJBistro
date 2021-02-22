package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadDB2Activity extends AppCompatActivity {

    LinearLayout mainContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db2);
        //ReadDB레이아웃 연결
        mainContainer=(LinearLayout)findViewById(R.id.linearLayoutInReadDB);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        SQLiteDatabase myBistroDB = dbHelper.getReadableDatabase();

        //전체 디비 출력
        Cursor cursor = myBistroDB.rawQuery("select rating, type, title, location, strftime('%Y-%m-%d', visited), review from myRestaurant", null);
        while (cursor.moveToNext()) {
            TextView textView = new TextView(getApplicationContext());
            textView.setTextSize(15);
            textView.setText("별점 : " + cursor.getInt(0) + " | 방문일 : " + cursor.getString(4) + " | 식당명 : " + cursor.getString(2) + "\n" + "위치 : " + cursor.getString(3));

            TextView reView = new TextView(getApplicationContext());
            reView.setTextSize(15);
            reView.setText("한줄 리뷰 : " + cursor.getString(5));
            TextView enter = new TextView(getApplicationContext());
            enter.setText("\n");
            mainContainer.addView(textView);
            mainContainer.addView(reView);
            mainContainer.addView(enter);
        }
        myBistroDB.close();

    }
    //메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    //메뉴 아이템 셀렉트
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.item_in:
                Intent intent = new Intent(getApplicationContext(), WriteDBActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_show:
                Intent intent1 = new Intent(getApplicationContext(), ReadDBActivity.class);
                startActivity(intent1);
                return true;
            case R.id.item_all:
                Intent intent2 = new Intent(getApplicationContext(), ReadDB2Activity.class);
                startActivity(intent2);
                return true;
        }
        return false;
    }
}