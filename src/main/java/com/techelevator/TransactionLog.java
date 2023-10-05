package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class TransactionLog extends Report{

    public void createLog () {

        File outputFile = new File("src/main/java/com/techelevator/Log.txt");
        try (PrintWriter printerWriter = new PrintWriter(outputFile)) {
            Purchases purchases = new Purchases();
            for (String transaction : purchases.transactionLog) {
                printerWriter.println(transaction);
            }
        } catch (Exception e) {

        }
    }


}
