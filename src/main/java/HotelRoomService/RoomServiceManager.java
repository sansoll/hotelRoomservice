package HotelRoomService;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RoomServiceManager {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                try {
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
                            try {
                                System.out.print("주문하실 메뉴 번호를 입력하세요: ");
                                orderNumber = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                // 입력이 숫자가 아닌 경우 예외 처리
                                System.out.println("숫자를 입력하세요. 다시 시도해주세요.");
                                scanner.nextLine(); // 입력 버퍼 비우기
                            }
                        }

                        // 주문 메뉴 정보 표시
                        roomOrder.displayMenuInfo(orderNumber);
                    } else if (serviceNumber == 4) {
                        // 프로그램 종료
                        break;
                    } else {
                        // 유효하지 않은 서비스 번호인 경우
                        System.out.println("유효하지 않은 서비스 번호입니다. 다시 시도해주세요.");
                    }
                } catch (Exception e) {
                    // 예외 처리: 입력 오류 메시지 출력
                    System.out.println("Manager 입력 오류: " + e.getMessage());
                    scanner.nextLine(); // 입력 버퍼 비우기
                }
            }
        } finally {
            // Scanner 닫기
            scanner.close();
        }
    }
}
