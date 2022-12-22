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
    public Sprite sprite;
    boolean active;
    public Bullet(Texture img, float x, float y){
        this.x = x;
        this.y = y;
        sprite = new Sprite(img);
        sprite.setScale(5, 5);
    }
    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
    }
    public void update(float playerX, float playerY, float playerRotation){
        if(active) {
            x += playerX;
            y += playerY;
        }
        if(Helper.outOfScreen(x, y)){
            disable();
        }
    }
    public void disable(){
        active = false;
    }
}
