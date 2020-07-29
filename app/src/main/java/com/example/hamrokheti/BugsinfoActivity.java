package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hamrokheti.adapter.BugsinfoAdapter;
import com.example.hamrokheti.api.CatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import StrictMode.StrictModeClass;
import model.bugsinfo;
import retrofit2.Call;
import retrofit2.Response;

import static url.Url.getInstance;

public class BugsinfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<bugsinfo> bugsinfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugsinfo);

        StrictModeClass.StrictMode();
        recyclerView = findViewById(R.id.BugsinfoRecyclerView);

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<bugsinfo>> listCall = catApi.getbugsinfo();
        try {
            Response<List<bugsinfo>> getbugsinfo = listCall.execute();
            if (getbugsinfo.isSuccessful()){
                bugsinfoList = getbugsinfo.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BugsinfoAdapter bugsinfoAdapter = new BugsinfoAdapter(this,bugsinfoList);
        recyclerView.setAdapter(bugsinfoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}