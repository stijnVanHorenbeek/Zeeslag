package models;


import models.valueTypes.Coordinates;


public class ActorFactory
{
    public static final int TOWER = 1;
    public static final int SHIP = 2;
    public static final int HELICOPTER = 3;
    public static Actor createActor(int type, Coordinates coordinates)
    {
        switch (type)
        {
            case TOWER:
                return new Tower(coordinates, 0, 0, 0, Randomizer.getRandomDouble(), Randomizer.getRandomInt(), 0 );
            case SHIP:
                return new Ship(coordinates, Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomInt(), Randomizer.getRandomDouble());
            case HELICOPTER:
                return new Helicopter(coordinates, Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomInt(), Randomizer.getRandomDouble());
                default:
                    throw new IllegalArgumentException("Not a known actor");
        }
    }
}
