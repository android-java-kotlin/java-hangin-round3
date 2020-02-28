package com.m7amdelbana.haninround3.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.models.Place;

import java.util.ArrayList;
import java.util.List;

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
        List<Place> places = new ArrayList<>();


        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 1", "Address 1", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 2", "Address 2", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 3", "Address 3", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 4", "Address 4", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 5", "Address 5", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 6", "Address 6", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 7", "Address 7", 2.5F));
        places.add(new Place("http://i.imgur.com/DvpvklR.png", "Name 8", "Address 8", 2.5F));


        // TODO: LinearLayoutManager
        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // recyclerView.setLayoutManager(linearLayoutManager);

        // TODO: LinearLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // TODO: StaggeredGridLayoutManager
        // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // recyclerView.setLayoutManager(staggeredGridLayoutManager);

        PlaceAdapter placeAdapter = new PlaceAdapter(places, this);

        recyclerView.setAdapter(placeAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onItemClicked(int position) {
        navController.navigate(R.id.action_homeFragment_to_placeDetailsFragment);
    }
}
