package com.interview.programs;

import ch.qos.logback.core.CoreConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//    10/Mar/2022:19:45:00 iphone -- my login request step1
//    10/Mar/2022:19:46:00 Android -- my login request1
//    10/Mar/2022:19:46:00 Web -- my login request1
//    10/Mar/2022:19:45:00 iphone -- my login request step2
//    10/Mar/2022:19:45:00 iphone -- my login request step3
//    10/Mar/2022:19:51:56 iphone -- my login request step4
public class Synechone {

    public static void main(String[] args) throws IOException {
        File myFile = new File("C:\\Users\\anupb\\Downloads\\Filename.txt");

        if (myFile.exists()) {
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            List<String> listOfString = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.contains("iphone")) {
                    listOfString.add(line);
                }
            }
            fr.close();    //closes the stream and release the resources
        } else
            System.out.println("File does not exist");
    }
}

