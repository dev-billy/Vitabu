package com.billydnd.vitabu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String  title = getIntent().getStringExtra("title");

        titleTextView = findViewById(R.id.kitabu_name);

        titleTextView.setText(title);
    }
}
