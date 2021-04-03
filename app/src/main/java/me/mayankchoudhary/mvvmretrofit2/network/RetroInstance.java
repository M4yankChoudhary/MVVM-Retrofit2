package me.mayankchoudhary.mvvmretrofit2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static  String BASE_URL = "https://api.spacexdata.com/v4/";

    private static Retrofit  retrofit;

    public static Retrofit getRetrofitClient() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    return retrofit;
    }

}
