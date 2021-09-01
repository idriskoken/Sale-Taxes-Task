package com.codewithidris;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static double tax = 0.00;
    final static double basictax = 10.0;
    final static double importedTax = 5.0;
    static double price;
    static int quantity;
    static ArrayList<Double> priceList = new ArrayList<>();
    static ArrayList<String> outputTextList = new ArrayList<>();
    static  double totalTax = 0.00;
    static double taxAmount;
    static  double totalPreis = 0.00;

    public static void main(String[] args) {
        System.out.println("Please enter an Input:");
        do {
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("n")){
                System.out.println("Your total payment bill: ");
                int i = 0;
                for(Double output: priceList) {
                    System.out.println(outputTextList.get(i) + ": " + output);
                    i++;
                }
                System.out.println("Sales Taxes: " + totalTax);
                System.out.println("Total: " + totalPreis);
                System.exit(0);
            }
            if(input.contains(" at ")){
                String[] inputArray = input.split(" ");
                quantity = Integer.parseInt(inputArray[0]);
                price = Double.parseDouble(inputArray[inputArray.length - 1]);

                String outputText = input.substring(0 , input.indexOf(" at "));

                if(input.contains("imported")){
                    tax = importedTax;
                    if(input.contains("book") || input.contains("chocolate") || input.contains("pills")){

                        taxAmount = quantity * price * tax / 100;
                        price = quantity * price + quantity * price * tax / 100;

                    }
                    else {
                        tax += basictax;
                        taxAmount = quantity * price * tax / 100;
                        price = quantity * price + quantity * price * tax / 100;
                    }
                }
                else {
                    if (input.contains("book") || input.contains("chocolate") || input.contains("pills")) {
                        taxAmount = 0;
                        price = quantity * price;
                    } else {
                        tax = basictax;
                        taxAmount = quantity * price * tax / 100;
                        price = quantity * price + quantity * price * tax / 100;
                    }
                }

                priceList.add(price);
                outputTextList.add(outputText);
                totalPreis += price;
                totalTax += taxAmount;
                System.out.println("Please enter more input or to exist press \"N\"");
            }
            else{
                System.out.println("Please enter your order in a correct way like \"1 book at 10.00\" or \"1 imported book at 10.00\"");
            }

        }while(true);
    }
    public void ProgramWillBeClosed() {

    }
}
