package com.example.carolineho.escape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Room5 extends AppCompatActivity {

    private TextView mKey;
    private Button mToRoom6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room5);

        mKey = (TextView) findViewById(R.id.Key);
        mToRoom6 = (Button) findViewById(R.id.ToRoom6);

        View.OnClickListener getKeyListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToRoom6.setVisibility(View.VISIBLE);
            }
        };

        mKey.setOnClickListener(getKeyListener);

        View.OnClickListener toRoom6Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Room5.this, Room6.class);
                startActivity(intent);
            }
        };

        mToRoom6.setOnClickListener(toRoom6Listener);
    }
}
