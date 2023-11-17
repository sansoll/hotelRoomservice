package HotelRoomService;

import java.io.*;

public class RoomServiceShowMenu {
    public void RoomServiceShowMenu() {
        System.out.println("<메뉴>");

        try (FileInputStream fin = new FileInputStream("");
             InputStreamReader in = new InputStreamReader(fin, "MS949")) {

            int c;

            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
        catch (IOException e) {
            System.out.println("입출력 오류: " + e.getMessage());
        }
        System.out.println("");
    }
}
