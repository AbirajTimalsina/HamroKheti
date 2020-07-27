package com.example.hamrokheti.api;

import java.util.List;

import model.category;
import model.productList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CatApi {

    @GET("category/all")
    Call<List<category>> getcategory();

    @GET("productList/productList/{categoryId}")
    Call<List<productList>> getproductList(@Path("categoryId") String categoryId);

}
