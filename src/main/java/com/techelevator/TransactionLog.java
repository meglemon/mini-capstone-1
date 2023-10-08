package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TransactionLog extends Report{

    public void createLog (List<String> transactionList) {

        File outputFile = new File("src/main/java/com/techelevator/Log.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile, true);
             PrintWriter printWriter = new PrintWriter(fileOutputStream)) {
            for (String transaction : transactionList) {
                printWriter.println(transaction);
            }
            printWriter.flush();
        } catch (IOException e) {

        }


    }



}
