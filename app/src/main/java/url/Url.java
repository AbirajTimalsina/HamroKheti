package url;

import androidx.lifecycle.ViewModelProvider;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    //public static final String base_url = "http://192.168.3.30:3001/"; // for real device
    public static final String base_url = "http://10.0.2.2:3000/"; // for virtual device
    // public static final String base_url = "http://172.100.100.5:3000/";  // for cloud.
    public static String token = "Bearer ";
    public static String imagePath = base_url + "uploads/" ;

    public static Retrofit getInstance(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .client(client)
                .build();

        return retrofit;
    }
}
