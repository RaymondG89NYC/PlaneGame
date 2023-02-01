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
    int size;
    public Bullet(Texture img, Plane plane){
        x = plane.getX();
        y = plane.getY();
        size = 3;
        angle = plane.getAngle();
        speedX = Helper.xSpeed(10, angle) + plane.getXSpeed();
        speedY = Helper.ySpeed(10, angle) + plane.getYSpeed();
        sprite = new Sprite(img);
        sprite.setScale(size, size);
        active = true;
        sprite.setRotation(angle);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public int getSize(){
        return size;
    }

    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
    }
    public void update(){
        x += speedX;
        y += speedY;
        if(Helper.outOfScreen(x, y)){
            disable();
        }
    }
    public void disable(){
        active = false;
    }
    public boolean getStatus(){return active;}
}
