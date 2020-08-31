package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;

import com.example.hamrokheti.adapter.LinkAdapter;
import com.example.hamrokheti.api.CatApi;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import StrictMode.StrictModeClass;
import model.link;
import static url.Url.getInstance;
import retrofit2.Call;
import retrofit2.Response;

public class LinkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<link> linkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        recyclerView = findViewById(R.id.LinkRecyclerView);
        StrictModeClass.StrictMode();

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<link>> listCall = catApi.getlink();
        try {
            Response<List<link>> getlink = listCall.execute();
                if (getlink.isSuccessful()){
                    linkList = getlink.body();
                }
        }catch (IOException e){
            e.printStackTrace();
        }

       LinkAdapter linkAdapter = new LinkAdapter(this,linkList);
        recyclerView.setAdapter(linkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}