package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.FruitsConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitsTest {

    @Test
    public void testArray(){
        System.setProperty("array", "apple,banana,orange");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());

        assertThat (config.getFruitsArray())
                .containsExactly("apple", "banana", "orange");
    }

    @Test
    public void testList(){
        System.setProperty("list", "apple,banana,orange");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());

        assertThat (config.getFruitsList())
                .containsExactly("apple", "banana", "orange");
    }

    @Test
    public void testDefault(){
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());
        assertThat (config.getFruitsDefault())
                .containsExactly("apple", "banana");
    }

    @Test
    public void testSeparator(){
        System.setProperty("separator", "apple;banana");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());
        assertThat (config.getFruitsSeparator())
                .containsExactly("apple", "banana");
    }

}
