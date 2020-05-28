package com.billydnd.vitabu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText userName,password;
    Button loginActionBtn;
    String submittedName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userName = findViewById(R.id.login_name);
        password = findViewById(R.id.login_pass);
        loginActionBtn = findViewById(R.id.login_action_btn);

        loginActionBtn.setEnabled(false);
        loginActionBtn.setBackgroundColor(getResources().getColor(R.color.grey));
        loginActionBtn.setTextColor(Color.BLACK);


        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() >3){
                    loginActionBtn.setEnabled(true);
                    loginActionBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    loginActionBtn.setTextColor(Color.WHITE);
                }else{
                    loginActionBtn.setEnabled(false);
                    loginActionBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    loginActionBtn.setTextColor(Color.BLACK);
                }
            }
        });

        loginActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submittedName = userName.getText().toString().substring(0,1).toUpperCase() + userName.getText().toString().substring(1);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name",submittedName);
                v.getContext().startActivity(intent);

                Toast toast = Toast.makeText(getApplicationContext(),"Logging in successful",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
