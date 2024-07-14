package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;


public class ManageScreen extends JPanel {

    private JComboBox<String> passengerClassComboBox;
    private JTextField passengerNameFilter;
    private JTextField passengerIDMinFilter;
    private JTextField passengerIDMaxFilter;
    private JComboBox<String> passengerGenderFilter;
    private JTextField amountParAndSibFilter;
    private JTextField amountKidsAndParentsFilter;
    private JTextField ticketFilter;
    private JTextField fareMinFilter;
    private JTextField fareMaxFilter;
    private JTextField cabinNumFilter;
    private JComboBox<String> embarkFilter;
    private FilterByChoise filterByChoise;
    private JButton filter;
    private JButton statistics;
    private JComboBox<String> aggDataComboBox;
    //private MyKeyListener keyListener;
    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            addTextFilterBoxes(x,y);
            addFilterJbutton();
            addStatisticsJbutton();
            addAggDataCombox();


        }
        else{
            System.out.println("couldndt find file");
        }
    }


    public void addFilterJbutton(){
        this.filterByChoise = new FilterByChoise();
        this.filter = new JButton("Filter");
        this.filter.setBounds(300,0+Constants.MARGIN_FROM_TOP,100,100);
        this.add(this.filter);
        this.filter.setBackground(Color.GRAY);
        this.filter.addActionListener(e -> {
            JLabel dialogMassage=new JLabel();
            JOptionPane.showMessageDialog(dialogMassage,  filter());
        });
    }


    public void addStatisticsJbutton(){
        this.statistics = new JButton("Statistics");
        this.statistics.setBounds(300,100+Constants.MARGIN_FROM_TOP,100,100);
        this.add(this.statistics);
        this.statistics.setBackground(Color.GRAY);
        this.statistics.addActionListener(e -> { this.filterByChoise.createStatsFile();   });
    }

    public void addAggDataCombox(){
        this.aggDataComboBox = new JComboBox<>(Constants.AGG_DATA_OPTIONS);
        this.aggDataComboBox.setBounds(300,200+Constants.MARGIN_FROM_TOP*2,100,100);
        this.add(this.aggDataComboBox);
        this.aggDataComboBox.setBackground(Color.GRAY);
        this.aggDataComboBox.addActionListener(e -> {
            JLabel dialogMassage=new JLabel();
            if(!aggDataComboBox.getSelectedItem().toString().equals(Constants.AGG_DATA_OPTIONS[0])) {
                JOptionPane.showMessageDialog(dialogMassage, this.filterByChoise.aggregateDataByColumns(aggDataComboBox.getSelectedItem().toString()));
            }

        });
    }


    public String filter(){

       return this.filterByChoise.filter(
                this.passengerClassComboBox.getSelectedItem().toString(),
                this.passengerNameFilter.getText(),
                this.passengerIDMinFilter.getText(),
                this.passengerIDMaxFilter.getText(),
                this.passengerGenderFilter.getSelectedItem().toString(),
                this.amountParAndSibFilter.getText(),
                this.amountKidsAndParentsFilter.getText(),
                this.ticketFilter.getText(),
                this.fareMinFilter.getText(),
                this.fareMaxFilter.getText(),
                this.cabinNumFilter.getText(),
                this.embarkFilter.getSelectedItem().toString() );
    }


    public void  addTextFilterBoxes(int x, int y){
        JLabel survivedLabel = new JLabel("Passenger Class: ");
        JLabel passengerNameLable = new JLabel("Passenger Name: ");
        JLabel passengerIDMinLable = new JLabel("Passenger ID Min: ");
        JLabel passengerIDMaxLable = new JLabel("Passenger ID Max: ");
        JLabel passengerGenderLable = new JLabel("Passenger Gender: ");
        JLabel amountParAndSibLable = new JLabel("Passenger's Siblings: ");
        JLabel amountKidsAndParentsLable = new JLabel("Passenger's Kids: ");
        JLabel ticketLable = new JLabel("Passenger ticket Num: ");
        JLabel fareMinLable = new JLabel("Passenger Min Fare: ");
        JLabel fareMaxLable = new JLabel("Passenger max Fare: ");
        JLabel cabinNumLable = new JLabel("Passenger's Cabin: ");
        JLabel embarkLable = new JLabel("Passenger's Embark: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y+(Constants.LABEL_HEIGHT*0 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        passengerNameLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*1 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        passengerIDMinLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*2 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        passengerIDMaxLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*3 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        passengerGenderLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*4 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        amountParAndSibLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*5 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        amountKidsAndParentsLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*6 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        ticketLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*7 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        fareMinLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*8 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        fareMaxLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*9 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        cabinNumLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*10 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        embarkLable.setBounds(x + Constants.MARGIN_FROM_LEFT, y + (Constants.LABEL_HEIGHT*11 + Constants.MARGIN_FROM_TOP), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);
        this.add(passengerNameLable);
        this.add(passengerIDMinLable);
        this.add(passengerIDMaxLable);
        this.add(passengerGenderLable);
        this.add(amountParAndSibLable);
        this.add(amountKidsAndParentsLable);
        this.add(ticketLable);
        this.add(fareMinLable);
        this.add(fareMaxLable);
        this.add(cabinNumLable);
        this.add(embarkLable);


        this.passengerClassComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerNameFilter = new JTextField();
        this.passengerIDMinFilter = new JTextField();
        this.passengerIDMaxFilter = new JTextField();
        this.passengerGenderFilter = new JComboBox<>(Constants.PASSENGER_GENDER_OPTIONS);
        this.amountParAndSibFilter = new JTextField();
        this.amountKidsAndParentsFilter = new JTextField();
        this.ticketFilter= new JTextField();
        this.fareMinFilter = new JTextField();
        this.fareMaxFilter = new JTextField();
        this.cabinNumFilter = new JTextField();
        this.embarkFilter = new JComboBox<>(Constants.PASSENGER_EMBARK_OPTIONS);
        this.aggDataComboBox=new JComboBox<>(Constants.AGG_DATA_OPTIONS);

        this.passengerClassComboBox.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH, y+ (Constants.LABEL_HEIGHT*0 + Constants.MARGIN_FROM_TOP), Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.passengerNameFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*1 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.passengerIDMinFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*2 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.passengerIDMaxFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*3 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.passengerGenderFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*4 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.amountParAndSibFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*5 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.amountKidsAndParentsFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*6 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.ticketFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*7 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.fareMinFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*8 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.fareMaxFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*9 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.cabinNumFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*10 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.embarkFilter.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH,y + (Constants.LABEL_HEIGHT*11 + Constants.MARGIN_FROM_TOP),Constants.ALL_FILTER_WIDTH, Constants.ALL_FILTER_HEIGHT);
        this.passengerClassComboBox.setBackground(Color.WHITE);
        this.embarkFilter.setBackground(Color.WHITE);
        this.passengerGenderFilter.setBackground(Color.WHITE);


        passengerIDMinFilter.addKeyListener(new MyKeyListener(passengerIDMinFilter));
        passengerIDMaxFilter.addKeyListener(new MyKeyListener(passengerIDMaxFilter));
        amountParAndSibFilter.addKeyListener(new MyKeyListener(amountParAndSibFilter));
        amountKidsAndParentsFilter.addKeyListener(new MyKeyListener(amountKidsAndParentsFilter));
        fareMinFilter.addKeyListener(new MyKeyListener(fareMinFilter));
        fareMaxFilter.addKeyListener(new MyKeyListener(fareMaxFilter));


        this.add(this.passengerClassComboBox);
        this.add(this.passengerNameFilter);
        this.add(this.passengerIDMinFilter);
        this.add(this.passengerIDMaxFilter);
        this.add(this.passengerGenderFilter);
        this.add(this.amountParAndSibFilter);
        this.add(this.amountKidsAndParentsFilter);
        this.add(this.ticketFilter);
        this.add(this.fareMinFilter);
        this.add(this.fareMaxFilter);
        this.add(this.cabinNumFilter);
        this.add(this.embarkFilter);




    }


}