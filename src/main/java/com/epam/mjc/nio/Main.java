package com.epam.mjc.nio;


import java.io.File;

public class Main {

    public static void main(String[] args){
        FileReader fileReader = new FileReader();
        File file = fileReader.getFileFromResources("Profile.txt");
        System.out.println(fileReader.getDataFromFile(file));
    }
}
