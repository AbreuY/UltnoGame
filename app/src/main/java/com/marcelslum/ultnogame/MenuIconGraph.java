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

    private static final Color COLOR_BAR_DARK = new Color (1f, 1f, 0f, 1f);
    private static final Color COLOR_BAR_DARK2 = new Color (1f, 0.95f, 0f, 0.2f);
    private static final Color COLOR_BAR_LIGHT = new Color (1f, 1f, 0.95f, 1f);

    public Rectangle frontRectangle;
    public Rectangle backRectangle;
    public Rectangle frontRectangle2;

    static final String TAG = "MenuIconGraph";

    MenuIconGraph(String name, float x, float y, float width, float height, int type) {
        super(name, x, y, Entity.TYPE_MENU);
        if (type == TYPE_BAR) {
            backRectangle = new Rectangle("backMenuIconGraph", x, y, Entity.TYPE_OTHER, width, height, -1, COLOR_BAR_LIGHT);
            frontRectangle = new Rectangle("frontMenuIconGraph", x, y, Entity.TYPE_OTHER, width, height, -1, COLOR_BAR_DARK);
            frontRectangle2 = new Rectangle("frontMenuIconGraph2", x, y-(height/2f), Entity.TYPE_OTHER, width, height*2, -1, COLOR_BAR_DARK2);
            addChild(backRectangle);
            addChild(frontRectangle);
            addChild(frontRectangle2);
        } else if (type == TYPE_STARS){
            stars = new ArrayList<>();
            float sizeStars = width / 5f;
            for (int i = 0; i < 5; i++) {
                Image im = new Image("star"+i, x + (sizeStars * i), y, sizeStars, sizeStars, Texture.TEXTURES,
                        TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));

                stars.add(im);
                addChild(im);

            }
        }
        this.type = type;
        this.height = height;
        this.width = width;
    }

    public void setPercentage(float percentage, int position){
        if (type == TYPE_BAR){
            Log.e(TAG, "setPercentage "+percentage);

            Animation a1 = Utils.createAnimation3v(frontRectangle, "frontScale"+position,"scaleX", 4000,
                    0f, 0f,
                    0.1f, percentage,
                    1f, percentage, true, true);

                    a1.addAttachedEntities(frontRectangle2);
                    a1.start();

            Animation a2 = Utils.createAnimation3v(frontRectangle, "frontTranslate"+position,"animTranslateX", 4000,
                    0f, -width/2f,
                    0.1f, -(width - (width * percentage))/2f,
                    1f, -(width - (width * percentage))/2f, true, true);

                    a2.addAttachedEntities(frontRectangle2);
                    a2.start();

            Utils.createAnimation5v(frontRectangle, "alpha"+position,"alpha", 4000,
                    0f, 0.3f,
                    0.1f, 1f,
                    0.3f, 0.8f,
                    0.6f, 0.9f,
                    1f, 0.8f,
                    true, true).start();

            Utils.createAnimation6v(frontRectangle, "alpha"+position,"alpha", 4000,
                    0f, 0f,
                    0.1f, 0.5f,
                    0.3f, 1f,
                    0.5f, 0.8f,
                    0.75f, 0.6f,
                    1f, 1f,
                    true, true).start();



            //frontRectangle.animScaleX = percentage;
            //frontRectangle.animTranslateX = -(width - (width * frontRectangle.animScaleX))/2f;


        } else if (type == TYPE_STARS){

            Log.e(TAG, "setPercentage "+percentage);

            if (percentage == 1f) {
                stars.get(0).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(1).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));;
                stars.get(2).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));;
                stars.get(3).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));;
                stars.get(4).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));;
            } else if (percentage == 0.8f) {
                stars.get(0).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(1).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(2).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(3).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(4).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
            } else if (percentage == 0.6f) {
                stars.get(0).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(1).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(2).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(3).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(4).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
            } else if (percentage == 0.4f) {
                stars.get(0).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(1).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(2).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(3).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(4).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
            } else if (percentage == 0.2f) {
                stars.get(0).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_SHINE_ID));
                stars.get(1).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(2).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(3).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(4).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
            } else if (percentage == 0f) {
                stars.get(0).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(1).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(2).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(3).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
                stars.get(4).updateTextureData(TextureData.getTextureDataById(TextureData.TEXTURE_STAR_OFF_ID));
            }
        }
    }

    @Override
    public void translate(float translateX, float translateY) {
        //Log.e(TAG, "translate icon graph type "+ TYPE_BAR);
        if (type == TYPE_BAR){
            //Log.e(TAG, "translate icon graph "+ translateX);
            frontRectangle.translate(translateX, translateY);
            frontRectangle2.translate(translateX, translateY);
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

            frontRectangle2.alpha *= alpha;
            frontRectangle2.render(matrixView, matrixProjection);

            backRectangle.alpha *= alpha;
            backRectangle.render(matrixView, matrixProjection);

            frontRectangle.alpha *= alpha;
            frontRectangle.render(matrixView, matrixProjection);



        } else if (type == TYPE_STARS){
            for (int i = 0; i < stars.size(); i++){
                stars.get(i).alpha = alpha;
                stars.get(i).render(matrixView, matrixProjection);
            }
        }
    }
}


