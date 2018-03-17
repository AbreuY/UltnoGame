package com.marcelslum.ultnogame;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by marcel on 17/09/2016.
 */
public abstract class Sound {

    public static SoundPool soundPool;

    public static SoundPool soundPoolBallHit1;
    public static SoundPool soundPoolBallHit2;
    public static SoundPool soundPoolBallHit3;
    public static SoundPool soundPoolBallHit4;

    public static int soundBallHit;
    public static int soundBallHit2;
    public static int soundBallHit3;
    public static int soundBallHit4;

    public static int soundCounter;
    public static int soundDestroyTarget;
    public static int soundScore;
    public static int soundAlarm;
    public static int soundBallFall;
    public static int soundBlueBallExplosion;
    public static int soundExplosion;
    public static int soundGameOver;
    public static int soundMenuSelectBig;
    public static int soundMenuSelectSmall;

    public static int soundTextBoxAppear;
    public static int soundBarSize;
    public static int soundWind;
    public static int soundSuccess1;
    public static int soundSuccess2;
    public static int soundMenuIconDrop2;
    public static int soundStarsUp;
    public static int soundDuplicateBall;
    public static int soundWin1;
    public static int soundWin2;

    public static LoopMediaPlayer loopMenu;
    public static LoopMediaPlayer loop;

    public static String TAG = "Sound";

    public static AudioTrack mAudioTrack;


    public static SoundPool soundPoolBallHit;
    
    


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    public static void init(){

        //Log.e(TAG, "init loading sounds");

        AudioAttributes audioAttrib = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        soundPool = new SoundPool.Builder().setAudioAttributes(audioAttrib).setMaxStreams(8).build();
        soundBallHit = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.ballhit1, 1);
        soundDestroyTarget = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.destroy_target, 1);
        soundMenuSelectBig = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.menuselectbig, 1);
        soundMenuSelectSmall = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.menuselectsmall, 1);
        soundMenuIconDrop2 = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.bells9, 1);
        soundCounter = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.counter, 1);
        soundAlarm = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.alarm, 1);
        soundBallFall = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.ballfall, 1);
        soundBlueBallExplosion = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.blueballexplosion, 1);
        soundExplosion = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.explosion, 1);
        soundGameOver = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.gameover2, 1);
        soundScore = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.score, 1);
        soundWin1 = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.win0_powerup17, 1);
        soundWin2 = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.win1_powerup16, 1);
        soundTextBoxAppear = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.textboxappear, 1);
        soundBarSize = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.bar, 1);
        soundWind = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.wind, 1);
        soundSuccess1 = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.success1, 1);
        soundSuccess2 = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.success2, 1);
        soundStarsUp = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.starsup, 1);
        soundDuplicateBall = soundPool.load(Game.mainActivity.getApplicationContext(), R.raw.duplicateball, 1);

        ByteBuffer pcm;
        byte[] music;
        try {

            InputStream input = Game.mainActivity.getResources().getAssets().open("destroy_target.wav");
            WavToPCM.WavInfo info = WavToPCM.readHeader(input);
            pcm = ByteBuffer.wrap(WavToPCM.readWavPcm(info, input));
            music = pcm.array();

            mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, music.length,
                    AudioTrack.MODE_STATIC);

            mAudioTrack.write(music, 0, music.length);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static long lastBallHit = -500;
    static long actualTime;
    static int lastBallHitId;


    public static void PlayShortAudioFileViaAudioTrack()
    {
        mAudioTrack.stop();
        mAudioTrack.play();
    }


    public static int playBallHit(int id, float left, float right, int loop){


        PlayShortAudioFileViaAudioTrack();

        return 1;

                /*

        loop = 0;

        actualTime = Utils.getTime();
        if (actualTime - lastBallHit < 100){
            Log.e(TAG, "Não tocando o som. Muito próximo da ultima vez.");
            return -1;
        } else {
            soundPool.stop(lastBallHitId);
        }
        lastBallHit = actualTime;
        
        
        

        if (SaveGame.saveGame == null || SaveGame.saveGame.sound) {
            if (soundPool != null) {
                lastBallHitId = soundPool.play(soundBallHit, left * 1f, right * 1f, 0, loop, 1);
                return lastBallHitId;
            } else {
                Log.e(TAG, "Não tocando o som. SoundPool nulo.");
                return -1;
            }
        } else {
            Log.e(TAG, "Não tocando o som. SaveGame.saveGame.sound = false.");
            return -1;
        }
        */
    }

    public static int play(int id, float left, float right, int loop){

        loop = 0;

        if (SaveGame.saveGame == null || SaveGame.saveGame.sound) {
                if (soundPool != null) {
                    //Log.e(TAG, "Tocando o som " + id + "volume " + left + " ; "+ right);
                        return soundPool.play(id, left * 1f, right * 1f, 0, loop, 1);
                } else {
                    Log.e(TAG, "Não tocando o som. SoundPool nulo.");
                    return -1;
                }
        } else {
            Log.e(TAG, "Não tocando o som. SaveGame.saveGame.sound = false.");
            return -1;
        }

    }

    public static void pauseAll(){
        if (soundPool != null) {
            soundPool.autoPause();
        }

        //if (soundPoolBallHit != null){
        //    soundPoolBallHit.autoPause();
        //}

        if (loop != null){
            loop.pause();
        }
    }

    
    public static void checkLoopPlaying(){
        if (Game.gameState == Game.GAME_STATE_JOGAR){
            //Log.e(TAG, "check loop playing");
            if (loop == null){
                //Log.e(TAG, "loop nulo, criando novo");
                loadLoop();
                return;
            }
            
            try {
                loop.play();
            } catch (Exception e) {
                //Log.e(TAG, "loop play falhou, criando novo");
                loop = null;
                loadLoop();
                return;
            }
            
            try {
                loop.isPlaying();
            } catch (Exception e) {
                //Log.e(TAG, "loop isPlaying falhou, criando novo");
                loop = null;
                loadLoop();
            }
        }
    }
    
    public static void loadLoop(){
        int loopChoose = (SaveGame.saveGame.currentLevelNumber-1) % 3;
        //Log.e(TAG, "loopChoose "+ loopChoose);
        switch (loopChoose){
            case 0:
                Sound.loop = LoopMediaPlayer.create(Game.mainActivity, R.raw.m1_hypnotic_puzzle2, R.raw.m3_hypnotic_puzzle4, 0.8f);
                break;
            case 1:
                Sound.loop = LoopMediaPlayer.create(Game.mainActivity, R.raw.m2_hypnotic_puzzle3, R.raw.m4_hypnotic_puzzle, 0.8f);
                break;
            case 2:
                Sound.loop = LoopMediaPlayer.create(Game.mainActivity, R.raw.m10_mellow_puzzler, 0.8f);
                break;
            default:
                Sound.loop = LoopMediaPlayer.create(Game.mainActivity, R.raw.m1_hypnotic_puzzle2, R.raw.m3_hypnotic_puzzle4, 0.8f);
                break;
        }
    }

}
