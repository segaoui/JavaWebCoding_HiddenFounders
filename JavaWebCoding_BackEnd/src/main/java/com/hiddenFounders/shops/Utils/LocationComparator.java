package com.hiddenFounders.shops.Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hiddenFounders.shops.entities.Location;
import com.hiddenFounders.shops.entities.Shop;

public class LocationComparator {

	public LocationComparator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double distance(Location location_a, Location location_b) {
		float pk = (float) (180.f / Math.PI);

		float a1 = location_a.getCoordinates().get(0) / pk;
		float a2 = location_a.getCoordinates().get(1) / pk;
		float b1 = location_b.getCoordinates().get(0) / pk;
		float b2 = location_b.getCoordinates().get(1) / pk;

		double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
		double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
		double t3 = Math.sin(a1) * Math.sin(b1);
		double tt = Math.acos(t1 + t2 + t3);

		return 6366000 * tt;
	}

	public List<Shop> sortLocations(List<Shop> shops, Location myLocation) {
		Comparator<Shop> comp = new Comparator<Shop>() {
			@Override
			public int compare(Shop o, Shop o2) {

				Double distance1 = distance(myLocation, o.getlocation());

				Double distance2 = distance(myLocation, o2.getlocation());

				return distance1.compareTo(distance2);
			}
		};

		Collections.sort(shops, comp);
		return shops;
	}
}
