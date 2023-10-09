package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

import static com.techelevator.Purchases.dailySalesReport;

public class SalesReport {


    //  F I E L D S  //
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private final File dailySalesReport = new File("src/main/java/com/techelevator/SalesReport.txt");
    private final File salesData = new File("src/main/java/com/techelevator/SalesData.txt");
    private Map<Item, Integer> dailySalesMap = new HashMap<>();
    private List<Item> dailySalesList = new ArrayList<>();
    private final Scanner fileReader = new Scanner(System.in);


    //  GETTERS & SETTERS //
    public File getDailySalesReport() {
        return dailySalesReport;
    }

    public Map<Item, Integer> getDailySalesMap() {
        return dailySalesMap;
    }

    public void setDailySalesMap(Map<Item, Integer> dailySalesMap) {
        this.dailySalesMap = dailySalesMap;
    }

    public List<Item> getDailySalesList() {
        return dailySalesList;
    }

    public void setDailySalesList(List<Item> dailySalesList) {
        this.dailySalesList = dailySalesList;
    }

    public Scanner getFileReader() {
        return fileReader;
    }

    public File getSalesData() {
        return salesData;
    }

    //  M E T H O D S  //
    private Map<Item, Integer> currentSalesMap(List<Item> dailySalesList) {   // method to make current sales into a map
        for (int i = 0; i < dailySalesList.size(); i++) {
            dailySalesList.add(dailySalesList.get(i));
        }
        for (Item sale : dailySalesList) {
            if (dailySalesMap.containsKey(sale)) {
                int updatedSold = dailySalesMap.get(sale) + 1;
                dailySalesMap.put(sale, updatedSold);
            } else {
                dailySalesMap.put(sale, 1);
            }
        }
        return dailySalesMap;
    }


    public File setDailySalesReport(Map<Item, Integer> dailySalesMap) {    // method to create a file holding current sales
        // File dailySalesReport = new File("src/main/java/com/techelevator/SalesReport.txt");
        double totalSales = 0.00;
        try (PrintWriter printerWriter = new PrintWriter(dailySalesReport)) {
            for (Map.Entry<Item, Integer> purchase : dailySalesMap.entrySet()) {
                String name = (purchase.getKey().getName());
                int quantitySold = purchase.getValue();
                double unitPrice = purchase.getKey().getPrice();
                double totalSold = (quantitySold * unitPrice);
                totalSales += totalSold;
                String line = name + ": " + quantitySold + " @ " + unitPrice + " = $" + totalSold;
                printerWriter.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please write to a valid file.");
        }
        return dailySalesReport;
    }


    public Map<Item, Integer> extractSalesData() {   //  method to update a map holding all of the sales
        File inputFile = new File("src/main/java/com/techelevator/SalesData.txt");
        Map<Item, Integer> pastSales = new HashMap<>();
        try (Scanner fileReader = new Scanner(inputFile)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] itemProperties = line.split("\\|");
                String itemName = itemProperties[0];
                String itemsSold = itemProperties[1];
                int itemQuantitySold = Integer.parseInt(itemsSold);
                String itemPriceString = itemProperties[2];
                Double itemPrice = Double.parseDouble(itemPriceString);
                Item newItem = new Item(itemName, itemPrice);
                pastSales.put(newItem, itemQuantitySold);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File path to read from not found! Please enter a valid file.");
        }
        return pastSales;
    }

    public File setSalesData(Map<Item, Integer> dailySalesMap) { // method to update the master sales report file
        double totalSales = 0.00;
        try (PrintWriter printerWriter = new PrintWriter(salesData)) {
            for (Map.Entry<Item, Integer> purchase : dailySalesMap.entrySet()) {
                String name = (purchase.getKey().getName());
                int quantitySold = purchase.getValue();
                double unitPrice = purchase.getKey().getPrice();
                double totalSold = (quantitySold * unitPrice);
                totalSales += totalSold;
                String line = name + "|" + quantitySold + "|" + unitPrice;
                printerWriter.println(line);
            }
            printerWriter.println("**TOTAL SALES** $" + df.format(totalSales));

        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please write to a valid file.");
        }
        return salesData;
    }

    public void runSalesReport(File dailySalesReport) {  // print out the absolute sales report
        try (Scanner fileReader = new Scanner(dailySalesReport)) {

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println();
            System.out.println("File cannot be found.");
        }
    }



}


