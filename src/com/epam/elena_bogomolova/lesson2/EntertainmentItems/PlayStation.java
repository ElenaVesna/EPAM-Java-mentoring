package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.GameItem;
import com.epam.elena_bogomolova.lesson2.Supplemental.VideoItem;

import java.util.Scanner;

public class PlayStation extends Equipment implements VideoItem, GameItem {

    public PlayStation(String place, String name) {
        super(place, name);
        this.idlePower = 27;
    }

    @Override
    public void playGames() {
        System.out.println("Choose game and press Enter!");
        System.out.println("(hint: input game name)");
        Scanner sc = new Scanner(System.in);
        String game = sc.nextLine();
        System.out.println("Game " + game + "started! Enjoy!");
        power = idlePower*3;
    }

    @Override
    public void playVideo() {
        System.out.println("Play station starts to play games Demo video for you");
        power = idlePower + 35;
    }
}
