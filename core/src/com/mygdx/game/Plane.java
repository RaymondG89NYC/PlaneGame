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

    public Plane(Texture img){
        x = Gdx.graphics.getWidth()/2-10;
        y = Gdx.graphics.getHeight()/2;
        sprite = new Sprite(img);
        sprite.setScale(2);
        speed = 0;
    }

    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
//        System.out.println(x + "," + y);
    }
    public void update(){
        float angle = Helper.findDegree(this.x, this.y);
        sprite.setRotation(angle);
        if(angle>=175){
            sprite.flip(false,true);
        }
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
        return Helper.xSpeed(this.x, this.y, speed);
    }
    public float getYSpeed(){
        return Helper.ySpeed(this.x, this.y, speed);
    }

}
