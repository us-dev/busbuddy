package edu.umn.msse.busbuddy.transit;

import java.util.Date;
import java.util.Set;

import edu.umn.msse.busbuddy.tracking.TransitVehicle;

/**
 * A point on a {@link Route} in which a {@link TransitVehicle} will stop to pick
 * up and drop off passengers. A Stop also is responsible for providing a set of
 * the times in which the {@link TransitVehicle} will be at the Stop.
 * 
 * A Stop is identified within the context of a single {@link Route}. This
 * means that two {@link Route}s may share the same physical Stop {@link #location},
 * but maintain different schedules.
 */
public class Stop {
	
	/**
	 * The physical location of the Stop.
	 */
	private Location location;
		
	/**
	 * Reports the expected times in which a {@link TransitVehicle} will be
	 * at the given Stop for a given time period.
	 * 
	 * @pre \paramname{begin} < \paramname{end}.
	 *
	 * @param begin The start of the reporting time period. All Stop Times returned
	 * will be on (or after) this time. If null, assume to be the current time.
	 * 
	 * @param end The end of the reporting time period. All Stop Times returned
	 * will before this time.
	 * 
	 * @return Stop Times associated with this Stop that satisfy the begin and end
	 * criteria.
	 */
	public Set<Date> getStopTimes(Date begin, Date end){
		throw new UnsupportedOperationException();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}