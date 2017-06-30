package com.example.iulian.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewMemo extends AppCompatActivity {

    EditText titleInput;
    EditText textInput;
    BDHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        titleInput = (EditText) findViewById(R.id.memoTitle);
        textInput = (EditText) findViewById(R.id.memoText);
        dbHandler = new BDHandler(this, null, null, 1);

        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewMemo.this, Memos.class));
            }

        });

    }

    public void saveButtonClicked(View view){
        DBMemo memo = new DBMemo(titleInput.getText().toString(), textInput.getText().toString());
        dbHandler.addMemo(memo);
        startActivity(new Intent(NewMemo.this, Memos.class));
    }

}
