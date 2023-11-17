package HotelRoomService;

import java.util.Scanner;

public class RoomServiceManager {
    public static void main(String args[]){
//    public void RoomServiceManager(){
        for(;;){
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("사용하실 서비스의 번호를 입력하시오.");
            System.out.println("1. 룸서비스 메뉴 설정하기");
            System.out.println("2. 룸서비스 메뉴 보이기");
            System.out.println("3. 고객님이 주문한 룸서비스 메뉴 입력하기");
            System.out.println("4. 돌아가기");
            System.out.print(">>> ");
        
            int ServiceNumber = scanner.nextInt();
            System.out.println("");
            
            if(ServiceNumber == 1){
                RoomServiceMenuSet MenuSetting = new RoomServiceMenuSet();
                MenuSetting.RoomServiceMenuSet();
            }
            
            else if (ServiceNumber == 2){
                RoomServiceShowMenu ShowMenu = new RoomServiceShowMenu();
                ShowMenu.RoomServiceShowMenu();
            }
            
            else if (ServiceNumber == 3) {
                RoomServiceOrder roomOrder = new RoomServiceOrder();
                int orderNumber;

                // 사용자가 숫자를 입력할 때까지 반복
                while (true) {
                System.out.print("주문하실 메뉴 번호를 입력하세요: ");
                    // 사용자 입력이 숫자인지 확인
                    if (scanner.hasNextInt()) {
                        orderNumber = scanner.nextInt();
                        break;
                    }
                    else {
                        // 숫자가 아닌 값이 입력된 경우
                        System.out.println("숫자를 입력하세요. 다시 시도해주세요.");
                        scanner.nextLine(); // 버퍼 비우기
                    }
                }

                roomOrder.displayMenuInfo(orderNumber);
            }
            else if (ServiceNumber == 4){
                scanner.close();
                return;
            }
        }
    }
}
