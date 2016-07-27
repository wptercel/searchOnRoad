/**
 * Base class of Google Maps Api proxies
 */
package com.expedia.searchonroad.proxy;

import com.google.maps.GeoApiContext;

/**
 * @author Peng Wu
 * 07/21/2016
 */
public abstract class GoogleMapsProxyBase {
	private final String apiKey = "AIzaSyAT_D6yyyYMmwttda35cImLQcqF1QGV1s0";
	
	protected GeoApiContext googleMapsApiContext;
	
	protected GoogleMapsProxyBase(){
		googleMapsApiContext = new GeoApiContext().setApiKey(apiKey);
	}
}
