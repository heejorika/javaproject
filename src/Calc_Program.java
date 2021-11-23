
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class frame extends JFrame {
    Container c; // 화면 창 만들기
    JButton button_list[] = new JButton[4]; // 버튼 4개
    String str_list[] = { "1. 계산하러 가기", "2. 로그인/로그아웃", "3. 회원가입", "4. 종료하기" }; // 버튼 4개 string
    boolean loginFlag;
    static ArrayList<String> name_list = new ArrayList<String>();
    static ArrayList<String> ID_list = new ArrayList<String>();
    static ArrayList<String> PW_list = new ArrayList<String>();

    // 생성자
    frame(boolean flag) {
        loginFlag=flag;
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

        if (loginFlag) {
            JLabel hi = new JLabel("WELCOME"); // 라벨 폰트 설정
            hi.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
            hi.setBounds(200, 0, 500, 100);
            hi.setHorizontalAlignment(JLabel.CENTER);
            hi.setForeground(Color.BLUE);
            c.add(hi);
        }

        for (int i = 0; i < 4; i++) {
            button_list[i] = new JButton(str_list[i]);
            button_list[i].setBounds(290, 220 + 70 * i, 300, 50); // 버튼 위치 조정
            c.add(button_list[i]);
        }
        setVisible(true);

        button_list[0].addActionListener(new ActionListener() { // 버튼 액션부분 (1. 계산하러가기)
            public void actionPerformed(ActionEvent e) {
                if (loginFlag) {
                    new part1();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "로그인 하세요.");
                }
            }
        });

        button_list[1].addActionListener(new ActionListener(){    //로그인/로그아웃
            public void actionPerformed(ActionEvent e) {
                if (loginFlag) {new logout();}
                else{ new login_test2(name_list, ID_list, PW_list);}
                setVisible(false);
            }
        });

        button_list[2].addActionListener(new ActionListener(){    //회원가입
            public void actionPerformed(ActionEvent e) {
                new join(name_list, ID_list, PW_list);
                setVisible(false);
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
        frame myframe = new frame(false);
    }
}