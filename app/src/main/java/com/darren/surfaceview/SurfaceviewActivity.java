package com.darren.surfaceview;


import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.darren.view_day01.R;

import java.io.IOException;

public  class SurfaceviewActivity extends AppCompatActivity {
	MediaPlayer mediaPlayer;
	SurfaceView mSurfaceView;
	Button mButtonStart;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surfaceview2);
		mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);
		mButtonStart = (Button) findViewById(R.id.button_start_surfaceView);
		if(mButtonStart!=null){
			mButtonStart.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if(mediaPlayer==null){
						mediaPlayer = new MediaPlayer();
					}
					mediaPlayer.reset();
					try {

						AssetFileDescriptor afd = getResources().getAssets().openFd("test.mp4");
						//Sets the data source (file-path or http/rtsp URL) to use,设置播放文件的路径
						mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(), afd.getLength());
						//Sets the audio stream type for this MediaPlayer，设置流的类型，此为音乐流
						mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
						//Sets the SurfaceHolder to use for displaying the video portion of the media，设置播放的容器
						mediaPlayer.setDisplay(mSurfaceView.getHolder());
						mediaPlayer.prepare();
						//Interface definition for a callback to be invoked when the media source is ready for playback
						mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
							@Override
							public void onPrepared(MediaPlayer mp) {
								mp.start();
							}
						});
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}


	}
}
