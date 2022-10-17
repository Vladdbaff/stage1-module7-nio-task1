package com.epam.mjc.nio;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        FileReader fileReader = new FileReader();
        File file = fileReader.getFileFromResources("Profile.txt");
        logger.log(Level.INFO, fileReader.getDataFromFile(file).toString());
    }
}
