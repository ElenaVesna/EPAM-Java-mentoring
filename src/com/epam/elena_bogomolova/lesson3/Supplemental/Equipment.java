package com.epam.elena_bogomolova.lesson3.Supplemental;

import java.util.Scanner;

public abstract class Equipment {
    protected long idlePower;

    protected long power = 0;

//    public enum Place {kitchen, room, bedroom, laundry};
    protected Places place;
    protected String name;
    protected boolean state = false; // общее состояние устройства: false = turned off, true = turned on
    protected boolean idle = true; // выполение полезной работы: true = включен в сеть, ничего не делает, false = выполняется полезную работу


    public Equipment(long idlePower, Places place, String name) {
        this.idlePower = idlePower;
        this.name = name;
        this.place = place;
    }

    public Equipment(Places place) {
        this.place = place;
    }

    public boolean turnOn() {
        if (!state) {
            state = true;
            power = idlePower;
            idle = true;
            return true;
        } else {
            System.out.println("item is already turned on");
            return false;
        }
    }

    protected void turnOff() {
        if (idle) {
            state = false;
            power = 0;
        } else {
            System.out.println("Do you really want to turn me off? I'm doing useful job, you can loose everything I've done");
            System.out.println("press Y to continue");
            Scanner sc = new Scanner(System.in);
            String areYouSure = sc.nextLine();
            if (areYouSure.equalsIgnoreCase("Y")) {
                state = false;
            }
        }
    }

    public void move(Places newPlace) {
        Places currentPlace = place;
        System.out.println("equipment was successfully moved from " + currentPlace + " to " + newPlace);
        place = newPlace;
    }

    public boolean isTurnedOn() {
        return state;
    }

    public Places getPlace() {
        return place;
    }

    public boolean isIdle() {
        return idle;
    }

    public long getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public long getIdlePower() {
        return idlePower;
    }
}
