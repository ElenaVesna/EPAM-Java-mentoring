package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.*;

import java.util.Scanner;

public class PC extends Equipment implements MusicItem, VideoItem, GameItem, PlannedActions {


    public PC(String place, String name) {
        super(17, place, name);
    }

    @Override
    public void playMusic() {
        System.out.println("Choose the album number and press enter to play!");
        System.out.println("1 - Deep Purple, 2 - Depeche Mode, 3 - The Beatles");
        Scanner sc = new Scanner(System.in);
        String album = sc.nextLine();
        System.out.println(album + " album started to play. Enjoy!");
        power = power + 15;
    }

    @Override
    public void stopPlayingMusic() {
        System.out.println("music playing stopped");
        power = power - 15;
    }

    @Override
    public void planStart(long startTime) {
        if (startTime >= System.currentTimeMillis()) {
            power = idlePower;
        }
    }

    @Override
    public void planStop(long stopTime) {
        if (stopTime >= System.currentTimeMillis()) {
            power = 0;
            System.out.println("PC is turning off. Goodbye!");
        }
    }

    @Override
    public void startSleepMode() {
        if (state) {
            System.out.println("PC is in sleep mode now");
            idle = true;
            power = idlePower - 10;
        } else System.out.println("PC cannot sleep when it is not turned on");
    }

    @Override
    public void stopSleepMode() {
        System.out.println("PC's awaken");
        power = idlePower;
    }

    @Override
    public void playGames() {
        System.out.println("PC started playing Solitaire");
        power = idlePower + 30;
    }

    @Override
    public void playVideo() {
        System.out.println("PC started playing 'Arrival' movie");
        power = idlePower*2;
    }
}
