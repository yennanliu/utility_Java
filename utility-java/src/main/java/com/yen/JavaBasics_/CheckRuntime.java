package com.yen.JavaBasics_;

public class CheckRuntime{
    public static void main(String[] args){
        System.out.println("running CheckRuntime ...");
        Runtime rt = Runtime.getRuntime();
        System.out.println("number of processor : " + rt.availableProcessors());
        System.out.println("space of storage : " + rt.freeMemory() / 1024/ 1024 + "M");
        System.out.println("Max space of storage : " + rt.maxMemory() / 1024/ 1024 + "M");
    }
}