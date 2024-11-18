import java.util.Scanner;

public class Player {
    private String name;
    private char symbole;
    
    public Player(String name, char symbole) {
        this.name = name;
        this.symbole = symbole;
    }

    /*-- GETTERS AND SETTERS --*/
    
    public String getName() {
        return name;
    }

    public char getSymbole() {
        return symbole;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    
    public char setSymbole(char symbole) {
        this.symbole = symbole;
        return symbole;
    }
    
}
