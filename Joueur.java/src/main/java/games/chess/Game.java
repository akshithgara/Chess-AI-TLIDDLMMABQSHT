/**
 * The traditional 8x8 chess board with pieces.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.chess;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;

// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add additional import(s) here
// <<-- /Creer-Merge: imports -->>

/**
 * The traditional 8x8 chess board with pieces.
 */
public class Game extends BaseGame {
    /**
     * Forsyth-Edwards Notation (fen), a notation that describes the game board state.
     */
    public String fen;

    /**
     * The list of [known] moves that have occurred in the game, in Universal Chess Inferface (UCI) format. The first element is the first move, with the last element being the most recent.
     */
    public List<String> history;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "cfa5f5c1685087ce2899229c04c26e39f231e897ecc8fe036b44bc22103ef801";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Chess";

        this.history = new ArrayList<String>();
        this.players = new ArrayList<Player>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    
    public void print() {
        char[] FEN = fen.toCharArray();
        char i_file = 'a';
        int i_rank = 8;
        int Wid_Hgh = 8;

        for(int i=0; i<Wid_Hgh+1; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n|  ");
        for(int i=0; i<Wid_Hgh; i++) {
            System.out.print(" | "+String.valueOf((char)(i_file+i)));
        }
        System.out.print(" |\n");
        for(int i=0; i<Wid_Hgh+1; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
        System.out.print("| "+String.valueOf(i_rank));

        int cnt=1;
        for(char c : FEN) {
            if(Character.isLetter(c)) {
                System.out.print(" | "+String.valueOf(c));
            } else if(Character.isDigit(c)) {
                for(char k=c; k>'0'; k--) {
                    System.out.print(" |  ");
                }
            } else if(c=='/') {
                System.out.print(" |\n");
                for(int i=0; i<Wid_Hgh+1; i++) {
                    System.out.print("+---");
                }
                System.out.print("+\n");
                System.out.print("| "+String.valueOf(i_rank-cnt++));
            } else if(c==' ') {
              break;
            }
        }
        System.out.print(" |\n");
        for(int i=0; i<Wid_Hgh+1; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
    }
    
    // <<-- /Creer-Merge: methods -->>
}
