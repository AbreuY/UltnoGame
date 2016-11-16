package com.marcelslum.ultnogame;

import java.util.ArrayList;

/**
 * Created by marcel on 02/08/2016.
 */
public class LevelLoader {
    public static void loadLevel(int levelNumber) {
        Level.LevelBuilder levelBuilder = new Level.LevelBuilder();
        levelBuilder
                .setBallsX_B1(0.3f)
                .setBallsY_B1(0.3f)
                .setBarsX_B1(0.3f)
                .setTargetsWidth(0.0895f)
                .setTargetsHeight(0.04f)
                .setTargetsDistance(0.001f)
                .setTargetsPadding(0.00225f)
                .setBarsScaleVariationOff()
                .setObstaclesScaleVariationOff()
                .setObstaclesPositionVariationOff()
                .setWindType(Level.WIND_TYPE_NO)
                .setSpecialBallPercentage0_1(0f)
                .setObstaclesQuantity(0)
                .setWindowsQuantity(0);
        if (levelNumber == 1) {
            levelBuilder.setTargetsMap(
                    new int[][]{
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
                    })
                    .setTargetsStates(new int[]{0, 1});
        }

        if (levelNumber >= 2) {
            levelBuilder
                    .setBallsAngleToRotate_BD_2(1.5f)//4f
                    //.setBallsMaxAngle_BD_55(2.182f)
                    //.setBallsMinAngle_BD_35(0.857f)
                    .setBallsVelocityVariation_BD_0_1(2f)
                    .setBallsVelocityMax_BD_1_3(1.467f)
                    .setBallsVelocityMin_BD_0_6(0.875f)
                    .setBarsWidth_BD_0_22(1.364f)
                    .setBarsX_B1(0.35f)
                    .setBarsVX_BD_0_0045(1.222f);
            if (levelNumber == 2) {
                levelBuilder.setTargetsMap(
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0}
                        })
                        .setTargetsStates(new int[]{0, 1});
            }
        }

        if (levelNumber >= 3) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.4f)
                    .setBallsVX(1.071f)
                    .setBallsVY(1.071f)
                    .setBallsAngleToRotate_BD_2(1f)
                    .setBallsMaxAngle_BD_55(1f)
                    .setBallsMinAngle_BD_35(1f)
                    .setBallsVelocityVariation_BD_0_1(1f)
                    .setBallsVelocityMax_BD_1_3(1f)
                    .setBallsVelocityMin_BD_0_6(1f)
                    .setBarsWidth_BD_0_22(0.909f)
                    .setBarsX_B1(0.3f)
                    .setBarsVX_BD_0_0045(1.111f);
            if (levelNumber == 3) {
                levelBuilder.setTargetsMap(
                        new int[][]{
                            {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                            {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                            {1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                        })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0);

                        //.setWindowsQuantity(0)
                        //.setWindowsHeight(0.5f)
                        //.setWindowsY(0.4f)
                        //.setWindowsDistance(0.2f)
                        //.setWindowsQuantityOfLines(6)
                        //.setWindowsVelocity(-0.003f)
                        //.setBarsScaleVariation(new ScaleVariationDataBuilder()
                        //        .setIsActive(false)
                        //        .setIncreaseWidth(false)
                        //        .setWidthVelocity(0.002f)
                        //        .setMinWidth_BI(0.5f)
                        //        .setMaxWidth_BI(2f));



            }
        }

        if (levelNumber >= 4) {
            levelBuilder
                    .setBallsQuantity(1)
                    .setBallsX_B1(0.1f)
                    .setBallsY_B1(0.6f)
                    .setBallsVX(1.071f)
                    .setBallsVY(1.071f)
                    .setBallsAngleToRotate_BD_2(1.1f)
                    .setBarsWidth_BD_0_22(0.818f)
                    .setBarsVX_BD_0_0045(1.111f);
            if (levelNumber == 4) {
                levelBuilder.setTargetsMap(
                        new int[][]{
                                {0,1,0,1,0,1,0,1,0,1,0},
                                {1,0,1,0,1,0,1,0,1,0,1},
                                {0,1,0,1,0,1,0,1,0,1,0}
                        })
                        .setTargetsStates(new int[]{0, 1})
                        .setObstaclesQuantity(1)
                        .setObstaclesX(0.45f)
                        .setObstaclesY(0.25f)
                        .setObstaclesWidth(0.1f)
                        .setObstaclesHeight(0.1f);

                    
                        /*
                        .setObstaclesPositionVariation(
                                new PositionVariationDataBuilder()
                                        .setIsActive(false)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.7f)
                                        .setMinY(0.3f)
                                        .setxVelocity(0.001f)
                                        .setyVelocity(0.001f),
                                new PositionVariationDataBuilder()
                                        .setIsActive(false)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.7f)
                                        .setMinY(0.3f)
                                        .setxVelocity(0.001f)
                                        .setyVelocity(0.001f),
                                new PositionVariationDataBuilder()
                                        .setIsActive(false)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.7f)
                                        .setMinY(0.3f)
                                        .setxVelocity(0.001f)
                                        .setyVelocity(0.001f)
                        )
                        .setObstaclesScaleVariation(
                            new ScaleVariationDataBuilder()
                            .setIsActive(false)
                            .setIncreaseWidth(true)
                            .setIncreaseHeight(true)
                            .setWidthVelocity(0.02f)
                            .setHeightVelocity(0.01f)
                            .setMinWidth_BI(0.5f)
                            .setMaxWidth_BI(4.5f)
                            .setMinHeight_BI(0.5f)
                            .setMaxHeight_BI(4.5f)
                        )
                        .setWindowsQuantity(0);
                        */
            }
        }


        if (levelNumber >= 5) {
            levelBuilder
                        .setBallsX_B1(0.2f)
                        .setBallsY_B1(0.45f)
                        .setBallsVX(1.143f)
                        .setBallsVY(1.143f)
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.35f, 0.5f)
                        .setObstaclesY(0.0925f, 0.2597f)
                        .setObstaclesWidth(0.15f, 0.15f)
                        .setObstaclesHeight(0.035f, 0.035f);
            if (levelNumber == 5) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0,1,1,1,0,1,0,1,1,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0},
                                        {0,1,1,1,0,1,0,1,1,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0},
                                        {1,1,1,1,1,1,1,1,1,1,1}
                                })
                .setTargetsStates(new int[]{0, 1});

            }
        }

        if (levelNumber >= 6) {
                levelBuilder
                        .setBallsMaxAngle_BD_55(1.0036f)
                        .setBallsMinAngle_BD_35(0.943f)
                        .setBallsVelocityVariation_BD_0_1(1.1f)
                        .setBallsVelocityMax_BD_1_3(1.6f)
                        .setBallsVelocityMin_BD_0_6(0.938f)
                        .setBarsWidth_BD_0_22(0.773f);
            if (levelNumber == 6) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                        {0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                        {0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}
                                })
                        .setTargetsStates(new int[]{0, 1})
                        .setObstaclesQuantity(1)
                        .setObstaclesX(0.46f)
                        .setObstaclesY(0.2f)
                        .setObstaclesWidth(0.08f)
                        .setObstaclesHeight(0.6f)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 7) {
            if (levelNumber == 7) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                                        {3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 8) {
                levelBuilder
                        .setBallsVX(1.214f)
                        .setBallsVY(1.214f)
                        .setBallsMaxAngle_BD_55(1.055f)
                        .setBallsMinAngle_BD_35(0.914f);
            if (levelNumber == 8) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 1, 2, 1, 3, 2, 3, 1, 1, 1, 1},
                                        {2, 2, 1, 1, 1, 3, 1, 1, 2, 2, 2},
                                        {1, 1, 2, 1, 3, 2, 3, 1, 1, 1, 1}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.31f, 0.64f)
                        .setObstaclesY(0.2f, 0.2f)
                        .setObstaclesWidth(0.02f, 0.02f)
                        .setObstaclesHeight(0.3f, 0.3f)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 9) {
            if (levelNumber == 9) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 1, 2, 4, 3, 0, 3, 1, 2, 1, 1},
                                        {2, 2, 1, 1, 1, 0, 1, 4, 1, 2, 2},
                                        {1, 1, 2, 1, 3, 0, 3, 1, 2, 1, 1},
                                        {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 10) {
            if (levelNumber == 10) {
                
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {3, 2, 1, 1, 0, 0, 0, 1, 1, 2, 3},
                                        {2, 2, 0, 1, 4, 0, 4, 1, 0, 2, 2},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(     0.425f,     0.425f)
                        .setObstaclesY(     0.1206f,      0.29f)
                        .setObstaclesHeight(0.044f,      0.044f)
                        .setObstaclesWidth(0.15f ,      0.15f)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 11) {
                levelBuilder.setBarsVX_BD_0_0045(1.133f);
            if (levelNumber == 11) {
                levelBuilder = new Level.LevelBuilder()
                        .setTargetsMap(
                                new int[][]{
                                        {0, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0},
                                        {1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1},
                                        {1, 3, 0, 1, 0, 0, 0, 1, 0, 3, 1},
                                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                        {1, 3, 2, 1, 0, 0, 0, 1, 2, 3, 1},
                                        {3, 2, 2, 1, 0, 0, 0, 1, 2, 2, 3},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 4, 0, 4, 0, 0, 0, 4, 0, 4, 0}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 12) {
           levelBuilder
                .setBallsX_B1(0.015f)
                .setBallsY_B1(0.55f);
            if (levelNumber == 12) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 2, 1, 0, 0, 0, 1, 2, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                                        {3, 0, 0, 3, 0, 0, 0, 3, 0, 0, 3}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(1)
                        .setObstaclesX(0.333f)
                        .setObstaclesY(0.43529f)
                        .setObstaclesHeight(0.0735294118f)
                        .setObstaclesWidth(0.333f)
                        .setObstaclesPositionVariation(
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.8f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0.001f)
                                        .setyVelocity(0))
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 13) {
            levelBuilder
                    .setBallsX_B1(0.127f)
                    .setBallsY_B1(0.5f);
            if (levelNumber == 13) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {4, 0, 1, 0, 4, 0, 1, 0, 1, 0, 1},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                                        {1, 0, 1, 0, 2, 0, 2, 0, 1, 0, 2},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.375f, 0.375f)
                        .setObstaclesY(0.1558823529f, 0.5854588235f)
                        .setObstaclesWidth(0.25f, 0.25f)
                        .setObstaclesHeight(0.0588235294f, 0.0588235294f)
                        .setObstaclesPositionVariation(
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.99f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0.001f)
                                        .setyVelocity(0),
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.99f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0.001f)
                                        .setIncreaseX(false)
                                        .setyVelocity(0))
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 14) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 14) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                                        {1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {0, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1},
                                        {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(1)
                        .setObstaclesX(0.475f)
                        .setObstaclesY(0.2038470588f)
                        .setObstaclesWidth(0.05f)
                        .setObstaclesHeight(0.1470588235f)
                        .setObstaclesPositionVariation(
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.9f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0f)
                                        .setyVelocity(0.00125f))
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 15) {
            levelBuilder
                    .setBallsX_B1(0.3f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 15) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                                        {1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                                        {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                                        {1, 1, 0, 1, 0, 4, 0, 1, 0, 1, 1},
                                        {0, 3, 1, 0, 1, 0, 1, 0, 1, 3, 0},
                                        {0, 0, 1, 1, 0, 4, 0, 1, 1, 0, 0},
                                        {1, 0, 0, 2, 1, 0, 1, 2, 0, 0, 1},
                                        {1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1},
                                        {0, 1, 1, 0, 0, 4, 0, 0, 1, 1, 0},
                                        {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                                        {0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
                                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},

                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)

                        .setObstaclesX(0.125f, 0.7916666667f)
                        .setObstaclesY(0.5676470588f, 0.5676470588f)
                        .setObstaclesWidth(0.0833f, 0.0833f)
                        .setObstaclesHeight(0.1764705882f, 0.1764705882f)
                        .setObstaclesPositionVariation(
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.9f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0f)
                                        .setyVelocity(0.00125f),
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.9f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0f)
                                        .setyVelocity(0.00125f))
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 16) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 16) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 1, 0, 2, 0, 2, 0, 2, 0, 1, 1},
                                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},

                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.4833333333f, 0.4583333333f)
                        .setObstaclesY(0.1661764706f, 0.4402882353f)
                        .setObstaclesWidth(0.0166666667f, 0.0833333333f)
                        .setObstaclesHeight(0.0588235294f, 0.0588235294f)
                        .setObstaclesPositionVariation(
                                null,
                                new PositionVariationDataBuilder()
                                        .setIsActive(true)
                                        .setMaxX(0.99f)
                                        .setMinX(0.01f)
                                        .setMaxY(0.9f)
                                        .setMinY(0.01f)
                                        .setxVelocity(0.00125f)
                                        .setyVelocity(0f))
                        .setObstaclesScaleVariation(
                                new ScaleVariationDataBuilder()
                                        .setIsActive(true)
                                        .setIncreaseWidth(true)
                                        .setIncreaseHeight(false)
                                        .setWidthVelocity(0.1f)
                                        .setHeightVelocity(0f)
                                        .setMinWidth_BI(1f)
                                        .setMaxWidth_BI(100000f)
                                        .setMinHeight_BI(1f)
                                        .setMaxHeight_BI(1f),
                                null
                        )
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 17) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 17) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 4, 1, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},

                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.55f, 0.35f)
                        .setObstaclesY(0.06675f, 0.3883470588f)
                        .setObstaclesWidth(0.1f, 0.1f)
                        .setObstaclesHeight(0.0605f, 0.0605f)
                        .setObstaclesScaleVariation(
                                new ScaleVariationDataBuilder()
                                        .setIsActive(true)
                                        .setIncreaseWidth(true)
                                        .setIncreaseHeight(false)
                                        .setWidthVelocity(0.01f)
                                        .setHeightVelocity(0f)
                                        .setMinWidth_BI(1f)
                                        .setMaxWidth_BI(100000f)
                                        .setMinHeight_BI(1f)
                                        .setMaxHeight_BI(1f),
                                new ScaleVariationDataBuilder()
                                        .setIsActive(true)
                                        .setIncreaseWidth(true)
                                        .setIncreaseHeight(false)
                                        .setWidthVelocity(0.012f)
                                        .setHeightVelocity(0f)
                                        .setMinWidth_BI(1f)
                                        .setMaxWidth_BI(100000f)
                                        .setMinHeight_BI(1f)
                                        .setMaxHeight_BI(1f)
                        )
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 18) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 18) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 0, 0, 1, 0, 2, 0, 1, 0, 0, 1},
                                        {0, 0, 1, 0, 0, 2, 0, 0, 1, 0, 0},
                                        {1, 0, 0, 1, 0, 2, 0, 1, 0, 0, 1},
                                        {0, 0, 1, 0, 0, 4, 0, 0, 1, 0, 0},
                                        {1, 0, 1, 1, 1, 4, 1, 1, 1, 0, 1},
                                        {1, 0, 1, 1, 0, 3, 0, 1, 1, 0, 1},
                                        {1, 0, 1, 1, 0, 3, 0, 1, 1, 0, 1},
                                        {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                                        {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                                })

                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.1176466667f, 0.8428633333f)
                        .setObstaclesY(0.4158558824f, 0.4158558824f)
                        .setObstaclesWidth(0.0416666667f, 0.0416666667f)
                        .setObstaclesHeight(0.0882352941f, 0.0882352941f)
                        .setObstaclesScaleVariation(
                                new ScaleVariationDataBuilder()
                                        .setIsActive(true)
                                        .setIncreaseWidth(true)
                                        .setIncreaseHeight(false)
                                        .setWidthVelocity(0f)
                                        .setHeightVelocity(0.012f)
                                        .setMinWidth_BI(1f)
                                        .setMaxWidth_BI(1f)
                                        .setMinHeight_BI(1f)
                                        .setMaxHeight_BI(100000f),
                                new ScaleVariationDataBuilder()
                                        .setIsActive(true)
                                        .setIncreaseWidth(true)
                                        .setIncreaseHeight(false)
                                        .setWidthVelocity(0f)
                                        .setHeightVelocity(0.012f)
                                        .setMinWidth_BI(1f)
                                        .setMaxWidth_BI(1f)
                                        .setMinHeight_BI(1f)
                                        .setMaxHeight_BI(100000f)
                        )
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 19) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 19) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                                        {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
                                        {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                                        {0, 1, 0, 1, 2, 0, 2, 1, 0, 1, 0},
                                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindType(Level.WIND_TYPE_RIGHT)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 20) {
            levelBuilder
                    .setBallsX_B1(0.2f)
                    .setBallsY_B1(0.7f);
            if (levelNumber == 20) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 2, 1, 1, 1, 4, 1, 1, 1, 2, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 1, 1, 1, 1, 3, 1, 1, 1, 1, 0},
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindType(Level.WIND_TYPE_LEFT)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 21) {
            if (levelNumber == 21) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {5, 0, 5, 0, 0, 0, 0, 0, 5, 0, 5},
                                        {0, 5, 0, 5, 0, 0, 0, 5, 0, 5, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0},
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 22) {
            if (levelNumber == 22) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                        {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2},
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                                        {0, 5, 0, 0, 0, 7, 0, 0, 0, 5, 0},
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 23) {

            levelBuilder
                    .setBallsX_B1(0.06f)
                    .setBallsY_B1(0.55f);

            if (levelNumber == 23) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                                        {0, 0, 0, 2, 0, 4, 0, 2, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 7, 4, 7, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 6, 5, 6, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 5, 6, 5, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 5, 5, 5, 0, 0, 0, 0},
                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(2)
                        .setObstaclesX(0.00225f, 0.63575f)
                        .setObstaclesY(0.3380882353f,      0.3380882353f)
                        .setObstaclesHeight(0.1652941176f,      0.1652941176f)
                        .setObstaclesWidth(0.361f,      0.361f)
                        .setWindType(Level.WIND_TYPE_LEFT)
                        .setWindowsQuantity(0);
            }
        }

        if (levelNumber >= 24) {

            levelBuilder
                .setBallsQuantity(2)
                .setBallsRadius_BD_0_01(1f, 1f)
                .setBallsInvencible(false, true)
                .setBallsX_B1(0.1f, 0.9f)
                .setBallsY_B1(0.55f, 0.55f)
                .setBallsVX(1.214f)
                .setBallsVY(1.214f)
                .setBallsAngleToRotate_BD_2(1.1f)
                .setBallsMaxAngle_BD_55(1.1f)
                .setBallsMinAngle_BD_35(1.055f)
                .setBallsVelocityVariation_BD_0_1(0.1f)
                .setBallsVelocityMax_BD_1_3(1f)
                .setBallsVelocityMin_BD_0_6(1f)
                .setBarsWidth_BD_0_22(0.909f);

        if (levelNumber == 24) {
            levelBuilder
                    .setTargetsMap(
                            new int[][]{
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                            })
                    .setTargetsStates(new int[]{0, 1, 2, 3})
                    .setObstaclesQuantity(0)
                    .setWindType(Level.WIND_TYPE_NO)
                    .setWindowsQuantity(0);
        }
    }

        if (levelNumber >= 25) {

            ArrayList<int[]> targetsAppend = new ArrayList<>();
            targetsAppend.add(new int[]{});
            targetsAppend.add(new int[]{55, 63, 64, 70, 71, 78});
            targetsAppend.add(new int[]{61, 68, 69, 75, 76, 84});

            levelBuilder
                    .setBallsQuantity(3)
                    .setBallsRadius_BD_0_01(1f, 1f, 1f)
                    .setBallsInvencible(false, true, true)
                    .setBallsFree(true, false, false)
                    .setBallsX_B1(0.1f, 0.1375f, 0.8615f)
                    .setBallsY_B1(0.58f, 0.4198529412f, 0.4198529412f)
                    .setBallsTargetsAppend(targetsAppend)
                    .setBallsVX(1.214f)
                    .setBallsVY(1.214f)
                    .setBallsAngleToRotate_BD_2(1.1f)
                    .setBallsMaxAngle_BD_55(1.1f)
                    .setBallsMinAngle_BD_35(1.055f)
                    .setBallsVelocityVariation_BD_0_1(0.1f)
                    .setBallsVelocityMax_BD_1_3(1f)
                    .setBallsVelocityMin_BD_0_6(1f)
                    .setBarsWidth_BD_0_22(0.909f);

            if (levelNumber == 25) {
                levelBuilder
                        .setTargetsMap(
                                new int[][]{
                                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                                        {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                                        {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},

                                })
                        .setTargetsStates(new int[]{0, 1, 2, 3})
                        .setObstaclesQuantity(0)
                        .setWindType(Level.WIND_TYPE_NO)
                        .setWindowsQuantity(0);
            }
        }


        Levels.levelObject = levelBuilder.build();
    }
}
/*

    ballsInitialX(new float[] {
        0.15f
    }).ballsInitialY(new float[]{0.6f}).ballsDesiredVelocityX(new float[]{0.0036f}).ballsDesiredVelocityY(new float[]{0.00564705882352941f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{55f}).ballsMinAngle(new float[]{35f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.5f}).ballsVelocityMinByInitialVelocity(new float[]{0.8f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.18f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.075176f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();
        game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1},
                            new int [][]{
                                    {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
                                    {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                                    {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}
                            }
                    );
                }

                @Override
                public void createObstacles() {
                    innerGame.addObstacle(new Obstacle("obstacle", innerGame,
                            gX*0.4f, gY*0.4f,
                            gX*0.2f, gY*0.04f
                            ));
                }

                @Override
                public void createWindows() {

                }
            });
            break;

        case 5:
            game.levelObject = new LevelBuilder().number(5).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.010f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0032f}).ballsDesiredVelocityY(new float[]{0.0056470588f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{55f}).ballsMinAngle(new float[]{35f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.5f}).ballsVelocityMinByInitialVelocity(new float[]{0.8f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.18f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {

                    createLevelTargets(new int[]{0, 1},
                            new int [][]{
                                    {0,1,1,1,0,1,0,1,1,1,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,1,1,1,0,1,0,1,1,1,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {1,1,1,1,1,1,1,1,1,1,1}
                            }
                    );
                }

                @Override
                public void createObstacles() {
                }

                @Override
                public void createWindows() {

                }
            });
            break;

        case 6:
            game.levelObject = new LevelBuilder().number(6).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.010f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0034f}).ballsDesiredVelocityY(new float[]{0.006f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{57f}).ballsMinAngle(new float[]{33f}).ballsVelocityVariation(new float[]{0.11f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1},
                            new int [][]{
                                    {0,0,0,0,0,0,0,0,1,1,1},
                                    {1,0,0,0,0,0,0,0,0,1,1},
                                    {1,0,0,0,0,0,0,0,0,0,1},
                                    {0,0,0,0,0,0,0,0,0,1,1},
                                    {0,1,0,0,0,0,0,0,1,1,1},
                                    {0,1,0,0,0,0,0,1,1,1,1},
                                    {0,0,0,0,0,0,1,0,1,0,1},
                                    {1,0,0,0,0,0,1,1,1,1,1},
                                    {1,0,0,0,0,0,1,1,1,1,1}
                            }
                    );
                }
                @Override
                public void createObstacles() {
                    innerGame.addObstacle(new Obstacle("obstacle", innerGame,
                            1f + innerGame.gameAreaResolutionX*0.46f,
                            innerGame.gameAreaResolutionY*0.2f,
                            innerGame.gameAreaResolutionX*0.08f,
                            innerGame.gameAreaResolutionY*0.05f
                    ));
                }

                @Override
                public void createWindows() {

                }
            });
            break;

        case 7:
            game.levelObject = new LevelBuilder().number(7).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.010f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0034f}).ballsDesiredVelocityY(new float[]{0.006f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{57f}).ballsMinAngle(new float[]{33f}).ballsVelocityVariation(new float[]{0.11f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1},
                            new int [][]{
                                    {0,3,3,3,3,3,3,3,3,3,3},
                                    {3,3,0,0,0,0,0,0,0,3,3}
                            }
                    );
                }
                @Override
                public void createObstacles(){}

                @Override
                public void createWindows() {}
            });
            break;

        case 8:
            game.levelObject = new LevelBuilder().number(8).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.010f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0035f}).ballsDesiredVelocityY(new float[]{0.0061764706f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{58f}).ballsMinAngle(new float[]{32f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1},
                            new int [][]{
                                    {1,1,2,1,3,2,3,1,1,1,1},
                                    {2,2,1,1,1,3,1,1,2,2,2},
                                    {1,1,2,1,3,2,3,1,1,1,1}
                            }
                    );
                }
                @Override
                public void createObstacles(){
                    innerGame.addObstacle(new Obstacle("obstacle", innerGame,
                            1f + innerGame.gameAreaResolutionX*0.31f,
                            innerGame.gameAreaResolutionY*0.2f,
                            innerGame.gameAreaResolutionX*0.02f,
                            innerGame.gameAreaResolutionY*0.3f
                    ));

                    innerGame.addObstacle(new Obstacle("obstacle", innerGame,
                            1f + innerGame.gameAreaResolutionX*0.64f,
                            innerGame.gameAreaResolutionY*0.2f,
                            innerGame.gameAreaResolutionX*0.02f,
                            innerGame.gameAreaResolutionY*0.3f
                    ));
                }

                @Override
                public void createWindows() {}
            });
            break;

        case 9:
            game.levelObject = new LevelBuilder().number(9).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.010f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0035f}).ballsDesiredVelocityY(new float[]{0.0061764706f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{58f}).ballsMinAngle(new float[]{32f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1, 2, 3},
                            new int [][]{
                                    {1,1,2,4,3,0,3,1,2,1,1},
                                    {2,2,1,1,1,0,1,4,1,2,2},
                                    {1,1,2,1,3,0,3,1,2,1,1},
                                    {1,1,1,1,1,4,1,1,1,1,1}
                            }
                    );
                }
                @Override
                public void createObstacles(){
                }

                @Override
                public void createWindows() {}
            });
            break;

        case 10:
            game.levelObject = new LevelBuilder().number(10).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.01f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0035f}).ballsDesiredVelocityY(new float[]{0.0061764706f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{58f}).ballsMinAngle(new float[]{32f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.005f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1, 2, 3},
                            new int [][]{
                                    {0,0,0,1,1,0,1,1,0,0,0},
                                    {0,0,0,1,1,0,1,1,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {3,2,1,1,0,0,0,1,1,2,3},
                                    {2,2,0,1,4,0,4,1,0,2,2},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {1,1,0,1,1,0,1,1,0,1,1}
                            }
                    );
                }
                @Override
                public void createObstacles(){

                    float posX = 0.1f;

                    for (int i = 0; i < 5; i++) {
                        innerGame.addObstacle(new Obstacle("obstacle", innerGame,
                                1f + innerGame.gameAreaResolutionX * posX + innerGame.gameAreaResolutionX*0.005f,
                                innerGame.gameAreaResolutionY * 0.12f,
                                innerGame.gameAreaResolutionX * 0.05f,
                                innerGame.gameAreaResolutionY * 0.2f
                        ));
                        innerGame.addObstacle(new Obstacle("obstacle", innerGame,
                                1f + innerGame.gameAreaResolutionX * posX + innerGame.gameAreaResolutionX*0.005f,
                                innerGame.gameAreaResolutionY * 0.29f,
                                innerGame.gameAreaResolutionX * 0.06f,
                                innerGame.gameAreaResolutionY * 0.2f
                        ));
                        posX += 0.185f;
                    }
                }

                @Override
                public void createWindows() {}
            });
            break;

        case 11:
            game.levelObject = new LevelBuilder().number(11).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.01f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0035f}).ballsDesiredVelocityY(new float[]{0.0061764706f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{58f}).ballsMinAngle(new float[]{32f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.0051f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1, 2, 3},
                            new int [][]{
                                    {0,3,0,1,0,0,0,1,0,3,0},
                                    {1,1,0,1,0,0,0,1,0,1,1},
                                    {1,3,0,1,0,0,0,1,0,3,1},
                                    {1,1,0,0,0,0,0,0,0,1,1},
                                    {1,3,2,1,0,0,0,1,2,3,1},
                                    {3,2,2,1,0,0,0,1,2,2,3},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,4,0,4,0,0,0,4,0,4,0}
                            }
                    );
                }
                @Override
                public void createObstacles(){
                }

                @Override
                public void createWindows() {}
            });
            break;

        case 12:
            game.levelObject = new LevelBuilder().number(12).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.01f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0035f}).ballsDesiredVelocityY(new float[]{0.0061764706f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{58f}).ballsMinAngle(new float[]{32f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.0051f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1, 2, 3},
                            new int [][]{
                                    {0,1,0,1,0,1,0,1,0,1,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {1,0,1,0,0,0,0,0,1,0,1},
                                    {0,1,0,1,0,0,0,1,0,1,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,4,0,0,0,0},
                            }
                    );
                }
                @Override
                public void createObstacles(){
                }

                @Override
                public void createWindows() {}
            });
            break;

        case 13:
            game.levelObject = new LevelBuilder().number(12).game(game).ballsQuantity(1).minBallsNotInvencibleAlive(1).ballsRadius(new float[]{0.01f}).ballsInitialX(new float[]{0.2f}).ballsInitialY(new float[]{0.4f}).ballsDesiredVelocityX(new float[]{0.0035f}).ballsDesiredVelocityY(new float[]{0.0061764706f}).ballsTextureMap(new int[]{Ball.COLOR_BALL_BLACK}).ballsIsInvencible(new boolean[]{false}).ballsAngleToRotate(new float[]{2.2f}).ballsMaxAngle(new float[]{58f}).ballsMinAngle(new float[]{32f}).ballsVelocityVariation(new float[]{0.1f}).ballsVelocityMaxByInitialVelocity(new float[]{1.6f}).ballsVelocityMinByInitialVelocity(new float[]{0.75f}).ballsTargetsAppend(new ArrayList<ArrayList<Target>>()).ballsFree(new boolean[]{true}).barsQuantity(1).barsSizeX(new float[]{0.17f}).barsSizeY(new float[]{0.0175f}).barsInitialX(new float[]{0.3f}).barsInitialY(new float[]{0.024f}).barsDesiredVelocityX(new float[]{0.0052f}).barsDesiredVelocityY(new float[]{0f}).targetWidth(0.0891f).targetHeight(0.04f).setTargetsDistanceByXResolution(0.0014f).setTargetsPaddingByXResolution(0.00225f).createLevel();

            game.levelObject.setEntitiesCreator(new Level.EntitiesCreator() {
                @Override
                public void createTargets() {
                    createLevelTargets(new int[]{0, 1, 2, 3},
                            new int [][]{
                                    {1,1,1,1,1,1,1,1,1,1,1},
                                    {2,0,2,0,2,0,2,0,2,0,2},
                                    {1,0,1,0,1,0,1,0,1,0,1},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,7,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,7,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {7,0,0,0,0,0,0,0,0,0,7},
                                    {0,7,0,0,0,7,0,0,0,7,0},
                            }
                    );
                }
                @Override
                public void createObstacles(){}

                @Override
                public void createWindows() {}
            });
            break;
        }
    }


    public static void  createTarget(int iX, int iY, int type, int[] states){
        if (type == 0){
            return;
        }

    }

    public static void createLevelTargets(int [] states, int [][] map){


    }

    */

