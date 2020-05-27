package com.billydnd.vitabu;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Billy on 5/27/2020.
 */
public class KitabuAdapter extends RecyclerView.Adapter<KitabuAdapter.KitabuViewHolder> {
    public static class KitabuViewHolder extends RecyclerView.ViewHolder{
        LinearLayout containerView;
        TextView titleTextView,authorTextView,publishTextView;
        KitabuViewHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.row_kitabu);
            titleTextView = view.findViewById(R.id.row_book_title);
            authorTextView = view.findViewById(R.id.row_book_author);
            publishTextView = view.findViewById(R.id.row_book_date);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Kitabu current = (Kitabu) containerView.getTag();
                    Intent intent = new Intent(v.getContext(),DetailActivity.class);
                    intent.putExtra("title",current.getName());

                    v.getContext().startActivity(intent);
                }
            });

        }
    }

    private List<Kitabu> kitabu = Arrays.asList(
            new Kitabu("Programming in Java","Billy J",2020),
            new Kitabu("Programming in Kotlin","James Q",2020),
            new Kitabu("Programming for Android","Robert Martin",2020)
    );

    @NonNull
    @Override
    public KitabuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kitabu,parent,false);
        return  new KitabuViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull KitabuViewHolder holder, int position) {
        Kitabu current = kitabu.get(position);
        holder.titleTextView.setText(current.getName());
        holder.authorTextView.setText(current.getAuthor());
        holder.publishTextView.setText(String.format("%d",current.getPublished_date()));
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return kitabu.size();
    }
}
