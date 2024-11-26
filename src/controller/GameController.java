package controller;

import model.games.*;
import model.player.*;
import view.UserInteract;
import view.GameView;

public class GameController {
    private Game game;
    private UserInteract menu;
    private GameView gameView;


    public GameController() {
        this.menu = new UserInteract();
        this.gameView = new GameView();
    }

}