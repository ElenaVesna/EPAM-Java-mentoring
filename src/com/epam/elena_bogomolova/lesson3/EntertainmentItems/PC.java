package com.epam.elena_bogomolova.lesson3.EntertainmentItems;

import com.epam.elena_bogomolova.lesson3.Supplemental.*;
import com.epam.elena_bogomolova.lesson3.WarningException;

import java.util.Scanner;

public class PC extends Equipment implements MusicItem, VideoItem, GameItem, PlannedActions {

    public PC(Places place, String name) {
        super(17, place, name);
    }

    @Override
    public void playMusic() throws WarningException {
        System.out.println("Choose the album number and press enter to play!");
        System.out.println("1 - Deep Purple, 2 - Depeche Mode, 3 - The Beatles");
        Scanner sc = new Scanner(System.in);
        String album = sc.nextLine();
        if (album.equals("1") || album.equals("2") || album.equals("3")) {
            System.out.println(album + " album started to play. Enjoy!");
            power = power + 15;
            idle = false;
        } else throw new WarningException("---Error: incorrect album number chosen");

    }

    @Override
    public void stopPlayingMusic() {
        System.out.println("music playing stopped");
        power = power - 15;
        idle = true;
    }

    @Override
    public void planStart(long startTime) {
        if (startTime >= System.currentTimeMillis()) {
            power = idlePower;
            idle = false;
        }
    }

    @Override
    public void planStop(long stopTime) {
        if (stopTime >= System.currentTimeMillis()) {
            power = 0;
            System.out.println("PC is turning off. Goodbye!");
            state = false;
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
        idle = false;
    }

    @Override
    public void playVideo() {
        System.out.println("PC started playing 'Arrival' movie");
        power = idlePower*2;
        idle = false;
    }
}
