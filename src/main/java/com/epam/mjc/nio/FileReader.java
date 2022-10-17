package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile profileDate = new RandomAccessFile(file.getAbsoluteFile(), "r")) {
            FileChannel channel = profileDate.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            while (channel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    sb.append((char) buffer.get());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getProfileFromFileStringData(sb.toString());
    }

    public File getFileFromResources(String fileName) {
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }


    public Profile getProfileFromFileStringData(String data) {
        String[] fields = data.split("\n");
        Profile profile = new Profile();
        for (String field: fields) {
            if (field.startsWith("Name: ")) {
                profile.setName(field.replace("Name: ", ""));
            } else if (field.startsWith("Age: ")) {
                profile.setAge(Integer.parseInt(field.replace("Age: ", "")));
            } else if (field.startsWith("Email: ")) {
                profile.setEmail(field.replace("Email: ", ""));
            } else if (field.startsWith("Phone: ")) {
                profile.setPhone(Long.parseLong(field.replace("Phone: ", "")));
            }
        }
        return profile;
    }
}
