//This program aims to find the different orders of different customers.
/*
The orders for Ergun are beyti, pizza, hamburger and tea.
The orders fot Erik are sushi, pasta, avocado and coffee.
the orders for others are none.
*/

import java.util.Scanner;

public class OrdersOfDifferentCustomers {
    public static boolean TestOfName(String name){
        boolean test=false;

        if(name.equals("Ergun")||name.equals("Erik"))
            //比较字符串的大小不能用==，而应该用NAME1.equals(NAME2);
            //函数返回的是true||false。
            test=true;

        return test;
    }


    public static String[] OrdrOfCstmr(String name){
        String[] menu=new String[4];

        if(name.equals("Ergun")){
            menu[0]="beyti";
            menu[1]="pizza";
            menu[2]="hamburger";
            menu[3]="tea";
        }else if(name.equals("Erik")){
            menu[0]="sushi";
            menu[1]="pasta";
            menu[2]="avocado";
            menu[3]="coffee";
        }

        return menu;
    }

    public static void main(String[] args){
        System.out.print("Type in the name of the customer:");

        Scanner sc=new Scanner(System.in);
        String name=sc.next();

        boolean test=TestOfName(name);
        String[] ordr;

        if(test){
            ordr=new String[4];
            ordr=OrdrOfCstmr(name);
        }else{
            ordr=new String[3];
        }

        if(test){
            System.out.println("The orders for "+name+" are:");

            for(int i=0;i<ordr.length;i++) {
                if(i!=ordr.length-1) {
                    System.out.print(ordr[i] + ",");
                }else{
                    System.out.print(ordr[i]+".");
                }
            }
        }else{
            System.out.println("The orders for "+name+" are none.");
        }

        sc.close();
    }

}