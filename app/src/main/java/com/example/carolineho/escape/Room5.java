package com.example.carolineho.escape;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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

        SpannableString key  = new SpannableString(mKey.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                mToRoom6.setVisibility(View.VISIBLE);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(mKey.getTextColors().getDefaultColor());
            }
        };
        key.setSpan(clickableSpan, 44, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mKey.setText(key);
        mKey.setHighlightColor(Color.TRANSPARENT);
        mKey.setMovementMethod(LinkMovementMethod.getInstance());

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
