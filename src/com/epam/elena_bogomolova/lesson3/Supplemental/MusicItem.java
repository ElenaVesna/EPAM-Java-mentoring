package com.epam.elena_bogomolova.lesson3.Supplemental;


import com.epam.elena_bogomolova.lesson3.WarningException;

public interface MusicItem {

    void playMusic() throws WarningException;
    void stopPlayingMusic();
}
