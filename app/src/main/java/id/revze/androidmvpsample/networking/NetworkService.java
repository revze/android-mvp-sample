package id.revze.androidmvpsample.networking;

import id.revze.androidmvpsample.models.AnimeResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("/anime/1/characters_staff")
    Call<AnimeResponse> getAnimeCharacters();
}
