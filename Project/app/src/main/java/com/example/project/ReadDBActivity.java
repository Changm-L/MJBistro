package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {
    Button btnFrag1, btnFrag2, btnFrag3, btnFrag4, btnFrag5;
    LinearLayout mainContainer;
    FragmentManager fr;
    OneFragment oneFrag;
    TwoFragment twoFrag;
    ThreeFragment threeFrag;
    FourFragment fourFrag;
    FiveFragment fiveFrag;
    IntroFragment introFrag;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        btnFrag1 = (Button) findViewById(R.id.button);
        btnFrag2 = (Button) findViewById(R.id.button2);
        btnFrag3 = (Button) findViewById(R.id.button3);
        btnFrag4 = (Button) findViewById(R.id.button4);
        btnFrag5 = (Button) findViewById(R.id.button5);
        textView2 =(TextView)findViewById(R.id.textView2);

        fr = getSupportFragmentManager();
        oneFrag = new OneFragment();
        twoFrag = new TwoFragment();
        threeFrag = new ThreeFragment();
        fourFrag = new FourFragment();
        fiveFrag = new FiveFragment();
        introFrag = new IntroFragment();

        FragmentTransaction ft = fr.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.main_container, introFrag);
        ft.commit();

        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fr.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, oneFrag);
                ft.commit();
                textView2.setVisibility(View.GONE);
            }
        });
       btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fr.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, twoFrag);
                ft.commit();
                textView2.setVisibility(View.GONE);
            }
        });
        btnFrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fr.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, threeFrag);
                ft.commit();
                textView2.setVisibility(View.GONE);
            }
        });
        btnFrag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fr.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, fourFrag);
                ft.commit();
                textView2.setVisibility(View.GONE);
            }
        });
        btnFrag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fr.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, fiveFrag);
                ft.commit();
                textView2.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

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