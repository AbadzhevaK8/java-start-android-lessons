package com.startandroid.p0271getintentaction;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Info extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        // получаем Intent, который вызывал это Activity
        Intent intent = getIntent();
        // читаем из него action
        String action = intent.getAction();

        String format = "", textInfo = "";

        // в зависимости от action заполняем переменные
        if (action.equals("com.startandroid.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }
        else if (action.equals("com.startandroid.intent.action.showdate")) {
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        // в зависимости от содержимого переменной format
        // получаем дату или время в переменную datetime
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String datetime = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvDate = (TextView) findViewById(R.id.tvInfo);
        tvDate.setText(textInfo + datetime);
    }
}