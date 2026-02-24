package p3dev;

public class ScoreTranslator {

    private final String[] scoreNames = {"love","fifteen","thirty","forty"};

    public String translate(int scorePlayerOne, int scorePlayerTwo){
        return scoreNames[scorePlayerOne] + "-" + scoreNames[scorePlayerTwo];
    }
}
