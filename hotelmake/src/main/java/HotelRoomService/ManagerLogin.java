package HotelRoomService;

import java.util.Scanner;

public class ManagerLogin {

    void managerpage() {
        while (true) {
            //System.out.println("");
            System.out.println("관리자 페이지");
            //System.out.println("------메뉴를 선택하세요------");
            System.out.println("사용하실 서비스의 번호를 입력하세요.");
            System.out.println("1.예약 2.음식 3.관리 9.프로그램 종료");
            System.out.print(">>> ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            
            //sc.nextLine();
            //choice = Integer.pareInt(choice);

            switch (choice) {
                case "1":
                //예약 메소드 호출
                    break;
                case "2":
                //음식 메소드 호출 
                    RoomServiceManager RoomServiceManager = new RoomServiceManager();
                    RoomServiceManager.RoomServiceManager();
                    break;
                case "3":
                //관리 메소드 호출 
                    break;
                case "9":
                    //프로그램 종료 
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("1~3번 중에 선택하세요.");
                    break;                    
            }
        }
    }
}