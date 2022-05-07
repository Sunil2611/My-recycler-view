package com.example.recyclerviewexample;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class RecycleViewAdapter extends RecyclerView.Adapter <RecycleViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtEmail;
        private ImageView imageView;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imageView = itemView.findViewById(R.id.action_image);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            parent = itemView.findViewById(R.id.parent);
        }
    }

    public RecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactrecview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int i = holder.getAdapterPosition();
        holder.txtName.setText(contacts.get(i).getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,contacts.get(i).getName()+"Selected", Toast.LENGTH_SHORT).show();
            }
        });
        holder.txtEmail.setText(contacts.get(i).getEmail());
        Glide.with(context)
                .asBitmap()
                .load(contacts.get(i).getImageUrl())
                .into(holder.imageView);

        //holder..setImage(contacts.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {

        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }
}
