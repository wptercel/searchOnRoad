package com.expedia.searchonroad.proxy;

import com.google.maps.DirectionsApi;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;

public class GoogleMapsDirectionProxy extends GoogleMapsProxyBase{
	
	private void print() throws Exception{
		DirectionsResult result = DirectionsApi.getDirections(googleMapsApiContext, "21050 Vanowen Street, Canoga Park, CA", "12601 SE 41st Pl, Bellevue, WA").await();
		for(DirectionsRoute route : result.routes){
			for(DirectionsLeg leg : route.legs){
				System.out.println("Route: " + leg.duration.inSeconds);
				int seconds = 0;
				for(DirectionsStep step : leg.steps){
					seconds += step.duration.inSeconds;
					System.out.println(step.duration.inSeconds + "\t" + seconds);
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		GoogleMapsDirectionProxy test = new GoogleMapsDirectionProxy();
		test.print();
	}
}
