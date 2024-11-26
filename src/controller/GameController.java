package controller;

import model.games.Game;
import model.games.TicTacToe;
import model.games.Gomoku;
import model.games.ConnectFour;
import view.UserInteract;
import view.GameView;

public class GameController {
    private UserInteract menu;
    private GameView gameView;


    public GameController() {
        this.menu = new UserInteract();
        this.gameView = new GameView();
    }

}