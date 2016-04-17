package com.example.carolineho.escape;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Room6 extends AppCompatActivity {

    private Button mToRoom7;
    private EditText mClutter1;
    private EditText mClutter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room6);

        mToRoom7 = (Button) findViewById(R.id.ToRoom7);
        mClutter1 = (EditText) findViewById(R.id.Clutter1);
        mClutter2 = (EditText) findViewById(R.id.Clutter2);

        TextView.OnEditorActionListener clutter1Listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(v.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        };

        mClutter1.setOnEditorActionListener(clutter1Listener);

        TextView.OnEditorActionListener clutter2Listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(v.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        };

        mClutter2.setOnEditorActionListener(clutter2Listener);

        View.OnClickListener toRoom7Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClutter1.getText().length()==0 && mClutter2.getText().length()==0) {
                    Intent intent = new Intent(Room6.this, Room7.class);
                    startActivity(intent);
                }
            }
        };

        mToRoom7.setOnClickListener(toRoom7Listener);
    }
}
