package com.marcelslum.ultnogame;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by marcel on 09/12/2016.
 */

// TODO otimizar a troca de cor da estrela, evitando a criação de novo objeto a cada vez

public class MenuIconGraph extends Entity{

    public static final int TYPE_BAR = 1;
    public static final int TYPE_STARS = 2;

    public int type;
    public float width;
    public float height;
    public ArrayList<Image> stars;

    private static final Color COLOR_BAR_DARK = new Color (1f, 1f, 0.1f, 1f);
    private static final Color COLOR_BAR_LIGHT = new Color (1f, 1f, 0.95f, 1f);

    Rectangle frontRectangle;
    Rectangle backRectangle;

    MenuIconGraph(String name, float x, float y, float width, float height, int type) {
        super(name, x, y);
        if (type == TYPE_BAR) {
            backRectangle = new Rectangle("back", x, y, width, height, -1, COLOR_BAR_LIGHT);
            frontRectangle = new Rectangle("front", x, y, width, height, -1, COLOR_BAR_DARK);
            addChild(backRectangle);
            addChild(frontRectangle);
        } else if (type == TYPE_STARS){
            stars = new ArrayList<>();
            float sizeStars = width / 5f;
            for (int i = 0; i < 5; i++) {
                Image im = new Image("star"+i, x + (sizeStars * i), y, sizeStars, sizeStars, Texture.TEXTURE_BUTTONS_AND_BALLS,
                        (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.add(im);
                addChild(im);

            }
        }
        this.type = type;
        this.height = height;
        this.width = width;
    }

    public void setPercentage(float percentage){
        if (type == TYPE_BAR){
            Log.e(TAG, "setPercentage "+percentage);
            frontRectangle.animScaleX = percentage;
            frontRectangle.animTranslateX = -(width - (width * frontRectangle.animScaleX))/2f;
            Log.e(TAG, "frontRectangle.animTranslateX "+frontRectangle.animTranslateX);
        } else if (type == TYPE_STARS){
            if (percentage == 1f) {
                stars.get(0).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(1).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(2).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(3).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(4).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
            } else if (percentage == 0.8f) {
                stars.get(0).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(1).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(2).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(3).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(4).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
            } else if (percentage == 0.6f) {
                stars.get(0).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(1).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(2).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(3).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(4).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
            } else if (percentage == 0.4f) {
                stars.get(0).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(1).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(2).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(3).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(4).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
            } else if (percentage == 0.2f) {
                stars.get(0).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f);
                stars.get(1).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(2).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(3).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(4).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
            } else if (percentage == 0f) {
                stars.get(0).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(1).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(2).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(3).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
                stars.get(4).setUvData((0f + 1.5f) / 1024f, (128f - 1.5f) / 1024f, (128f + 1.5f) / 1024f, (256f - 1.5f) / 1024f);
            }
        }
    }

    @Override
    public void translate(float translateX, float translateY) {
        //Log.e(TAG, "translate icon graph type "+ TYPE_BAR);
        if (type == TYPE_BAR){
            //Log.e(TAG, "translate icon graph "+ translateX);
            frontRectangle.translate(translateX, translateY);
            backRectangle.translate(translateX, translateY);
        } else if (type == TYPE_STARS){
            for (int i = 0; i < stars.size(); i++){
                stars.get(i).translate(translateX, translateY);
            }
        }
    }

    @Override
    public void render(float[] matrixView, float[] matrixProjection) {
        if (type == TYPE_BAR){
            backRectangle.alpha = alpha;
            backRectangle.render(matrixView, matrixProjection);
            frontRectangle.alpha = alpha;
            frontRectangle.render(matrixView, matrixProjection);
        } else if (type == TYPE_STARS){
            for (int i = 0; i < stars.size(); i++){
                stars.get(i).alpha = alpha;
                stars.get(i).render(matrixView, matrixProjection);
            }
        }
    }
}