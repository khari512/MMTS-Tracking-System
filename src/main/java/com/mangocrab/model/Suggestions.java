package com.mangocrab.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Suggestions implements Serializable {

	private String name;
	private String subject;
	private String suggestionString;
	private String catageory;
	private Date createdDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSuggestionString() {
		return suggestionString;
	}

	public void setSuggestionString(String suggestionString) {
		this.suggestionString = suggestionString;
	}

	public String getCatageory() {
		return catageory;
	}

	public void setCatageory(String catageory) {
		this.catageory = catageory;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
        Suggestions other = (Suggestions) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
    
    
    @Override
	public String toString() {
		return "Suggestions [name=" + name + ", subject=" + subject
				+ ", suggestionString=" + suggestionString + ", catageory="
				+ catageory + ", createdDate=" + createdDate + ", getName()="
				+ getName() + ", getSubject()=" + getSubject()
				+ ", getSuggestionString()=" + getSuggestionString()
				+ ", getCatageory()=" + getCatageory() + ", getCreatedDate()="
				+ getCreatedDate() + "]";
	}
}
