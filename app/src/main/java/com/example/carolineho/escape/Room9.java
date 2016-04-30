package com.example.carolineho.escape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Room9 extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {

    private TextView mLanding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room9);

        mLanding = (TextView) findViewById(R.id.Landing);

        findViewById(R.id.Elevator).setOnTouchListener(this);
        findViewById(R.id.ToEscape).setOnDragListener(this);
        findViewById(R.id.FromEscape).setOnDragListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        if (e.getAction()==DragEvent.ACTION_DRAG_ENTERED) {
            mLanding.setText("Landing Here");
        }
        if (e.getAction()==DragEvent.ACTION_DROP) {
            View view = (View) e.getLocalState();
            if(v.getId() == R.id.ToEscape){
                ViewGroup from = (ViewGroup) view.getParent();
                from.removeView(view);
                LinearLayout to = (LinearLayout) v;
                to.addView(view);
                view.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Room9.this, Escaped.class);
                startActivity(intent);
            }
            view.setVisibility(View.VISIBLE);
        }
        return true;
    }

}
