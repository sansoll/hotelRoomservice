package HotelRoomService;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        ManagerLogin manager = new ManagerLogin();
        CsrLogin csr = new CsrLogin();
        Scanner scanner = new Scanner(System.in);
        String managerID = "manager";
        String managerPW = "1234";
        String csrID = "csr", csrPW = "5678";

        while (true) {
            //System.out.println("---호텔 매니저 프로그램 로그인 페이지입니다.---");
            System.out.println("호텔 매니저 프로그램 로그인 페이지입니다.");
            System.out.println("-----------------------------------");
            System.out.print("ID : ");
            String id = scanner.nextLine(); //아이디 입력
            System.out.print("PW : ");
            String pw = scanner.nextLine(); //비밀번호 입력 
            
            if (managerID.equals(id) || csrID.equals(id) == true) { //관리자 아이디와 같으면
                if (managerPW.equals(pw) == true) { // 관리자 비번이 입력되면
                    System.out.println("관리자로 로그인되었습니다.");
                    System.out.println("-----------------------------------");
                    manager.managerpage();//관리자 로그인 메소드 호출
                    return;
                } else if (csrPW.equals(pw) == true) { //담당자 비번이 입력되면
                    System.out.println("고객서비스 담당자로 로그인되었습니다.");
                    System.out.println("-----------------------------------");
                    csr.csrpage();  //담당자 로그인 메소드 호출
                    return;
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            } else {
                System.out.println("아이디가 틀렸습니다.");
            }
        }
        //만약 id가 manager이고 비밀번호가 1234라면 관리자 메소드로 이동 틀리면 로그인 실패 문구 출력
        //만약 id가 scr이고 비밀번호가 1234라면 담당자 메소드로 이동 클리면 실패문구 출력 
    }

}