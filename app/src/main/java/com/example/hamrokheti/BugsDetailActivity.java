package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.hamrokheti.adapter.BugsDetailAdapter;
import com.example.hamrokheti.api.CatApi;

import StrictMode.StrictModeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

import model.bugsDetail;
import retrofit2.Call;
import retrofit2.Response;

import static url.Url.getInstance;

public class BugsDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<bugsDetail> bugsDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugs_detail);

        String bugsinfoId = getIntent().getStringExtra("bugsinfo");

        StrictModeClass.StrictMode();
        recyclerView = findViewById(R.id.BugsDetailRecyclerView);

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<bugsDetail>> listCall = catApi.getbugsDetail(bugsinfoId);
        try {
            Response<List<bugsDetail>> getbugsDetail = listCall.execute();

            if (getbugsDetail.isSuccessful()){
                bugsDetails = getbugsDetail.body();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        BugsDetailAdapter bugsDetailAdapter = new BugsDetailAdapter(this,bugsDetails);
        recyclerView.setAdapter(bugsDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}