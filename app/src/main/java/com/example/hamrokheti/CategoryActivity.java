package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamrokheti.Retrofit.ApiClient;
import com.example.hamrokheti.Retrofit.ApiInterface;
import com.example.hamrokheti.adapter.CategoryAdapter;
import com.example.hamrokheti.api.CatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import StrictMode.StrictModeClass;
import model.category;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.Url;

import static url.Url.base_url;
import static url.Url.getInstance;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    List<category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        StrictModeClass.StrictMode();
        recyclerView = findViewById(R.id.CateRecyclerView);

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<category>> listCall = catApi.getcategory();
        try {
            Response<List<category>> getcategory = listCall.execute();
            if (getcategory.isSuccessful()){
                categoryList = getcategory.body();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}