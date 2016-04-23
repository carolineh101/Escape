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

public class Room7 extends AppCompatActivity {

    private Button mToRoom8;
    private EditText mSpace1;
    private EditText mSpace2;
    private TextView mDummy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room7);

        mToRoom8 = (Button) findViewById(R.id.ToRoom8);
        mSpace1 = (EditText) findViewById(R.id.Space1);
        mSpace2 = (EditText) findViewById(R.id.Space2);
        mDummy = (TextView) findViewById(R.id.Dummy);

        mSpace2.setTextColor(mDummy.getTextColors().getDefaultColor());
        mSpace2.setHorizontallyScrolling(false);
        mSpace2.setMaxLines(3);

        TextView.OnEditorActionListener space1Listener = new TextView.OnEditorActionListener() {
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

        mSpace1.setOnEditorActionListener(space1Listener);

        TextView.OnEditorActionListener space2Listener = new TextView.OnEditorActionListener() {
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

        mSpace2.setOnEditorActionListener(space2Listener);

        View.OnClickListener toRoom8Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSpace1.getText().toString().equals("Room7") && mSpace2.getText().toString().equals("Thisroomhasmuchmorespace...butnowtheendoftheroomistoofaraway.")) {
                    Intent intent = new Intent(Room7.this, Escaped.class);
                    startActivity(intent);
                }
            }
        };

        mToRoom8.setOnClickListener(toRoom8Listener);
    }
}
