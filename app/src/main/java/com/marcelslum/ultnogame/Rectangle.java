package com.marcelslum.ultnogame;


import java.util.ArrayList;

public class Rectangle extends PhysicalObject {
    public float width;
    public float height;
    public ScaleVariationData scaleVariationData;
    public PositionVariationData positionVariationData;
    public float borderPercentage = 0.0f;
    public float borderMinThickness;
    public float borderMaxThickness;
    public Color borderColor;
    public float borderThicknes;


    Rectangle(String name, float x, float y, float width, float height, int weight, Color color){
        super(name, x, y, weight);
        this.program = Game.solidProgram;
        this.color = color;
        this.width = width;
        this.height = height;
        setDrawInfo();
    }

    public void addBorder(float percentage, float minThickness, float maxThickness, Color borderColor){
        //Log.e("rectangle", "addborder");
        this.borderPercentage = percentage;
        this.borderMinThickness = minThickness;
        this.borderMaxThickness = maxThickness;
        this.borderColor = borderColor;

        borderThicknes = width * borderPercentage;
        if (borderThicknes > borderMaxThickness){
            borderThicknes = borderMaxThickness;
        } else if (borderThicknes < borderMinThickness){
            borderThicknes = borderMinThickness;
        }
        //Log.e("rectangle", "borderThicknes" + borderThicknes);

        setDrawInfo();
        //Log.e("rectangle", " setDrawInfo end");
    }

