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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location mLastLocation;
    GeoFire geoFire;
    private LatLng LokasiDriver;
    Marker mDriverMarker;




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
        mMap.animateCamera(CameraUpdateFactory.zoomTo(mMap.getCameraPosition().zoom - 15.5f));
        mMap.getUiSettings().setZoomControlsEnabled(true);



        LatLng Giwangan = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwangan).title("Terminal Giwangan").snippet("Jl Imogiri Timur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Giwangan));

        LatLng tegalgendu = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(tegalgendu).title("Tegal Gendu 1").snippet("Jl Tegal Gendu").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tegalgendu));

        LatLng JEC = new LatLng(-7.798488, 110.402895);
        mMap.addMarker(new MarkerOptions().position(JEC).title("JEC").snippet("Jl Janti").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(JEC));

        LatLng SoloJanti = new LatLng(-7.783155, 110.411644);
        mMap.addMarker(new MarkerOptions().position(SoloJanti).title("Janti Utara").snippet("Jl Solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SoloJanti));

        LatLng Transmart = new LatLng(-7.783204, 110.420169);
        mMap.addMarker(new MarkerOptions().position(Transmart).title("Transmart").snippet("Jl Solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Transmart));

        LatLng Maguwo = new LatLng(-7.783326, 110.4303992);
        mMap.addMarker(new MarkerOptions().position(Maguwo).title("Maguwo").snippet("JL solo").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Maguwo));

        LatLng Bandara = new LatLng(-7.784518, 110.43569);
        mMap.addMarker(new MarkerOptions().position(Bandara).title("Bandara").snippet("Bandara ADISUCIPTO").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bandara));

        LatLng Disnaker = new LatLng(-7.769320, 110.431056);
        mMap.addMarker(new MarkerOptions().position(Disnaker).title("Disnaker").snippet("JL Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Disnaker));

        LatLng Instiper = new LatLng(-7.764492, 110.423604);
        mMap.addMarker(new MarkerOptions().position(Instiper).title("Instiper").snippet("JL Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Instiper));

        LatLng UPN = new LatLng(-7.760525, 110.407873);
        mMap.addMarker(new MarkerOptions().position(UPN).title("UPN").snippet("JL. Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UPN));

        LatLng Hartono = new LatLng(-7.758263, 110.399459);
        mMap.addMarker(new MarkerOptions().position(Hartono).title("Hartono Mall").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Hartono));

        LatLng CondongCatur = new LatLng(-7.756636, 110.395825);
        mMap.addMarker(new MarkerOptions().position(CondongCatur).title("Terminal Condong Catur").snippet("Terminal Condong Catur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CondongCatur));

        LatLng Manggung = new LatLng(-7.758188, 110.386465);
        mMap.addMarker(new MarkerOptions().position(Manggung).title("Manggung").snippet("Jl Ringroad Utara").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Manggung));

        LatLng Sardjito = new LatLng(-7.768367, 110.374060);
        mMap.addMarker(new MarkerOptions().position(Sardjito).title("RS Sardjito").snippet("RS Sardjito").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sardjito));

        LatLng Kopma = new LatLng(-7.774309, 110.375108);
        mMap.addMarker(new MarkerOptions().position(Kopma).title("Kopma UGM").snippet("Jl Kaliurang").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kopma));

        LatLng Cik = new LatLng(-7.782318, 110.375077);
        mMap.addMarker(new MarkerOptions().position(Cik).title("Cik Ditiro").snippet("JL Cik Ditiro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Cik));

        LatLng smp = new LatLng(-7.78729, 110.375275);
        mMap.addMarker(new MarkerOptions().position(smp).title("SMPN 5").snippet("SMPN 5 ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(smp));

        LatLng sudirman = new LatLng(-7.782978, 110.369537);
        mMap.addMarker(new MarkerOptions().position(sudirman).title("BUMIPUTERA").snippet("Jl Sudirman").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sudirman));

        LatLng diponegoro = new LatLng(-7.782860, 110.362559);
        mMap.addMarker(new MarkerOptions().position(diponegoro).title("Diponegoro").snippet("Jl Diponegoro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(diponegoro));

        LatLng samsat = new LatLng(-7.787129, 110.359738);
        mMap.addMarker(new MarkerOptions().position(samsat).title("Samsat").snippet("Jl Tentara Pelajar").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(samsat));

        LatLng jlagran = new LatLng(-7.789509, 110.360186);
        mMap.addMarker(new MarkerOptions().position(jlagran).title("Stasiun Tugu").snippet("Jl Aggran").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jlagran));

        LatLng malbor1 = new LatLng(-7.790666, 110.366059);
        mMap.addMarker(new MarkerOptions().position(malbor1).title("Malioboro 1").snippet("Jl Malioboro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malbor1));

        LatLng malbor2 = new LatLng(-7.795185, 110.365534);
        mMap.addMarker(new MarkerOptions().position(malbor2).title("Malioboro 2").snippet("Jl Malioboro").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malbor2));

        LatLng benteng = new LatLng(-7.799874, 110.365035);
        mMap.addMarker(new MarkerOptions().position(benteng).title("(BENTENG VREDENBURG").snippet("Jl Ahmad Yani").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(benteng));

        LatLng pku = new LatLng(-7.801243, 110.359725);
        mMap.addMarker(new MarkerOptions().position(pku).title("KH AHMAD DAHLAN").snippet("jL KH AHMAD DAHLAN").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pku));

        LatLng ngabean = new LatLng(-7.803723, 110.356256);
        mMap.addMarker(new MarkerOptions().position(ngabean).title("Terminal Ngabean").snippet("Terminal Ngabean").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ngabean));

        LatLng jokteng = new LatLng(-7.813219, 110.357347);
        mMap.addMarker(new MarkerOptions().position(jokteng).title("Jokteng (Pugeran)").snippet("Jl MT Haryono").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jokteng));

        LatLng sugiyono = new LatLng(-7.814801, 110.370073);
        mMap.addMarker(new MarkerOptions().position(sugiyono).title("SD Pujokusuman").snippet("Jl Kolonel Sugiyono").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sugiyono));

        LatLng wirosaban = new LatLng(-7.824808, 110.379172);
        mMap.addMarker(new MarkerOptions().position(wirosaban).title("Wirosaban").snippet("Jl Sorogenen").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wirosaban));

        LatLng Giwanganakhir = new LatLng(-7.834420, 110.391708);
        mMap.addMarker(new MarkerOptions().position(Giwanganakhir).title("Terminal Giwangan").snippet("Jl Imogiri Timur").snippet("Jl Imogiri Timur").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelterr)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Giwanganakhir));


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://transtracker-96bda.firebaseio.com/Driver/Driver3A");
        final GeoFire geoFire = new GeoFire(databaseReference);
        final DatabaseReference newRef = FirebaseDatabase.getInstance().getReference().child("Driver").child("Driver3A");
          newRef.addValueEventListener(new ValueEventListener() {
            @Override
           public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                   /*if(mDriverMarker != null){
                        mDriverMarker.remove();
                    }
                    */
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




