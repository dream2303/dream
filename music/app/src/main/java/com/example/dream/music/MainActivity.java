package com.example.dream.music;


import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.dream.music.DB.MusicDb;
import com.example.dream.music.DB.Tool;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
private ListView musiclistview;
private List<MusicDb> musiclist;
private SeekBar seekbar;
private TextView starttext;
private TextView playingtime;
private TextView totaltime;
private Button circlebtn;
private Button playbtn;
private Button nextbtn;
private Button priorbtn;
private String path;
private int Position;
private MusicService musicService=new MusicService();
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musiclistview=(ListView)findViewById(R.id.music_listView);
        musiclist= new ArrayList<>();
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            initListView();
        }
    }

    private void initListView(){
        musiclist = Tool.getMusicList(this);
        MusicAdapter adapter = new MusicAdapter(MainActivity.this,
                R.layout.message, musiclist);
        musiclistview.setAdapter(adapter);
        starttext=(TextView)findViewById(R.id.startText) ;
        playingtime=(TextView)findViewById(R.id.playingTime);
        seekbar=(SeekBar)findViewById(R.id.seekBar);
        totaltime=(TextView)findViewById(R.id.totalTime);
        circlebtn=(Button)findViewById(R.id.circle);
        priorbtn=(Button)findViewById(R.id.prior);
        playbtn=(Button)findViewById(R.id.play);
        nextbtn=(Button)findViewById(R.id.next);
        musiclistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicDb Db = musiclist.get(position);
                path=Db.getPath();
                Position=position;
                musicService.start(path,Position);
              updateProgress();
            }
        });

        seekbar.setMax(musicService.getMusicLength());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    musicService.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        circlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.setPlayMode();
                if(musicService.getPlayMode()==Tool.PlayMode.ONE) {
                    circlebtn.setText("单曲");
                }
                else if(musicService.getPlayMode()==Tool.PlayMode.ORDER) {
                    circlebtn.setText("顺序");
                }
                else{
                    circlebtn.setText("随机");
                }
            }
        });

        priorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.playpriorMusic(MainActivity.this);
                updateProgress();
            }
        });
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.start(path,Position);
            }
        });

       nextbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               musicService.playNextMusic(MainActivity.this);
               updateProgress();
           }
       });
    }
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(!starttext.getText().equals(musicService.getMusicName(MainActivity.this))){
                starttext.setText(musicService.getMusicName(MainActivity.this));
                playingtime.setText(Tool.parseTime(0));
                totaltime.setText((Tool.parseTime(musicService.getMusicLength())));
                seekbar.setProgress(0);
                seekbar.setMax(musicService.getMusicLength());
                updateProgress();
            }
            int progress = musicService.getProgress();
            seekbar.setProgress(progress);
            playingtime.setText(Tool.parseTime(progress));
            updateProgress();
            return true;
        }
    });


    private void updateProgress() {
        Message msg = Message.obtain();
        handler.sendMessageDelayed(msg, 1000);
    }

}
