package id.revze.androidmvpsample.networking;

import android.content.Context;

import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.util.ArrayList;

import id.revze.androidmvpsample.R;
import id.revze.androidmvpsample.models.AnimeCharacter;
import id.revze.androidmvpsample.models.AnimeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service {
    private static final Service INSTANCE = new Service();
    private NetworkService networkService;

    private Service() {
        networkService = NetworkModule.getInstance().create(NetworkService.class);
    }

    public static Service getInstance() {
        return INSTANCE;
    }

    public void getAnimeCharacters(final Context context, final GetAnimeCharactersCallback animeCharactersCallback) {
        Call<AnimeResponse> animeResponseCall = networkService.getAnimeCharacters();
        animeResponseCall.enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {
                animeCharactersCallback.onSuccess(response.body().getAnimeCharacters());
            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                if (t instanceof MalformedJsonException) animeCharactersCallback.onError(context.getString(R.string.server_error));
                else if (t instanceof IOException) animeCharactersCallback.onError(context.getString(R.string.network_error));
                else animeCharactersCallback.onError(context.getString(R.string.something_went_wrong));
            }
        });
    }

    public interface GetAnimeCharactersCallback {
        void onSuccess(ArrayList<AnimeCharacter> animeCharacters);

        void onError(String message);
    }
}
