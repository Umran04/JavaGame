package Levels;

import Bodies.Gems;
import Bodies.Player;
import Bodies.Portal;
import Listeners.GemPickUp;
import Listeners.Interaction;
import Listeners.UsePortal;
import city.cs.engine.World;
import game.Game;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    private Player player;
    private Portal portal;
    private Game game;
    private int lvlNumber;
    private Gems gems;

    /**
     * setting the base for each level
     * @param game
     */
    public GameLevel(Game game){
        this.game = game;

        //adding the player and the functionalities for it
        player = new Player(this);
        player.setPosition(playerPosition());
        player.addCollisionListener(new GemPickUp(player,gems));
        player.addCollisionListener(new UsePortal(this,game,player,portal));
        player.addCollisionListener(new Interaction(this,player));

        //setting up the portal that should be there for each level
        portal = new Portal(this);
        portal.setPosition(portalPosition());
    }

    public Player getPlayer(){return player;}

    /**
     * setting up the abstract method for each level and its completion requirements
     * @returns gemCount of player if it equals to the amount of gems required to complete the level
     */
    public abstract boolean isComplete();


    public int getLivesRemaining(){
        return player.getLives();
    }

    public int getGemsCollected(){
        return player.getGemCount();
    }

    /**
     * gets each level number
     * @return lvlNumber
     */
    public int getLvlNumber(){return lvlNumber;}

    public abstract Vec2 portalPosition();

    public abstract Vec2 playerPosition();

    public abstract int getTimer();



}
