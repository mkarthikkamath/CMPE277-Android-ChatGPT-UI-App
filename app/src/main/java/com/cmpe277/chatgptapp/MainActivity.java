package com.cmpe277.chatgptapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrompt;
    private Button buttonSend;
    private TextView textViewResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrompt = findViewById(R.id.editTextPrompt);
        buttonSend = findViewById(R.id.buttonSend);
        textViewResponse = findViewById(R.id.textViewResponse);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prompt = editTextPrompt.getText().toString();
                new ChatGPTAsyncTask(response -> textViewResponse.setText(response)).execute(prompt);
            }
        });
    }
}
