package com.example.iulian.memo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayMemo extends AppCompatActivity {

    TextView memoTitle;
    TextView memoText;
    BDHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_memo);

        String s = getIntent().getStringExtra("EXTRA_MEMO_TITLE");

        dbHandler = new BDHandler(this, null, null, 1);
        Cursor c = dbHandler.extractText(s);
        c.moveToFirst();
        String temp = c.getString(c.getColumnIndex("memotext"));


        memoText = (TextView) findViewById(R.id.mText);
        memoText.setText(temp);

        memoTitle = (TextView) findViewById(R.id.mTitle);
        memoTitle.setText(s);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayMemo.this, Memos.class));
            }

        });

    }



}
