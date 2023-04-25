package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textCount; //окно вывода
    private Button button; //кнопка
    private int count = 0; //переменная счётчика


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // присваивание переменным  представления
        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        // выполнение действий при нажатии
        button.setOnClickListener(listener);
    }

    // объект обработки нажатия
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++;
            textCount.setText(Integer.toString(count));
        }
    };


    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT); // инициализация
        toast.show(); // демонстрация
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "Cтоп активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", count);
        Toast toast = Toast.makeText(this, "запись данных в контейнер Bundle", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("key");
        Toast toast = Toast.makeText(this, "считывание данныхиз контейнера Bundle", Toast.LENGTH_SHORT);

    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
       Toast toast = Toast.makeText(this, R.string.pause_activity, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0,0);
        toast.show(); // демонстрация
        super.onPause();
    }


    @Override
    protected void onResume() {
        textCount.setText(Integer.toString(count));

        Toast toast = Toast.makeText(this, R.string.resume_activity, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView cat = new ImageView(this);
        cat.setImageResource(R.drawable.cat);
        toastContainer.addView(cat, 1);
        toast.show();
        super.onResume();
    }
}