package com.torry.demo;

public class SingleTon {
    private SingleTon(){};
    private static volatile SingleTon instance;
    public  static SingleTon getInstance(){
        if(instance == null){
            synchronized(SingleTon.class) {
                if(instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for(int i = 0;i < 10;i++){
            System.out.println(SingleTon.getInstance().hashCode());
        }
    }
}
