package com.star.demodragdrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView.setOnTouchListener(listener);
    }

    View.OnTouchListener listener = new View.OnTouchListener() {
        private  float x,y;
        private int mx ,my;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch ((event.getAction()))
            {
                case MotionEvent.ACTION_DOWN:   //使用者按下
                    x = event.getX();
                    y = event.getY();
                case MotionEvent.ACTION_MOVE:   //使用者移動
                    mx = (int) (event.getRawX() -x);
                    my = (int) (event.getRawY() - getContentViewTop() - y);
                    v.layout(mx , my , mx + v.getWidth() , my + v.getHeight());
                    break;
            }
            return true;
        }
    };
    //計算ContentView的高度計算
    public int getContentViewTop() {
        View contentView = getWindow().findViewById(android.R.id.content);
        int[] coordinates = new int[2];
        contentView.getLocationOnScreen(coordinates);
        return coordinates[1];
    }
}
