package com.example.carolineho.escape;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class Room3 extends AppCompatActivity {

    private TextView mToRoom4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room3);

        mToRoom4 = (TextView) findViewById(R.id.ToRoom4);

        SpannableString room4  = new SpannableString(mToRoom4.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(Room3.this, Room4.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(mToRoom4.getTextColors().getDefaultColor());
            }
        };
        room4.setSpan(clickableSpan, 93, 99, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mToRoom4.setText(room4);
        mToRoom4.setHighlightColor(Color.TRANSPARENT);
        mToRoom4.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
