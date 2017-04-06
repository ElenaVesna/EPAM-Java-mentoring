package com.epam.elena_bogomolova.lesson5.task1.Supplemental;

import com.epam.elena_bogomolova.lesson3.ErrorException;
import com.epam.elena_bogomolova.lesson3.WarningException;

import java.util.Scanner;

public abstract class Equipment {

    private static final String AGREE = "Press Y to continue";
    private static final String ALREADY_TRNDON = "Unit is already turned on";
    private static final String CONFRM_TURNOFF = "Unit is in working process, do you really want to turn it off?";
    private static final String NO_TURNOFF = "You decided not to turn off, the unit will continue working";
    private static final String ERR_INCORR_PLACE = "---Incorrect place entered";
    private static final String PLACES_HINT = "(Hint: possible places are: kitchen, room, bedroom, laundry)";
    private static final String ASK_PLACE_INPUT = "Enter new place you want to move to and press Enter";

    protected long idlePower;

    protected long power = 0;

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

    public void turnOn() {
        if (!state) {
            state = true;
            power = idlePower;
            idle = true;
        } else {
            System.out.println(ALREADY_TRNDON);
        }
    }

    public final void turnOff() throws WarningException {
        if (state) {
            if (idle) {
                state = false;
                power = 0;
            } else {
                System.out.println(CONFRM_TURNOFF);
                System.out.println(AGREE);
                Scanner sc = new Scanner(System.in);
                String areYouSure = sc.nextLine();
                if (areYouSure.equalsIgnoreCase("Y")) {
                    state = false;
                } else {
                    throw new WarningException(NO_TURNOFF);
                }
            }
        } else throw new ErrorException();
    }

    public void move() throws WarningException {
        try {
            Places newPlace = getPlaceInput();
            if (place == newPlace) {
                System.out.println(name + " is already in " + place);
            } else {
                System.out.printf("%1$s was successfully moved from %2$s to %3$s \n", name, place, newPlace);
                place = newPlace;
            }
        } catch (ErrorException e) {
            System.out.println(ERR_INCORR_PLACE);
        }
    }

    private Places getPlaceInput() {
        System.out.println(ASK_PLACE_INPUT);
        System.out.println(PLACES_HINT);
        Scanner sc = new Scanner(System.in);
        Places newPlace = null;
        String input = sc.nextLine().toLowerCase();
        for (Places place: Places.values()) {
            if (input.equals(place.toString())) {
                    newPlace = place;
                }
            }
        if (newPlace == null) {
            throw new ErrorException();
        }
        return newPlace;
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

    public boolean getState() {
        return state;
    }
}
