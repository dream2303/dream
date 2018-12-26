package com.example.dream.music;



import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.dream.music.DB.MusicDb;
import com.example.dream.music.DB.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicService {
    private Tool.PlayMode playMode = Tool.PlayMode.ORDER;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private List<Integer> playedMusicIndex = new ArrayList<>();;
    private String playingMusicPath;
    private int playingMusicPosition;
    private List<MusicDb> musicList;

    public int getProgress() {
        return mediaPlayer.getCurrentPosition();
    }

    public int getMusicLength() {
        return mediaPlayer.getDuration();
    }

    public String getMusicName(Context context) {
        musicList = Tool.getMusicList(context);
        return musicList.get(playingMusicPosition).getTitle();
    }


    public void setProgress(int time) {
        mediaPlayer.seekTo(time);
    }

public Tool.PlayMode getPlayMode(){
    return playMode;
}

    public  Tool.PlayMode setPlayMode(){
    if(playMode==Tool.PlayMode.ONE){
        playMode=Tool.PlayMode.ORDER;
    }
    else if(playMode==Tool.PlayMode.ORDER)
    {
        playMode=Tool.PlayMode.RANDOM;
    }
    else {
        playMode=Tool.PlayMode.ONE;
    }
    return playMode;
    }
    public void start(String path,int position){
        if (playingMusicPath == null || (playingMusicPath != null && !playingMusicPath.equals(path))) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
                mediaPlayer.start();
                playingMusicPosition = position;
                playingMusicPath = path;
                playedMusicIndex.add(position);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     else if (mediaPlayer.isPlaying()) {
        mediaPlayer.pause();
        }
        else {
        mediaPlayer.start();
    }
    }
    public void playpriorMusic(Context context) {
        musicList = Tool.getMusicList(context);
        if (playedMusicIndex.size() > 0) {
            playingMusicPosition = playedMusicIndex.remove(playedMusicIndex.size() - 1);
            play();
        } else if (playingMusicPosition == 0) {
            playingMusicPosition = musicList.size() - 1;
        } else {
            playingMusicPosition--;
        }
        play();
    }

    public void playNextMusic(Context context) {
        musicList = Tool.getMusicList(context);
        if (playMode == Tool.PlayMode.ONE) {
            play();
        } else if (playMode == Tool.PlayMode.ORDER) {
            if (playingMusicPosition == musicList.size() - 1) {
                playingMusicPosition = 0;
            } else {
                playingMusicPosition++;
            }
            play();
        } else {
            playingMusicPosition = ((int) (Math.random() * musicList.size()));
            play();
        }
        playedMusicIndex.add(playingMusicPosition);
    }
    private void play() {
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(musicList.get(playingMusicPosition).getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
