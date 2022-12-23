package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import java.lang.Math;


public class Helper {
    public static float findDegree(double playerX, double playerY){
        int x1= Gdx.input.getX();
        int y1=Gdx.graphics.getHeight()-Gdx.input.getY();

//        System.out.println(x1 + "," + y1);
//        System.out.println(Gdx.graphics.getHeight());

        double radians= Math.atan2(y1 - playerY, x1 - playerX);
        float angle=(float)radians* MathUtils.radiansToDegrees;
        return angle;
    }
    public static float xSpeed(double speed, float degree){
        float xSpeed = (float) (speed*Math.cos(degree*MathUtils.degreesToRadians));
//        System.out.println("x: " + xSpeed);
//        System.out.println("speed: " + speed);
//        System.out.println(100*Math.sin(30*MathUtils.degreesToRadians));
        return xSpeed;
    }
    public static float ySpeed(double speed, float degree){
        float ySpeed = (float) (speed*Math.sin(degree*MathUtils.degreesToRadians));
//        System.out.println("y: " + ySpeed);
        return ySpeed;
    }
    public static boolean outOfScreen(double objectX, double objectY){
        return ((objectX > Gdx.graphics.getWidth() || objectX < 0) || (objectY < 0 || objectY > Gdx.graphics.getHeight()));
    }
}
