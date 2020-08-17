package com.example.hamrokheti.api;

import java.util.List;

import model.bugsDetail;
import model.bugsinfo;
import model.category;
import model.productList;
import model.techDetail;
import model.techinfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CatApi {

    @GET("category/all")
    Call<List<category>> getcategory();

    @GET("productList/productList/{categoryId}")
    Call<List<productList>> getproductList(@Path("categoryId") String categoryId);
    // getting product list according to category

    @GET("bugsinfo/all")
    Call<List<bugsinfo>> getbugsinfo();

    @GET("bugsDetail/bugsDetail/{bugsinfoId}")
    Call<List<bugsDetail>> getbugsDetail(@Path("bugsinfoId") String bugsinfoId);

    @GET("techinfo/all")
    Call<List<techinfo>> gettechinfo();

    @GET("techDetail/techDetail/{techinfoId}")
    Call<List<techDetail>> gettechDetail(@Path("techinfoId") String techinfoId);
}
