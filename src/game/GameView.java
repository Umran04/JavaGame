package game;

import Bodies.Player;
import Levels.GameLevel;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView { //extending one of the physics engine class called UserView


    public static final Font STATUS_FONT = new Font("Monospaced", Font.BOLD, 20); // setting the font to be used in the foreground text
    private int gemsCollected;
    private int lives;
    private int time;
    private  Image background;
    private GameLevel currentLevel;
    private Player player;

    //adding the fields


    /**
     * creating the gameView, essentially the camera that shows what is happening in the game
     * @param currentLevel
     * @param image
     * @param player
     */
    public GameView(GameLevel currentLevel,Image image,Player player) {
        super(currentLevel, 720, 360);
        this.currentLevel = currentLevel;
        this.player = player;

        background = new ImageIcon("data/Images/woods.jpg").getImage();

        //setting the size of the window
    }

    /**
     * this method takes the given background from the game class and
     * adds it to the current level based on the level number given
     * @param g
     */
    protected void paintBackground(Graphics2D g){
        if(currentLevel.getLvlNumber() == 1) {
            g.drawImage(background, 0, 0, this); //using the paint background method to insert the image to fit the window
        } else if (currentLevel.getLvlNumber() == 2) {
            g.drawImage(background,0,0,this);
        }else if(currentLevel.getLvlNumber() == 3){
            g.drawImage(background,0,0,this);
        }
    }

    /**
     * the method that sets the background
     * @param background
     */
   public void setBackground(Image background) {
        this.background = background;
    }

    /**
     * this method adds string text to the foreground such as how many gems the player currently has or how many lives remaining
     * or the current time
     * @param g
     */
    protected void paintForeground(Graphics2D g){
        gemsCollected = currentLevel.getGemsCollected();
        lives = currentLevel.getLivesRemaining();
        time = currentLevel.getTimer();
        g.setColor(Color.RED);
        g.setFont(STATUS_FONT);
        g.drawString("Gem count: " + gemsCollected + "/4", 50,50);
        g.drawString("Lives: " + lives,50,20);
        g.drawString("Collect all the gems to win",50,80);
        g.drawString("Timer: " + time,50,110);

    }

    /**
     *
     * @param player
     */
    public void setPlayer(Player player){
        this.player = player;
    }


}
