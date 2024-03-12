package model;

import service.botPlayingStrategy.BoltPlayingStrategyFactory;

public class Bot extends Player{

    int botDifficultyChoice;
    public Bot(int id, char symbol, int botDifficultyChoice) {
        super(id, "CHITTI", symbol, PlayerType.BOT);
        this.botDifficultyChoice = botDifficultyChoice;
        printBotChoice(botDifficultyChoice);
    }

    public void printBotChoice(int botDifficultyChoice){
        switch (botDifficultyChoice){
            case 1 :
                System.out.println("You Choose to Play with : " + BotDifficultyLevel.NORMAL.name());
                break;
            case 2 :
                System.out.println("You Choose to Play with : " + BotDifficultyLevel.RANDOM.name());
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Normal.");
        }
    }
    @Override
    public Move makeMove(Board board){
        return BoltPlayingStrategyFactory.botPlayingStrategy(botDifficultyChoice).makeMove(board, this);
    }
}
