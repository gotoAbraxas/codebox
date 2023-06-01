package service;


import java.util.ArrayList;
import java.util.List;

// singleton 디자인패턴 중 하나.
public class Service { // 유저가 모르는 곳.
    private static Service instance;
    private final List<Integer> list = new ArrayList<>();

    public void insert(int number){
        list.add(number);

    }
    public static Service getInstance(){
        if(instance == null) instance = new Service();
        return instance;
    }

}
