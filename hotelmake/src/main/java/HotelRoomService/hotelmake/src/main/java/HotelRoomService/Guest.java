package HotelRoomService;

import static HotelRoomService.GuestInfo.makeInfo;
import java.util.Scanner;

public class Guest {

    Scanner scanner = new Scanner(System.in);

    public void GuestStart() {
        boolean x = true;
        GuestList gi = new GuestList();
        Payment p = new Payment();
        while (x) {
            System.out.println("-----------------------------------");
            System.out.println("[1.출력 / 2.예약 / 3.정보 수정 / 4.체크인 / 5.체크아웃 / 6.결제 유형 기록 / 7.결제 정보 보기 / 10.이전화면 출력]");
            //System.out.println("사용하실 서비스의 번호를 입력하세요.");
            //System.out.println("1. 예약 관리");
            //System.out.println("2. 체크인");
            //System.out.println("3. 체크아웃");
            //System.out.println("4. 결제 관리");
            //System.out.println("5. 이전화면 출력");
            System.out.print(">>> ");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    gi.ShowInfo();
                    break;
                case 2:
                    gi.Book(makeInfo());
                    break;
                case 3:
                    System.out.println("수정할 정보의 예약번호를 입력해 주세요.");
                    int bookNum = scanner.nextInt();
                    gi.UpdateInfo(makeInfo(), bookNum);
                    break;
                case 4:
                    gi.CheckIn();
                    break;
                case 5:
                    gi.CheckOut();
                    break;
                case 6:
                    p.recordPayment();
                    break;
                case 7:
                    p.ShowPayments();
                    break;
                case 10:
                    x = false;
                    break;
            }
        }
    }
}