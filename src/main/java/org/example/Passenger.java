package org.example;

public class Passenger implements Comparable<Passenger>{
    private Integer passengerId;
    private boolean survived;
    private Integer pClass;
    private String name;
    private String gender;
    private Double age;
    private Integer sbillingAndPartnersAmount; // SibSp
    private Integer parentAndChilrdrenAmount; // Parch
    private String ticket;
    private Double fare;
    private String cabin;
    private String embarkLocation;


    public Passenger(Integer passengerId, Integer survived, Integer pClass, String name, String gender, Double age, Integer sbillingAndPartnersAmount,
                     Integer parentAndChilrdrenAmount, String ticket, Double fare, String cabin, String embarkLocation) {
        this.passengerId = (passengerId.equals(-1) ? null : passengerId);
        this.survived = ( survived==1 );
        this.pClass = (pClass.equals(-1) ? null : pClass);
        this.name = name;
        this.gender = gender;
        this.age = (age.equals(-1) ? null : age);
        this.sbillingAndPartnersAmount = (sbillingAndPartnersAmount.equals(-1) ? null : sbillingAndPartnersAmount) ;
        this.parentAndChilrdrenAmount = (parentAndChilrdrenAmount.equals(-1) ? null : parentAndChilrdrenAmount) ;
        this.ticket = ticket;
        this.fare = (fare.equals(-1) ? null : fare);
        this.cabin = cabin;
        this.embarkLocation = embarkLocation;
    }

    public boolean hasFamilyOrPartners(){
        return (this.sbillingAndPartnersAmount+this.parentAndChilrdrenAmount )>0;
    }

    public String ageGroup(){
        String res ="";
        if(this.age>=Constants.AGE_GROUP_UP_TO_10[0] && this.age<=Constants.AGE_GROUP_UP_TO_10[1]){res=Constants.AGE_GROUP_NAME_UP_TO_10;}
        if(this.age>=Constants.AGE_GROUP_UP_TO_20[0] && this.age<=Constants.AGE_GROUP_UP_TO_20[1]){res=Constants.AGE_GROUP_NAME_UP_TO_20;}
        if(this.age>=Constants.AGE_GROUP_UP_TO_30[0] && this.age<=Constants.AGE_GROUP_UP_TO_30[1]){res=Constants.AGE_GROUP_NAME_UP_TO_30;}
        if(this.age>=Constants.AGE_GROUP_UP_TO_40[0] && this.age<=Constants.AGE_GROUP_UP_TO_40[1]){res=Constants.AGE_GROUP_NAME_UP_TO_40;}
        if(this.age>=Constants.AGE_GROUP_UP_TO_50[0] && this.age<=Constants.AGE_GROUP_UP_TO_50[1]){res=Constants.AGE_GROUP_NAME_UP_TO_50;}
        if(this.age>=Constants.AGE_GROUP_SENIOR[0] && this.age<=Constants.AGE_GROUP_SENIOR[1]){    res=Constants.AGE_GROUP_NAME_SENIOR;}
        return res;
    }


    public String farePriceGroup(){
        String res ="";
        if(this.fare<=Constants.FARE_PRICE_GROUP10){res=Constants.FARE_PRICE_GROUP_NAME_10;}
        if(this.fare>=Constants.FARE_PRICE_GROUP30[0] && this.fare<=Constants.FARE_PRICE_GROUP30[1]){res=Constants.FARE_PRICE_GROUP_NAME_30;}
        if(this.fare>=Constants.FARE_PRICE_GROUP30_PLUS){res=Constants.FARE_PRICE_GROUP_NAME_30_PLUS;}
        return res;
    }



    public boolean sameNumberKids(String amountKidsAndParents){
        boolean same =false;
        if(!amountKidsAndParents.equals("")){
            if (this.parentAndChilrdrenAmount==Integer.parseInt(amountKidsAndParents)){same=true;}
        }
        else{same=true;}
        return same;
    }
    public boolean sameNumberPartner(String amountParAndSib){
        boolean same =false;
        if(!amountParAndSib.equals("")){
            if (this.sbillingAndPartnersAmount==Integer.parseInt(amountParAndSib)){same=true;}
        }
        else{same=true;}
        return same;
    }