    public void setDrawInfo(){
        //Log.e("rectangle", " setDrawInfo init");

        if (borderPercentage == 0f) {
            initializeData(12, 6, 0, 16);
        } else {
            initializeData(12*5, 6*5, 0, 16*5);
        }

        Utils.insertRectangleVerticesData(verticesData, 0,  0f, width, 0f, height, 0f);
        Utils.insertRectangleIndicesData(indicesData, 0, 0);
        Utils.insertRectangleColorsData(colorsData, 0, color);


        //Log.e("rectangle", " borderPercentage "+borderPercentage);
        if (borderPercentage != 0.0f) {
            //Log.e("rectangle", " borderPercentage");
            for (int i = 0; i < 4; i++){
                //Log.e("rectangle", " borda "+i);
                if (i == 0){
                    Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  0f, width, 0f, borderThicknes, 0f);
                } else if (i == 1){
                    Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  0f, width, height - borderThicknes, height, 0f);
                } else if (i == 2){
                    Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  0f, borderThicknes, 0f, height, 0f);
                } else {
                    Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  width - borderThicknes, width, 0f, height, 0f);
                }
                Utils.insertRectangleIndicesData(indicesData, (i+1)*6, (i+1)*4);
                Utils.insertRectangleColorsData(colorsData, (i+1)*16, borderColor);
            }
        }

        verticesBuffer = Utils.generateFloatBuffer(verticesData);
        indicesBuffer = Utils.generateShortBuffer(indicesData);
        colorsBuffer = Utils.generateFloatBuffer(colorsData);
    }

    @Override
    public void setSatData(){
        if(this.polygonData == null) {
            float transformedWidth = getTransformedWidth();
            float transformedHeight = getTransformedHeight();
            ArrayList<Vector> points = new ArrayList<>();
            points.add(new Vector(0, 0));
            points.add(new Vector(transformedWidth, 0));
            points.add(new Vector(transformedWidth, transformedHeight));
            points.add(new Vector(0, transformedHeight));
            polygonData = new SatPolygon(new Vector(positionX, positionY), points);
            
        } else {
            polygonData.pos.x = positionX;
            polygonData.pos.y = positionY;
        }
    }

    @Override
    public float getTransformedWidth() {
        return width * accumulatedScaleX;
    }

    @Override
    public float getTransformedHeight() {
        return height * accumulatedScaleY;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }
    
    
    public void setScaleVariation(ScaleVariationDataBuilder builder){
        scaleVariationData = builder.build();
    }

    public void setPositionVariation(PositionVariationDataBuilder builder){
        positionVariationData = builder.build();
    }
    
    public void stopScaleVariation(){
        if (scaleVariationData != null) {
            scaleVariationData.isActive = false;
        }
    }

    public void initScaleVariation(){
        if (scaleVariationData != null) {
            scaleVariationData.isActive = true;
        }
    }

    public void stopPositionVariation(){
        if (positionVariationData != null) {
            positionVariationData.isActive = false;
        }
    }

    public void initPositionVariation(){
        if (positionVariationData != null) {
            positionVariationData.isActive = true;
        }
    }
    

    @Override
    public void checkTransformations(boolean updatePrevious) {

        if (positionVariationData != null){
            PositionVariationData p = positionVariationData;
            if (p.isActive){
                if (p.xVelocity > 0f){
                    if (p.increaseX){
                        translateX += p.xVelocity * Game.gameAreaResolutionX;
                        if ((x + accumulatedTranslateX + translateX + getTransformedWidth())>(p.maxX*Game.gameAreaResolutionX)){
                            translateX -= p.xVelocity * Game.gameAreaResolutionX * 2;    
                            p.increaseX = false;
                        }
                    } else {
                        translateX -= p.xVelocity * Game.gameAreaResolutionX;
                        if ((x + accumulatedTranslateX + translateX)<(p.minX*Game.gameAreaResolutionX)){
                            translateX += p.xVelocity * Game.gameAreaResolutionX * 2;
                            p.increaseX = true;
                        }
                    }
                }

                if (p.yVelocity > 0f){
                    if (p.increaseY){
                        translateY += p.yVelocity * Game.gameAreaResolutionY;
                        if ((y + accumulatedTranslateY + translateY + getTransformedHeight())>(p.maxY*Game.gameAreaResolutionY)){
                            translateY -= p.yVelocity * Game.gameAreaResolutionY * 2;
                            p.increaseY = false;
                        }
                    } else {
                        translateY -= p.yVelocity * Game.gameAreaResolutionY;
                        if ((y + accumulatedTranslateY + translateY)<(p.minY*Game.gameAreaResolutionY)){
                            translateY += p.yVelocity * Game.gameAreaResolutionY * 2;
                            p.increaseY = true;
                        }
                    }
                }
            }
        }
        

        if (scaleVariationData != null){
            ScaleVariationData s = scaleVariationData;
            if (s.isActive){
                if (s.widthVelocity > 0f){
                    if (s.increaseWidth){
                        scaleX += s.widthVelocity;
                        if (accumulatedScaleX + scaleX > ((width*s.maxWidth_BI)/width)){
                            scaleX -= s.widthVelocity*2;
                            s.increaseWidth = false;
                        }
                    } else {
                        scaleX -= s.widthVelocity;
                        if (accumulatedScaleX + scaleX < ((width*s.minWidth_BI)/width)){
                            scaleX += s.widthVelocity*2;
                            s.increaseWidth = true;
                        }
                    }
                }

                if (s.heightVelocity > 0f){
                    if (s.increaseHeight){
                        scaleY += s.heightVelocity;
                        if (accumulatedScaleY + scaleY > ((height*s.maxHeight_BI)/height)){
                            scaleY -= s.heightVelocity*2;
                            s.increaseHeight = false;
                        }
                    } else {
                        scaleY -= s.heightVelocity;
                        if (accumulatedScaleY + scaleY < ((height*s.minHeight_BI)/height)){
                            scaleY += s.heightVelocity*2;
                            s.increaseHeight = true;
                        }
                    }
                }
            }

            if (borderPercentage != 0.0f) {

                float difHeight = height / getTransformedHeight();
                float difWidth = width / getTransformedWidth();

                for (int i = 0; i < 4; i++){
                    if (i == 0){
                        Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  0f, width, 0f, borderThicknes * difHeight, 0f);
                    } else if (i == 1){
                        Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  0f, width, height - (borderThicknes * difHeight), height, 0f);
                    } else if (i == 2){
                        Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  0f, borderThicknes * difWidth, 0f, height, 0f);
                    } else {
                        Utils.insertRectangleVerticesData(verticesData, (i+1)*12,  width - (borderThicknes * difWidth), width, 0f, height, 0f);
                    }
                }
            }
            verticesBuffer = Utils.generateFloatBuffer(verticesData);
        }
        super.checkTransformations(updatePrevious);
    }

    @Override
    public void updateQuatreeData() {
        quadtreeData.setX(positionX);
        quadtreeData.setY(positionY);
        quadtreeData.setWidth(getTransformedWidth());
        quadtreeData.setHeight(getTransformedHeight());
    }

}