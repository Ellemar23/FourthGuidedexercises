package com.example.fourthguidedexercises;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView result;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure the layout filename is correct!

        // Initialization
        username = findViewById(R.id.etUsernameGE4);
        password = findViewById(R.id.etPasswordGE4);
        result = findViewById(R.id.tvResultGE4);
        login = findViewById(R.id.btnLoginGE4);

        showResult();
    }

    public void showResult() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().isEmpty() ) {
                    username.setError("Username is required!");
                    return;
                }

                if (password.getText().toString().isEmpty()) {
                    password.setError("Password is required!");
                    return;
                }


                String userInput = username.getText().toString();
                String passInput = password.getText().toString();

                if (!userInput.equals("") && !passInput.equals("")) {
                    result.setText("Welcome " + userInput + "!");
                    result.setBackgroundColor(Color.GREEN);
                    result.setTextColor(Color.DKGRAY);
                } else {
                    result.setText("Username and Password does not exist!");
                    result.setTextColor(Color.RED);
                }
                clearEntry();
            }
        });
    }

    public void clearEntry() {
        result.setVisibility(View.VISIBLE);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }
}
