package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterByChoise {
    private List<Passenger> passengers;
    private String headerCSV;
    private static int fileNumber;
    private List <Passenger> filteredPassengers;
    private File statisticsFile;
    private PrintWriter statsWiter;


    public FilterByChoise (){
        this.fileNumber = 1;
        this.passengers = new ArrayList<>();
        createPassengerList();
        createStatsFile();


    }

    private void createStatsFile(){
        statisticsFile = new File(Constants.PATH_TO_STATISTICS_FILE);
        try {
            statsWiter = new PrintWriter(statisticsFile);
            statsWiter.println("All Statistics:\n");
            statsWiter.println(classStats());
            statsWiter.println(embarkStats());
            statsWiter.println(genderStats());
            statsWiter.println(hasFamilyStats());
            statsWiter.println(ageStats());
            statsWiter.println(fareStats());
            statsWiter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public  String classStats() {
        String resLines="";
        Map<Integer,Map<Boolean, List<Passenger> > > classToSurvieInEach = passengers.stream().collect(
                Collectors.groupingBy(Passenger::getpClass,Collectors.groupingBy(Passenger::isSurvived))
        );
        double didntSurvive1=classToSurvieInEach.get(1).get(false).size();
        double survived1=classToSurvieInEach.get(1).get(true).size();
        double didntSurvive2=classToSurvieInEach.get(2).get(false).size();
        double survived2=classToSurvieInEach.get(2).get(true).size();
        double didntSurvive3=classToSurvieInEach.get(3).get(false).size();
        double survived3=classToSurvieInEach.get(3).get(true).size();
            resLines+=" Class 1:"+"\n";
            resLines+="    Survived: "+survived1*Constants.PERCENT/(survived1+didntSurvive1)+"%\n";
            resLines+="    didn't Survive: "+didntSurvive1*Constants.PERCENT/(survived1+didntSurvive1)+"%\n";
            resLines+=" Class 2:"+"\n";
            resLines+="    Survived: "+survived2*Constants.PERCENT/(survived2+didntSurvive2)+"%\n";
            resLines+="    didn't Survive: "+didntSurvive2*Constants.PERCENT/(survived2+didntSurvive2)+"%\n";
            resLines+=" Class 3:"+"\n";
            resLines+="    Survived: "+survived3*Constants.PERCENT/(survived3+didntSurvive3)+"%\n";
            resLines+="    didn't Survive: "+didntSurvive3*Constants.PERCENT/(survived3+didntSurvive3)+"%\n";

        return resLines;

    }


    public String  embarkStats() {
        String resLines="";
        Map<String,Map<Boolean, List<Passenger> > > embarkToSurvieInEach = passengers.stream().collect(
                Collectors.groupingBy(Passenger::getEmbarkLocation,Collectors.groupingBy(Passenger::isSurvived))
        );

        double didntSurviveS=embarkToSurvieInEach.get(Constants.EMBARK_S).get(false).size();
        double survivedS=embarkToSurvieInEach.get(Constants.EMBARK_S).get(true).size();
        double didntSurviveC=embarkToSurvieInEach.get(Constants.EMBARK_C).get(false).size();
        double survivedC=embarkToSurvieInEach.get(Constants.EMBARK_C).get(true).size();
        double didntSurviveQ=embarkToSurvieInEach.get(Constants.EMBARK_Q).get(false).size();
        double survivedQ=embarkToSurvieInEach.get(Constants.EMBARK_Q).get(true).size();
        resLines+=" Embark S:\n";
        resLines+="    Survived: "+survivedS*Constants.PERCENT/(survivedS+didntSurviveS)+"%\n";
        resLines+="    didn't Survive: "+didntSurviveS*Constants.PERCENT/(survivedS+didntSurviveS)+"%\n";
        resLines+=" Embark C:"+"\n";
        resLines+="    Survived: "+survivedC*Constants.PERCENT/(survivedC+didntSurviveC)+"%\n";
        resLines+="    didn't Survive: "+didntSurviveC*Constants.PERCENT/(survivedC+didntSurviveC)+"%\n";
        resLines+=" Embark Q:"+"\n";
        resLines+="    Survived: "+survivedQ*Constants.PERCENT/(survivedQ+didntSurviveQ)+"%\n";
        resLines+="    didn't Survive: "+didntSurviveQ*Constants.PERCENT/(survivedQ+didntSurviveQ)+"%\n";
        return resLines;


    }


    public  String genderStats() {
        String resLines="";
        Map<String, Map<Boolean, List<Passenger>>  > genderToSurvieInEach = passengers.stream().collect(
                Collectors.groupingBy(Passenger::getGender,Collectors.groupingBy(Passenger::isSurvived))
        );

        double didntSurviveMale=genderToSurvieInEach.get(Constants.GENDER_MALE).get(false).size();
        double survivedMale=genderToSurvieInEach.get(Constants.GENDER_MALE).get(true).size();
        double didntSurviveFemail=genderToSurvieInEach.get(Constants.GENDER_MALE).get(false).size();
        double survivedFemail=genderToSurvieInEach.get(Constants.GENDER_FEMALE).get(true).size();
        resLines+=" Gender:"+"\n";
        resLines+="    Survived Males: "+survivedMale*Constants.PERCENT/(didntSurviveMale+survivedMale)+"%\n";
        resLines+="    Survived Females: "+survivedFemail*Constants.PERCENT/(survivedFemail+didntSurviveFemail)+"%\n";
        return resLines;

    }


    public  String hasFamilyStats() {
        String resLines="";
        Map<Boolean, Map<Boolean, List<Passenger>>  > familyToSurvieInEach = passengers.stream().collect(
                Collectors.groupingBy(Passenger::hasFamilyOrPartners,Collectors.groupingBy(Passenger::isSurvived))
        );

        double hasFamilydidntSurvive=familyToSurvieInEach.get(true).get(false).size();
        double hasFamilySurvive=familyToSurvieInEach.get(true).get(true).size();
        double noFamilydidntSurvive=familyToSurvieInEach.get(false).get(false).size();
        double noFamilySurvive=familyToSurvieInEach.get(false).get(true).size();
        resLines+=" Family and Friends:"+"\n";
        resLines+="    Survived with Family: "+hasFamilySurvive*Constants.PERCENT/(hasFamilySurvive+hasFamilydidntSurvive)+"%\n";
        resLines+="    Survived without Family: "+noFamilySurvive*Constants.PERCENT/(noFamilydidntSurvive+noFamilySurvive)+"%\n";
        return resLines;

    }

    public  String ageStats() {

        String resLines="";
        Map<String, Map<Boolean, List<Passenger>>  > ageToSurvieInEach = passengers.stream().collect(
                Collectors.groupingBy(Passenger::ageGroup,Collectors.groupingBy(Passenger::isSurvived))
        );

        double didntSurvive10=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_10).get(false).size();
        double survived10=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_10).get(true).size();

        double didntSurvive20=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_20).get(false).size();
        double survived20=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_20).get(true).size();

        double didntSurvive30=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_30).get(false).size();
        double survived30=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_30).get(true).size();

        double didntSurvive40=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_40).get(false).size();
        double survived40=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_40).get(true).size();

        double didntSurvive50=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_50).get(false).size();
        double survived50=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_UP_TO_50).get(true).size();

        double didntSurviveSenior=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_SENIOR).get(false).size();
        double survivedSenior=ageToSurvieInEach.get(Constants.AGE_GROUP_NAME_SENIOR).get(true).size();


        resLines+=" Age Groups:"+"\n";
        resLines+="    Survived: "+Constants.AGE_GROUP_NAME_UP_TO_10+" : "+survived10*Constants.PERCENT/(survived10+didntSurvive10)+"%\n";
        resLines+="    Survived: "+Constants.AGE_GROUP_NAME_UP_TO_20+" : "+survived20*Constants.PERCENT/(survived20+didntSurvive20)+"%\n";
        resLines+="    Survived: "+Constants.AGE_GROUP_NAME_UP_TO_30+" : "+survived30*Constants.PERCENT/(survived30+didntSurvive30)+"%\n";
        resLines+="    Survived: "+Constants.AGE_GROUP_NAME_UP_TO_40+" : "+survived40*Constants.PERCENT/(survived40+didntSurvive40)+"%\n";
        resLines+="    Survived: "+Constants.AGE_GROUP_NAME_UP_TO_50+" : "+survived50*Constants.PERCENT/(survived50+didntSurvive50)+"%\n";
        resLines+="    Survived: "+Constants.AGE_GROUP_NAME_SENIOR+" : "+survivedSenior*Constants.PERCENT/(survivedSenior+didntSurviveSenior)+"%\n";

        return resLines;

    }



    public  String fareStats() {

        String resLines="";
        Map<String, Map<Boolean, List<Passenger>>  > fareToSurvieInEach = passengers.stream().collect(
                Collectors.groupingBy(Passenger::farePriceGroup,Collectors.groupingBy(Passenger::isSurvived))
        );

        double didntSurvive10=fareToSurvieInEach.get(Constants.FARE_PRICE_GROUP_NAME_10).get(false).size();
        double survived10=fareToSurvieInEach.get(Constants.FARE_PRICE_GROUP_NAME_10).get(true).size();

        double didntSurvive30=fareToSurvieInEach.get(Constants.FARE_PRICE_GROUP_NAME_30).get(false).size();
        double survived30=fareToSurvieInEach.get(Constants.FARE_PRICE_GROUP_NAME_30).get(true).size();

        double didntSurvive30Plus=fareToSurvieInEach.get(Constants.FARE_PRICE_GROUP_NAME_30_PLUS).get(false).size();
        double survived30Plus=fareToSurvieInEach.get(Constants.FARE_PRICE_GROUP_NAME_30_PLUS).get(true).size();


        resLines+=" Fare Price Groups:"+"\n";
        resLines+="    Survived: "+Constants.FARE_PRICE_GROUP_NAME_10+" : "+survived10*Constants.PERCENT/(survived10+didntSurvive10)+"%\n";
        resLines+="    Survived: "+Constants.FARE_PRICE_GROUP_NAME_30+" : "+survived30*Constants.PERCENT/(survived30+didntSurvive30)+"%\n";
        resLines+="    Survived: "+Constants.FARE_PRICE_GROUP_NAME_30_PLUS+" : "+survived30Plus*Constants.PERCENT/(survived30Plus+didntSurvive30Plus)+"%\n";

        return resLines;

    }




    public void createNewFileToStoreFilter(){


        File outputFile = new File(Constants.PATH_TO_FILES+fileNumber+".csv");
        try {
            PrintWriter pw = new PrintWriter(outputFile);
            pw.println(headerCSV);
            filteredPassengers.stream().sorted().forEach(passenger -> pw.print(passenger));
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        fileNumber++;

    }





    public String filter(String passengerClass, String passengerName, String passengerIDMin,
                        String passengerIDMax ,String passengerGender, String amountParAndSib,
                        String amountKidsAndParents, String ticket, String fareMin,
                        String fareMax, String cabinNum, String embark){
        this.filteredPassengers =new ArrayList<>();


        passengers.stream().filter(passenger -> passenger.isIdBiggerOrSame(passengerIDMax))
                            .filter(passenger -> passenger.isIdSmallerOrSame(passengerIDMin))
                            .filter(passenger -> passenger.isNameLike(passengerName))
                            .filter(passenger -> passenger.sameClass(pClassToNum(passengerClass)))
                            .filter(passenger -> passenger.sameGender(passengerGender))
                            .filter(passenger -> passenger.sameNumberPartner(amountParAndSib))
                            .filter(passenger -> passenger.sameNumberKids(amountKidsAndParents))
                            .filter(passenger -> passenger.sameTicket(ticket))
                            .filter(passenger -> passenger.sameCabinNum(cabinNum))
                            .filter(passenger -> passenger.sameEmbark(embark))
                            .filter(passenger -> passenger.isfarebiggerOrSame(fareMax))
                            .filter(passenger -> passenger.isfareSmallerOrSame(fareMin))
                .forEach(passenger -> {filteredPassengers.add(passenger); }
        );



        String result = "Total Row: " + this.filteredPassengers.size()+ " Survived: " +
                countSurvived(this.filteredPassengers) +" dead "+ ( countNotSurvived(this.filteredPassengers));
        createNewFileToStoreFilter();
        return result;
    }





    private int  pClassToNum( String passengerClass){
        int pclass=0;
        switch (passengerClass){
            case "1st":
                pclass = 1;
                break;
            case "2nd":
                pclass = 2;
                break;
            case "3rd":
                pclass = 3;
                break;
        }
        return pclass;
    }

    private int countSurvived(List<Passenger> passengers) {
        int survived = 0;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).isSurvived()){
                survived++;
            }
        }
        return survived;
    }
    private int countNotSurvived(List<Passenger> passengers) {
        int notSurvived = 0;
        for (int i = 0; i < passengers.size(); i++) {
            if (!passengers.get(i).isSurvived()){
                notSurvived++;
            }
        }
        return notSurvived;
    }




    private  void createPassengerList() {
        String line;
        String splitBy=",";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader((Constants.PATH_TO_DATA_FILE)));
            this.headerCSV=bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) !=null){
                String[] dataOfPassenger = line.split(splitBy);
                this.passengers.add(createNewPassenger(dataOfPassenger));
            }
        }catch (IOException e){
            System.out.println("can't read from the file");
        }
    }

    private  Passenger createNewPassenger(String[] dataOfPassenger) {
        Integer id = Integer.parseInt(dataOfPassenger[0].isBlank() ? "-1" : dataOfPassenger[0]);
        Integer survived = Integer.parseInt(dataOfPassenger[1].isBlank() ? "-1" : dataOfPassenger[1]);
        Integer pClass = Integer.parseInt(dataOfPassenger[2].isBlank() ? "-1" : dataOfPassenger[2]);
        String name = dataOfPassenger[3] + dataOfPassenger[4];
        String gender = dataOfPassenger[5];
        Double age = Double.valueOf(dataOfPassenger[6].isBlank() ? "-1" : dataOfPassenger[6]);
        Integer sbillingAndPartnersAmount = Integer.parseInt(dataOfPassenger[7].isBlank() ? "-1" : dataOfPassenger[7]);
        Integer parentAndChilrdrenAmount = Integer.parseInt(dataOfPassenger[8].isBlank() ? "-1" : dataOfPassenger[8]);
        String ticket = dataOfPassenger[9];
        Double fare = Double.valueOf(dataOfPassenger[10].isBlank() ? "-1" : dataOfPassenger[10]);
        String cabin = dataOfPassenger[11];
        String embarked = null;
        if (dataOfPassenger.length == 13) {
            embarked = dataOfPassenger[12];
        }
        return new Passenger(id, survived, pClass, name, gender, age, sbillingAndPartnersAmount, parentAndChilrdrenAmount, ticket, fare, cabin, embarked);
    }






    }

