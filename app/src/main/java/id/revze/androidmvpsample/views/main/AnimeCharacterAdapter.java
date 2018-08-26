package id.revze.androidmvpsample.views.main;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import id.revze.androidmvpsample.R;
import id.revze.androidmvpsample.models.AnimeCharacter;

public class AnimeCharacterAdapter extends RecyclerView.Adapter<AnimeCharacterAdapter.AnimeCharacterViewHolder> {

    private ArrayList<AnimeCharacter> animeCharacters;

    public AnimeCharacterAdapter(ArrayList<AnimeCharacter> animeCharacters) {
        this.animeCharacters = animeCharacters;
    }

    @NonNull
    @Override
    public AnimeCharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_character, parent, false);
        return new AnimeCharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeCharacterViewHolder holder, int position) {
        final AnimeCharacter animeCharacter = animeCharacters.get(position);
        holder.ivCharacter.setImageURI(Uri.parse(animeCharacter.getImageUrl()));
        holder.tvName.setText(animeCharacter.getName());
        holder.tvRole.setText(animeCharacter.getRole());
    }

    @Override
    public int getItemCount() {
        return animeCharacters.size();
    }

    public class AnimeCharacterViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ivCharacter;
        private TextView tvName, tvRole;

        public AnimeCharacterViewHolder(View view) {
            super(view);
            ivCharacter = view.findViewById(R.id.iv_character);
            tvName = view.findViewById(R.id.tv_name);
            tvRole = view.findViewById(R.id.tv_role);
        }
    }
}
