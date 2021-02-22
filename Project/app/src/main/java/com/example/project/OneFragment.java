package com.example.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneFragment} factory method to
 * create an instance of this fragment.
 */

public class OneFragment extends Fragment {
    public OneFragment() {
        // Required empty public constructor
    }

    DBHelper dbHelper;
    SQLiteDatabase myBistroDB;
    LinearLayout mainContainer;
    Button btn_rating, btn_date, btn_reset;
    TextView textView, reView;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        //DB, 버튼, 리니어레이아웃 연결
        dbHelper = new DBHelper(getContext());
        myBistroDB = dbHelper.getReadableDatabase();
        btn_rating = (Button) v.findViewById(R.id.btn_rating1);
        btn_date = (Button) v.findViewById(R.id.btn_date1);
        btn_reset = (Button) v.findViewById(R.id.btn_reset1);
        mainContainer = (LinearLayout) v.findViewById(R.id.main_input);

        //배경 이미지 투명도 50 적용
        Drawable alpha = ((ImageView) v.findViewById(R.id.imageView3)).getDrawable();
        alpha.setAlpha(50);

        //DB 읽어오기
        cursor = myBistroDB.rawQuery("select rating, type, title, location, strftime('%Y-%m-%d', visited), review from myRestaurant where type='한식' order by rating desc, visited asc", null);
        while (cursor.moveToNext()) {
            textView = new TextView(getContext());
            textView.setTextSize(15);
            textView.setText("별점 : " + cursor.getInt(0) + " | 방문일 : " + cursor.getString(4) + " | 식당명 : " + cursor.getString(2) +  "\n" + "위치 : " + cursor.getString(3));

            reView = new TextView(getContext());
            reView.setTextSize(15);
            reView.setText("한줄 리뷰 : " + cursor.getString(5) + "\n");
            mainContainer.addView(textView);
            mainContainer.addView(reView);

        }

        //미완성 버튼들
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"구현 예정중입니다.",Toast.LENGTH_LONG).show();
            }
        });
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"구현 예정중입니다.",Toast.LENGTH_LONG).show();
            }
        });
        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"구현 예정중입니다.",Toast.LENGTH_LONG).show();
            }
        });

        //커서 및 DB종료
        cursor.close();
        myBistroDB.close();

        return v;
    }
}