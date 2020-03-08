package patterns.behavior.memento;

public class Test {
    public static void main(String[] args) {
        GameState gameState = new GameState(1,"level 1");
        System.out.println(gameState);
        GameStateMemento gameStateMemento = gameState.saveGame();
        System.out.println(gameState);
        gameState.changeGameState(2,"level 2");
        System.out.println(gameState);
        gameState.restore(gameStateMemento);
        System.out.println(gameState);
    }
}
