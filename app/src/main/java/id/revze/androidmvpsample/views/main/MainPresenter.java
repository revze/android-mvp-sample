package id.revze.androidmvpsample.views.main;

import android.content.Context;

import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.util.ArrayList;

import id.revze.androidmvpsample.R;
import id.revze.androidmvpsample.models.AnimeCharacter;
import id.revze.androidmvpsample.networking.Service;
import id.revze.androidmvpsample.models.AnimeResponse;
import id.revze.androidmvpsample.views.base.Presenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements Presenter<MainView> {
    private MainView mainView;

    @Override
    public void onAttach(final MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }

    public void getAnimeCharacters(final Context context) {
        if (mainView != null) mainView.showLoader();

        Service.getInstance().getAnimeCharacters(context, new Service.GetAnimeCharactersCallback() {
            @Override
            public void onSuccess(ArrayList<AnimeCharacter> animeCharacters) {
                if (mainView != null) {
                    mainView.hideLoader();
                    mainView.onSuccessGetAnimeCharacters(animeCharacters);
                }
            }

            @Override
            public void onError(String message) {
                if (mainView != null) {
                    mainView.hideLoader();
                    mainView.onFailedGetAnimeCharacters(message);
                }
            }
        });
    }
}
