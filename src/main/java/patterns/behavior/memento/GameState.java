package patterns.behavior.memento;

public class GameState {
    private int id;
    private String gameState;

    public GameState(int id, String gameState) {
        this.id = id;
        this.gameState = gameState;
    }

    public GameStateMemento saveGame(){
        return new GameStateMemento(id,gameState);
    }

    public void restore(GameStateMemento memento){
        this.id  = memento.getId();
        this.gameState = memento.getGameState();
    }

    public void changeGameState(int id , String gameState){
        this.id = id;
        this.gameState = gameState;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "id=" + id +
                ", gameState='" + gameState + '\'' +
                '}';
    }
}
