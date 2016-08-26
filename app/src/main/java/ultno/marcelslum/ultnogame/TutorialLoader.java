package ultno.marcelslum.ultnogame;

/**
 * Created by marcel on 02/08/2016.
 */
public class TutorialLoader {
    private static TutorialLoader ourInstance = new TutorialLoader();

    public static TutorialLoader getInstance() {
        return ourInstance;
    }

    private TutorialLoader() {
    }

    public static void loadTutorial(Game game, int levelNumber){

        final Timer timer = new Timer();
        final Game g = game;
        final float gX = game.gameAreaResolutionX;
        final float gY = game.gameAreaResolutionY;
        float size = gX*0.03f;
        float width = gX*0.6f;
        float x = gX*0.2f;
        float y = gY*0.2f;

        switch (levelNumber){
            case 1:
                // L1T1
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox1", g)
                                .position(x, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l1t1))
                                .withArrow(gX *0.4f, gY *0.9f)
                                .build()
                        )
                        .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                            @Override
                            public void onShowBeforeAnim() {
                                    g.balls.get(0).clearDisplay();
                                    g.bars.get(0).isMovable = true;
                                }
                            }
                        )
                        .build()
                );
                
                // L1T2
                game.levelObject.tutorials.add(
                    new Tutorial.TutorialBuilder(
                        new TextBox.TextBoxBuilder("textoBox2", g)
                            .position(x, y)
                            .width(width)
                            .size(size)
                            .text(Utils.getStringResource(game, R.string.l1t2))
                            .withArrow(gX *0.7f, gY *0.85f)
                            .build()
                    )
                   .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                        @Override
                        public void onShowBeforeAnim() {
                                g.balls.get(0).display();
                                g.balls.get(0).x = gX * 0.7f;
                                g.balls.get(0).y = gY * 0.85f;
                                g.bars.get(0).isMovable = false;
                                g.bars.get(0).x = g.levelObject.barsInitialPositionX.get(0);
                            }
                        }
                    )
                    .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                
                                createAnimation2v(g.balls.get(0), "translateX", "translateX", 2000, 
                                    0f, 0f, 0.3f, gX * 0.15f, true, true).start();
                                    
                                createAnimation2v(g.balls.get(0), "translateY", "translateY", 2000, 
                                    0f, 0f, 0.3f, gY * 0.14f, true, true).start();
                                    
                                // TODO xVermelho
                                /*
                                    xVermelho.position = V(self.gameArea.resolution.x * 0.75, self.gameArea.resolution.y * 0.85);
                                    xVermelho.size= V(self.gameArea.resolution.x * 0.06, self.gameArea.resolution.y * 0.09);
                                    xVermelho.alpha = 0;
                                    xVermelho.display();
                                    ANIM.createAnimation(xVermelho, 'animXVermelho', 'alpha', 1500, [[0,0],[0.5,0.4],[1,0]], true, true, 0).start();
                                */
                                
                            }
                        }
                    )
                    .onUnshowBeforeAnim(new Tutorial.OnUnshowBeforeAnim() {
                        @Override
                        public void onUnshowBeforeAnim() {
                                g.resetAllAnimations();
                                // TODO xVermelho clearDisplay()
                            }
                        }
                    )
                    .build()
                );       
                // L1T3
                game.levelObject.tutorials.add(
                    new Tutorial.TutorialBuilder(
                        new TextBox.TextBoxBuilder("textoBox3", g)
                            .position(x, y*2.5f)
                            .width(width)
                            .size(size)
                            .text(Utils.getStringResource(game, R.string.l1t3))
                            .withArrow(gX *0.5f, gY *0.1f)
                            .build()
                    )
                   .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                        @Override
                        public void onShowBeforeAnim() {
                                g.balls.get(0).x = gX * 0.4f;
                                g.balls.get(0).y = gY * 0.15f;
                            }
                        }
                    )
                    .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                createAnimation2v(g.balls.get(0), "translateX", "translateX", 2000, 
                                    0f, 0f, 0.3f, gX * 0.15f, true, true).start();
                                createAnimation2v(g.balls.get(0), "translateY", "translateY", 2000, 
                                    0f, 0f, 0.3f, gY * 0.14f, true, true).start();
                                createAnimation3v(g.balls.get(0), "alpha", "alpha", 2000, 
                                    0f, 0f, 0.25f, 1f, 0.4f, 0f, true, true).start();   
                            }
                        }
                    )
                    .build()
                );
                
                // L1T4
                game.levelObject.tutorials.add(
                    new Tutorial.TutorialBuilder(
                        new TextBox.TextBoxBuilder("textoBox4", g)
                            .position(x, y*2f)
                            .width(width)
                            .size(size)
                            .text(Utils.getStringResource(game, R.string.l1t4))
                            .withArrow(gX *0.5f, gY *0.95f)
                            .build()
                    )
                    .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                g.resetAllAnimations();
                                g.targets.get(4).clearDisplay();
                                g.balls.get(0).x = gX * 0.5f;
                                g.balls.get(0).y = gY * 0.05f;
                                g.scorePanel.setValue(100, true, 500, false);
                            }
                        }
                    )
                    .build()
                );
                
                // L1T5
                game.levelObject.tutorials.add(
                    new Tutorial.TutorialBuilder(
                        new TextBox.TextBoxBuilder("textoBox5", g)
                            .position(x, y*2f)
                            .width(width)
                            .size(size)
                            .text(Utils.getStringResource(game, R.string.l1t5))
                            .withArrow(gX *0.5f, gY *0.95f)
                            .build()
                    )
                    .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                for (int i = 0; i < g.targets.size(); i++){
                                    if (i != 4){
                                        g.targets.reduceAlpha(500, 0f);
                                    }
                                }
                                
                                g.balls.get(0).x = gX * 0.5f;
                                g.balls.get(0).y = gY * 0.05f;
                                g.scorePanel.setValue(900, true, 500, false);
                            }
                        }
                    )
                    .build()
                );
                
                // L1T6
                final TimerTask ttl1t6 = new TimerTask() {
                    @Override
                    public void run() {
                        g.scorePanel.setValue(g.scorePanel.value - 10, false, 1000, false);
                    };
                }

                game.levelObject.tutorials.add(
                    new Tutorial.TutorialBuilder(
                        new TextBox.TextBoxBuilder("textoBox6", g)
                            .position(x, y*2f)
                            .width(width)
                            .size(size)
                            .text(Utils.getStringResource(game, R.string.l1t6))
                            .withArrow(gX *0.5f, gY *0.95f)
                            .build()
                    )
                    .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                timer.scheduleAtFixedRate(ttl1t6, 0, 1000);
                            }
                        }
                    )
                    .build()
                );
                
                // L1T7
                game.levelObject.tutorials.add(
                    new Tutorial.TutorialBuilder(
                        new TextBox.TextBoxBuilder("textoBox7", g)
                            .position(x, y*2f)
                            .width(width)
                            .size(size)
                            .text(Utils.getStringResource(game, R.string.l1t7))
                            .withoutArrow()
                            .build()
                    )
                    .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                ttl1t6.cancel();
                                timer.cancel();
                                timer.purgue();
                            }
                        }
                    )
                    .build()
                );
                break;
                
                case 2:
                // L2T1
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox1", g)
                                .position(x*0.5f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l1t2))
                                .withoutArrow()
                                .build()
                        )
                        .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                            @Override
                            public void onShowBeforeAnim() {
                                    g.balls.get(0).x = gX * 0.3f;
                                    g.balls.get(0).y = gY * 0.72f;
                                }
                            }
                        )
                        .build()
                );
                
                // L2T2
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox2", g)
                                .position(x*0.25f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l1t2))
                                .withoutArrow()
                                .build()
                        )
                        .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                            @Override
                            public void onShowBeforeAnim() {
                                    g.balls.get(0).x = gX * 0.3f;
                                    g.balls.get(0).y = gY * 0.72f;
                                }
                            }
                        )
                        .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                    createAnimation3v(g.balls.get(0), "translateX", "translateX", 3000, 
                                        0f, 0f, 0.25f, gX*0.15f, 0.5f, gX*0.4f, true, true).start();
                                    createAnimation3v(g.balls.get(0), "translateY", "translateY", 3000, 
                                        0f, 0f, 0.25f, gY*0.26f, 0.5f, -gY*0.3f, true, true).start();
                                    createAnimation2v(g.bars.get(0), "translateX", "translateX", 3000, 
                                        0f, 0f, 0.5f, -gX*0.4f, true, true).start();   
                                }
                            }
                        )
                        .build()
                );
                
                // L2T3
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox3", g)
                                .position(x*0.25f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l1t3))
                                .withoutArrow()
                                .build()
                        )
                        .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                            @Override
                            public void onShowBeforeAnim() {
                                    g.balls.get(0).clearAnimations();
                                    g.bars.get(0).clearAnimations();
                                    g.balls.get(0).x = gX * 0.3f;
                                    g.balls.get(0).y = gY * 0.72f;
                                    g.bars.get(0).x = gX * 0.1f;
                                }
                            }
                        )
                        .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                    createAnimation3v(g.balls.get(0), "translateX", "translateX", 3000, 
                                        0f, 0f, 0.25f, gX*0.15f, 0.5f, gX*0.2f, true, true).start();
                                    createAnimation3v(g.balls.get(0), "translateY", "translateY", 3000, 
                                        0f, 0f, 0.25f, gY*0.26f, 0.5f, gY*0.15f, true, true).start();
                                    createAnimation2v(g.bars.get(0), "translateX", "translateX", 3000, 
                                        0f, 0f, 0.5f, gX*0.4f, true, true).start();   
                                }
                            }
                        )
                        .onUnshowBeforeAnim(new Tutorial.OnUnshowBeforeAnim() {
                            @Override
                            public void onUnshowBeforeAnim() {
                                    g.balls.get(0).clearAnimations();
                                    g.bars.get(0).clearAnimations();
                                }
                            }
                        )
                        .build()
                );
                
                // L2T4
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox4", g)
                                .position(x*0.25f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l1t4))
                                .withoutArrow()
                                .build()
                        )
                        .build()
                );
                break;
                
                case 4:
                // L4T1
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox1", g)
                                .position(x*0.5f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l4t1))
                                .withArrow(gX*0.6f, gY*0.48f)
                                .build()
                        )
                        .build()
                );
                break;
                
                case 7:
                // L7T1
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox1", g)
                                .position(x*0.5f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l7t1))
                                .withArrow(gX*0.6f, gY*0.08f)
                                .build()
                        )
                        .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                            @Override
                            public void onShowBeforeAnim() {
                                    g.balls.get(0).clearDisplay();
                                }
                            }
                        )
                        .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                    createAnimation3v(g.targets.get(4), "alpha", "alpha", 3000, 
                                        0f, 1f, 0.75f, 0.99f, 1f, 0, true, true).start(); 
                                    ArrayList<float[]> valuesAnimTarget = new ArrayList<>();
                                        valuesAnimTarget.add(new float[]{0f,3f});
                                        valuesAnimTarget.add(new float[]{0.25f,2f});
                                        valuesAnimTarget.add(new float[]{0.5f,1f});
                                        valuesAnimTarget.add(new float[]{0.75f,0f});
                                    Animation animTarget = new Animation(g.targets.get(4), "animTarget", "numberForAnimation", 3000, 
                                        valuesAnimTarget, true, false);
                                        animTarget.setOnChangeNotFluid(new Animation.OnChange() {
                                            @Override
                                            public void onChange() {
                                                if (innerMessageInGame.numberForAnimation == 3f){
                                                    g.targets.get(4).setType(Target.COLOR);
                                                } else if (innerMessageInGame.numberForAnimation == 3f) {
                                                    g.targets.get(4).setType(Target.COLOR);
                                                } else if (innerMessageInGame.numberForAnimation == 1f) {
                                                    g.targets.get(4).setType(Target.COLOR); 
                                                } else if (innerMessageInGame.numberForAnimation == 0f) {
                                                    g.targets.get(4).setType(Target.COLOR);
                                                }
                                            }
                                        });
                                        animTarget.start();
                                    }
                                }
                            )
                            .onShowBeforeAnim(new Tutorial.OnShowBeforeAnim() {
                                @Override
                                public void onShowBeforeAnim() {
                                        g.targets.get(4).clearAnimations();
                                        g.targets.get(4).alpha = 1f;
                                        g.targets.setType(Target.COLOR)
                                    }
                                }
                            )
                            
                        )
                        .build()
                );
                break;
                
                case 9:
                // L9T1
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox1", g)
                                .position(x*0.5f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l9t1))
                                .withoutArrow()
                                .build()
                        )
                        .build()
                );
                
                // L9T2
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox2", g)
                                .position(x*0.5f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l9t2))
                                .withArrow(gX*0.5f, gY*0.25f)
                                .build()
                        )
                        .build()
                );
                
                // L9T3
                game.levelObject.tutorials.add(
                        new Tutorial.TutorialBuilder(
                            new TextBox.TextBoxBuilder("textoBox3", g)
                                .position(x*0.5f, y)
                                .width(width)
                                .size(size)
                                .text(Utils.getStringResource(game, R.string.l9t3))
                                .withoutArrow()
                                .build()
                        )
                        .onShowAfterAnim(new Tutorial.OnShowAfterAnim() {
                            @Override
                            public void onShowAfterAnim() {
                                
                                
                                float posX = gX * 0.6f;
                                float posY = gY * 0.28f;
                                
                                g.balls.get(0).x = posX;
                                g.balls.get(0).y = posY;
                                
                                float size = g.balls.get(0).radius;
                                
                                Ball ball2 = new Ball("ball2", g, posX - size * 2, posY - size * 2, size, 8);
                                    ball2.program = this.game.imageProgram;
                                    ball2.textureUnit = Game.TEXTURE_BUTTONS_AND_BALLS;
                                    ball2.setTextureUnitAndUvData(COLOR_BALL_BLUE);
                                
                                Ball ball3 = new Ball("ball2", g, posX + size * 2, posY - size * 2, size, 8);
                                    ball3.program = this.game.imageProgram;
                                    ball3.textureUnit = Game.TEXTURE_BUTTONS_AND_BALLS;
                                    ball3.setTextureUnitAndUvData(COLOR_BALL_ORANGE);
                                
                                Ball ball4 = new Ball("ball2", g, posX - size * 2, posY + size * 2, size, 8);
                                    ball4.program = this.game.imageProgram;
                                    ball4.textureUnit = Game.TEXTURE_BUTTONS_AND_BALLS;
                                    ball4.setTextureUnitAndUvData(COLOR_BALL_RED);
                                
                                Ball ball5 = new Ball("ball2", g, posX + size * 2, posY + size * 2, size, 8);
                                    ball5.program = this.game.imageProgram;
                                    ball5.textureUnit = Game.TEXTURE_BUTTONS_AND_BALLS;
                                    ball5.setTextureUnitAndUvData(COLOR_BALL_PINK);
                            
                                g.addBall(ball2);
                                g.addBall(ball3);
                                g.addBall(ball4);
                                g.addBall(ball5);
                                
                                    
                            }
                        )
                        .build()
                );
                
                break;
        }
    }
}
