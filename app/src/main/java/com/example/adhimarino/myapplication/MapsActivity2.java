package com.example.adhimarino.myapplication;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;


public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location mLastLocation;
    GeoFire geoFire;
    private LatLng LokasiDriver;
    Marker mDriverMarker;
    LatLng Giwangan, tegalgendu, Maguwo, Bandara,
            CondongCatur,  ngabean,
            Giwanganakhir, Nitikan, sugiono2, sma7, tejokusuman, khaahmaddahlan, smp14, sudriman3,
            yap, jakal, sarjito, kentungan, jih, amikom, instiper2, binamarga, jayakarta, harjolukito, wonocatur, banguntapan, fojanti ;

    LatLng arrayLokasi[] = new LatLng[30];



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(mMap.getCameraPosition().zoom - 15.5f));
        mMap.getUiSettings().setZoomControlsEnabled(true);



        Giwangan = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwangan)
                .title("Terminal Giwangan")
                .snippet("Jl Imogiri Timur")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Giwangan));


        Nitikan = new LatLng(-7.824808, 110.379972);
        mMap.addMarker(new MarkerOptions().position(Nitikan).title("Nitikan").snippet("Jl Sorogenen").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Nitikan));

        sugiono2 = new LatLng(-7.815114, 110.371870);
        mMap.addMarker(new MarkerOptions().position(sugiono2).title("Musemun Perjuangan").snippet("Jl Kolonel Sugiyono").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sugiono2));

        sma7  = new LatLng(-7.813437, 110.358140);
        mMap.addMarker(new MarkerOptions().position(sma7).title("SMA Negeri 7 Yogyakarta").snippet("Jl MT Haryono").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sma7));

        Maguwo = new LatLng(-7.783326, 110.4303992);
        mMap.addMarker(new MarkerOptions().position(Maguwo).title("Maguwo").snippet("JL solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Maguwo));

        Bandara = new LatLng(-7.784518, 110.43569);
        mMap.addMarker(new MarkerOptions().position(Bandara).title("Bandara").snippet("Bandara ADISUCIPTO").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bandara));

        tejokusuman = new LatLng(-7.807815, 110.355995);
        mMap.addMarker(new MarkerOptions().position(tejokusuman).title("Taman Sari").snippet("JL Tejokusuman").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tejokusuman));

        khaahmaddahlan = new LatLng(-7.801161, 110.360603);
        mMap.addMarker(new MarkerOptions().position(khaahmaddahlan).title("KHA DAHLAN 2").snippet("JL KHA DAHLAN ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(khaahmaddahlan));

        smp14 = new LatLng(-7.786579, 110.359915);
        mMap.addMarker(new MarkerOptions().position(smp14).title("SMP Negeri 14").snippet("JL. Tentara Pelajar").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(smp14));

        sudriman3 = new LatLng(-7.782916, 110.368765);
        mMap.addMarker(new MarkerOptions().position(sudriman3).title("Hotel Shantika").snippet("Jl Sudirman").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sudriman3));

        CondongCatur = new LatLng(-7.756636, 110.395825);
        mMap.addMarker(new MarkerOptions().position(CondongCatur).title("Terminal Condong Catur").snippet("Terminal Condong Catur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CondongCatur));

        yap = new LatLng(-7.781218, 110.375166);
        mMap.addMarker(new MarkerOptions().position(yap).title("RS Mata Dr Yap").snippet("Jl Cik Di Tiro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(yap));

        jakal = new LatLng(-7.774631, 110.374927);
        mMap.addMarker(new MarkerOptions().position(jakal).title("Pertanian UGM").snippet("Jl Kaliurang").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jakal));

        sarjito = new LatLng(-7.769582, 110.37352);
        mMap.addMarker(new MarkerOptions().position(sarjito).title("RS Sardjito").snippet("RS Sardjito").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sarjito));

        kentungan = new LatLng(-7.755246, 110.383762);
        mMap.addMarker(new MarkerOptions().position(kentungan).title("Kentungan").snippet("JL Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kentungan));

        jih = new LatLng(-7.75881, 110.403127);
        mMap.addMarker(new MarkerOptions().position(jih).title("Rumah Sakit JIH").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jih));

        amikom = new LatLng(-7.760692, 110.408855);
        mMap.addMarker(new MarkerOptions().position(amikom).title("Amikom").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(amikom));

        instiper2 = new LatLng(-7.764348, 110.423698);
        mMap.addMarker(new MarkerOptions().position(instiper2).title("Instiper").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(instiper2));

        binamarga = new LatLng(-7.77451, 110.430805);
        mMap.addMarker(new MarkerOptions().position(binamarga).title("Binamarga").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(binamarga));

        jayakarta = new LatLng(-7.783406, 110.41944);
        mMap.addMarker(new MarkerOptions().position(jayakarta).title("Hotel Jayakarta").snippet("Jl Solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jayakarta));

        harjolukito = new LatLng(-7.797304, 110.409993);
        mMap.addMarker(new MarkerOptions().position(harjolukito).title("RS. AU dr. S. Hardjolukito").snippet("Blok O").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(harjolukito));

        wonocatur = new LatLng(-7.798632, 110.406364);
        mMap.addMarker(new MarkerOptions().position(wonocatur).title("JEC Wonocatur").snippet("Jl Janti").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wonocatur));

        banguntapan = new LatLng(-7.80735, 110.402218);
        mMap.addMarker(new MarkerOptions().position(banguntapan).title("Banguntapan").snippet("Jl Gedong Kuning").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(banguntapan));

        tegalgendu = new LatLng( -7.825867, 110.391407);
        mMap.addMarker(new MarkerOptions().position(tegalgendu).title("Tegal Gendu 1").snippet("Jl Tegal Gendu").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tegalgendu));

        ngabean = new LatLng(-7.803723, 110.356256);
        mMap.addMarker(new MarkerOptions().position(ngabean).title("Terminal Ngabean").snippet("Terminal Ngabean").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ngabean));

        fojanti = new LatLng(-7.786123, 110.410364);
        mMap.addMarker(new MarkerOptions().position(fojanti).title("Janti Selatan").snippet("Janti Flyover").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fojanti));


        Giwanganakhir = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwanganakhir).title("Terminal Giwangan").snippet("Jl Imogiri Timur").snippet("Jl Imogiri Timur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Giwanganakhir));


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://transtracker-96bda.firebaseio.com/Driver/Driver3B");
        final GeoFire geoFire = new GeoFire(databaseReference);
        final DatabaseReference newRef = FirebaseDatabase.getInstance().getReference().child("Driver").child("Driver3B");
        newRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if(mDriverMarker != null){
                        mDriverMarker.remove();
                    }
                    double latitude = ds.child("Location").child("l").child("0").getValue(Double.class);
                    double longitude = ds.child("Location").child("l").child("1").getValue(Double.class);
                    LatLng newLocation = new LatLng(latitude, longitude);
                    mDriverMarker = mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title(dataSnapshot.getKey())
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bu)));
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            ValueEventListener eventListener = new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    newRef.addListenerForSingleValueEvent(eventListener);


                    GeoQuery geoQuery = geoFire.queryAtLocation(new GeoLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 10);
                    geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
                        @Override
                        public void onKeyEntered(String key, GeoLocation location) {

                        }

                        @Override
                        public void onKeyExited(String key) {

                        }

                        @Override
                        public void onKeyMoved(String key, GeoLocation location) {

                        }

                        @Override
                        public void onGeoQueryReady() {

                        }

                        @Override
                        public void onGeoQueryError(DatabaseError error) {

                        }
                    });

                }
            };


        });

    }

}




