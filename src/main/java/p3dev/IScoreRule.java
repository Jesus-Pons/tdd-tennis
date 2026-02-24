package p3dev;

public interface IScoreRule {
    boolean applies(int scorePlayerOne,int scorePlayerTwo);
    String getScore(int scorePlayerOne,int scorePlayerTwo);
}
