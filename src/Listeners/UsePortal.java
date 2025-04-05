package Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import Levels.GameLevel;
import Bodies.Player;
import Bodies.Portal;

public class UsePortal implements CollisionListener {


    GameLevel level;
    Game g;
    private Player player;
    private Portal portal;

    public UsePortal( GameLevel level, Game game, Player player,Portal portal){
        this.player = player;
        this.portal = portal;
        this.level = level;
        g = game;
    }


    /**
     * when a player body collides with the portal
     * it will check if the level completion requirements have been met,
     * if so then the player progresses onto the next level
     * @param e
     */
    public void collide(CollisionEvent e){
        if(e.getOtherBody() instanceof Portal && level.isComplete() && (level.getLvlNumber() == 1 || level.getLvlNumber() == 2)){
            System.out.println("You have finished level " + level.getLvlNumber());
            System.out.println("Moving onto next level...");
            g.goToNextLevel();
            // this checks that if the player wants to go in the portal, all the objectives have been completed
            // if that condition is true the game will end
        }
        else if (e.getOtherBody() instanceof Portal && !level.isComplete()){
            System.out.println("Collect all the gems to finish the level");
            //System.out.println("Gems collected: " + p.getGemCount() + "/ 4");
            // this checks the other side of it and if the conditions have not been met then a message will be printed out
        }
        else if (e.getOtherBody() instanceof Portal && level.isComplete() && level.getLvlNumber() == 3) {
            System.out.println("You finished the game!!");
            System.exit(0);
            //here if the level number is 3 and the player uses the portal, the game will end

        }

    }
}
