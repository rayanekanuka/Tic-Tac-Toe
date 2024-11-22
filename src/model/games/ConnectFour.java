package model.games;

import view.GameView;

public class ConnectFour extends Game {

    public ConnectFour(GameView view) {
        super(view, 7, 6,4);
        this.setDecoration();
    }

    public void setDecoration() {
        this.decoration = "\r\n" + //
                "╔═╗┌─┐┌┐┌┌┐┌┌─┐┌─┐┌┬┐  ╔═╗┌─┐┬ ┬┬─┐\r\n" + //
                "║  │ │││││││├┤ │   │   ╠╣ │ ││ │├┬┘\r\n" + //
                "╚═╝└─┘┘└┘┘└┘└─┘└─┘ ┴   ╚  └─┘└─┘┴└─\r\n" + //
                "";
    }

    public String getDecoration() {
        return this.decoration;
    }

}