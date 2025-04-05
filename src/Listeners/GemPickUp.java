package Listeners;

import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;
import Bodies.Gems;
import Bodies.Player;

public class GemPickUp implements CollisionListener {

    private Player p;
    private Gems g;


    public GemPickUp(Player p, Gems g){
        this.p = p;
        this.g = g;

    }

    /**
     * method which sees if the gems is being collided with by a player
     * if so then the body will be destroyed and the player gem count will increase
     * @param e
     */
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Gems){
            e.getOtherBody().destroy();
            p.getGemCount();
            p.incrementGemCount();
            //when player collides with gems, those will get destroyed and the gem count will increment by 1
        }

    }
}
