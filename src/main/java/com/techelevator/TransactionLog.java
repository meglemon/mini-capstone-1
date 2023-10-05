package com.techelevator;

import java.io.File;
import java.io.PrintWriter;

public class TransactionLog extends Report{

    File outputFile = new File("src/main/java/com/techelevator/Log.txt");
    try (PrintWriter printerWriter = new PrintWriter(outputFile)) {
        Purchases purchases = new Purchases();
        for (int i = 0; i < purchases.transactionLog.size(); i++) {
            printerWriter.println(purchases.transactionLog.get(0));
            
        }
    } catch (Exception e) {
        
    }


}
