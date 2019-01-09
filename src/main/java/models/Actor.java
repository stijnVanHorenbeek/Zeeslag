package models;

import models.valueTypes.Coordinates;

public abstract class Actor {
    private Coordinates coordinates;
    private double speed;
    private double reactionTime;
    private double agility;
    private double size;
    private int capacity;
    private double vector;

    protected Actor() { }

    public Actor(Coordinates coordinates, double speed, double agility, double size, int capacity, double vector) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity can't be zero or negative");
        if (speed < 0) throw new IllegalArgumentException("speed can't be negative");
        if (agility < 0) throw new IllegalArgumentException("agility can't be negative");
        if (size < 0) throw new IllegalArgumentException("size can't be negative");

        this.coordinates = coordinates;
        this.speed = speed;
        this.agility = agility;
        this.size = size;
        this.capacity = capacity;
        this.vector = vector;
    }

    public Coordinates getCoordinates() { return this.coordinates;}

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(Actor actor) {
        this.reactionTime = (getDistance(actor) / speed) * agility;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getVector() {
        return vector;
    }

    public void setVector(double vector) {
        this.vector = vector;
    }

    public double getDistance(Actor actor) {
        return calculateDistance(actor.getCoordinates());
    }
    private double calculateDistance(Coordinates destination) {
        double theta = this.coordinates.getLongitude() - destination.getLongitude();
        double distance =
                Math.sin(degreesToRadians(this.coordinates.getLatitude())) * Math.sin(degreesToRadians(destination.getLatitude())) +
                Math.cos(degreesToRadians(this.coordinates.getLatitude())) * Math.cos(degreesToRadians(destination.getLatitude())) * Math.cos(degreesToRadians(theta));

        distance = Math.acos(distance);
        distance = radiansToDegrees(distance);
        distance = distance * 60 * 1.1515;
        return distance * 0.8684;
    }

    private double degreesToRadians(double degrees) {
        return (degrees * Math.PI / 180.0);
    }
    private double radiansToDegrees(double radians) {
        return (radians * 180.0 / Math.PI);
    }
}
