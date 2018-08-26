package id.revze.androidmvpsample.views.main;

import java.util.ArrayList;

import id.revze.androidmvpsample.models.AnimeCharacter;
import id.revze.androidmvpsample.views.base.View;

public interface MainView extends View {
    void onSuccessGetAnimeCharacters(ArrayList<AnimeCharacter> animeCharacters);

    void onFailedGetAnimeCharacters(String message);

    void showLoader();

    void hideLoader();
}
