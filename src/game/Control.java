package game;

import Bodies.Player;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control extends KeyAdapter {
    private static final float WALK = 9.5f;
    private static final float JUMP = 15f;

    //setting up constant values
    private Player p;

    /**
     *
     * @param p
     */
    public Control(Player p){
        this.p = p;
    }

    /**
     * depending on the key presses, the player will be able to move left and right and jump
     * @param e the event to be processed
     */
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ //if the right arrow key or character 'D' is pressed, the player will move right
            p.startWalking(WALK); //uses the constant walking speed
        }
        else if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {//if the left arrow key or character 'A' is pressed, the player will move left
            p.startWalking(-WALK);// WALK is set to minus so player will move in the opposite direction


        }
        else if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            Vec2 j = p.getLinearVelocity();
            if(Math.abs(j.y)< 1){
                p.jump(JUMP);
                // this calculates if the velocity of the player is less than 1 when the W or up key is pressed
                // if so then the character will jump

            }
        }
    }

    /**
     * depending on the key releases, the player will be able to stop moving left and right
     * @param e the event to be processed
     */
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            p.stopWalking();
            p.setLinearVelocity(new Vec2());
        }
        else if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            p.stopWalking();
            p.setLinearVelocity(new Vec2());
        }
        else if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            p.setGravityScale(1.33f);
        }
    }

    /**
     * method where the player goes from one level to the next and allows the player to be updated to the current level
     * @param newPlayer
     */
    public void updatePlayer(Player newPlayer){
        p = newPlayer;
    }


}
