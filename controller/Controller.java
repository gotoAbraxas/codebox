package controller;

import service.Service;

import java.util.Scanner;

public class Controller {
    private final Scanner sc;

    private final Service service;

    public Controller(Scanner sc) {
        this.sc = sc;
        service = Service.getInstance();
    }
    /**
    *  기능 : 모드를 찾아 검색한다.
     * @param  : None
     * @Return : None
    * */
    public void selectMode() { // 유저가 보는 곳
        int mode;
        try {
            mode = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            mode = 0;
        }
        if (mode == 1) {
//            TODO : insert 기능 만들 것
            service.insert(sc.nextInt());
        }else if(mode == 2){
//            TODO : select 전체 찾기 기능 만들 것
        } else if (mode == 3) {
//            TODO : 인덱스를 입력받아 찾는 것
        } else if (mode == 4) {
//            TODO : selectMode 다시 실행
        }
    }
}
