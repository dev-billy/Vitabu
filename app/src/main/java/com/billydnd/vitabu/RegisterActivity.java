package com.billydnd.vitabu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText userName;
    Button registerActionBtn;
    String submittedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        registerActionBtn = findViewById(R.id.register_action_btn);
        userName = findViewById(R.id.register_name);



        registerActionBtn.setEnabled(false);
        registerActionBtn.setBackgroundColor(getResources().getColor(R.color.grey));
        registerActionBtn.setTextColor(Color.BLACK);

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
                    registerActionBtn.setEnabled(true);
                    registerActionBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    registerActionBtn.setTextColor(Color.WHITE);
                }else{
                    registerActionBtn.setEnabled(false);
                    registerActionBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    registerActionBtn.setTextColor(Color.BLACK);
                }


            }
        });

        registerActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submittedName = userName.getText().toString().substring(0,1).toUpperCase() + userName.getText().toString().substring(1);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name",submittedName);
                v.getContext().startActivity(intent);

                Toast toast = Toast.makeText(getApplicationContext(),"Registration successful",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
