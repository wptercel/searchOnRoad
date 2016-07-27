package com.expedia.searchonroad.proxy;

import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GoogleMapsGeocodingProxy extends GoogleMapsProxyBase{
	public LatLng getLocations(String address){
		GeocodingResult[] results = null;
		try {
			results = GeocodingApi.geocode(googleMapsApiContext, address).await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(results.length == 0){
			return null;
		}
		else
			return results[0].geometry.location;
	}
}
