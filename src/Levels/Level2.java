package Levels;

import Bodies.*;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Game;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level2 extends GameLevel implements ActionListener {

    private int lvlNumber = 2;
    private int secondsPassed = 0;
    private int gems = 4;
    public Level2(Game game, Player player){
        super(game);

        Shape shape1 = new BoxShape(65, 2f);
        StaticBody ground = new StaticBody(this, shape1);
        ground.setPosition(new Vec2(0, -10F));
        ground.setFillColor(Color.PINK);

        Shape shape2 = new BoxShape(10,0.5f);
        StaticBody platform1 = new StaticBody(this, shape2);
        platform1.setPosition(new Vec2(7,0));
        platform1.setFillColor(Color.PINK);

        Shape shape3 = new BoxShape(5,0.5f);
        StaticBody platform2 = new StaticBody(this, shape3);
        platform2.setPosition(new Vec2(-11.5f,4));
        platform2.setFillColor(Color.PINK);

        Shape shape4 = new BoxShape(8,0.5f);
        StaticBody platform3 = new StaticBody(this, shape4);
        platform3.setPosition(new Vec2(-30f,9));
        platform3.setFillColor(Color.PINK);


        for (int i = 0; i < 2; i++){
            Body e = new Enemy(this,player);
            e.setPosition(new Vec2(i*22-36,10));
            // for loop in place which allows enemies to be placed rather can creating and positioning each individual enemy object
        }

        /*Body spider = new Spider();
        spider.setPosition(new Vec2(0,0));

        /*Body enemy2 = new Enemy(this,p);
        enemy2.setPosition(new Vec2(-36f,20));*/

        Body trap1 = new Traps(this,player);
        trap1.setPosition(new Vec2(3,1f));

        Body trap2 = new Traps(this,player);
        trap2.setPosition(new Vec2(-27,10f));

        Body gem1 = new Gems(this);
        gem1.setPosition(new Vec2(-8,5.5f));

        Body gem2 = new Gems(this);
        gem2.setPosition(new Vec2(6,1.5f));

        Body gem3 = new Gems(this);
        gem3.setPosition(new Vec2(-30f,10.5f));

        Body gem4 = new Gems(this);
        gem4.setPosition(new Vec2(0,-7f));

        Timer timer = new Timer(1000, this);
        timer.setInitialDelay(100);
        timer.start();



        //setting up all the objects such as the enemies,platforms,gems and traps that would appear in the level



    }
    public boolean isComplete() {
        return getPlayer().getGemCount() == gems;}

    public int getLvlNumber(){return lvlNumber;}

    public Vec2 portalPosition(){
        return new Vec2(18,4);
    }

    @Override
    public Vec2 playerPosition() {
        return new Vec2(-8,0);
    }
    public void actionPerformed(ActionEvent ae) {
        //secondsPassed++;
        if (secondsPassed == 50){
            System.out.println("Ran out of time");
            System.exit(0);
        }
    }

    public int getTimer(){
        return secondsPassed;
    }



}
