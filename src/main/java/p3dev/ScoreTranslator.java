package p3dev;

public class ScoreTranslator {

    public String translate(int scorePlayerOne, int scorePlayerTwo){
        if (scorePlayerOne == 1 && scorePlayerTwo == 0) return "fifteen-love";
        else if(scorePlayerOne ==2 && scorePlayerTwo == 0) return "thirty-love";
        return "love-love";
    }
}