    public boolean sameClass(int pClass){
        boolean same=false;

        switch (pClass){
            case Constants.PASSENGER_ALL_CLASS:
                same=true;
                break;
            case Constants.PASSENGER_FIRST_CLASS:
                same=this.pClass==Constants.PASSENGER_FIRST_CLASS;
                break;
            case Constants.PASSENGER_SECOND_CLASS:
                same=this.pClass==Constants.PASSENGER_SECOND_CLASS;
                break;
            case Constants.PASSENGER_THIRD_CLASS:
                same=this.pClass==Constants.PASSENGER_THIRD_CLASS;
                break;
        }

        return same;
    }

    public boolean isNameLike(String name){
        boolean like=false;
        if(!name.equals("") ){
            if(this.name.toLowerCase().contains(name.toLowerCase())){
                like=true;
            }
        }else{like=true;}
        return like;
    }

    public boolean sameGender(String s){
        boolean same=false;
        if(!s.equals("") ){
            if(this.gender.toLowerCase().contains(s.toLowerCase())){
                same=true;
            }
        }else{ same=true;}
        return same;
    }




    public boolean sameCabinNum(String cabin){
        boolean same=false;
        if(!cabin.equals("") ){
            if(this.cabin.equals(cabin)){
                same=true;
            }
        }else{ same=true;}
        return same;
    }

    public boolean sameEmbark(String embark){
        boolean same=false;
        if(!embark.equals("") ){
            if(this.embarkLocation.equals(embark)){
                same=true;
            }
        }else{ same=true;}
        return same;
    }


    public boolean sameTicket(String ticket){
        boolean same=false;
        if(!ticket.equals("") ){
            if(this.ticket.equals(ticket)){
                same=true;
            }
        }else{ same=true;}
        return same;
    }


    public boolean isIdBiggerOrSame(String id){
        boolean bigger= false;
        if( id.equals("") ){
            bigger= true;
        }
        else{
            if( this.passengerId<= Integer.parseInt(id)){bigger=true;}
        }
        return bigger;
    }

    public boolean isIdSmallerOrSame(String id){
        boolean smaller= false;
         if( id.equals("") ){
            smaller= true;
        }
        else{
            if( this.passengerId>= Integer.parseInt(id)){smaller=true;}
        }
        return smaller;
    }




    public boolean isfarebiggerOrSame(String fare){
        boolean bigger= false;
        if( fare.equals("") ){
            bigger= true;
        }
        else{
            if( this.fare<= Integer.parseInt(fare)){bigger=true;}
        }
        return bigger;
    }

    public boolean isfareSmallerOrSame(String fare){
        boolean smaller= false;
        if( fare.equals("") ){
            smaller= true;
        }
        else{
            if( this.fare>= Integer.parseInt(fare)){smaller=true;}
        }
        return smaller;
    }



    public boolean isSurvived() {
        return survived;
    }


    public Integer getpClass() {
        return pClass;
    }


    public Integer getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Double getAge() {
        return age;
    }

    public Integer getSbillingAndPartnersAmount() {
        return sbillingAndPartnersAmount;
    }

    public Integer getParentAndChilrdrenAmount() {
        return parentAndChilrdrenAmount;
    }

    public String getTicket() {
        return ticket;
    }

    public Double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarkLocation() {
        return embarkLocation ==null ? "" : embarkLocation;
    }

    public String getFormattedName(){
        StringBuilder sb = new StringBuilder(this.name.replace("(","").replace(")",""));
        int endOfLastName = sb.indexOf(" ");
        String lastName = sb.substring(1,endOfLastName+1) ;
        sb.delete(0,endOfLastName+1);
        int endOfTitle= sb.indexOf(".");
        String titel = sb.substring(0,endOfTitle+1) ;
        sb.delete(0,endOfTitle+1);
        String firstName =  sb.toString().substring(0,sb.length()-1);
        return firstName + "  " + lastName;
    }

    @Override
    public String toString() {
        return  passengerId +
                ", " + (survived  ? "yes" : "no") +
                ", " + pClass +
                ", " + getFormattedName()  +
                ", " + gender +
                ", " + age +
                ", " + sbillingAndPartnersAmount +
                ", "  + parentAndChilrdrenAmount +
                ", " + ticket +
                ", " + fare +
                ", " + cabin+
                ", "  + embarkLocation+"\n" ;
    }

    @Override
    public int compareTo(Passenger other) {
        return this.getFormattedName().compareTo(other.getFormattedName());
    }
}
