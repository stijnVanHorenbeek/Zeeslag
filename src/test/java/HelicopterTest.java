import models.Helicopter;
import models.valueTypes.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelicopterTest {
    @Test
    public void helicopter_should_throw_exception_given_a_negative_capacity(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), 0,0,1,-1,0));
    }

    @Test
    public void helicopter_should_throw_exception_given_a_zero_capacity(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), 0,0,1,0,0));
    }
    @Test
    public void helicopter_should_throw_exception_given_negative_speed(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), -1,1,1,1,0));
    }

    @Test
    public void helicopter_should_throw_exception_given_negative_agility(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), 1,-1,1,1,0));
    }

    @Test
    public void helicopter_should_throw_exception_given_negative_size(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), 0,0,-1,1,0));
    }

    @Test
    public void helicopter_should_throw_exception_given_a_zero_size(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), 0,0,0,1,0));
    }

    @Test
    public void helicopter_should_throw_exception_given_negative_vector(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Helicopter(new Coordinates(1,1), 1,0,1,1,-1));
    }
}
