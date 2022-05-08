package com.example.lab2rolandokathyver2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class CcssAlajuela_Activity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityalajuela)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapAlajuela) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val ccssAlajuela = LatLng(10.020801, -84.213866)
        mMap.addMarker(
            MarkerOptions()
            .position(ccssAlajuela)
            .title("CCSS Alajuela"))
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ccssAlajuela,15F))
    }

}