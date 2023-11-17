package HotelRoomService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoomServiceOrder {

    // 주문 정보를 저장하는 변수들
    private int[] OrderNum;      // 주문 번호 배열
    private String[] OrderName;  // 주문 메뉴명 배열
    private int[] OrderPrice;    // 주문 가격 배열
    public int PriceSum = 0;

    // 생성자: 주문 정보를 읽어와서 처리함
    public RoomServiceOrder() {
        loadMenuInfo();  // 메뉴 정보 로딩
    }

    // 파일에서 메뉴 정보를 읽어와 배열에 저장하는 메서드
    private void loadMenuInfo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\akzmw\\Desktop\\RoomServiceMenu.txt"))) {
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
            OrderNum = new int[dataCount];
            OrderName = new String[dataCount];
            OrderPrice = new int[dataCount];

            reader.close(); 
            FileReader fileReader = new FileReader("C:\\Users\\akzmw\\Desktop\\RoomServiceMenu.txt");
            BufferedReader newReader = new BufferedReader(fileReader);

            int index = 0;
            // 파일을 다시 읽어서 주문 정보를 배열에 저장
            while ((line = newReader.readLine()) != null) {
                int orderNumber = extractOrderNumber(line);

                // 숫자가 0보다 큰 경우에만 주문 정보 처리
                if (orderNumber >= 0) {
                    OrderNum[index] = orderNumber;

                    // 공백을 기준으로 메뉴명과 가격 분리
                    String[] parts = line.split(" ");
                    OrderName[index] = parts[1];
                    OrderPrice[index] = Integer.parseInt(parts[2]);
                    index++;
                }
            }
        } catch (IOException e) {
            System.out.println("입출력 오류: " + e.getMessage());
        }
    }

    // 사용자가 입력한 숫자와 메뉴 번호가 일치하면 해당 메뉴 정보를 출력
    public void displayMenuInfo(int userNumber) {
        for (int i = 0; i < OrderNum.length; i++) {
            if (userNumber == OrderNum[i]) {
                PriceSum = PriceSum + OrderPrice[i];
                return;
            }
        }
        System.out.println("일치하는 메뉴가 없습니다.");
    }

    // 각 줄의 가장 첫 번째에 오는 숫자를 추출하는 메서드
    private int extractOrderNumber(String line) {
        String[] parts = line.split(" ");
        try {
            // 숫자로 변환하여 반환
            return Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우 0 반환
            return 0;
        }
    }
}