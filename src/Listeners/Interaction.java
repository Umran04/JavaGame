package Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Bodies.Enemy;
import Levels.GameLevel;
import Bodies.Player;
import Bodies.Traps;

public class Interaction implements CollisionListener {
    //this class implements an interface which provides certain functionalities
    private Player p;
    public Interaction(GameLevel level, Player p){
        this.p = p;
    }

    /**
     * when a player collides with an enemy body,
     * wether that is a trap or an enemy, the players life will decrease by 1
     * @param e
     */
    public void collide(CollisionEvent e){
        if(e.getOtherBody() instanceof Enemy){
            p.getLives();
            p.decreaseLives();
            p.playSound();
            }
        if(e.getOtherBody() instanceof Traps){
            p.getLives();
            p.decreaseLives();
            p.playSound();
        }

            //when the player collides with enemy bodies it will reduce a life

            }

    }



