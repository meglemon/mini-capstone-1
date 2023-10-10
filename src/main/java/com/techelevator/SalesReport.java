package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

public class SalesReport {


    //  F I E L D S  //
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private final File dailySalesReport = new File("src/main/java/com/techelevator/SalesReport.txt");
    private final File salesData = new File("src/main/java/com/techelevator/SalesData.txt");
    private Map<Item, Integer> dailySalesMap = new HashMap<>();
    private Map<String, Double> pastSales = new HashMap<>();
    private List<Item> dailySalesList = new ArrayList<>();
    private final Scanner fileReader = new Scanner(System.in);

    //  CONSTRUCTOR  //
    public SalesReport() {
    }

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

    public java.util.Map<String, Double> getPastSales() {
        return pastSales;
    }

    public Scanner getFileReader() {
        return fileReader;
    }

    public File getSalesData() {
        return salesData;
    }

    //  M E T H O D S  //
//   private Map<Item, Integer> currentSalesMap(List<Item> dailySalesList) {   // method to make current sales into a map
//        for (int i = 0; i < Purchases.getCurrentSalesReport().size(); i++) {
//            dailySalesList.add(Purchases.currentSalesReport.get(i));
//        }
//        for (Item sale : dailySalesList) {
//            if (dailySalesMap.containsKey(sale)) {
//                int updatedSold = dailySalesMap.get(sale) + 1;
//                dailySalesMap.put(sale, updatedSold);
//            } else {
//                dailySalesMap.put(sale, 1);
//            }
//        }
//        return dailySalesMap;
//    }
//
//    public File setDailySalesReport(Map<Item, Integer> dailySalesMap) {    // method to create a file holding current sales
//        double totalSales = 0.00;
//        try (PrintWriter printerWriter = new PrintWriter(dailySalesReport)) {
//            for (Map.Entry<Item, Integer> purchase : dailySalesMap.entrySet()) {
//                String name = (purchase.getKey().getName());
//                int quantitySold = purchase.getValue();
//                double unitPrice = purchase.getKey().getPrice();
//                double totalSold = (quantitySold * unitPrice);
//                totalSales += totalSold;
//                String line = name + "|" + quantitySold + "|" + unitPrice + "|" + totalSold;
//                printerWriter.println(line);
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found! Please write to a valid file.");
//        }
//        return dailySalesReport;
//    }
//
//    public Map<String, Double> setPastSales() {   //  method to update a map holding all of the sales
//
//        setDailySalesReport(dailySalesMap);
//
//        try (Scanner fileReader = new Scanner(dailySalesReport)) {
//            while (fileReader.hasNextLine()) {
//                String line = fileReader.nextLine();
//                String[] itemProperties = line.split("\\|");
//                String itemName = itemProperties[0];
//                String itemsSold = itemProperties[1];
//                int itemQuantitySold = Integer.parseInt(itemsSold);
//                String itemPriceString = itemProperties[2];
//                Double itemPrice = Double.parseDouble(itemPriceString);
//                pastSales.put(itemName, itemPrice);
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File path to read from not found! Please enter a valid file.");
//        }
//        return pastSales;
//    }
//
//    public File setSalesData(Map<String, Double> pastSales) {   // method to update the master sales report file
//
//       setPastSales();
//
//        double totalSales = 0.00;
//        try (PrintWriter printerWriter = new PrintWriter(salesData)) {
//            for (Map.Entry<Item, Integer> purchase : dailySalesMap.entrySet()) {
//                String name = (purchase.getKey().getName());
//                int quantitySold = purchase.getValue();
//                double unitPrice = purchase.getKey().getPrice();
//                double totalSold = (quantitySold * unitPrice);
//                totalSales += totalSold;
//                String line = name + "|" + quantitySold + "|" + unitPrice;
//                printerWriter.println(line);
//            }
//            printerWriter.println("**TOTAL SALES** $" + df.format(totalSales));
//
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found! Please write to a valid file.");
//        }
//        return salesData;
//    }
//
//    public void runSalesReport(File salesData) {  // print out the absolute sales report
//
//        setSalesData(pastSales);
//
//        try (Scanner fileReader = new Scanner(salesData)) {
//
//            while (fileReader.hasNextLine()) {
//                String line = fileReader.nextLine();
//                System.out.println(line);
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println();
//            System.out.println("File cannot be found.");
//        }
//    }


   //method to convert transActionLog into Sales list
    public List<String> transactionLogToSalesList () {
        File inputFile = new File("src/main/java/com/techelevator/Log.txt");
        List<String> salesAsList = new ArrayList<>();
        try(Scanner fileScanner = new Scanner(inputFile);) {

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                if (line.contains("FEED MONEY") == false && line.contains("GIVE CHANGE") == false) {
                    int index = 0;
                    salesAsList.add(index, line.substring(20, line.lastIndexOf(' ')));
                    index += 1;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry the file wasn't able to be opened.");
        }
        return salesAsList;

    }

    //method to take salesList and convert into Map that counts # of sales of each item in list
    public Map<String, Integer> salesListToMap(List <String> salesList) {
        Map <String, Integer> salesMap = new HashMap<>();

        for (String sale : salesList) {
            if (salesMap.containsKey(sale)) {
                int updatedFrequency = salesMap.get(sale) + 1;
                salesMap.put(sale, updatedFrequency);
            }
            else {
                salesMap.put(sale, 1);
            }


        }

        return salesMap;

    }

    //takes SalesReport and print outs on console and makes rewrites file
    public File printSales(Map<String, Integer> salesMap) {
        File outputFile = new File("src/main/java/com/techelevator/SalesReport.txt");
        try (PrintWriter printerWriter = new PrintWriter(outputFile)) {

            double totalSales = 0.00;

            for (Map.Entry<String, Integer> sale: salesMap.entrySet()) {
                double itemPrice = Double.parseDouble(sale.getKey().substring(sale.getKey().indexOf('$') + 1));
                String itemName = sale.getKey().substring(0, sale.getKey().indexOf('$') - 4);
                int quantitySold = sale.getValue();
                double salesForItem = itemPrice * quantitySold;
                totalSales += salesForItem;
                String line = itemName + ": " + quantitySold + " @ $" + df.format(itemPrice) + " = " + df.format(salesForItem);
                printerWriter.println(line);
                System.out.println(line);

            }
            printerWriter.println("**TOTAL SALES** $" + df.format(totalSales));


        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please write to a valid file.");
        }
        return salesData;
    }

//    public void runSalesReport(File salesData) {  // print out the absolute sales report
//
//        setSalesData(pastSales);
//
//        try (Scanner fileReader = new Scanner(salesData)) {
//
//            while (fileReader.hasNextLine()) {
//                String line = fileReader.nextLine();
//                System.out.println(line);
//            }
//
//
//        }
//        return outputFile;
//    }



}


