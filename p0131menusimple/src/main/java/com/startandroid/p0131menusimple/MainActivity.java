package com.startandroid.p0131menusimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
      // TODO Auto-generated method stub
      Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
      return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        


    }
}