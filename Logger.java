package com.techelevator.view;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    static PrintWriter log;

    public static void log(String message) throws IOException{
        DateTimeFormatter logFileFormat = DateTimeFormatter.ISO_DATE;

        File logFile = new File("src/main/resources/logs" + logFileFormat.format(LocalDate.now())+ ".log");

        try
        {
            if(log == null)
            {
                if (!logFile.getParentFile().exists()){
                    logFile.getParentFile().mkdirs();
                }
                log = new PrintWriter(new FileOutputStream(logFile));
            }
            DateTimeFormatter logMessageFormat = DateTimeFormatter.ISO_DATE_TIME;

            log.println(" " + message + "at time: " + logMessageFormat.format(LocalDateTime.now()));

            log.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

