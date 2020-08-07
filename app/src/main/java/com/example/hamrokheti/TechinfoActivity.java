package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hamrokheti.adapter.TechinfoAdapter;
import com.example.hamrokheti.api.CatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import StrictMode.StrictModeClass;
import model.techinfo;
import retrofit2.Call;
import retrofit2.Response;

import static url.Url.getInstance;

public class TechinfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<techinfo> techinfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techinfo);

        StrictModeClass.StrictMode();
        recyclerView = findViewById(R.id.TechinfoRecyclerView);

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<techinfo>> listCall = catApi.gettechinfo();
        try {
            Response<List<techinfo>> gettechinfo = listCall.execute();
            if (gettechinfo.isSuccessful()){
                techinfoList = gettechinfo.body();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        TechinfoAdapter techinfoAdapter = new TechinfoAdapter(this,techinfoList);
        recyclerView.setAdapter(techinfoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}