package model;

public class BotDifficultLevelChooser {
    public static BotDifficultyLevel chooseBotDifficultyLevel(int botDifficultyChoice) {
        switch (botDifficultyChoice) {
            case 2:
                return BotDifficultyLevel.RANDOM;
            case 1:
            default:
                return BotDifficultyLevel.NORMAL;
        }
    }
}
