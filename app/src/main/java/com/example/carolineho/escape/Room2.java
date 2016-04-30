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

public class Room2 extends AppCompatActivity {

    private Button mToRoom1;
    private EditText mRoom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);

        mToRoom1 = (Button) findViewById(R.id.ToRoom1);
        mRoom2 = (EditText) findViewById(R.id.Room2);

        View.OnClickListener toRoom1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Room2.this, Room1.class);
                startActivity(intent);
            }
        };

        mToRoom1.setOnClickListener(toRoom1Listener);

        View.OnClickListener clickRoom2Listener = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (v.getId() == mRoom2.getId())
                {
                    mRoom2.setCursorVisible(true);
                }
            }
        };

        mRoom2.setOnClickListener(clickRoom2Listener);

        TextView.OnEditorActionListener room2Listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (v.getText().toString().equals("Room 3")) {
                        Intent intent = new Intent(Room2.this, Room3.class);
                        startActivity(intent);
                    }
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(v.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        };

        mRoom2.setOnEditorActionListener(room2Listener);
    }
}
