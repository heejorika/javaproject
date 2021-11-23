import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class part1 extends JFrame { // 계산 종류 화면
    Container c; // 화면 창 만들기
    JButton button_list[] = new JButton[6]; // 버튼 6개
    String str_list[] = { "사칙연산 계산", "알바비 계산", "환율 계산", "적정 수면시간 계산", "D-DAY 계산", "BMI 계산" }; // 버튼 6개 string

    // 생성자
    part1() {
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
        la.setBounds(200, 0, 500, 100);
        la.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        c.add(la);
        c.setLayout(null); // 레이아웃 설정

        for (int i = 0; i < 6; i += 2) {
            button_list[i] = new JButton(str_list[i]);
            button_list[i].setBounds(200, 50 + 70 * (i + 1), 150, 75); // 버튼 위치 조정
            c.add(button_list[i]);
        }
        for (int i = 1; i < 6; i += 2) {
            button_list[i] = new JButton(str_list[i]);
            button_list[i].setBounds(550, 50 + 70 * i, 150, 75); // 버튼 위치 조정
            c.add(button_list[i]);
        }
        JButton home = new JButton("처음으로"); // 홈버튼
        home.setBounds(0, 0, 125, 50);
        c.add(home);

        home.addActionListener(new ActionListener() { // 버튼 액션부분 (첫화면으로)
            public void actionPerformed(ActionEvent e) {
                new frame(true); // 메인화면으로 이동
                setVisible(false);
            }
        });
        button_list[0].addActionListener(new ActionListener() { // 사칙연산 계산버튼
            public void actionPerformed(ActionEvent e) {
                new aop();
                setVisible(false);
            }
        });


        button_list[1].addActionListener(new ActionListener() { // 알바비
            public void actionPerformed(ActionEvent e) {
                new PAY();
                setVisible(false);
            }
        });

        button_list[2].addActionListener(new ActionListener() { // 환율
            public void actionPerformed(ActionEvent e) {
                new change();
                setVisible(false);
            }
        });


        button_list[3].addActionListener(new ActionListener() { // 수면
            public void actionPerformed(ActionEvent e) {
                new sleepCalc();
                //setVisible(false);
            }
        });

        button_list[4].addActionListener(new ActionListener() { // d-day
            public void actionPerformed(ActionEvent e) {
                new DDay();
                //setVisible(false);
            }
        });

        button_list[5].addActionListener(new ActionListener() { // bmi
            public void actionPerformed(ActionEvent e) {
                new BMI();
                setVisible(false);
            }
        });

        setVisible(true);

    }

}
