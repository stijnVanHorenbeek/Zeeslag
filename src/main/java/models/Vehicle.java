package models;

import models.valueTypes.Coordinates;

import java.util.ArrayList;

public abstract class Vehicle extends Actor implements IObserver {
    private ArrayList<Tower> towers;
    private Tower activeTower;
    private IState state;

    protected Vehicle() { }

    public Vehicle(Coordinates coordinates, double speed, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, agility, size, capacity, vector);
        state = new NormalState(this);
    }

    public void update(Vehicle vehicleInSos) {
        this.state = new RescueState(vehicleInSos, this);
        this.setReactionTime(vehicleInSos);
        act();
    }

    public void act() {
        this.state.act(this);
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
        calculateActiveTower();
        activeTower.registerObserver(this);
    }

    public Tower getActiveTower() {
        return activeTower;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    private void calculateActiveTower() {
        double distance = 0;
        for (Tower tower : towers) {
            if(activeTower == null){
                activeTower = tower;
            } else if (tower.getDistance(this) < activeTower.getDistance(this)){
                activeTower = tower;
            }
        }
    }
}
