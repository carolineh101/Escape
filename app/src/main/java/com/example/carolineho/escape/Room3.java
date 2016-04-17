package com.example.carolineho.escape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Room3 extends AppCompatActivity {

    private TextView mToRoom4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room3);

        mToRoom4 = (TextView) findViewById(R.id.toRoom4);

        View.OnClickListener toRoom4Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Room3.this, Room4.class);
                startActivity(intent);
            }
        };

        mToRoom4.setOnClickListener(toRoom4Listener);
    }
}
