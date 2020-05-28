package com.billydnd.vitabu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView,dateTextView,descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String  title = getIntent().getStringExtra("title");
        String date = getIntent().getStringExtra("publishdate");
        String description = getIntent().getStringExtra("description");

        titleTextView = findViewById(R.id.kitabu_name);
        dateTextView = findViewById(R.id.kitabu_publish);
        descriptionTextView = findViewById(R.id.kitabu_description);

        titleTextView.setText(title);
        dateTextView.setText(date);
        descriptionTextView.setText(description);
    }
}
