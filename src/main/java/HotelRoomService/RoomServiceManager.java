package HotelRoomService;

import java.util.Scanner;

public class RoomServiceManager {
    public static void main(String args[]) {
        for (;;) {
            try (Scanner scanner = new Scanner(System.in)) {
                // 사용자에게 서비스 메뉴를 표시
                System.out.println("사용하실 서비스의 번호를 입력하시오.");
                System.out.println("1. 룸서비스 메뉴 설정하기");
                System.out.println("2. 룸서비스 메뉴 보이기");
                System.out.println("3. 고객님이 주문한 룸서비스 메뉴 입력하기");
                System.out.println("4. 돌아가기");
                System.out.print(">>> ");

                // 사용자 입력을 받음
                int serviceNumber = scanner.nextInt();
                System.out.println("");

                if (serviceNumber == 1) {
                    // 룸서비스 메뉴 설정 서비스 호출
                    RoomServiceMenuSet menuSetting = new RoomServiceMenuSet();
                    menuSetting.configureMenu();
                } else if (serviceNumber == 2) {
                    // 룸서비스 메뉴 보기 서비스 호출
                    RoomServiceShowMenu showMenu = new RoomServiceShowMenu();
                    showMenu.displayMenu();
                } else if (serviceNumber == 3) {
                    // 주문 입력 서비스 호출
                    RoomServiceOrder roomOrder = new RoomServiceOrder();
                    int orderNumber;

                    // 사용자가 숫자를 입력할 때까지 반복
                    while (true) {
                        System.out.print("주문하실 메뉴 번호를 입력하세요: ");
                        // 사용자 입력이 숫자인지 확인
                        if (scanner.hasNextInt()) {
                            orderNumber = scanner.nextInt();
                            break;
                        } else {
                            // 숫자가 아닌 값이 입력된 경우
                            System.out.println("숫자를 입력하세요. 다시 시도해주세요.");
                            scanner.nextLine(); // 버퍼 비우기
                        }
                    }

                    // 주문 메뉴 정보 표시
                    roomOrder.displayMenuInfo(orderNumber);
                } else if (serviceNumber == 4) {
                    // 프로그램 종료
                    return;
                }
            } catch (Exception e) {
                // 예외 처리: 입력 오류 메시지 출력
                System.out.println("입력 오류: " + e.getMessage());
            }
        }
    }
}
