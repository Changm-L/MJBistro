package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.DBHelper;
import com.example.project.R;
import com.example.project.WriteDBActivity;

public class WriteDBActivity extends AppCompatActivity {
    EditText titleEdit, ratingEdit, visitedEdit, typeEdit, locationEdit, reviewEdit;
    Button insertBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_db);

        //에디트 텍스트 연결
        typeEdit = (EditText)findViewById(R.id.editText_type);
        locationEdit =(EditText)findViewById(R.id.editText_location);
        titleEdit = (EditText)findViewById(R.id.editText_title);
        ratingEdit =(EditText)findViewById(R.id.editText_rating);
        visitedEdit=(EditText)findViewById(R.id.editText_visited);
        reviewEdit =(EditText)findViewById(R.id.editText_review);
        insertBtn = (Button)findViewById(R.id.button_insert);

        //디비 연결
        DBHelper helper = new DBHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        //인서트 버튼 클릭시 데이터베이스 삽입
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=titleEdit.getText().toString();
                String rating=ratingEdit.getText().toString();
                String visited=visitedEdit.getText().toString();
                String type = typeEdit.getText().toString();
                String location = locationEdit.getText().toString();
                String review = reviewEdit.getText().toString();

                ContentValues values = new ContentValues();
                values.put("title", title);
                values.put("type", type);
                values.put("rating", rating);
                values.put("visited", visited);
                values.put("location", location);
                values.put("review", review);
                db.insert("myRestaurant",null, values);
                db.close();
                Intent intent = new Intent(getApplicationContext(), ReadDBActivity.class);
                startActivity(intent);
            }
        });
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
        switch (item.getItemId()){
            case R.id.item_in:
                Intent intent = new Intent(getApplicationContext(), WriteDBActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_show:
                Intent intent1 = new Intent(getApplicationContext(),ReadDBActivity.class);
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