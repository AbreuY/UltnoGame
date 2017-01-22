package com.marcelslum.ultnogame;


import android.util.Log;

import java.util.ArrayList;

/**
 * Created by marcel on 07/08/2016.
 */
public class TextBox extends Entity{
    public ArrayList<Text> texts;
    public float width;
    public float height;
    public float size;
    public String text;
    public float padding = 0.2f;
    public boolean isHaveArrow = false;
    public boolean isHaveFrame = true;
    public boolean isHaveArrowContinue = true;
    public Button arrowContinuar;
    public Color textColor = new Color(0f, 0f, 0f, 0.9f);
    public Line arrow;
    public float arrowX;
    public float arrowY;
    public Entity frame;
    public float frameWidth;
    public int frameType;
    private OnPress onPress;

    public TextBox(TextBoxBuilder builder) {
        super(builder.name, builder.x, builder.y);
        width = builder.width;
        size = builder.size;
        isHaveArrow = builder.isHaveArrow;
        isHaveFrame = builder.isHaveFrame;
        isHaveArrowContinue = builder.isHaveArrowContinue;
        arrowX = builder.arrowX;
        arrowY = builder.arrowY;
        texts = new ArrayList<>();
        frameType = builder.frameType;
        setText(builder.text);
    }
    
    public void setText(String text){
        if (texts != null){
            texts = new ArrayList<>();
        }
        if (childs != null){
            childs.clear();
        }
        this.text = text;
        
        texts = Text.splitStringAtMaxWidth(name, text, Game.font, textColor, size, width * 0.9f);

        float textPadding = size * padding;

        Text.doLinesWithStringCollection(texts, y + (textPadding * 4), size, textPadding, false);

        float textX = x + (textPadding * 4);
        for (int i = 0; i < texts.size(); i++){
            texts.get(i).x = textX;
            addChild(texts.get(i));
        }

        float lastTextY = texts.get(texts.size() - 1).y;
        if (isHaveArrowContinue) {
            height = lastTextY - y + size + (textPadding * 6);
        } else {
            height = lastTextY - y + size + (textPadding * 3);
        }

        frameWidth = width + (textPadding*6);

        if (isHaveFrame){

            if (frameType == TextBoxBuilder.FRAME_TYPE_IMAGE) {
                frame = new Image("frame", x, y, frameWidth, height, Texture.TEXTURE_TITTLE, 0f, 1f, 0f, 550f / 1024f);
            } else if (frameType == TextBoxBuilder.FRAME_TYPE_SOLID) {
                frame = new Rectangle("frame", x, y, frameWidth, height, -1, new Color(0.7f, 0.7f, 0.7f, 1.0f));
            }
            addChild(frame);
        }
        
        if (isHaveArrowContinue){
            arrowContinuar = new Button("arrowContinuar", x + width - size*0.5f, lastTextY - textPadding, size, size, Texture.TEXTURE_BUTTONS_AND_BALLS, 3f, Button.BUTTON_TYPE_BUTTONS_AND_BALLS);
            arrowContinuar.setTextureMap(14);
            arrowContinuar.textureMapUnpressed = 14;
            arrowContinuar.textureMapPressed = 6;
            arrowContinuar.setOnPress(new Button.OnPress() {
                @Override
                public void onPress() {
                    //TODO tirar a arrowcontinue???????????
                }
            });
            addChild(arrowContinuar);
        } else {
            if (getListener() == null) {
                setListener(new InteractionListener("listenerTextBox" + this.name, x, y, frameWidth, height, 5000, this,
                        new InteractionListener.PressListener() {
                            @Override
                            public void onPress() {
                                Log.e("textbox", "onPress textBox");
                                if (onPress != null) {
                                    onPress.onPress();
                                }
                            }

                            @Override
                            public void onUnpress() {
                            }
                        }
                ));
            } else {
                getListener().setPositionAndSize(x, y, frameWidth, height);
            }
        }
        
        if (isHaveArrow){
            appendArrow(arrowX, arrowY);
        }
    }

    public void setOnPress(OnPress _onPress){
        onPress = _onPress;
    }

    public interface OnPress{
        void onPress();
    }

    public void setPositionY(float y) {
        this.y = y;
        float textPadding = size * padding;
        float textY = this.y + (textPadding * 4);
        for (int i = 0; i < this.texts.size(); i++){
            this.texts.get(i).y = textY;
            textY += size + textPadding;
        }

        if (isHaveFrame){
            frame.y = y;
        }

        if (isHaveArrowContinue){
            arrowContinuar.y = textY - textPadding;
        } else {
            getListener().y = y;
        }

        if (isHaveArrow){
            appendArrow(arrowX, arrowY);
        }
    }


    public void appendArrow(float arrowX, float arrowY){
        isHaveArrow = true;
        float initialX;
        float initialY;
        //Log.e("textbox appendArrow", " " + frame.x + " " + frame.y + " " + frame.width + " " + frame.height);
        if (arrowY > (y + height)){
            initialY = y + height;
            initialX = x + (frameWidth/2f);
        } else if (arrowY < frame.y){
            initialY = y;
            initialX = x + (frameWidth/2f);
        } else {
            initialY = y + (height/2f);
            if (arrowX < x){
                initialX = x;
            } else if (arrowX > (x+frameWidth)){
                initialX = x + frameWidth;
            } else {
                initialX = x;
            }
        }
        //Log.e("textbox appendArrow", " initialX " + initialX + " initialY " + initialY);
        arrow = new Line("line", initialX, initialY, arrowX, arrowY, textColor);
        addChild(arrow);
    }

    public void render(float[] matrixView, float[] matrixProjection){
        if (isHaveArrow && arrow != null){
            arrow.prepareRender(matrixView, matrixProjection);
        }

        if (isHaveFrame){
            frame.prepareRender(matrixView, matrixProjection);
        }

        if (isHaveArrowContinue){
            arrowContinuar.alpha = alpha * 0.6f;
            arrowContinuar.prepareRender(matrixView, matrixProjection);
        }
        
        for (int i = 0; i < this.texts.size();i++){
            this.texts.get(i).alpha = alpha;
            this.texts.get(i).prepareRender(matrixView, matrixProjection);
        }
    }
}
