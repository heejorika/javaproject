
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class frame extends JFrame {
    Container c; // 화면 창 만들기
    JButton button_list[] = new JButton[4]; // 버튼 4개
    String str_list[] = { "1. 계산하러 가기", "2. 로그인/회원 가입", "3. 히스토리 보기", "4. 종료하기" }; // 버튼 4개 string

    // 생성자
    frame() {
        setTitle("2021_자바 프로젝트_계산기 프로그램");
        setSize(900, 600);
        setLocationRelativeTo(null); // 프레임 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료
        setVisible(true); // 프레임이 보이도록 설정

        // 버튼 설정, 자동으로 실행

        c = getContentPane(); // 컨텐트팬을 이용해서 그 위치에 컴포넌트 추가(위치)
        JLabel la = new JLabel("어?이걸 어떻게 계산하더라?");
        Font font = new Font("Aharoni 굵게", Font.BOLD, 30); // 라벨 폰트 설정
        la.setFont(font);
        la.setBounds(200, 100, 500, 100);
        la.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        c.add(la);
        c.setLayout(null); // 레이아웃 설정

        for (int i = 0; i < 4; i++) {
            button_list[i] = new JButton(str_list[i]);
            button_list[i].setBounds(290, 220 + 70 * i, 300, 50); // 버튼 위치 조정
            c.add(button_list[i]);
        }
        setVisible(true);

        button_list[0].addActionListener(new ActionListener() { // 버튼 액션부분 (1. 계산하러가기)
            public void actionPerformed(ActionEvent e) {
                new part1(); // 계산 종류가 있는 part1 화면으로 전환
                //setVisible(false); // 이전 화면은 안보이게 설정
            }
        });

        button_list[1].addActionListener(new ActionListener(){    //로그인
            public void actionPerformed(ActionEvent e) {
                new login_test2();
            }
        });

        button_list[2].addActionListener(new ActionListener(){    //히스토리 보기(로그인 안햇으므로)
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "로그인을 해주세요.");
            }
        });

        button_list[3].addActionListener(new ActionListener() { // 버튼 액션부분 (4. 종료하기)
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    //로그인 했을 때 프레임 
    frame(String name) {
        setTitle("2021_자바 프로젝트_계산기 프로그램");
        setSize(900, 600);
        setLocationRelativeTo(null); // 프레임 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료
        setVisible(true); // 프레임이 보이도록 설정

        // 버튼 설정, 자동으로 실행

        c = getContentPane(); // 컨텐트팬을 이용해서 그 위치에 컴포넌트 추가(위치)
        JLabel la = new JLabel("어?이걸 어떻게 계산하더라?");
        Font font = new Font("Aharoni 굵게", Font.BOLD, 30); // 라벨 폰트 설정
        la.setFont(font);
        la.setBounds(200, 100, 500, 100);
        la.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        c.add(la);
        c.setLayout(null); // 레이아웃 설정

        JLabel userName = new JLabel(name+" 님 환영합니다!");
        userName.setBounds(700,10,200,20);
        c.add(userName);

        for (int i = 0; i < 4; i++) {
            button_list[i] = new JButton(str_list[i]);
            button_list[i].setBounds(290, 220 + 70 * i, 300, 50); // 버튼 위치 조정
            c.add(button_list[i]);
        }
        setVisible(true);

        button_list[0].addActionListener(new ActionListener() { // 버튼 액션부분 (1. 계산하러가기)
            public void actionPerformed(ActionEvent e) {
                new part1(); // 계산 종류가 있는 part1 화면으로 전환
                //setVisible(false); // 이전 화면은 안보이게 설정
            }
        });

        button_list[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new logout();  //★★★★★★★★★★★★로그아웃 페이지를 변경
            }
        });

        button_list[3].addActionListener(new ActionListener() { // 버튼 액션부분 (4. 종료하기)
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}



public class Calc_Program {
    public static void main(String[] args) {
        frame myframe = new frame();
    }
}