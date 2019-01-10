package models;


import models.valueTypes.Coordinates;

/**
 * factory to create Actors
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

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
                return new Tower(coordinates, 0, 0, 1, Randomizer.getRandomInt(), 0 );
            case SHIP:
                return new Ship(coordinates, Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomDoubleBetweenBounds(100,1), Randomizer.getRandomInt(), Randomizer.getRandomDouble());
            case HELICOPTER:
                return new Helicopter(coordinates, Randomizer.getRandomDouble(), Randomizer.getRandomDouble(), Randomizer.getRandomDoubleBetweenBounds(100,1), Randomizer.getRandomIntBetweenBounds(250,1), Randomizer.getRandomDouble());
                default:
                    throw new IllegalArgumentException("Not a known actor");
        }
    }
}
