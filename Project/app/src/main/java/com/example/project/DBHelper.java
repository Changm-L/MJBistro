package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public DBHelper(@Nullable Context context) {
        super(context, "myBistro", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //테이블 생성
        String query = "create table myRestaurant(" +
                "_id integer primary key," +
         //식당 종류
                "type text," +
         //식당명
                "title text," +
         //별점
                "rating int," +
         //주소
                "location text," +
         //방문일
                "visited datetime," +
         //후기
                "review text)";

        //초기 데이터 입력
        sqLiteDatabase.execSQL(query);
        query = "insert into myRestaurant(type, title, rating, location, visited, review) values('한식', '몽땅부대찌개', 4, '서대문구 홍은동','2020-11-18', '부대찌개는 몽땅')";
        sqLiteDatabase.execSQL(query);
        query = "insert into myRestaurant(type, title, rating, location, visited, review) values('중식', '진짜루', 3, '서대문구 남가좌동','2020-11-20', '짜장면은 진짜루')";
        sqLiteDatabase.execSQL(query);
        query = "insert into myRestaurant(type, title, rating, location, visited, review) values('일식', '스시 하나에', 5, '서대문구 남가좌동','2020-11-28', '회전초밥은 하나에')";
        sqLiteDatabase.execSQL(query);
        query = "insert into myRestaurant(type, title, rating, location, visited, review) values('양식', '주인백파스타', 4, '서대문구 남가좌동','2020-11-27', '파스타는 주인백')";
        sqLiteDatabase.execSQL(query);
        query = "insert into myRestaurant(type, title, rating, location, visited, review) values('디저트', '와플대학', 4, '서대문구 남가좌동','2020-11-20', '와플은 와플대학')";
        sqLiteDatabase.execSQL(query);
    }

    //데이터베이스 버전 변경시 테이블 삭제
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            sqLiteDatabase.execSQL("drop table myRestaurant");
            onCreate(sqLiteDatabase);
        }
    }
}
