package HotelRoomService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RoomServiceOrder {
    // 주문 정보를 저장하는 변수들
    private int[] orderNum;      // 주문 번호 배열
    private String[] orderName;  // 주문 메뉴명 배열
    private int[] orderPrice;    // 주문 가격 배열
    public int priceSum = 0;

    // 생성자: 주문 정보를 읽어와서 처리함
    public RoomServiceOrder() {
        loadMenuInfo();  // 메뉴 정보 로딩
    }

    // 파일에서 메뉴 정보를 읽어와 배열에 저장하는 메서드
    private void loadMenuInfo() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Windows\\Temp\\RoomServiceMenu.txt"), StandardCharsets.UTF_8)) {
            String line;

            int dataCount = 0;

            // 파일에서 읽은 데이터 개수 세기
            while ((line = reader.readLine()) != null) {
                int orderNumber = extractOrderNumber(line);

                if (orderNumber >= 0) {
                    dataCount++;
                }
            }

            // 배열의 크기를 데이터 개수에 맞게 초기화
            orderNum = new int[dataCount];
            orderName = new String[dataCount];
            orderPrice = new int[dataCount];

            // 파일을 다시 읽어서 주문 정보를 배열에 저장
            try (BufferedReader newReader = Files.newBufferedReader(Paths.get("C:\\Windows\\Temp\\RoomServiceMenu.txt"), StandardCharsets.UTF_8)) {
                int index = 0;
                while ((line = newReader.readLine()) != null) {
                    int orderNumber = extractOrderNumber(line);

                    // 숫자가 0보다 큰 경우에만 주문 정보 처리
                    if (orderNumber >= 0) {
                        orderNum[index] = orderNumber;

                        // 공백을 기준으로 메뉴명과 가격 분리
                        String[] parts = line.split(" ");
                        orderName[index] = parts[1];
                        orderPrice[index] = Integer.parseInt(parts[2]);
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            // 예외 처리: 입출력 오류 메시지 출력
            System.out.println("ServiceOrder입출력 오류: " + e.getMessage());
        }
    }

    // 사용자가 입력한 숫자와 메뉴 번호가 일치하면 해당 메뉴 정보를 출력
    public void displayMenuInfo(int userNumber) {
        for (int i = 0; i < orderNum.length; i++) {
            if (userNumber == orderNum[i]) {
                priceSum = priceSum + orderPrice[i];
                System.out.println(orderName[i] + " 주문이 완료되었습니다.");
                //System.out.println("");
                return;
            }
        }
        System.out.println("일치하는 메뉴가 없습니다.");
        //System.out.println("");
    }

    // 각 줄의 가장 첫 번째에 오는 숫자를 추출하는 메서드
    private int extractOrderNumber(String line) {
        String[] parts = line.split(" ");
        try {
            // 숫자로 변환하여 반환
            return Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우 -1 반환
            return -1;
        }
    }
}
