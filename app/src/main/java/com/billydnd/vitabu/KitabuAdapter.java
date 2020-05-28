package com.billydnd.vitabu;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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
                    intent.putExtra("publishdate",current.getPublished_date());
                    intent.putExtra("description",current.getDescrption());

                    v.getContext().startActivity(intent);
                }
            });

        }
    }

    private List<Kitabu> kitabu = new ArrayList<>();
    private RequestQueue requestQueue;

    KitabuAdapter(Context context){
        requestQueue = Volley.newRequestQueue(context);
        loadData();
    }

    public void loadData(){
        String url = "https://www.googleapis.com/books/v1/volumes?q=programming&key=AIzaSyCtpyPizdZeNvHWNdf1bkLI-3TxmvjtdIo";
        JsonObjectRequest request = new  JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray items = response.getJSONArray("items");
                    for(int i = 0; i < items.length();i++){
                        JSONObject item = items.getJSONObject(i);
                        JSONObject bookInfo = item.getJSONObject("volumeInfo");
                        String bookTitle = bookInfo.getString("title");
                        String author = bookInfo.getJSONArray("authors").get(0).toString();
                        String publishedDate = bookInfo.getString("publishedDate");
                        String description = bookInfo.getString("description");
                        kitabu.add(new Kitabu(bookTitle,author,publishedDate,description));
                        notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    Log.e("kitabu", "Item Error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("kitabu","Item List error",error);
            }
        });

        requestQueue.add(request);
    }

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
        holder.publishTextView.setText(current.getPublished_date().substring(0,4));
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return kitabu.size();
    }
}
