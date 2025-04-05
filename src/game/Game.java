package game;

import Bodies.Enemy;
import Bodies.Gems;
import Bodies.Player;
import Levels.GameLevel;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Listeners.GiveFocus;
import Listeners.Tracker;
import city.cs.engine.*;

import javax.swing.*;


import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Game {

    private Player player;
    private SoundClip gameMusic;
    GameLevel currentLevel;
    Control control;
    GameView view;
    private Image backgroundLevel1;
    private Image backgroundLevel2;
    private Image backgroundLevel3;


    /**
     * main class to set up the actual game
     */
    public Game() {

        //setting up the background images
        backgroundLevel2 = new ImageIcon("data/Images/cave.jpg").getImage();
        backgroundLevel3 = new ImageIcon("data/Images/woods2.jpg").getImage();

        currentLevel = new Level1(this,player); // setting up level 1 as the current level
        view = new GameView(currentLevel,backgroundLevel1,player); // adding the view to the world
        control = new Control(currentLevel.getPlayer()); // adding the keyboard control to the player

        //adding background music
        try {
            gameMusic = new SoundClip("data/Sounds/backgroundSound.wav");   // Open an audio input stream
            gameMusic.loop(); // Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            //System.out.println(e);
        }

        view.addKeyListener(control);//giving the control to view
        view.addMouseListener(new GiveFocus(view));//mouse is in view, allow the player to be controlled
        final JFrame f = new JFrame("Gem collector"); // creating JFrame window

        f.add(view); // adding the view to the JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);

        //DebugViewer d = new DebugViewer(world,720,360);
        System.out.println("Lives remaining: 5");

        //centralising the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = f.getSize();
        Point frameLocation = new Point(dim.width / 2 - windowSize.width / 2,
                dim.height / 2 - windowSize.height / 2);
        f.setLocation(frameLocation);


        currentLevel.addStepListener(new Tracker(view,currentLevel.getPlayer()));
        // adds the tracker step listener which allows the camera to follow the player


        currentLevel.start();
        // starts the simulation
    }

    /**
     * method which changes the level of the game
     */
    public void goToNextLevel(){

        if (currentLevel instanceof Level1) {

            currentLevel.stop();//stops current level

            Player prevPlayer = currentLevel.getPlayer();

            currentLevel = new Level2(this,player);//sets up level 2

            currentLevel.addStepListener(new Tracker(view,currentLevel.getPlayer()));//adds the tracker for the player into the new level

            Player newPlayer = currentLevel.getPlayer();// adds the player to level 2

            view.setWorld(currentLevel);// setting view into level 2

            view.setPlayer(player);

            view.setBackground(backgroundLevel2);// changing the background of level 2

            control.updatePlayer(currentLevel.getPlayer());// updating the control to new level

            currentLevel.start();//starts new level
        }
        else if (currentLevel instanceof  Level2){
            currentLevel.stop();

            Player prevPlayer = currentLevel.getPlayer();

            currentLevel = new Level3(this,player);

            currentLevel.addStepListener(new Tracker(view,currentLevel.getPlayer()));

            Player newPlayer = currentLevel.getPlayer();

            view.setWorld(currentLevel);

            view.setPlayer(player);

            view.setBackground(backgroundLevel3);

            control.updatePlayer(currentLevel.getPlayer());

            currentLevel.start();

        } else if (currentLevel  instanceof Level3) {

        }

    }

    /**
     * main class
     * @param args
     */
    public static void main(String [] args){
        new Game(); // runs the constructed code in the main method to start it

        }


    public Player getPlayer(){return player; }



}

