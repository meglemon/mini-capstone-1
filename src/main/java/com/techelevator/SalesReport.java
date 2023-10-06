package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import static com.techelevator.Purchases.dailySalesReport;

public class SalesReport {


    Map<Item, Integer> dailySalesMap = new HashMap<>();

    List<Item> dailySalesList = new ArrayList<>();

    private Map<Item, Integer> currentSalesMap (List<Item> dailySalesList) {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < dailySalesReport.size(); i++) {
            dailySalesList.add(dailySalesReport.get(i));
        }
        for (Item sale : dailySalesList) {
            if (dailySalesMap.containsKey(sale)){
                int updatedSold = dailySalesMap.get(sale) + 1;
                dailySalesMap.put(sale, updatedSold);
            }
            else {
                dailySalesMap.put(sale, 1);
            }

        }
        return dailySalesMap;
    }

    public File dailySalesToData(Map<Item, Integer> dailySalesMap) {
        File salesData = new File("src/main/java/com/techelevator/SalesData.txt");
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
        } catch (FileNotFoundException e) {
        }


        return salesData;
    }

    public Map<Item, Integer> extractSalesData() {
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
//                pastSales.put(newItem, price),
            }
            return pastSales;


        } catch (FileNotFoundException e) {
            return null;
        }
    }



    public File dailySalesToFile(Map<Item, Integer> dailySalesMap) {
        File dailySalesReport = new File("src/main/java/com/techelevator/SalesReport.txt");
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
        }


        return dailySalesReport;
    }

    }


