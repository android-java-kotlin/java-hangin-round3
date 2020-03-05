package com.m7amdelbana.haninround3.ui.bookings;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.m7amdelbana.haninround3.R;

public class BookingsFragment extends Fragment {

    public BookingsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookings, container, false);
    }
}
