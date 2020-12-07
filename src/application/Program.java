package application;

import entities.Company;
import entities.Individual;
import entities.TaxPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main (String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPlayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax players: ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println("Tax player #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (ch == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures ));
            }
            else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }

        }
        System.out.println();
        System.out.println("TAXES PAID: ");
        for(TaxPlayer taxPlayer : list){
            System.out.println(taxPlayer.getName() + ": $" + String.format("%.2f", taxPlayer.tax()));
        }
        double sum = 0;
        for(TaxPlayer taxPlayer : list){
            sum += taxPlayer.tax();
        }
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
    }
}
