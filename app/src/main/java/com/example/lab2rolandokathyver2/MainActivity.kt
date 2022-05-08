package com.example.lab2rolandokathyver2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.gms.ads.*
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(){

    private val TAG = "MAinActivity"

    private lateinit var mAdView: AdView
    private lateinit var interstitialAD: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this)

        bannerAds()
        interstitialAd()

        findViewById<Button>(R.id.btnHeredia).setOnClickListener {
            //startActivity(Intent(this, CcssHeredia_Activity::class.java))
            if(interstitialAD.isLoaded) {
                interstitialAD.show()
            } else {
                Log.d(TAG, "El anuncio interstitial no fue cargado")
            }
        }

        findViewById<Button>(R.id.btnAlajuela).setOnClickListener {
            startActivity(Intent(this, CcssAlajuela_Activity::class.java))
        }

    }

    private fun interstitialAd() {
        interstitialAD = InterstitialAd(this)
        interstitialAD.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        interstitialAD.loadAd(AdRequest.Builder().build())
        val i = Intent(this, CcssHeredia_Activity::class.java)
        interstitialAD.adListener = object : AdListener(){
            override fun onAdLoaded() {
                Log.d(TAG, "Se cargo el anuncio interstitial")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                Log.d(TAG, "Anuncio fallo de cargar interstitial")
            }

            override fun onAdOpened() {
                Log.d(TAG, "Se abrio el anuncio interstitial")
            }

            override fun onAdClicked() {
                Log.d(TAG, "Se dio click al anuncio interstitial")
            }

            override fun onAdClosed() {
                Log.d(TAG, "Se cerro el anuncio interstitial")
                interstitialAD.loadAd(AdRequest.Builder().build())

                startActivity(i)
            }
        }

    }

    private fun bannerAds() {
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object : AdListener(){
            override fun onAdLoaded() {
                Log.d(TAG, "Se cargo el anuncio")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                Log.d(TAG, "Anuncio fallo de cargar")
            }

            override fun onAdOpened() {
                Log.d(TAG, "Se abrio el anuncio")
            }

            override fun onAdClicked() {
                Log.d(TAG, "Se dio click al anuncio")
            }

            override fun onAdClosed() {
                Log.d(TAG, "Se cerro el anuncio")
            }
        }
    }




}