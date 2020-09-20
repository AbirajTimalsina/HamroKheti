package com.example.hamrokheti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamrokheti.Retrofit.ApiClient;
import com.example.hamrokheti.Retrofit.ApiInterface;
import com.example.hamrokheti.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WheatherActivity extends AppCompatActivity {

    EditText etSrc;
    ImageView imgSrc;
    TextView txtTemp,txtDesc,txtHum,txtPre;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheather);

        etSrc = findViewById(R.id.etSearch);
        imgSrc = findViewById(R.id.imgSearch);
        txtTemp = findViewById(R.id.txtTemp);
        txtDesc = findViewById(R.id.txtDesc);
        txtHum = findViewById(R.id.txtHum);
        txtPre = findViewById(R.id.txtPre);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WheatherActivity.this,MordernDashboardActivity.class);
                startActivity(intent);
            }
        });

        imgSrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (TextUtils.isEmpty(etSrc.getText())){
                   etSrc.setError("मौसम जानकारी हेर्न कृपया तपाईको शहरको नाम टाइप गर्नुहोस्");
                   etSrc.requestFocus();
                   return;
               }
                getWeatherData(etSrc.getText().toString().trim());
            }
        });
    }

    private void getWeatherData(String name){

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                txtTemp.setText("Temperature"+" : "+response.body().getMain().getTemp()+"  °C");
                txtDesc.setText("Feels Like"+" : "+response.body().getMain().getFeels_like()+"  °C");
                txtHum.setText("Humidity"+" : "+response.body().getMain().getHumidity()+"  %");
                txtPre.setText("Pressure"+" : "+response.body().getMain().getPressure()+" mbar");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}