package com.groupname.artifactname;

//public class EnumsT{
//    static final EnumsT APPLE = new EnumsT();
//    static final EnumsT SAMSUNG = new EnumsT();
//    static final EnumsT IQOO = new EnumsT();
//
//}

public enum EnumsT {
    APPLE(100),SAMSUNG,IQOO(70);
    int price;

    EnumsT(){
        price = 80;
    }

    EnumsT(int p){
        price = p;
    }

    public int getPrice(){
        return price;
    }
}

