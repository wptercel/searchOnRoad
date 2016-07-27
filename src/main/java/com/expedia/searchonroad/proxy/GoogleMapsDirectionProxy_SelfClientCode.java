package com.expedia.searchonroad.proxy;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GoogleMapsDirectionProxy_SelfClientCode {
	private final String BASE_URL = "https://maps.googleapis.com/maps/api/directions";
	private final String AUTHORIZATION = "AIzaSyAT_D6yyyYMmwttda35cImLQcqF1QGV1s0";

	public void getDirection(String origin, String destination) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(BASE_URL).path("json")
				.queryParam("origin", origin)
				.queryParam("destination", destination)
				.queryParam("key", AUTHORIZATION);

		System.out.println(target.request(MediaType.TEXT_PLAIN_TYPE).get().readEntity(String.class));
	}

	public static void main(String args[]) {
		GoogleMapsDirectionProxy_SelfClientCode test = new GoogleMapsDirectionProxy_SelfClientCode();
		test.getDirection("Montreal", "Toronto");
	}
}
