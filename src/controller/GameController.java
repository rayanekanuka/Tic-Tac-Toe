package controller;

import model.games.Game;
import view.GameView;

public abstract class GameController {
    protected Game game;
    protected GameView gameView;

    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

}
