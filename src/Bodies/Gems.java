package Bodies;

import Bodies.Player;
import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Gems extends StaticBody {
    BodyImage gemImage;
    private static SoundClip gemSound;
    private static final PolygonShape gemShape = new PolygonShape(0.435f,0.591f,
            0.792f,0.171f, 0.018f,-0.669f, -0.75f,0.159f, -0.483f,0.615f, 0.387f,0.621f);

    //adding sound to gem if picked up
    static {
        try {
            gemSound = new SoundClip("data/Sounds/gemCollect.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * setting up the gem object with a GIF
     * @param world
     */
    public Gems(World world){

        super(world,gemShape);
        gemImage = new BodyImage("data/GIF/greenGem.gif", 1.5f);
        this.addImage(gemImage);


    }

    /**
     * override the destroy method so when gem gets picked up it play the sound attached to it
     */
    @Override
    public void destroy()
    {
        gemSound.play();
        super.destroy();
    }




}
