package com.SelfStudy.TwitterTrends;

import java.util.Scanner;

public class CalculateAttack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = 1;
        int y1 = 1;
        int x2 = 3;
        int y2 = 3;
        //45degree
        boolean degree45 = (Math.abs(x1 - x2) == Math.abs(y1 - y2));
        boolean file = (x1 == x2 || y1 == y2);
        if(degree45||file){
            System.out.println("YES");
        }else
            System.out.println("NO");

}}
