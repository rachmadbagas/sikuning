package io.jagoketik.sikuning;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Iterator;
import java.util.List;

import io.jagoketik.sikuning.adapter.destinasiAdapter;
import io.jagoketik.sikuning.adapter.nomorAdapter;
import io.jagoketik.sikuning.api.RetrofitClient;
import io.jagoketik.sikuning.fragment.angkot_sekitar;
import io.jagoketik.sikuning.model.mobil_angkot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class order_alternate extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_alternate);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.order_panel,new angkot_sekitar())
                .commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        buildGoogleApiClient();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-8.2932184, 113.4424043)));
        mMap.setMyLocationEnabled(true);
        mMap.setPadding(10, 60, 10, 0);
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        Call<List<mobil_angkot>> call = RetrofitClient.getInstance().getApi().getangkot(latitude + "", longitude + "");
        call.enqueue(new Callback<List<mobil_angkot>>() {
            @Override
            public void onResponse(Call<List<mobil_angkot>> call, Response<List<mobil_angkot>> response) {
                Iterator<mobil_angkot> it = response.body().iterator();
                while (it.hasNext()) {
                    double a = -8.1771862;
                    double b = 113.7186184;
                    mobil_angkot item = it.next();
                    a = (double) item.getAngkot_lat() * 1;
                    b = (double) item.getAngkot_long() * 1;
//                    Toast.makeText(getBaseContext(), a + " - " + b , Toast.LENGTH_LONG).show();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(a, b)).title(item.getKode() + item.getAngkot_nomor() + " " + item.getAngkot_plat_nomor()));
                }
            }

            @Override
            public void onFailure(Call<List<mobil_angkot>> call, Throwable t) {

            }
        });
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
        mLocationRequest.setInterval(500);
        mLocationRequest.setFastestInterval(500);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//        Toast.makeText(this.getBaseContext(), location.getLatitude() +" , "+ location.getLongitude(), Toast.LENGTH_SHORT).show();

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));


    }

//    private void findNearByPlaces(){
//        double currentLat = mLastLocation.getLatitude();
//        double currentLng = mLastLocation.getLongitude();

//        List<LocationModel> nearByLocationList = new ArrayList<LocationModel>();
//        for(int i =0 ; i< GetLocation.size(); i++ ){
//            if(isInRange(currentLat,currentLng,GetLocation.getlat(),
//                    GetLocation.getLong())){
//                nearByLocationList.add(GetLocation.get(i));
//            }
//        }
//
//        showDataOnMap(nearByLocationList);
//    }

//    private boolean isInRange(long currentLat, long currentlongi,long databaseLat, long databaselongi)
//    {
//        Location loc1 = new Location(currentLat,currentlongi); loc1.setLatitude(lat1);
//        loc1.setLongitude(lon1);
//        Location loc2 = new Location(databaseLat, databaselongi); loc2.setLatitude(lat2);
//        loc2.setLongitude(lon2);
//        float distanceInMeters = loc1.distanceTo(loc2);
//        if(distanceInMeters <= 50)// your given range
//            return true;
//        else
//            return false;
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

