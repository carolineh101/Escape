package com.example.carolineho.escape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Room1 extends AppCompatActivity {

    private Button mToRoom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        mToRoom2 = (Button) findViewById(R.id.ToRoom2);
        View.OnLongClickListener toRoom2Listener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Room1.this, Room2.class);
                startActivity(intent);
                return true;
            }
        };

        mToRoom2.setOnLongClickListener(toRoom2Listener);
    }
}
