/*package game;

import Bodies.*;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
public class GameWorld extends World {
    private Player p;
    private int gems = 4;

    public GameWorld(){


          p = new Player(this);
          //adding the player object that was created from the player class into the gameWorld




        Shape shape1 = new BoxShape(65, 2f);
        StaticBody ground = new StaticBody(this, shape1);
        ground.setPosition(new Vec2(0, -10F));
        ground.setFillColor(Color.BLACK);


        Shape shape2 = new BoxShape(10,0.5f);
        StaticBody platform1 = new StaticBody(this, shape2);
        platform1.setPosition(new Vec2(7,0));
        platform1.setFillColor(Color.BLACK);

        Shape shape3 = new BoxShape(5,0.5f);
        StaticBody platform2 = new StaticBody(this, shape3);
        platform2.setPosition(new Vec2(-11.5f,4));
        platform2.setFillColor(Color.BLACK);

        Shape shape4 = new BoxShape(8,0.5f);
        StaticBody platform3 = new StaticBody(this, shape4);
        platform3.setPosition(new Vec2(-30f,9));
        platform3.setFillColor(Color.BLACK);


        for (int i = 0; i < 2; i++){
             Body e = new Enemy(this,p);
             e.setPosition(new Vec2(i*22-36,10));
             // for loop in place which allows enemies to be placed rather can creating and positioning each individual enemy object
        }

        /*body enemy1 = new Enemy(this,p);
        enemy1.setPosition(new Vec2(-14,10));

        Body enemy2 = new Enemy(this,p);
        enemy2.setPosition(new Vec2(-36f,20));

        Body trap1 = new Traps(this,p);
        trap1.setPosition(new Vec2(3,1f));

        Body trap2 = new Traps(this,p);
        trap2.setPosition(new Vec2(-27,10f));

        Body gem1 = new Gems(this);
        gem1.setPosition(new Vec2(-8,5.5f));

        Body gem2 = new Gems(this);
        gem2.setPosition(new Vec2(6,1.5f));

        Body gem3 = new Gems(this);
        gem3.setPosition(new Vec2(-30f,10.5f));

        Body gem4 = new Gems(this);
        gem4.setPosition(new Vec2(0,-7f));

        Body portal = new Portal(this);
        portal.setPosition(new Vec2(14,4));

        //setting up all the objects such as the enemies,platforms,gems and traps that would appear in the level

    }

    public Player getPlayer(){
        return p;
    }
    //create access to the player object

    public boolean levelComplete(){
        return getPlayer().getGemCount() == gems;
    }
    //method to see if the conditions of finishing the level has been met
    public int getGems() {
        return gems;
    }
    //access to the gem object


}

 */
