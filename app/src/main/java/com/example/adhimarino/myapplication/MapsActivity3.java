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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener, RoutingListener {

    private GoogleMap mMap;
    TextView textHasil;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    Double hasil, hasilMin;
    LatLng posisiH;
    Button btnshrt;
    LatLng CurrentLocation;
    LatLng Giwangan, tegalgendu, JEC, SoloJanti, Transmart, Maguwo, Bandara, Disnaker, Instiper,
            UPN, Hartono, CondongCatur, Manggung, Sardjito, Kopma, Cik, smp, sudirman, diponegoro,
            samsat, jlagran, malbor1, malbor2, benteng, pku, ngabean, jokteng, sugiyono, wirosaban,
            Giwanganakhir;

    LatLng arrayLokasi[] = new LatLng[30];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);
        polylines = new ArrayList<>();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        textHasil =  (TextView) findViewById(R.id.textHasil);
        btnshrt = (Button) findViewById(R.id.btnshrt);
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


        CurrentLocation = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CurrentLocation));

        Giwangan = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwangan).title("Terminal Giwangan").snippet("Jl Imogiri Timur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Giwangan));

        tegalgendu = new LatLng(-7.826051, 110.391738);
        mMap.addMarker(new MarkerOptions().position(tegalgendu).title("Tegal Gendu 1").snippet("Jl Tegal Gendu").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tegalgendu));

        JEC = new LatLng(-7.798488, 110.402895);
        mMap.addMarker(new MarkerOptions().position(JEC).title("JEC").snippet("Jl Janti").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(JEC));

        SoloJanti = new LatLng(-7.783155, 110.411644);
        mMap.addMarker(new MarkerOptions().position(SoloJanti).title("Janti Utara").snippet("Jl Solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SoloJanti));

        Transmart  = new LatLng(-7.783204, 110.420169);
        mMap.addMarker(new MarkerOptions().position(Transmart).title("Transmart").snippet("Jl Solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Transmart));

        Maguwo = new LatLng(-7.783326, 110.4303992);
        mMap.addMarker(new MarkerOptions().position(Maguwo).title("Maguwo").snippet("JL solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Maguwo));

        Bandara = new LatLng(-7.784518, 110.43569);
        mMap.addMarker(new MarkerOptions().position(Bandara).title("Bandara").snippet("Bandara ADISUCIPTO").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bandara));

        Disnaker = new LatLng(-7.769320, 110.431056);
        mMap.addMarker(new MarkerOptions().position(Disnaker).title("Disnaker").snippet("JL Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Disnaker));

        Instiper = new LatLng(-7.764492, 110.423604);
        mMap.addMarker(new MarkerOptions().position(Instiper).title("Instiper").snippet("JL Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Instiper));

        UPN = new LatLng(-7.760525, 110.407873);
        mMap.addMarker(new MarkerOptions().position(UPN).title("UPN").snippet("JL. Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UPN));

        Hartono = new LatLng(-7.758263, 110.399459);
        mMap.addMarker(new MarkerOptions().position(Hartono).title("Hartono Mall").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Hartono));

        CondongCatur = new LatLng(-7.756636, 110.395825);
        mMap.addMarker(new MarkerOptions().position(CondongCatur).title("Terminal Condong Catur").snippet("Terminal Condong Catur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CondongCatur));

        Manggung = new LatLng(-7.758188, 110.386465);
        mMap.addMarker(new MarkerOptions().position(Manggung).title("Manggung").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Manggung));

        Sardjito = new LatLng(-7.768367, 110.374060);
        mMap.addMarker(new MarkerOptions().position(Sardjito).title("RS Sardjito").snippet("RS Sardjito").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sardjito));

        Kopma = new LatLng(-7.774309, 110.375108);
        mMap.addMarker(new MarkerOptions().position(Kopma).title("Kopma UGM").snippet("Jl Kaliurang").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kopma));

        Cik = new LatLng(-7.782318, 110.375077);
        mMap.addMarker(new MarkerOptions().position(Cik).title("Cik Ditiro").snippet("JL Cik Ditiro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Cik));

        smp = new LatLng(-7.78729, 110.375275);
        mMap.addMarker(new MarkerOptions().position(smp).title("SMPN 5").snippet("SMPN 5 ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(smp));

        sudirman = new LatLng(-7.782978, 110.369537);
        mMap.addMarker(new MarkerOptions().position(sudirman).title("BUMIPUTERA").snippet("Jl Sudirman").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sudirman));

        diponegoro = new LatLng(-7.782860, 110.362559);
        mMap.addMarker(new MarkerOptions().position(diponegoro).title("Diponegoro").snippet("Jl Diponegoro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(diponegoro));

        samsat = new LatLng(-7.787129, 110.359738);
        mMap.addMarker(new MarkerOptions().position(samsat).title("Samsat").snippet("Jl Tentara Pelajar").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(samsat));

        jlagran = new LatLng(-7.789509, 110.360186);
        mMap.addMarker(new MarkerOptions().position(jlagran).title("Stasiun Tugu").snippet("Jl Aggran").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jlagran));

        malbor1 = new LatLng(-7.790666, 110.366059);
        mMap.addMarker(new MarkerOptions().position(malbor1).title("Malioboro 1").snippet("Jl Malioboro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malbor1));

        malbor2 = new LatLng(-7.795185, 110.365534);
        mMap.addMarker(new MarkerOptions().position(malbor2).title("Malioboro 2").snippet("Jl Malioboro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malbor2));

        benteng = new LatLng(-7.799874, 110.365035);
        mMap.addMarker(new MarkerOptions().position(benteng).title("BENTENG VREDENBURG").snippet("Jl Ahmad Yani").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(benteng));

        pku = new LatLng(-7.801243, 110.359725);
        mMap.addMarker(new MarkerOptions().position(pku).title("KH AHMAD DAHLAN").snippet("jL KH AHMAD DAHLAN").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pku));

        ngabean = new LatLng(-7.803723, 110.356256);
        mMap.addMarker(new MarkerOptions().position(ngabean).title("Terminal Ngabean").snippet("Terminal Ngabean").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ngabean));

        jokteng = new LatLng(-7.813219, 110.357347);
        mMap.addMarker(new MarkerOptions().position(jokteng).title("Jokteng (Pugeran)").snippet("Jl MT Haryono").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jokteng));

        sugiyono = new LatLng(-7.814801, 110.370073);
        mMap.addMarker(new MarkerOptions().position(sugiyono).title("SD Pujokusuman").snippet("Jl Kolonel Sugiyono").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sugiyono));

        wirosaban = new LatLng(-7.824808, 110.379172);
        mMap.addMarker(new MarkerOptions().position(wirosaban).title("Wirosaban").snippet("Jl Sorogenen").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wirosaban));

        Giwanganakhir = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwanganakhir).title("Terminal Giwangan").snippet("Jl Imogiri Timur").snippet("Jl Imogiri Timur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Giwanganakhir));

        arrayLokasi = new LatLng[]{Giwangan, tegalgendu, JEC, SoloJanti, Transmart, Maguwo, Bandara, Disnaker, Instiper,
                UPN, Hartono, CondongCatur, Manggung, Sardjito, Kopma, Cik, smp, sudirman, diponegoro,
                samsat, jlagran, malbor1, malbor2, benteng, pku, ngabean, jokteng, sugiyono, wirosaban,
                Giwanganakhir};

        btnshrt.setOnClickListener(new View.OnClickListener() {
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

                textHasil.setText(hasilMin.toString() + "" + posisiH.toString());
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
        int Radius = 6371;// radius of earth in Km
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

    }


    private List<Polyline> polylines;
    private static final int[] COLORS = new int[]{R.color.wallet_holo_blue_light};
    @Override
    public void onRoutingFailure(RouteException e) {

        if(e != null) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Something went wrong, Try again", Toast.LENGTH_SHORT).show();
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
        //add route(s) to the map.
        for (int i = 0; i <route.size(); i++) {

            //In case of more than 5 alternative routes
            int colorIndex = i % COLORS.length;

            PolylineOptions polyOptions = new PolylineOptions();
            polyOptions.color(getResources().getColor(COLORS[colorIndex]));
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(route.get(i).getPoints());
            Polyline polyline = mMap.addPolyline(polyOptions);
            polylines.add(polyline);

            Toast.makeText(getApplicationContext(),"Jarak "+ route.get(i/1000).getDistanceValue()+"M",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRoutingCancelled() {

    }
}
