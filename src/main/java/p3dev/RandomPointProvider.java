package p3dev;

import java.util.Random;

public class RandomPointProvider implements PointProvider {
    private final Random random = new Random();

    @Override
    public int getNextPointWinner() {
        return random.nextBoolean() ? 1 : 2;
    }
}