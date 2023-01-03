package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Explosion {
    double x;
    double y;
    float angle;
    public Sprite sprite;
    boolean active;
    Plane plane;
    float frame = 0;

    public Explosion(Texture img, Plane plane, Missile missile){
        x = missile.getX();
        y = missile.getY();

        this.plane = plane;

        angle = MathUtils.randomSign() * (float)Helper.random(180,0);

        sprite = new Sprite(img);
        sprite.setScale(2, 2);
        active = true;
        sprite.setRotation(angle);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public boolean getStatus(){
        return active;
    }
    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
    }
    public void update() {
        x -= plane.getX();
        y -= plane.getY();
        frame++;
        if(frame > 60){
            sprite.setScale(1, 1);
        }
        if(frame == 120){
            active = false;
        }
    }


}
