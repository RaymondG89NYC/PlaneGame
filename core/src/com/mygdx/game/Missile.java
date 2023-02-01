package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Missile {
    double x;
    double y;
    double speed;
    double speedX;
    double speedY;
    float angle;
    float rotateSpeed;
    public Sprite sprite;
    boolean active;
    Plane plane;
    public float getXSpeed(){
        return Helper.xSpeed(speed, angle);
    }
    public float getYSpeed(){
        return Helper.ySpeed(speed, angle);
    }
    public Missile(Texture img, Plane plane){
        x = Gdx.graphics.getWidth()/2 + MathUtils.randomSign() * Helper.random(Gdx.graphics.getWidth()/2+300, Gdx.graphics.getWidth()/2);
        y = Gdx.graphics.getHeight()/2 + MathUtils.randomSign() * Helper.random(Gdx.graphics.getHeight()/2+300,Gdx.graphics.getWidth()/2);

        rotateSpeed = (float) Helper.random(4,2);
        angle = Helper.findDegree(x, y, false);

//            speedX = Helper.xSpeed(10, angle) + plane.getXSpeed();
//            speedY = Helper.ySpeed(10, angle) + plane.getYSpeed();
        //^^something cool with high spawn rate

        speed = Helper.random(10,5);
        speedX = getXSpeed() - plane.getXSpeed();
        speedY = getYSpeed() - plane.getYSpeed();
        this.plane = plane;
        sprite = new Sprite(img);
        sprite.setScale(1, 1);
        active = true;
        sprite.setRotation(angle);
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
    public void update() {
        speedX = getXSpeed() - plane.getXSpeed();
        speedY = getYSpeed() - plane.getYSpeed();
        float targetAngle = Helper.findDegree(this.x, this.y, false);
        while(checkAngle()){
            fixAngle();
        }

        if(rotateDirection(angle, targetAngle)){
            if(angle + 1 == targetAngle || angle - 1 == targetAngle){

            }
            else {
                angle += rotateSpeed;
            }

        }
        else{
            angle -= rotateSpeed;
        }
        x += speedX;
        y += speedY;
        sprite.setRotation(angle);
    }

    public boolean rotateDirection(float object, float target){
        return (object - target > 180 || object - target < 0 && target - object < 270);
    }
    public boolean checkAngle(){
        return (angle > 180 || angle < -180);
    }
    public void fixAngle(){
        if(angle > 180){
            angle -= 360;
        }
        if(angle < -180){
            angle += 360;
        }
    }
    public boolean getStatus(){return active;}
    public void disable(){
        active = false;
    }
}
