package com.m7amdelbana.haninround3.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.network.api.APIClient;
import com.m7amdelbana.haninround3.network.models.Place;
import com.m7amdelbana.haninround3.network.services.PlacesService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements PlaceItemClick {

    private RecyclerView recyclerView;
    private NavController navController;
    private PlacesService placesService;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        recyclerView = view.findViewById(R.id.home_recyclerView);
        placesService = APIClient.getClient().create(PlacesService.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        getPlacesUsingRx();
    }

    @Override
    public void onItemClicked(int position) {
        navController.navigate(R.id.action_homeFragment_to_placeDetailsFragment);
    }

    private void getPlaces() {
        placesService.getPlaces().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(@NotNull Call<List<Place>> call, @NotNull Response<List<Place>> response) {
                if (response.isSuccessful()) {
                    List<Place> places = response.body();
                    setupData(places);
                } else {
                    Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Place>> call, @NotNull Throwable t) {
                Toast.makeText(getActivity(), "Service Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("CheckResult")
    private void getPlacesUsingRx() {
        placesService.getPlacesUsingRx().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Place>>() {
                    @Override
                    public void onSuccess(List<Place> places) {
                        setupData(places);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), "Service Error: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setupData(List<Place> places) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        PlaceAdapter placeAdapter = new PlaceAdapter(places, HomeFragment.this);
        recyclerView.setAdapter(placeAdapter);
    }
}
