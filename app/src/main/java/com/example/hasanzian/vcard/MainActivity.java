package com.example.hasanzian.vcard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListDataModel> list = new ArrayList<>();
        list.add(new ListDataModel(getString(R.string.udacity), getString(R.string.company), R.drawable.ic_domain_grey600_48dp));
        list.add(new ListDataModel(getString(R.string.address_udacity), getString(R.string.location_udacity), R.drawable.ic_google_maps_grey600_48dp));
        list.add(new ListDataModel(getString(R.string.number_udacity), getString(R.string.phone_udacity), R.drawable.ic_phone_grey600_48dp));
        list.add(new ListDataModel(getString(R.string.website_udacity), getString(R.string.website_udacity_title), R.drawable.ic_earth_grey600_48dp));
        ListView listView = findViewById(R.id.list);
        Adaptor mAdapter = new Adaptor(this, list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if (position == 1) {
                    String str_location = "2465 Latham St Mountain View, CA 94043";
                    String map = "http://maps.google.co.in/maps?q=" + str_location;
                    // where str_location is the address string
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                    startActivity(i);
                }
                if (position == 2) {
                    if (isPermissionGranted()) {
                        call_action();
                    }

                }
                if (position == 3){

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.udacity.com"));
                    startActivity(browserIntent);
                }

            }
        });

    }

    private void call_action() {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:650-555-5555"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"Permission is required to call",Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(callIntent);
    }

    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
