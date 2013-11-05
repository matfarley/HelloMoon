package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	private MediaPlayer mPlayer;
	
	public void stop(){
		if(mPlayer != null){
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void play(Context c){
		stop(); //Prevents the creation of multiple instances of MediaPlayer
		
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop(); //Makes sure MediaPlayer only holds resources while it is in use.
				
			}
		});
		
		mPlayer.start();		
	}

}
