package id.revze.androidmvpsample.models;

import com.google.gson.annotations.SerializedName;

public class AnimeCharacter {
    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    private String role;

    public AnimeCharacter(String imageUrl, String name, String role) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
