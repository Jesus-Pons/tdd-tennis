package p3dev;

public class ScoreTranslator {

    public String translate(int scorePlayerOne, int scorePlayerTwo){
        if (scorePlayerOne == 1 && scorePlayerTwo == 0) return "fifteen-love";
        return "love-love";
    }
}
