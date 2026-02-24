package p3dev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomPointProviderTest {

    @Test
    void should_always_return_one_or_two() {
        RandomPointProvider provider = new RandomPointProvider();

        for (int i = 0; i < 1000; i++) {
            int result = provider.getNextPointWinner();

            assertTrue(result == 1 || result == 2,
                    "El proveedor devolvió un valor inválido: " + result);
        }
    }
}