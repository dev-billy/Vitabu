package com.billydnd.vitabu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView,dateTextView,descriptionTextView;
    private Button buyBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String  title = getIntent().getStringExtra("title");
        String date = getIntent().getStringExtra("publishdate");
        String description = getIntent().getStringExtra("description");

        titleTextView = findViewById(R.id.kitabu_name);
        dateTextView = findViewById(R.id.kitabu_publish);
        descriptionTextView = findViewById(R.id.kitabu_description);
        buyBook = findViewById(R.id.buy_book_btn);

        titleTextView.setText(title);
        dateTextView.setText(date);
        descriptionTextView.setText(description);

        buyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Item is not available in your country",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
