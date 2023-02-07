package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Text {
    private String text;
    private double x;
    private double y;
    private Plane plane;
    private Missile missile;
    private BitmapFont font = new BitmapFont();
    public Text(String text, Plane plane, Missile missile) {
        this.text = text;
        this.x = missile.getX();
        this.y = missile.getY();
    }
    public void draw(Batch batch) {
            font.draw(batch, (CharSequence) text, (float) x, (float) y);
    }

}
