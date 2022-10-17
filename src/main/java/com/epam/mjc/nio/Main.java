package com.epam.mjc.nio;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        FileReader fileReader = new FileReader();
        File file = fileReader.getFileFromResources("Profile.txt");
        Profile profile = fileReader.getDataFromFile(file);
        logger.log(Level.INFO, "Profile info: name = {0}, age = {1}, email = {2}, phone = {3}", new Object[] {profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone()});
    }
}
