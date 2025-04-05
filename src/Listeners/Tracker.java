package Listeners;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.GameView;
import Bodies.Player;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Player player;
    public Tracker(GameView view, Player player) {
        this.view = view;
        this.player = player;
    }
    public void preStep(StepEvent e) {}

    /**
     * method that allows the view to always follow the player
     * @param e
     */
    public void postStep(StepEvent e) {

        view.setCentre(new Vec2(player.getPosition()));
        // after every step in the game, the camera will adjust the position to the centre of the player
        // thus allowing the camera to follow the player
    }
}
