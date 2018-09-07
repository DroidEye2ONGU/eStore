import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OtherTest {

    @Test
    public void mapTest() {
        Map<Integer, Integer> map = new HashMap<>();

        Integer integer = map.get(1);

        System.out.println(integer);
    }

}
