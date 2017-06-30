package com.example.iulian.memo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Memos extends AppCompatActivity {

    BDHandler dbHandler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memos);


        dbHandler = new BDHandler(this, null, null, 1);

        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.buttonContainer);

        Cursor c = dbHandler.extractTitles();
        c.moveToFirst();

        if(c.moveToFirst() && c.getCount() >= 1) {
            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex("memotitle")) != null) {
                    String mTitle = c.getString(c.getColumnIndex("memotitle"));
                    button = new Button(this);
                    button.setText(mTitle);
                    buttonContainer.addView(button);

                    final Intent intent = new Intent(Memos.this, DisplayMemo.class);
                    intent.putExtra("EXTRA_MEMO_TITLE", mTitle);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(intent);
                        }

                    });

                    c.moveToNext();
                }
            }
        }


        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Memos.this, NewMemo.class));
            }

        });

    }
}
