package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    double x;
    double y;
    double speedX;
    double speedY;
    public Sprite sprite;
    int number;

    public Background(Texture img, int x){
        this.x = 1375 + 2550 * (x-1);
        y = 1780;
        sprite = new Sprite(img);
        sprite.setScale(10, 10);
        number = (x - 1);
    }
    public void draw(SpriteBatch batch){
        sprite.setPosition((float) x, (float) y);
        sprite.draw(batch);
    }
    public void update(float playerX, float playerY){
        x -= playerX;
        y -= playerY;
        if(x < number*2550 + 1375){
            x += 2550;
        }
        if(x > number*2550 + 1375){
            x -= 2550;
        }
    }
}
