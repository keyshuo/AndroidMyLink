package com.example.mylink_10.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.mylink_10.R;

import java.util.Map;

public class SoundPlayer {
    private static MediaPlayer music;
    private static SoundPool sound;

    private static boolean musicSw = true;      //音乐开关
    private static boolean soundSw = true;      //音效开关
    private static Context context;

    private static final int[] musicId = {R.raw.bgm1, R.raw.bgm2, R.raw.bgm3};
    private static Map<Integer, Integer> soundMap;
    private static SharedPreferences sharedPreferences;


    /**
     * 初始化方法
     *
     * @param c
     */
    public static void init(Context c) {
        context = c;
        initMusic();
        initSound();
    }

    /**
     * 初始化音乐播放
     */
    private static void initMusic() {
        sharedPreferences = context.getSharedPreferences("option-config", Context.MODE_PRIVATE);
        int m = sharedPreferences.getInt("music", 0);
        music = MediaPlayer.create(context, SoundPlayer.musicId[m]);
        music.setLooping(true);                 //设置循环播放
    }

    /**
     * 初始化音效
     */
    private static void initSound() {
    }

    /**
     * 暂停音乐
     */
    public static void pauseMusic() {
        if (music.isPlaying()) {
            music.pause();
        }
    }

    /**
     * 播放音乐
     */
    public static void startMusic() {
        if (musicSw) {
            music.start();
        }
    }

    /**
     * 设置音乐开关
     * @param musicSw 开关状态
     */
    public static void setMusicSw(boolean musicSw) {
        SoundPlayer.musicSw = musicSw;
        if (musicSw) {
            music.start();
        } else {
            music.stop();
        }
    }

    /**
     * 更换音乐
     */
//    public static void changeMusic() {
//        if (music != null) {
//            music.release();
//        }
//        initMusic();
//        startMusic();
//    }

    public static boolean isMusicSw() {
        return musicSw;
    }
}
