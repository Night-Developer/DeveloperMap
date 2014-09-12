package com.example.developermap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements InfoWindowAdapter {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager manager = getSupportFragmentManager();
		SupportMapFragment supoortMapFragment = (SupportMapFragment)manager.findFragmentById(R.id.map);
		
		GoogleMap map = supoortMapFragment.getMap();
		
		map.addMarker(new MarkerOptions()
	       .position(new LatLng(0,0))
	       .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
	       .title("Hola")
	       .snippet("Descripcion"));
		
		
		map.addMarker(new MarkerOptions()
	       .position(new LatLng(50,0))
	       .title("Hola 2")
	       .snippet("Descripcion 2"));
		
		
		map.setInfoWindowAdapter(this);
		
	}

	@Override
	public View getInfoContents(Marker arg0) {
		
		return null;
	}

	@Override
	public View getInfoWindow(Marker arg0) {
		
		LayoutInflater inflater = ((LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
		
		View view = inflater.inflate(R.layout.custom_layout, null);
		
		return view;
	}
}
