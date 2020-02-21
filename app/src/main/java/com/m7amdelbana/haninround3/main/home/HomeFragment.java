package com.m7amdelbana.haninround3.main.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.models.Place;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.home_recyclerView);
        List<Place> places = new ArrayList<>();


        places.add(new Place("", "Name 1", "Address 1", 2.5F));
        places.add(new Place("", "Name 2", "Address 2", 2.5F));
        places.add(new Place("", "Name 1", "Address 1", 2.5F));
        places.add(new Place("", "Name 2", "Address 2", 2.5F));

        PlaceAdapter placeAdapter = new PlaceAdapter(places, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(placeAdapter);

        return view;
    }
}
