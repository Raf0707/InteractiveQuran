package raf.tabiin.quraninteractive.util;

import android.media.MediaPlayer;

public class StandartMediaPlayer {
    private MediaPlayer mediaPlayer;
    private int currentPosition;

    static MediaPlayer instance;

    public StandartMediaPlayer() {
        mediaPlayer = new MediaPlayer();
    }

    public void play(String filePath) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            currentPosition = mediaPlayer.getCurrentPosition();
        }
    }

    public void resume() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(currentPosition);
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.reset();
        currentPosition = 0;
    }

    public void release() {
        stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public static MediaPlayer getInstance(){
        if(instance == null){
            instance = new MediaPlayer();
        }
        return instance;
    }

}
