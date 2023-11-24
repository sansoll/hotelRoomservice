package HotelRoomService;

import java.io.*;
import java.util.Scanner;

public class GuestListM {

    private static final String FILE_PATH = "C:\\Users\\akzmw\\Desktop\\RoomNumber.txt";

    public void GuestListM() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 체크인");
            System.out.println("2. 체크아웃");
            System.out.println("3. 예약 정보 출력");
            System.out.println("4. 예약 정보 저장");
            System.out.println("5. 예약 정보 수정");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter 키 소비

            switch (choice) {
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    readReservationFromFile();
                    break;
                case 4:
                    writeReservationToFile();
                    break;
                case 5:
                    updateReservationInFile();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
            }
        }
    }

    private static void checkIn() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("체크인할 방 번호를 입력하세요: ");
            String targetRoomNumber = scanner.nextLine();

            // 파일을 읽어서 체크인할 방 번호를 찾음
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(targetRoomNumber)) {
                    found = true;
                    break;
                }
            }

            reader.close();

            if (found) {
                System.out.println("체크인이 완료되었습니다.");
            } else {
                System.out.println("해당 방 번호의 체크인 정보를 찾을 수 없습니다. 다시 입력하세요.");
            }

        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void checkOut() {
    try {
        Scanner scanner = new Scanner(System.in);

        System.out.print("체크아웃할 예약 번호를 입력하세요: ");
        int targetReservationNumber = scanner.nextInt();

        // 파일을 읽어서 체크아웃할 예약 번호를 찾음
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        boolean found = false;
        StringBuilder updatedContent = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int reservationNumber = Integer.parseInt(parts[0]);

            if (reservationNumber == targetReservationNumber) {
                found = true;
                // 해당 예약 번호와 일치하는 줄의 나머지 데이터를 삭제
                updatedContent.append(reservationNumber).append("\n");
            } else {
                updatedContent.append(line).append("\n");
            }
        }

        reader.close();

        if (found) {
            // 파일에 수정된 내용을 쓰기
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(updatedContent.toString());
            writer.close();

            System.out.println("체크아웃이 완료되었습니다.");
        } else {
            System.out.println("해당 예약 번호의 체크인 정보를 찾을 수 없습니다. 다시 입력하세요.");
        }

    } catch (IOException e) {
        System.out.println("파일을 읽거나 쓰는 중 오류가 발생했습니다: " + e.getMessage());
    }
}

    private static void readReservationFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("파일에서 읽은 예약 정보:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void writeReservationToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("예약 날짜를 입력하세요: ");
            String reservationDate = scanner.nextLine();
            System.out.print("First Name을 입력하세요: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name을 입력하세요: ");
            String lastName = scanner.nextLine();
            System.out.print("전화번호를 입력하세요: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("투숙객 수를 입력하세요: ");
            int numberOfGuests = scanner.nextInt();
            System.out.print("방 번호를 입력하세요: ");
            int roomNumber = scanner.nextInt();

            // 현재까지 저장된 정보의 개수를 가져옴
            int currentCount = countLines(FILE_PATH);

            // 정보를 파일에 쓰기 (번호와 정보를 공백으로 구분)
            writer.write(currentCount + 1 + " " + reservationDate + " " + firstName + " " + lastName + " " + phoneNumber + " " + numberOfGuests + " " + roomNumber);
            writer.newLine();

            System.out.println("파일에 예약 정보를 저장했습니다.");
        } catch (IOException e) {
            System.out.println("파일에 쓰는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void updateReservationInFile() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("수정할 예약 번호를 입력하세요: ");
            int targetReservationNumber = scanner.nextInt();

            // 파일을 읽어서 수정할 예약 정보를 찾음
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            StringBuilder updatedContent = new StringBuilder();
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int reservationNumber = Integer.parseInt(parts[0]);

                if (reservationNumber == targetReservationNumber) {
                    found = true;

                    System.out.print("새로운 예약 날짜를 입력하세요: ");
                    String newReservationDate = scanner.next();
                    System.out.print("새로운 First Name을 입력하세요: ");
                    String newFirstName = scanner.next();
                    System.out.print("새로운 Last Name을 입력하세요: ");
                    String newLastName = scanner.next();
                    System.out.print("새로운 전화번호를 입력하세요: ");
                    String newPhoneNumber = scanner.next();
                    System.out.print("새로운 투숙객 수를 입력하세요: ");
                    int newNumberOfGuests = scanner.nextInt();
                    System.out.print("새로운 방 번호를 입력하세요: ");
                    int newRoomNumber = scanner.nextInt();

                    // 수정된 내용으로 업데이트
                    updatedContent.append(reservationNumber)
                            .append(" ").append(newReservationDate)
                            .append(" ").append(newFirstName)
                            .append(" ").append(newLastName)
                            .append(" ").append(newPhoneNumber)
                            .append(" ").append(newNumberOfGuests)
                            .append(" ").append(newRoomNumber)
                            .append("\n");
                } else {
                    updatedContent.append(line).append("\n");
                }
            }

            reader.close();

            if (!found) {
                System.out.println("해당 예약 번호를 찾을 수 없습니다.");
                return;
            }

            // 파일에 수정된 내용을 쓰기
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(updatedContent.toString());
            writer.close();

            System.out.println("예약 정보를 수정했습니다.");

        } catch (IOException e) {
            System.out.println("파일을 읽거나 쓰는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 파일의 라인 수를 세는 메서드
    private static int countLines(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }
}