package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId ++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

// TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {

        if(name == null && employer == null && location == null && positionType == null && coreCompetency == null) {
            return "OOPS! This job does not seem to exist";
        }

        String displayName = name;
        String displayEmployer = employer.getValue();
        String displayLocation = location.getValue();
        String displayPositionType= positionType.getValue();
        String displayCoreCompetancy = coreCompetency.getValue();

// Task 5 - 3
        if(name.isEmpty()){
            displayName = "Data not available";
        }if(employer.getValue().isEmpty()) {
            displayEmployer = "Data not available";
        }if(location.getValue().isEmpty()) {
            displayLocation = "Data not available";
        }if(positionType.getValue().isEmpty()) {
            displayPositionType = "Data not available";
        }if(coreCompetency.getValue().isEmpty()) {
            displayCoreCompetancy = "Data not available";
        }

// Task 5 - 1 & 2
        return System.lineSeparator() +
                "ID: " + id +  System.lineSeparator()+
                "Name: " + displayName  + System.lineSeparator()+
                "Employer: " + displayEmployer + System.lineSeparator()+
                "Location: " + displayLocation + System.lineSeparator()+
                "Position Type: " + displayPositionType + System.lineSeparator()+
                "Core Competency: " + displayCoreCompetancy +
                System.lineSeparator();
    }
}