package HotelRoomService;

import java.util.Scanner;

public class CsrLogin {

    //호출해야할 메소드의 객체 넣기
    //담당자 로그인 메소드를 만들자.
    void csrpage() {
        while (true) {
            //System.out.println(" ");
            System.out.println("고객 서비스 담당자 페이지");
            //System.out.println("------메뉴를 선택하세요-------");
            System.out.println("사용하실 서비스의 번호를 입력하세요.");
            System.out.println("[1.예약 / 2.음식 / 9.프로그램 종료]");
            System.out.print(">>> ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {                   
                case "1"://예약 메소드 호출                   
                    break;
                case "2"://음식 메소드 호출
                    RoomServiceManager RoomServiceManager = new RoomServiceManager();
                    RoomServiceManager.RoomServiceManager();
                    break;
                case "9"://프로그램 종료 
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("1~3번 중에 선택하세요.");
                    break;
                    
            }
        }
    }
}