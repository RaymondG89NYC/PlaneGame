package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Plane {
    float x;
    float y;
    float speed;
    public Sprite sprite;
    float distance;
    float height;
    boolean rightSideUp;
    float angle;

    public Plane(Texture img){
        x = Gdx.graphics.getWidth()/2-10;
        y = Gdx.graphics.getHeight()/2;
        sprite = new Sprite(img);
        sprite.setScale(2);
        speed = 0;
        angle = 0;
    }

    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
//        System.out.println(x + "," + y);
    }
    public void update(){
        float mouseAngle = Helper.findDegree(this.x, this.y);

        while(checkAngle()){
            fixAngle();
        }
        if(rotateDirection(angle, mouseAngle)){
            if(angle + 1 == mouseAngle || angle - 1 == mouseAngle){

            }
            else {
                angle += 4;
            }
        }
        else{
            angle -= 4;
        }
        System.out.println(angle);
        sprite.setRotation(angle);
        distance += getXSpeed();
        height += getYSpeed();
    }
    public void increaseSpeed(){
        if(speed < 20) {
            speed += 0.1;
        }
    }
    public void decreaseSpeed(){
        if(speed>-1) {
            speed -= 0.1;
        }
    }
    public float getXSpeed(){
        return Helper.xSpeed(speed, angle);
    }
    public float getYSpeed(){
        return Helper.ySpeed(speed, angle);
    }
    public float getX(){return x;}
    public float getY(){return y;}
    public float getAngle(){return angle;}

    public boolean rotateDirection(float object, float target){
//        if(object < 0 && target > 0){
//
//            System.out.println("Test");
//
//            return (object - target <= 180 && object - target >= 0);
//        }
//        return !(object - target <= 180 && object - target >= 0);
//        if(Math.abs()
        return (object - target > 180 || object - target < 0);
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

}
