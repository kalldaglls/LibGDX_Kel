package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.w3c.dom.Text;

public class AnimPlayer {
    Texture texture;
    Animation<TextureRegion> animation;
    float time;
    //float fps;
    boolean loop;


    public AnimPlayer(String name, int width, int height, float fps, Animation.PlayMode mode){
        this.loop = loop;
        texture = new Texture(name);
        TextureRegion region = new TextureRegion(new Texture(name));
        TextureRegion[][] regions = region.split(region.getRegionWidth()/width, region.getRegionHeight()/height);
        TextureRegion[] regions1 = new TextureRegion[width  * height];

        int cnt = 0;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[i].length; j++) {
                regions1[cnt++] = regions[i][j];
            }
        }

        animation = new Animation<TextureRegion>(1.5f/fps, regions1);//Сколько будет показывать кадр, откуда берет кадр!
        animation.setPlayMode(mode);
    }

    public void step(float time) {
        this.time += time;
    }

    public TextureRegion getFrame() {
        return animation.getKeyFrame(time);
    }

    public void reSetTime() {time = 0;}

    public boolean isFinished() {
        return animation.isAnimationFinished(time);
    }

    public void setPlayMode(Animation.PlayMode mode) {animation.setPlayMode(mode);}

    public void dispose() {
        texture.dispose();

    }
}
