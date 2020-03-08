package patterns.behavior.memento;

public class GameStateMemento {
    private int id;
    private String gameState;

    public GameStateMemento(int id, String gameState) {
        this.id = id;
        this.gameState = gameState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }
}
