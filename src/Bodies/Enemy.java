package Bodies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Create a new DynamicBody for the enemy.
 */
public class Enemy extends Walker implements StepListener {
        // enemies extend walker which extends dynamic body
    private static final PolygonShape enemyShape = new PolygonShape(2.0f,1.04f,
            2.84f,-0.52f, -1.76f,-0.64f, -2.66f,1.6f, -1.02f,2.04f, 1.66f,1.28f);
        //creating the shape of the enemies

    private float left, right;
    private final int RANGE = 1;
    private final int SPEED = 3;
    private Gems gems;
    private BodyImage enemyImage;

    /**
     * Create a new walker
     * @param world
     * @param p
     */
    public Enemy(World world, Player p) {
        super(world, enemyShape);

        enemyImage = new BodyImage("data/Images/enemy.png",5f);// creating enemy image
        this.addImage(enemyImage);// attaching enemy image to the shape created
        GhostlyFixture enemy = new GhostlyFixture(this,enemyShape,100);
        world.addStepListener(this); // including the step listener in this class which allows the enemy to patrol
        enemy.getDensity();
        this.startWalking(SPEED); // setting the walking speed of the enemy



    }

    /**
     * Set the position of the enemy, allow the enemy to patrol a certain region of the level
     * @param position
     */
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }


    /**
     * Method that actually moves the enemy from left to right
     * @param stepEvent
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }



    }










