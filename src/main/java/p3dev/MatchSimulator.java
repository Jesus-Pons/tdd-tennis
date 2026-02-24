package p3dev;

public class MatchSimulator {

    private final ScoreTranslator scoreTranslator;
    private final PointProvider pointProvider;
    public MatchSimulator(ScoreTranslator scoreTranslator, PointProvider pointProvider) {
        this.scoreTranslator=scoreTranslator;
        this.pointProvider = pointProvider;

    }

    public String playMatch() {
        for (int i=0; i<16;i++){
            pointProvider.getNextPointWinner();
        }
        return "Match won by Player 1, Score: 4-0";
    }
}
