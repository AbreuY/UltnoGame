package com.marcelslum.ultnogame;

import java.util.ArrayList;

public class BallGoalsPanel extends Entity{

    public float size;
    public int value;
    public int ballsAlive;
    public int minBallsAlive;
    public int ballsInvencible;
    public float initialX;
    public float initialY;
    public int blackBalls;
    public int blueBalls;
    public float lastXBall;
    public ArrayList<ParticleGenerator> particleGenerators;

    BallGoalsPanel(String name, Game game, float x, float y, float size) {
        super(name, x, y, Entity.TYPE_PANEL);
        initialX = x;
        initialY = y;
        this.size = size;
        isSolid = false;
        isCollidable = false;
        isVisible = true;
        alpha = 1;
        this.textureId = Texture.TEXTURES;
        this.program = Game.imageProgram;
        ballsAlive = 4;
        minBallsAlive = 2;
        ballsInvencible = 1;
        setValues(ballsAlive, minBallsAlive, ballsInvencible);
        particleGenerators = new ArrayList<>();
    }

    @Override
    public void prepareRender(float[] matrixView, float[] matrixProjection) {
        super.prepareRender(matrixView, matrixProjection);
        if (isVisible) {
            for (int i = 0; i < particleGenerators.size(); i++) {
                if (particleGenerators.get(i).isActive){
                    particleGenerators.get(i).prepareRender(matrixView, matrixProjection);
                }
            }
        }
    }

    @Override
    public void checkTransformations(boolean updatePrevious) {
        super.checkTransformations(updatePrevious);
        if (particleGenerators != null) {
            for (int i = 0; i < particleGenerators.size(); i++) {
                if (particleGenerators.get(i).isActive) {
                    particleGenerators.get(i).checkTransformations(updatePrevious);
                }
            }
        }
    }

    public void setValues(int ballsAlive, int minBallsAlive, int ballsInvencible) {
        this.ballsAlive = ballsAlive;
        this.minBallsAlive = minBallsAlive;
        this.ballsInvencible = ballsInvencible;
        initializeData(12 * ballsAlive, 6 * ballsAlive, 8 * ballsAlive, 0);

        blackBalls = ballsAlive - ballsInvencible - (ballsAlive - minBallsAlive - ballsInvencible);
        blueBalls = ballsAlive - minBallsAlive - ballsInvencible;

        float xOfTriangle = 0f;
        if (blackBalls == 1) {
            xOfTriangle -= size * 0.5f;
        } else if (blackBalls == 2) {
            xOfTriangle -= size * 1.5f;
        }

        x = initialX - xOfTriangle - (size * (ballsInvencible + 1));
        if (ballsInvencible > 0){
            x -= size;
        } else {
            x += size * 0.5f;
        }

        int ballsInvecibleDraw = ballsInvencible;
        int ballsBlackDraw = blackBalls;
        int ballsBlueDraw = blueBalls;

        for (int i = 0; i < ballsAlive;i++){

            if (ballsInvecibleDraw > 0) {
                Utils.insertRectangleVerticesData(verticesData, i * 12, xOfTriangle, xOfTriangle+size, 0f, size, 0f);
                Utils.insertRectangleIndicesData(indicesData, i * 6, i * 4);
                Utils.insertRectangleUvData(uvsData, i * 8, TextureData.getTextureDataById(TextureData.TEXTURE_PANEL_INVENCIBLE_ID));
                ballsInvecibleDraw -= 1;
                if (ballsInvecibleDraw == 0){
                    xOfTriangle += size*2;
                } else {
                    xOfTriangle += size;
                }
            } else if (ballsBlackDraw > 0){
                Utils.insertRectangleVerticesData(verticesData, i * 12, xOfTriangle, xOfTriangle+size, 0f, size, 0f);
                Utils.insertRectangleIndicesData(indicesData, i * 6, i * 4);
                Utils.insertRectangleUvData(uvsData, i * 8, TextureData.getTextureDataById(TextureData.TEXTURE_PANEL_BLACK_ID));

                ballsBlackDraw -= 1;
                if (ballsBlackDraw == 0){
                    xOfTriangle += size*2;
                } else {
                    xOfTriangle += size;
                }
            } else if (ballsBlueDraw > 0) {

                Utils.insertRectangleVerticesData(verticesData, i * 12, xOfTriangle, xOfTriangle+size, 0f, size, 0f);
                Utils.insertRectangleIndicesData(indicesData,i * 6, i * 4);
                Utils.insertRectangleUvData(uvsData, i * 8, TextureData.getTextureDataById(TextureData.TEXTURE_PANEL_BLUE_ID));

                ballsBlueDraw -= 1;
                xOfTriangle += size;
            }
        }

        lastXBall = xOfTriangle + size/2f;


        verticesBuffer = Utils.generateOrUpdateFloatBuffer(verticesData, verticesBuffer);
        indicesBuffer = Utils.generateOrUpdateShortBuffer(indicesData, indicesBuffer);
        uvsBuffer = Utils.generateOrUpdateFloatBuffer(uvsData, uvsBuffer);

    }
    
    public void explodeBlueBall(){
        if (blueBalls > 0){
            Game.sound.playBlueBallExplosion();
            //Sound.playSoundPool(Sound.soundBlueBallExplosion, 1, 1, 0);

            setValues(ballsAlive - 1, minBallsAlive, ballsInvencible);

            // TODO verificar se está certo, ou seja, se a bola azul explode no lugar certo
            Game.blueBallExplodeX = initialX + (animTranslateX*animScaleX) + ((lastXBall)*animScaleX);
            Game.blueBallExplodeY =  y + animTranslateY + ((size/2f)*animScaleY);
            Game.forBlueBallExplode = true;

        }
    }

    public void prepareUvData(int textureMap){
        Utils.x1 = 0f;
        Utils.x2 = 0f;
        Utils.y1 = 0f;
        Utils.y2 = 0f;

        if (textureMap < 5){
            Utils.y1 = 0.005f;
            Utils.y2 = 0.245f;
        } else if (textureMap < 9){
            Utils.y1 = 0.2505f;
            Utils.y2 = 0.495f;
        } else if (textureMap < 13){
            Utils.y1 = 0.5005f;
            Utils.y2 = 0.745f;
        } else if (textureMap < 17){
            Utils.y1 = 0.7505f;
            Utils.y2 = 0.995f;
        }


        if (textureMap == 1 || textureMap == 5 || textureMap == 9 || textureMap == 13){
            Utils.x1 = 0.005f;
            Utils.x2 = 0.2495f;
        } else if (textureMap == 2 || textureMap == 6 || textureMap == 10 || textureMap == 14){
            Utils.x1 = 0.2505f;
            Utils.x2 = 0.4995f;
        } else if (textureMap == 3 || textureMap == 7 || textureMap == 11 || textureMap == 15){
            Utils.x1 = 0.501f;
            Utils.x2 = 0.7495f;
        } else if (textureMap == 4 || textureMap == 8 || textureMap == 12 || textureMap == 16){
            Utils.x1 = 0.751f;
            Utils.x2 = 0.9995f;
        }
    }

    public void clearExplosions() {
        particleGenerators.clear();
    }
}
