package com.example.stefan.google_mapa2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bundle dane = getIntent().getExtras();
        int miasto = dane.getInt("miasto");
        switch(miasto)
        {
            case 1:

                LatLng lublin = new LatLng(51.2464536, 22.568446300000005);
                mMap.addMarker(new MarkerOptions().position(lublin).title("LUBLIN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(lublin));
                break;
            case 2:

                LatLng war = new LatLng(52.229676, 21.012228999999934);
                mMap.addMarker(new MarkerOptions().position(war).title("WARSZAWA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(war));
                break;
            case 3:

                LatLng par = new LatLng(48.85661400000001, 2.3522219000000177);
                mMap.addMarker(new MarkerOptions().position(par).title("PARYŻ"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(par));
                break;
        }
    }
}
