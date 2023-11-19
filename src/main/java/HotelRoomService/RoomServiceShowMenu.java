package HotelRoomService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RoomServiceShowMenu {
    public void displayMenu() {
        // 메뉴를 파일에서 읽어와서 화면에 표시하는 서비스 시작
        System.out.println("<메뉴>");

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\akzmw\\Desktop\\RoomServiceMenu.txt"), StandardCharsets.UTF_8)) {
            String line;

            // 파일에서 한 줄씩 읽어오면서 출력
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // 예외 처리: 입출력 오류 메시지 출력
            System.out.println("입출력 오류: " + e.getMessage());
        }

        System.out.println("");
    }
}
