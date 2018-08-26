package id.revze.androidmvpsample.views.base;

public interface Presenter<T extends View> {
    void onAttach(T View);

    void onDetach();
}
