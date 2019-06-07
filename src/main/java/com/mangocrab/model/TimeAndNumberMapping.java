package com.mangocrab.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class TimeAndNumberMapping implements Serializable {
	
	private double time;
	private int trainNumber;
	private boolean notOnSundayFlag;
	private double expTime;
	private String currentLocation;
	
	public TimeAndNumberMapping(){
		
	}
	public TimeAndNumberMapping(double time, int trainNumber) {
		super();
		this.time = time;
		this.trainNumber = trainNumber;
	}
	
    public double getExpTime() {
		return expTime;
	}
	public void setExpTime(double expTime) {
		this.expTime = expTime;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public boolean isNotOnSundayFlag() {
		return notOnSundayFlag;
	}
	public void setNotOnSundayFlag(boolean notOnSundayFlag) {
		this.notOnSundayFlag = notOnSundayFlag;
	}
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private  Key key;

    @Attribute(version = true)
    private  Long version;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TimeAndNumberMapping other = (TimeAndNumberMapping) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
