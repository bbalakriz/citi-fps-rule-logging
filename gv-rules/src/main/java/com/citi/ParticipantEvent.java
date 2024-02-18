package com.citi;

public class ParticipantEvent {
    private String id;
    private String location;
    private long registeredTime;

    public long getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(long registeredTime) {
        this.registeredTime = registeredTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ParticipantEvent [id=" + id + ", location=" + location + ", registeredTime=" + registeredTime + "]";
    }

    
}
