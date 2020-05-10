package com.e.birdbook;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer
{
    private MediaPlayer player = null;

    public AudioPlayer(Context context, int audioResource)
    {
        //this.player = new MediaPlayer();
        System.out.println("DEBUG: constructing audio player\n\n");
        if(player == null)
        {
            try
            {
                this.player = MediaPlayer.create(context, audioResource);
            }
            catch(Exception e)
            {
                System.out.println("YOYOYO");
                e.printStackTrace();
            }
        }
    }

    public void onPrepared(MediaPlayer player)
    {
        player.start();
    }

    public void toggleAudio()
    {
        if(this.player != null)
        {
            if (this.player.isPlaying())
                this.player.pause();
            else
                this.player.start();
        }
    }

}
