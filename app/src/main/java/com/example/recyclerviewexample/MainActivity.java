package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private static final String TAG = "Cannot in logt
    private RecyclerView contactRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactRecView = findViewById(R.id.contactRecView);


        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Sunil","sunil@gmail.com","https://m.media-amazon.com/images/M/MV5BODI4NDY1NzkyM15BMl5BanBnXkFtZTgwNzM3MDM0OTE@._V1_.jpg"));
        contacts.add(new Contact("Seema","seema@gmail.com","https://m.media-amazon.com/images/M/MV5BODI4NDY1NzkyM15BMl5BanBnXkFtZTgwNzM3MDM0OTE@._V1_.jpg"));

        RecycleViewAdapter adapter = new RecycleViewAdapter(this);
        adapter.setContacts(contacts);
        contactRecView.setAdapter(adapter);
        contactRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}