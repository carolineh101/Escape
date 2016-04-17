package com.example.carolineho.escape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Room0 extends AppCompatActivity {

    private Button mToRoom1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room0);

        mToRoom1 = (Button) findViewById(R.id.ToRoom1);

        View.OnClickListener toRoom1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Room0.this, Room1.class);
                startActivity(intent);
            }
        };

        mToRoom1.setOnClickListener(toRoom1Listener);
    }
}
