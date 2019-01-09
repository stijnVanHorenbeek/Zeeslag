import models.Tower;
import models.valueTypes.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TowerTest {

    @Test
    public void tower_should_throw_exception_given_a_negative_capacity(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 0,0,0,1,-1,0));
    }

    @Test
    public void tower_should_throw_exception_given_a_zero_capacity(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 0,0,0,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_positive_speed(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 1,0,0,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_negative_speed(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), -1,0,0,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_positive_reactionTime(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 0,1,0,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_negative_reactionTime(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 1,-1,0,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_positive_agility(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 0,0,10,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_negative_agility(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 1,0,-1,0,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_negative_size(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 0,0,0,-1,0,0));
    }

    @Test
    public void tower_should_throw_exception_given_positive_vector(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 1,0,0,0,0,1));
    }

    @Test
    public void tower_should_throw_exception_given_negative_vector(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Tower(new Coordinates(1,1), 1,0,0,0,0,-1));
    }
}
