package service.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningFactoryName name, int dimension){
       return new OrderOneWinningStrategy(dimension);
    }
}
