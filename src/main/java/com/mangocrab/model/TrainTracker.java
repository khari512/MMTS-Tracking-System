package com.mangocrab.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class TrainTracker implements Serializable {
	
	private String trainName;
	private String currentLocation;
	private int trainNo;
	private double actualTime; 
	private double time;
	private Date createdDate;
	private String trainStatus;
	public static int UNKNOW_DEST_CODE=111;
	public static int TRAIN_NUMBER_NOT_FOUND=222;

    public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public double getActualTime() {
		return actualTime;
	}

	public void setActualTime(double actualTime) {
		this.actualTime = actualTime;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getTrainStatus() {
		return trainStatus;
	}

	public void setTrainStatus(String trainStatus) {
		this.trainStatus = trainStatus;
	}

	@Override
	public String toString() {
		return "TrainTracker [getTrainName()=" + getTrainName()
				+ ", getCurrentLocation()=" + getCurrentLocation()
				+ ", getTrainNo()=" + getTrainNo() + ", getActualTime()="
				+ getActualTime() + ", getTime()=" + getTime()
				+ ", getCreatedDate()=" + getCreatedDate()
				+ ", getTrainStatus()=" + getTrainStatus() + ", getKey()="
				+ getKey() + ", getVersion()=" + getVersion() + ", hashCode()="
				+ hashCode() + "]";
	}

	private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

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
        TrainTracker other = (TrainTracker) obj;
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
