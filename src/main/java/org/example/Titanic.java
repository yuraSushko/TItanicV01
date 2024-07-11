package org.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class Titanic extends JFrame {
    private List<Passenger> passengers;

    private ManageScreen manageScreen;
    public static void main(String[] args) {
        new Titanic();
    }

    public Titanic() {
        this.setTitle("Titanic Passengers Data");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.add(new ManageScreen(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setVisible(true);
        this.passengers = new LinkedList<>();

        this.passengers.stream()./*.filter()*/ forEach(passenger -> {

            System.out.println(passenger.getFormattedName());
                }
        );
    }
















}