package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.GameItem;
import com.epam.elena_bogomolova.lesson2.Supplemental.MusicItem;
import com.epam.elena_bogomolova.lesson2.Supplemental.VideoItem;

import java.util.Scanner;

public class PlayStation extends Equipment implements VideoItem, GameItem {

    public PlayStation(String place) {
        super(place);
    }


    @Override
    public void playGames() {
        System.out.println("Choose game and press Enter!");
        System.out.println("(hint: input game name)");
        Scanner sc = new Scanner(System.in);
        String game = sc.nextLine();
        System.out.println("Game " + game + "started! Enjoy!");
    }

    @Override
    public void playVideo() {

    }
}
