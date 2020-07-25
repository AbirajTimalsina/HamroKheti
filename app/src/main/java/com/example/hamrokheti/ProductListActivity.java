package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hamrokheti.adapter.ProductListAdapter;
import com.example.hamrokheti.api.CatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import StrictMode.StrictModeClass;
import model.productList;
import retrofit2.Call;
import retrofit2.Response;

import static url.Url.getInstance;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<productList> productLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        StrictModeClass.StrictMode();
        recyclerView = findViewById(R.id.ProductListRecyclerView);

        CatApi catApi = getInstance().create(CatApi.class);
        Call<List<productList>> listCall = catApi.getproductList();
        try {

            Response<List<productList>> getproductList = listCall.execute();
            if (getproductList.isSuccessful()){
                productLists = getproductList.body();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        ProductListAdapter productListAdapter = new ProductListAdapter(this,productLists);
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}