package com.m7amdelbana.haninround3.ui.nearby;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.network.api.APIClient;
import com.m7amdelbana.haninround3.network.models.Place;
import com.m7amdelbana.haninround3.network.services.PlacesService;
import com.m7amdelbana.haninround3.ui.home.HomeFragment;
import com.m7amdelbana.haninround3.ui.home.PlaceAdapter;
import com.m7amdelbana.haninround3.utils.Utilities;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NearbyFragment extends Fragment implements OnMapReadyCallback {

    private Context context;
    private GoogleMap map;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Location currentLocation;

    public NearbyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        setupMap();
        return view;
    }

    private void setupMap() {
        context = Objects.requireNonNull(getActivity()).getApplicationContext();
        mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;

        // TODO: Check if connected!
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        // map.setMyLocationEnabled(true);

        getMyLocation();
        getPlaces();
    }

    private void getMyLocation() {
        if (Utilities.checkLocationPermission(context)) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);

            Task location = fusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    currentLocation = (Location) task.getResult();
                    if (currentLocation != null) {
                        initMarker(currentLocation.getLatitude(), currentLocation.getLongitude(), "My location");
                        moveCamera(currentLocation.getLatitude(), currentLocation.getLongitude());
                    } else {
                        Toast.makeText(context, "We can't find your location.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Open location", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initMarker(double lat, double lng, String title) {
        LatLng latLng = new LatLng(lat, lng);
        map.addMarker(new MarkerOptions().position(latLng).title(title));
    }

    private void moveCamera(double lat, double lng) {
        LatLng latLng = new LatLng(lat, lng);
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    private void getPlaces() {
        PlacesService placesService = APIClient.getClient().create(PlacesService.class);
        placesService.getPlaces().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(@NotNull Call<List<Place>> call, @NotNull Response<List<Place>> response) {
                if (response.isSuccessful()) {
                    List<Place> places = response.body();
                    if (places != null && !places.isEmpty()) {
                        for (Place place : places) {
                            initMarker(place.getLat(), place.getLng(), place.getName());
                        }
                    }
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

    @Override
    public void onResume() {
        super.onResume();
        mapFragment.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapFragment.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapFragment.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapFragment.onLowMemory();
    }
}