package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.*;

public class PC extends Equipment implements MusicItem, VideoItem, GameItem, PlannedActions {

    public PC(String place) {
        super(place);
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void planStart(long startTime) {

    }

    @Override
    public void planStop(long stopTime) {

    }

    @Override
    public void startSleepMode() {

    }

    @Override
    public void stopSleepMode() {

    }

    @Override
    public void playGames() {

    }

    @Override
    public void playVideo() {

    }
}
