package HotelRoomService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoomServiceMenuSet {
    public void configureMenu() {
        // 메뉴 설정 서비스 시작
        System.out.println("메뉴를 입력해주세요.");
        System.out.println("[메뉴번호 메뉴명(영어) 가격] 형식으로 입력해주세요. 아래에 나오는 문장은 예시입니다.");
        System.out.println("1 Pasta 22000");
        System.out.println("2 Fried_Chicken 22000");
        System.out.println("엔터를 두 번 입력하면 메뉴가 저장됩니다.");

        try (//Scanner scanner = new Scanner(System.in);
             FileWriter fout = new FileWriter("C:\\Windows\\Temp\\RoomServiceMenu.txt")) {

            // 사용자로부터 메뉴 정보 입력받기
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();

                // 엔터를 두 번 입력하면 입력 종료
                if (line.isEmpty()) {
                    break;
                }

                // 입력 형식이 유효한지 확인하고 파일에 저장
                if (!isValidDataFormat(line)) {
                    System.out.println("");
                    System.out.println("[메뉴번호 메뉴명(영어) 가격] 형식으로 입력해주세요. 아래에 나오는 문장은 예시입니다.");
                    System.out.println("1 Pasta 22000");
                    System.out.println("2 Fried_Chicken 22000");
                    System.out.println("");
                    continue;
                }

                fout.write(line + "\r\n");
            }

            System.out.println("메뉴가 저장되었습니다.");
            System.out.println("");
        } catch (IOException e) {
            // 예외 처리: 입출력 오류 메시지 출력
            System.out.println("MenuSet입출력 오류: " + e.getMessage());
        }
    }

    public boolean isValidDataFormat(String data) {
        // 입력된 데이터의 형식이 유효한지 확인
        String[] parts = data.split(" ");

        if (parts.length == 3) {
            try {
                int number = Integer.parseInt(parts[0]);
                if (number < 1 || number > 999) {
                    // 메뉴 번호가 범위를 벗어날 경우
                    return false;
                }

                if (!parts[1].isEmpty()) {
                    // 메뉴명이 비어있지 않은 경우
                    Integer.parseInt(parts[2]);
                    return true;
                }
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 경우
                return false;
            }
        }

        // 형식이 맞지 않는 경우
        return false;
    }
}
