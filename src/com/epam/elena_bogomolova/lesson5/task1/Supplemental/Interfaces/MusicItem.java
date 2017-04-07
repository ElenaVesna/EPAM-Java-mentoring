package com.epam.elena_bogomolova.lesson5.task1.Supplemental.Interfaces;


import com.epam.elena_bogomolova.lesson5.task1.Supplemental.WarningException;

public interface MusicItem {

    void playMusic() throws WarningException;
    void stopPlayingMusic();
}
