package com.example.adhimarino.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity4 extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener, RoutingListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    Double hasil, hasilMin;
    LatLng posisiH;
    Button btnshrt2;
    LatLng CurrentLocation;
    LatLng Giwangan, tegalgendu, Maguwo, Bandara,
            CondongCatur,  ngabean,
            Giwanganakhir, Nitikan, sugiono2, sma7, tejokusuman, khaahmaddahlan, smp14, sudriman3,
            yap, jakal, sarjito, kentungan, jih, amikom, instiper2, binamarga, jayakarta, harjolukito, wonocatur, banguntapan, fojanti ;

    LatLng arrayLokasi[] = new LatLng[30];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps4);
        polylines = new ArrayList<>();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
                btnshrt2 = (Button) findViewById(R.id.btnshrt2);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        CameraPosition cameraPosition = new CameraPosition.Builder().target( new LatLng(-7.796786, 110.4000479)).zoom(25).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        buildGoogleApiClient();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10);
        mLocationRequest.setFastestInterval(50);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
            CurrentLocation = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(CurrentLocation));
        }

        Giwangan = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwangan)
                .title("Terminal Giwangan")
                .snippet("Jl Imogiri Timur")
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

        arrayLokasi = new LatLng[]{Giwangan, tegalgendu, Maguwo, Bandara,
                CondongCatur,  ngabean, Giwanganakhir, Nitikan, sugiono2, sma7, tejokusuman, khaahmaddahlan, smp14, sudriman3,
                yap, jakal, sarjito, kentungan, jih, amikom, instiper2, binamarga, jayakarta, harjolukito, wonocatur, banguntapan, fojanti};

        btnshrt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hasilMin = 9999999999.0;
                for (int i = 0; i < arrayLokasi.length; i++){
                    hasil = CalculationByDistance(CurrentLocation, arrayLokasi[i]);
                    if(hasil < hasilMin){
                        hasilMin = hasil;
                        posisiH = arrayLokasi[i];
                    }
                }

                getRouteToMarker(posisiH);
            }
        });


    }

    private void getRouteToMarker(LatLng posisiH) {

        Routing routing = new Routing.Builder()
                .travelMode(AbstractRouting.TravelMode.WALKING)
                .withListener(this)
                .alternativeRoutes(false)
                .waypoints(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), posisiH    )
                .build();
        routing.execute();
    }



    @Override
    public void onConnectionSuspended(int i) {

    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        CurrentLocation = new LatLng(location.getLatitude(), location.getLongitude());
    }


    private List<Polyline> polylines;
    private static final int[] COLORS = new int[]{R.color.wallet_holo_blue_light};
    @Override
    public void onRoutingFailure(RouteException e) {

        if(e != null) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Ada yang salah ! coba lagi", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {
        if(polylines.size()>0) {
            for (Polyline poly : polylines) {
                poly.remove();
            }
        }
        polylines = new ArrayList<>();
            for (int i = 0; i <route.size(); i++) {
            int colorIndex = i % COLORS.length;
            PolylineOptions polyOptions = new PolylineOptions();
            polyOptions.color(ContextCompat.getColor(this, COLORS[colorIndex]));
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(route.get(i).getPoints());
            Polyline polyline = mMap.addPolyline(polyOptions);
            polylines.add(polyline);

            Toast.makeText(getApplicationContext(),"Jarak "+ route.get(i).getDistanceValue()+"M",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRoutingCancelled() {

    }
}
