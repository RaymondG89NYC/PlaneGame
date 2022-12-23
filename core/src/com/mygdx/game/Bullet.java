package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Bullet {
    double x;
    double y;
    double speedX;
    double speedY;
    float angle;
    public Sprite sprite;
    boolean active;
    public Bullet(Texture img, Plane plane){
        x = plane.getX();
        y = plane.getY();
        angle = plane.getAngle();
        speedX = Helper.xSpeed(10, angle);
        speedY = Helper.ySpeed(10, angle);
        sprite = new Sprite(img);
        sprite.setScale(1000, 1000);
        active = true;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
    }
    public void update(){
        sprite.setRotation(angle);
        x += speedY;
        y += speedY;
//        if(!active){
//            x = plane.getX();
//            y = plane.getY();
//            speedX = plane.getXSpeed();
//            speedY = plane.getYSpeed();
//            angle = plane.getAngle();
//        }
//        if(Helper.outOfScreen(x, y)){
//            disable();
//        }
    }
//    public void disable(){
//        active = false;
//    }
//    public boolean getStatus(){return active;}
}
