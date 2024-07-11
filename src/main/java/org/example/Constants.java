package org.example;


public class Constants {
    public static final int PERCENT=100;
    public static final String PATH_TO_FILES = "src/main/java/org/example/data/";
    public static final String PATH_TO_DATA_FILE = PATH_TO_FILES+"titanic.csv";
    public static final String PATH_TO_STATISTICS_FILE = PATH_TO_FILES+"statistics.txt";
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 600;
    public static final String[] PASSENGER_CLASS_OPTIONS = {"All", "1st", "2nd", "3rd"};

    public static final int PASSENGER_ALL_CLASS = 0;
    public static final int PASSENGER_FIRST_CLASS = 1;
    public static final int PASSENGER_SECOND_CLASS = 2;
    public static final int PASSENGER_THIRD_CLASS = 3;

    public static final int MARGIN_FROM_TOP = 15;
    public static final int MARGIN_FROM_LEFT = 5;
    public static final int LABEL_WIDTH = 140;
    public static final int LABEL_HEIGHT = 30;
    public static final int ALL_FILTER_WIDTH = 80;
    public static final int ALL_FILTER_HEIGHT = 30;

    public static final String  GENDER_MALE = "male";
    public static final String  GENDER_FEMALE = "female";

    public static final int[] AGE_GROUP_UP_TO_10 = {0,10};
    public static final int[] AGE_GROUP_UP_TO_20 = {11,20};
    public static final int[] AGE_GROUP_UP_TO_30 = {21,30};
    public static final int[] AGE_GROUP_UP_TO_40 = {31,40};
    public static final int[] AGE_GROUP_UP_TO_50 = {41,50};
    public static final int[] AGE_GROUP_SENIOR = {51,999};
    public static final String AGE_GROUP_NAME_UP_TO_10="up to 10";
    public static final String AGE_GROUP_NAME_UP_TO_20="up to 20";
    public static final String AGE_GROUP_NAME_UP_TO_30="up to 30";
    public static final String AGE_GROUP_NAME_UP_TO_40="up to 40";
    public static final String AGE_GROUP_NAME_UP_TO_50="up to 50";
    public static final String AGE_GROUP_NAME_SENIOR ="more than 50";



    public static final int FARE_PRICE_GROUP10 = 10;
    public static final int[] FARE_PRICE_GROUP30 = {11,30};
    public static final int FARE_PRICE_GROUP30_PLUS = 30;

    public static final String FARE_PRICE_GROUP_NAME_10 = "up to 10";
    public static final String FARE_PRICE_GROUP_NAME_30 = "up to 30";
    public static final String FARE_PRICE_GROUP_NAME_30_PLUS = "more than 30";

    public static final String  EMBARK_S = "S";
    public static final String  EMBARK_C = "C";
    public static final String  EMBARK_Q = "Q";




}
