package com.example.carolineho.escape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;

public class Room4 extends AppCompatActivity {

    private Button mToRoom5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room4);

        mToRoom5 = (Button) findViewById(R.id.ToRoom5);

        View.OnLongClickListener toRoom5Listener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Room4.this, Room5.class);
                startActivity(intent);
                return true;
            }
        };

        mToRoom5.setOnLongClickListener(toRoom5Listener);
    }
}
