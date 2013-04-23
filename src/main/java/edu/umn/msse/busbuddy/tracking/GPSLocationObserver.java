package edu.umn.msse.busbuddy.tracking;

import edu.umn.msse.busbuddy.transit.Location;

/**
 * Observer Pattern - Observer interface for GPS location tracking
 *
 */

public abstract class GPSLocationObserver {
	
	protected GPSLocationTracking gpsDevice; /**< Observer Pattern Subject  */
	protected int gpsID;                     /**< GPS Device ID being tracked*/
	protected Location gpsLocation;          /**< Current GPS latitude and longitude from GPS tracker */
	
	/**
	 * Observer Pattern update method to update transit vehicle GPS location
	 * @param gpsID - integer device ID from the GPS unit being tracked
	 * @param latitude - double new latitude from GPS device
	 * @param longitude - double new longitude from GPS device
	 */
	public abstract void gpsUpdate(int gpsID, Location newLocation);

	/**
	 * Return current GPS location received from a vehicle. 
	 * This is the state of the observer pattern.
	 * @return - Location
	 */
	public Location getGPSLocation() {
		return gpsLocation;
	}

	/**
	 * Set the current GPS location of a vehicle (state).
	 * @param gpsLocation - Location latest latitude and longitude of vehicle
	 */
	protected void setGPSLocation(Location gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
}