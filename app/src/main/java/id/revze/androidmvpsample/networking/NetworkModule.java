package id.revze.androidmvpsample.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.jikan.moe";

    public static Retrofit getInstance() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
