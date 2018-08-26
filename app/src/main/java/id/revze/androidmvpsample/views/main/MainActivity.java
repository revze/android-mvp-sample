package id.revze.androidmvpsample.views.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.revze.androidmvpsample.R;
import id.revze.androidmvpsample.models.AnimeCharacter;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mainPresenter;
    private Context context;
    private RecyclerView rvAnimeCharacter;
    private AnimeCharacterAdapter animeCharacterAdapter;
    private ArrayList<AnimeCharacter> animeCharacters = new ArrayList<>();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter();
        onAttachView();

        context = this;
        rvAnimeCharacter = findViewById(R.id.rv_anime_character);
        rvAnimeCharacter.setLayoutManager(new LinearLayoutManager(this));
        animeCharacterAdapter = new AnimeCharacterAdapter(animeCharacters);
        rvAnimeCharacter.setAdapter(animeCharacterAdapter);
        mainPresenter.getAnimeCharacters(context);
    }

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        mainPresenter.onDetach();
    }

    @Override
    public void showLoader() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    public void hideLoader() {
        if (progressDialog != null) progressDialog.dismiss();
    }

    @Override
    public void onFailedGetAnimeCharacters(String message) {
        Snackbar.make(getWindow().getDecorView().getRootView(), message, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onSuccessGetAnimeCharacters(ArrayList<AnimeCharacter> animeCharacters) {
        this.animeCharacters.addAll(animeCharacters);
        animeCharacterAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }
}
