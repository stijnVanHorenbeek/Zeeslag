import models.ActorFactory;
import models.valueTypes.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorFactoryTest {
    @Test
    public void should_throw_exception_trying_to_create_an_unknown_actor(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> ActorFactory.createActor(4,new Coordinates(1,1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ActorFactory.createActor(0,new Coordinates(1,1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ActorFactory.createActor(-1,new Coordinates(1,1)));
    }
}
