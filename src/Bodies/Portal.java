package Bodies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Stack;

public class Portal extends StaticBody {
    private static PolygonShape portalShape = new PolygonShape(0.27f,3.78f,
            2.02f,1.36f, 1.79f,-2.5f, 0.02f,-3.86f, -1.94f,-1.71f, -1.57f,3.5f);
    private BodyImage portalImage;
    private  World world;

    /**
     * creating the portal
     * @param world the portal should be added to
     */
    public Portal(World world){
        super(world,portalShape);
        this.world = world;
        portalImage = new BodyImage("data/GIF/portal.gif",8);
        this.addImage(portalImage);
    }
}
