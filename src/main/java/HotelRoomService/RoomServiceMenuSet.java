
package HotelRoomService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoomServiceMenuSet {

    public void RoomServiceMenuSet() {
        System.out.println("메뉴를 입력해주세요.");
        System.out.println("[메뉴번호 메뉴명(영어) 가격] 형식으로 입력해주세요. 아래에 나오는 문장은 예시입니다.");
        System.out.println("1 Pasta 22000");
        System.out.println("엔터를 두 번 입력하면 메뉴가 저장됩니다.");

        try (Scanner scanner = new Scanner(System.in);
             FileWriter fout = new FileWriter("C:\\Users\\akzmw\\Desktop\\RoomServiceMenu.txt")) {

            while (true) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    break;
                }

                if (!isValidDataFormat(line)) {
                    System.out.println("");
                    System.out.println("[메뉴번호 메뉴명(영어) 가격] 형식으로 입력해주세요. 아래에 나오는 문장은 예시입니다.");
                    System.out.println("1 Pasta 22000");
                    System.out.println("");
                    continue;
                }

                fout.write(line + "\r\n");
            }

            System.out.println("메뉴가 저장되었습니다.");
            System.out.println("");
        }
        catch (IOException e) {
            System.out.println("입출력 오류: " + e.getMessage());
        }
    }
    
    public boolean isValidDataFormat(String data) {
        String[] parts = data.split(" ");

        if (parts.length == 3) {
            try {
                int Number = Integer.parseInt(parts[0]);
                if (Number < 0 || Number > 9) {
                return false;
            }
                if (!parts[1].isEmpty()) {
                    Integer.parseInt(parts[2]);
                    return true;
                }
            }
            catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}