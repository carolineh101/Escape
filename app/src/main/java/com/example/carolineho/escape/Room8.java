package com.example.carolineho.escape;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Room8 extends AppCompatActivity {

    private EditText mDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room8);

        mDoor = (EditText) findViewById(R.id.Door);

        View.OnClickListener clickDoorListener = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (v.getId() == mDoor.getId())
                {
                    mDoor.setCursorVisible(true);
                }
            }
        };

        mDoor.setOnClickListener(clickDoorListener);

        TextView.OnEditorActionListener toRoom9Listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (v.getText().toString().toLowerCase().indexOf("door") != -1) {
                        Intent intent = new Intent(Room8.this, Room9.class);
                        startActivity(intent);
                    }
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(v.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        };

        mDoor.setOnEditorActionListener(toRoom9Listener);
    }
}
