package id.revze.androidmvpsample.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnimeResponse {
    @SerializedName("character")
    private ArrayList<AnimeCharacter> animeCharacters;

    public AnimeResponse() {}

    public ArrayList<AnimeCharacter> getAnimeCharacters() {
        return animeCharacters;
    }

    public void setAnimeCharacters(ArrayList<AnimeCharacter> animeCharacters) {
        this.animeCharacters = animeCharacters;
    }
}
