package com.m7amdelbana.haninround3.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m7amdelbana.haninround3.R;

public class PlaceDetailsFragment extends Fragment {

    public PlaceDetailsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_details, container, false);
    }
}
