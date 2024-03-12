package service.botPlayingStrategy;

import model.BotDifficultLevelChooser;
import model.BotDifficultyLevel;

public class BoltPlayingStrategyFactory {
    public static BotPlayingStrategy botPlayingStrategy(int botDifficultyChoice){
        BotDifficultyLevel botDifficultyLevel = BotDifficultLevelChooser.chooseBotDifficultyLevel(botDifficultyChoice);
        if (botDifficultyLevel == BotDifficultyLevel.RANDOM) {
            return new RandomBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
