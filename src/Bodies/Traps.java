package Bodies;

import Bodies.Player;
import city.cs.engine.*;

public class Traps extends StaticBody {
    BodyImage trapImage;
    private static final PolygonShape trap = new PolygonShape(1.141f,
            0.951f, 1.761f,-0.728f, -2.005f,-0.761f, -1.598f,0.984f, 0.685f,0.976f);

    /**
     * setting up the trap with images
     * @param world
     * @param p
     */
    public Traps(World world, Player p){
        super(world,trap);
        trapImage = new BodyImage("data/Images/trap.png",2);
        this.addImage(trapImage);
    }
}
