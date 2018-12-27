/**
 * Abstract class Actor
 *
 * @author Evy Dehaene
 * @version 27/12/2018
 */
public abstract class Actor
{
    // instance variables -
    private PACKAGE_NAME.Coordinates location;
    //private int counter;

    /*public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }*/

    public Actor(PACKAGE_NAME.Coordinates location) {
        this.location = location;
    }

    public PACKAGE_NAME.Coordinates getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "\n\t " + getClass().getName() + /*" nr. " + getCounter()+ */ " bevindt zich op "
                + getLocation();
    }

}
