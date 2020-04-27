package com.e.birdbook;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer
{
    private MediaPlayer player;

    public AudioPlayer(Context context, int audioResource)
    {
        this.player = new MediaPlayer();
        try
        {
            this.player = MediaPlayer.create(context, audioResource);
            this.player.prepare();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void toggleAudio()
    {
        if (this.player.isPlaying())
            this.player.pause();
        else
            this.player.start();

    }

}
