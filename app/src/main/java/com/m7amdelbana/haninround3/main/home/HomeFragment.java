package com.m7amdelbana.haninround3.main.home;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements PlaceItemClick {

    private RecyclerView recyclerView;
    private NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        return view;
    }

    void initUI(View view) {
        recyclerView = view.findViewById(R.id.home_recyclerView);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        getPlace();
    }

    @Override
    public void onItemClicked(int position) {
        navController.navigate(R.id.action_homeFragment_to_placeDetailsFragment);
    }

    void getPlace() {
        PlacesService placesService = APIClient.getClient().create(PlacesService.class);

        placesService.getPlaces().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(@NotNull Call<List<Place>> call, @NotNull Response<List<Place>> response) {
                if (response.isSuccessful()) {
                    // List<Place> places = new ArrayList<>();
                    List<Place> places = response.body();

                    // TODO: LinearLayoutManager
                    // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                    // recyclerView.setLayoutManager(linearLayoutManager);

                    // TODO: LinearLayoutManager
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    // TODO: StaggeredGridLayoutManager
                    // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                    // recyclerView.setLayoutManager(staggeredGridLayoutManager);

                    PlaceAdapter placeAdapter = new PlaceAdapter(places, HomeFragment.this);
                    recyclerView.setAdapter(placeAdapter);
                } else {
                    Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NotNull Call<List<Place>> call, @NotNull Throwable t) {
                Toast.makeText(getActivity(), "Service Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
