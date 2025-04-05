package Bodies;

import city.cs.engine.*;
import city.cs.engine.AttachedImage;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

/**
 * Create a new DynamicBody for player.
 */
public class Player extends Walker {
    //When a class extends another
    // it inherits the methods from that class and new methods specific to this class can also be created
    //That will be the case for majority of these classes
    private int lives;

    private BodyImage playerImage;

    private int gemCount;

    private static SoundClip hurtSound;
    //adding the fields for this class


    private static final PolygonShape characterShape = new PolygonShape(0.9f,1.62f,
            0.9f,-0.35f, 0.38f,-1.82f, -1.03f,-1.88f, -0.98f,-0.12f, -0.89f,1.75f);
    //creating a new polygon shape object to be my player shape

    //adding sound so if player gets hit this sound clip will play
    static {
        try {
            hurtSound = new SoundClip("data/Sounds/hurtSound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Create a new DynamicBody
     *
     * @param world The world that the Player should be added to.
     */
    public Player(World world) { // create the constructor for the class with the parameters being the game world that has been created
        super(world, characterShape);// super is used to call the superclass of this subclass which would be Dynamic body

        playerImage = new BodyImage("data/Images/player.png", 4);
        this.addImage(playerImage);
        this.setGravityScale(1.25f);
        lives = 5 ;
        gemCount = 0;
        //initialising values for the given fields

    }

    public int getLives() {
        return this.lives;
    }
    //lives is a private field, so it can only be accessed through a getter method

    /**
     *take away lives from player when hitting an enemy or obstacle
     */
    public void decreaseLives() {
        lives--; //take away lives from player: lives set to 5 each level
        System.out.println("Lives remaining: " + lives);
        if (lives == 0) {
            this.destroy();
            System.out.println("Game over");
            System.exit(0);
            //this method is used to decrease the lives of the player when they hit an enemy/obstacle
        }

    }


    /**
     * Create a method for allowing the player to move their character
     * @param speed The speed that is already set within the class
     */
   public void startWalking (float speed){
        super.startWalking(speed);
        this.removeAllImages();
        AttachedImage flip = new AttachedImage(this,playerImage,1,0,new Vec2(0,0));
        if(speed < 0) {
            flip.flipHorizontal();
        //this method allows the player image to change depending on which direction you are facing
        }

    }

    /**
     *
     * @return the current gemCount of the player
     */
    public int getGemCount(){return this.gemCount;}
    //gems is also a private field so a getter method is used

    /**
     * increase the gemCount of the player
     */
    public void incrementGemCount(){
        gemCount++;
        System.out.println("GEM COUNT: " + gemCount);
        //this method will be called when player collects the gems and the gem count will be increased
    }

    /**
     * when player interacts with an enemy or an obstacle play this sound
     */
    public void playSound(){
        hurtSound.play();

    }


}
