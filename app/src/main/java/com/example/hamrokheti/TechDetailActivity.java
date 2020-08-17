package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hamrokheti.adapter.TechDetailAdapter;
import com.example.hamrokheti.api.CatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static url.Url.getInstance;
import StrictMode.StrictModeClass;
import model.techDetail;
import retrofit2.Call;
import retrofit2.Response;


public class TechDetailActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<techDetail>techDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_detail);

        String techinfoId = getIntent().getStringExtra("techinfo");

        StrictModeClass.StrictMode();
        recyclerView = findViewById(R.id.TechDetailRecyclerView);

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<techDetail>> listCall = catApi.gettechDetail(techinfoId);
        try {
            Response<List<techDetail>> gettechDetail = listCall.execute();
            if (gettechDetail.isSuccessful()){
                techDetails = gettechDetail.body();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        TechDetailAdapter techDetailAdapter = new TechDetailAdapter(this,techDetails);
        recyclerView.setAdapter(techDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}