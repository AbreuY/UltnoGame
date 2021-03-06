package com.marcelslum.ultnogame;

import android.util.Log;

import java.util.ArrayList;

public class Messages extends Entity {

    ArrayList<Entity> childs2;
    ArrayList<Entity> childs3;


    private static Text [] texts;

    public Messages() {
        super("messages", Game.resolutionX * 0.97f, Game.gameAreaResolutionY * 0.7f, Entity.TYPE_PANEL);

        if (texts == null){
            texts = new Text[40];
        }

        for (int i = 0; i < texts.length; i++) {
            texts[i] = new Text();
            texts[i].isVisible = false;
        }

        isVisible = true;
        childs2 = new ArrayList<>();
        childs3 = new ArrayList<>();
    }

    private Text getUnusedText(){
        for (int i = 0; i < texts.length; i++) {
            //Log.e(TAG, "text " + i + " isVisible " + texts[i].isVisible);
            if (!texts[i].isVisible){
                return texts[i];
            }
        }
        return new Text();
    }

    public void showMessage(String messageText){
        int numberOfActiveTexts = 0;
        int childToReplace = -1;
        for (int i = 0; i < childs.size(); i++) {
            if (childs.get(i).isVisible) {
                numberOfActiveTexts += 1;
            } else {
                childToReplace = i;
                break;
            }
        }

        //Log.e("messages", "numberOfActiveTexts "+numberOfActiveTexts);

        final Text textObject;
        final Text textObject2;
        final Rectangle rectangle;
        float padd =  Game.gameAreaResolutionX * 0.01f;
        if (childToReplace != -1){

            textObject = getUnusedText();//Game.textPool.get();
            textObject.setData("text", x, childs.get(childToReplace).y,
                    Game.gameAreaResolutionY * 0.045f, messageText, Game.font, new Color (1f, 1f, 0f, 1f), Text.TEXT_ALIGN_RIGHT);
            textObject.isVisible = true;
            childs.set(childToReplace, textObject);



            textObject2 = getUnusedText();
            textObject2.setData("text2", x + (Game.gameAreaResolutionY * 0.045f * 0.07f), childs.get(childToReplace).y + (Game.gameAreaResolutionY * 0.045f * 0.07f),
                    Game.gameAreaResolutionY * 0.045f, messageText, Game.font, new Color (0.6f, 0.6f, 0f, 1f), Text.TEXT_ALIGN_RIGHT);
            textObject2.isVisible = true;
            childs2.set(childToReplace, textObject2);

            float textWidth = textObject.getWidth();

            rectangle = new Rectangle("messageRectangle", x - textWidth - padd , childs.get(childToReplace).y - (padd/4f), Entity.TYPE_OTHER, textWidth + (padd * 4f), Game.gameAreaResolutionY * 0.06f + (padd/2f), -1, Color.cinza60);
            childs3.set(childToReplace, rectangle);


        } else {
            textObject = getUnusedText();//Game.textPool.get();
            textObject.setData("text", x, y - (numberOfActiveTexts * Game.gameAreaResolutionY * 0.07f),
                    Game.gameAreaResolutionY * 0.045f, messageText, Game.font, new Color (1f, 1f, 0f, 1f), Text.TEXT_ALIGN_RIGHT);
            textObject.isVisible = true;
            childs.add(textObject);

            textObject2 = getUnusedText();
            textObject2.setData("text2", x + (Game.gameAreaResolutionY * 0.045f * 0.07f), y - (numberOfActiveTexts * Game.gameAreaResolutionY * 0.07f) + (Game.gameAreaResolutionY * 0.045f * 0.07f),
                    Game.gameAreaResolutionY * 0.045f, messageText, Game.font, new Color (0.6f, 0.6f, 0f, 1f), Text.TEXT_ALIGN_RIGHT);
            textObject2.isVisible = true;
            childs2.add(textObject2);

            float textWidth = textObject.getWidth();

            rectangle = new Rectangle("messageRectangle", x - textWidth - padd , textObject.y - (padd/4f), Entity.TYPE_OTHER, textWidth + (padd * 4f), Game.gameAreaResolutionY * 0.06f + (padd/2f), -1, Color.cinza60);
            childs3.add(rectangle);
        }


        textObject.animTranslateX = Game.resolutionX;
        textObject2.animTranslateX = Game.resolutionX;
        rectangle.animTranslateX =  Game.resolutionX;

        rectangle.isVisible = true;
        rectangle.alpha = 0.4f;

        Game.sound.playTextBoxAppear();

        //Sound.playSoundPool(Sound.soundTextBoxAppear, 0.3f, 0.3f, 0);

        Animation anim1 = Utils.createAnimation3v(textObject, "translateX", "translateX", 2225,
                0f, Game.resolutionX, 0.1f, 0f, 0.9f, -Game.resolutionX * 0.05f, false, true);
        anim1.addAttachedEntities(rectangle);
        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd() {

                Animation a2 = Utils.createAnimation2v(textObject, "translateX2", "translateX", 225,
                        0f, -Game.resolutionX * 0.05f, 1f,  Game.resolutionX, false, true);
                a2.addAttachedEntities(textObject2);
                a2.start();

                Utils.createSimpleAnimation(rectangle, "alpha", "alpha", 225, 0.3f, 0f).start();

                //Sound.playSoundPool(Sound.soundTextBoxAppear, 0.05f, 0.05f, 0);
            }
        });
        anim1.start();

        // retangula aumenta bruscamente alpha, depois aumenta aos poucos
        Utils.createAnimation4v(rectangle, "alpha", "alpha", 2225,
                0f, 0,
                0.1f, 0.6f,
                0.35f, 0.4f,
                0.9f, 0.3f,
                false, true).start();


        Utils.createAnimation3v(textObject2, "translateX", "translateX", 2225,
                0f, Game.resolutionX, 0.1f, 0f, 0.9f, -Game.resolutionX * 0.05f, false, true).start();

        textObject2.alpha = 1f;

        Utils.createSimpleAnimation(textObject, "alpha", "alpha", 2500, 1f, 0.6f, new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd() {
                textObject.isVisible = false;
                textObject2.isVisible = false;
                rectangle.isVisible = false;
            }
        }).start();


    }

    @Override
    public void checkTransformations(boolean updatePrevious) {
        if (childs2 != null) {
            for (int i = 0; i < childs2.size(); i++) {
                childs2.get(i).checkTransformations(updatePrevious);
            }
        }

        if (childs3 != null) {
            for (int i = 0; i < childs3.size(); i++) {
                if (childs3.get(i) != null) {
                    childs3.get(i).checkTransformations(updatePrevious);
                }
            }
        }
        super.checkTransformations(updatePrevious);
    }

    @Override
    public void prepareRender(float[] matrixView, float[] matrixProjection) {
        if (childs2 != null) {
            for (int i = 0; i < childs2.size(); i++) {
                for (int a = 0; a < childs2.get(i).animations.size(); a++) {

                    if (childs2.get(i).animations.get(a).started) {
                        //Log.e(TAG, childs2.get(i).animations.get(a).name);
                        childs2.get(i).animations.get(a).doAnimation();
                    }
                }
            }
        }

        if (childs3 != null) {
            for (int i = 0; i < childs3.size(); i++) {
                for (int a = 0; a < childs3.get(i).animations.size(); a++) {
                    if (childs3.get(i) != null && childs3.get(i).animations.get(a).started) {
                        //Log.e(TAG, childs2.get(i).animations.get(a).name);
                        childs3.get(i).animations.get(a).doAnimation();
                    }
                }
            }
        }
        super.prepareRender(matrixView, matrixProjection);
    }

    public void render(float[] matrixView, float[] matrixProjection) {
        for (int i = 0; i < childs.size(); i++) {
            if (childs.get(i).isVisible) {
                if (childs3.get(i) != null) {
                    childs3.get(i).render(matrixView, matrixProjection);
                }
                childs2.get(i).render(matrixView, matrixProjection);
                childs.get(i).render(matrixView, matrixProjection);
            }
        }
    }
}
