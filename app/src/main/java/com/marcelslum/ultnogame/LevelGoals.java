package com.marcelslum.ultnogame;

import java.util.ArrayList;

/**
 * Created by marcel on 14/12/2016.
 */

public class LevelGoals {

    public ArrayList<LevelGoal> levelGoals;
    int timesOfAngleDecrease = 0;
    int timesOfAngleIncrease = 0;
    int timesOfAccelerate = 0;
    int timesOfDecelerate = 0;
    int timesOfChangeBallSpeedInARow = 0;
    int timesOfObstacleHit = 0;
    int timesOfCollisionBetweenBalls = 0;
    int timesOfBallReachedWithMaximunBarSpped = 0;

    public int firstTimeLivingBalls = 0;

    public LevelGoals() {
        levelGoals = new ArrayList<>();
    }

    public void ballReachedWithMaximunBarSpped(){
        timesOfBallReachedWithMaximunBarSpped += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.REACH_BALL_WITH_MAXIMUN_BAR_SPEED && timesOfBallReachedWithMaximunBarSpped == lg.value){
                lg.setAchieved();
            }
        }
    }

    public void notifyBallsAlive(int number, int time){
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.KEEP_N_LIVING_BALLS && lg.value == number){
                lg.setAchieved();
            }

            if (lg.type == LevelGoal.KEEP_N_LIVING_BALLS_FOR_N_SECONDS && !lg.achieved){

                if (number >= lg.value){
                    if (firstTimeLivingBalls == 0){
                        firstTimeLivingBalls = time;
                    } else {
                        if (time - firstTimeLivingBalls >= lg.value2){
                            lg.setAchieved();
                        }
                    }
                } else {
                    if (firstTimeLivingBalls > 0){
                        firstTimeLivingBalls = 0;
                    }
                }
            }
        }
    }

    public void hitObstacle(){
        timesOfObstacleHit += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.HIT_OBSTACLE_N_TIMES){
                if (timesOfObstacleHit == lg.value) {
                    lg.setAchieved();
                } else if (timesOfObstacleHit < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfObstacleHit+" / "+lg.value);
                }
            }
        }
    }

    public void hitAnotherBall(){
        timesOfCollisionBetweenBalls += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.CAUSE_N_COLLISIONS_BETWEEN_BALLS){
                if (timesOfCollisionBetweenBalls == lg.value) {
                    lg.setAchieved();
                } else if (timesOfCollisionBetweenBalls < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfCollisionBetweenBalls+" / "+lg.value);
                }


                lg.setAchieved();
            }
        }
    }

    public void setFinish(int seconds){
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.JUST_FINISH){
                lg.setAchieved();
            }

            if (lg.type == LevelGoal.FINISH_IN_N_SECONDS && seconds <= lg.value){
                lg.setAchieved();
            }

            if (lg.type == LevelGoal.FINISH_LEVEL_WITHOUT_CHANGE_SPEED && timesOfAccelerate == 0 && timesOfDecelerate == 0){
                lg.setAchieved();
            }
        }
    }

    public void reachMaximunAngle(){
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.REACH_MAXIMUN_ANGLE){
                lg.setAchieved();
            }
        }
    }

    public void reachMinimunAngle(){
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.REACH_MINIMUN_ANGLE){
                lg.setAchieved();
            }
        }
    }

    public void increaseAngle(){
        timesOfAngleIncrease += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.INCREASE_ANGLE_N_TIMES){
                if (timesOfAngleIncrease == lg.value) {
                    lg.setAchieved();
                } else if (timesOfAngleIncrease < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfAngleIncrease+" / "+lg.value);
                }
            }
        }
    }

    public void decreaseAngle(){
        timesOfAngleDecrease += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.DECREASE_ANGLE_N_TIMES){
                if (timesOfAngleDecrease == lg.value) {
                    lg.setAchieved();
                } else if (timesOfAngleDecrease < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfAngleDecrease+" / "+lg.value);
                }
            }
        }
    }

    public void accelerateMaximun(){
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.ACCELERATE_MAXIMUN){
                lg.setAchieved();
            }
        }
    }

    public void decelerateMinimun(){
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.DECELERATE_MINIMUN){
                lg.setAchieved();
            }
        }
    }

    public void notifyNotSpeedChange(){
        timesOfChangeBallSpeedInARow = 0;
    }

    public void acelerate(){
        timesOfAccelerate += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.ACCELERATE_N_TIMES){
                if (timesOfAccelerate == lg.value) {
                    Game.messages.showMessage(lg.messageText + " " + timesOfAccelerate+" / "+lg.value);
                    lg.setAchieved();
                } else if (timesOfAccelerate < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfAccelerate+" / "+lg.value);
                }
            }
        }
        speedChange();
    }

    public void decelerate(){
        timesOfDecelerate += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.DECELERATE_N_TIMES){
                if (timesOfDecelerate == lg.value) {
                    Game.messages.showMessage(lg.messageText + " " + timesOfDecelerate+" / "+lg.value);
                    lg.setAchieved();
                } else if (timesOfDecelerate < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfDecelerate+" / "+lg.value);
                }
            }
        }
        speedChange();
    }

    public void speedChange(){
        timesOfChangeBallSpeedInARow += 1;
        for (int i = 0; i < levelGoals.size(); i++){
            LevelGoal lg = levelGoals.get(i);
            if (lg.type == LevelGoal.CHANGE_BALL_SPEED_N_TIMES_IN_A_ROW){
                if (timesOfChangeBallSpeedInARow == lg.value) {
                    lg.setAchieved();
                } else if (timesOfChangeBallSpeedInARow < lg.value){
                    Game.messages.showMessage(lg.messageText + " " + timesOfChangeBallSpeedInARow+" / "+lg.value);
                }
            }
        }
    }

    public void addLevelGoal(int numberOfStars, int type, int value){
        this.levelGoals.add(new LevelGoal(numberOfStars, type, value));
    }

    public int getStarsAchieved() {
        int stars = 0;
        for (int i = 0; i < levelGoals.size(); i++){
            if (levelGoals.get(i).achieved){
                stars += levelGoals.get(i).numberOfStars;
            }
        }
        if (stars > 5){
            stars = 5;
        }
        return stars;
    }
}
