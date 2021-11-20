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
                new frame(); // 메인화면으로 이동
                setVisible(false);
            }
        });
        button_list[0].addActionListener(new ActionListener() { // 사칙연산 계산버튼
            public void actionPerformed(ActionEvent e) {
                new aop();
                setVisible(false);
            }
        });

        setVisible(true);

    }

}

class aop extends JFrame implements ActionListener {
    JPanel panel = new JPanel(); // 버튼 영역
    JLabel label = new JLabel("0"); // 결과 영역
    double num1, num2; // 계산할 두개의 정수 부분
    double result; // 연산 결과
    String func = ""; // 기능 연산자
    String nInput = ""; // 마지막에 누른 연산자 저장
    boolean state = false; // 화면에 표시된 number 핸들러
    String key[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "=", "C", "÷" }; // 버튼에 들어갈 문자열
    // key 배열

    aop() {
        setTitle("사칙연산 계산기");
        setSize(400, 600);
        setVisible(true);
        setLocationRelativeTo(null); // 프레임 중앙에 배치
        // label
        label.setLayout(new BorderLayout());
        label.setFont(new Font("Serif", Font.BOLD, 50)); // 결과영역 폰트지정
        label.setHorizontalAlignment(JLabel.RIGHT); // 결과영역 오른쪽 정렬
        this.add(label, BorderLayout.NORTH); // 결과영역 북쪽배치로 추가
        // panel
        panel.setLayout(new GridLayout(4, 4)); // 버튼영역 4행 4열 GridLayout
        this.add(panel); // 버튼영역 추가
        // button
        JButton button[] = new JButton[key.length];
        for (int i = 0; i < 16; i++) {
            button[i] = new JButton(key[i]);
            button[i].setFont(new Font("serif", Font.BOLD, 40));
            button[i].addActionListener(this); // 버튼에 이벤트 추가, 액션리스너의 객체이므로 this로 지정

            if (i == 3 || i == 7 || i == 11 || i == 15)
                button[i].setForeground(Color.BLUE); // +,-,*,÷ 파란색으로 설정
            if (i == 13 || i == 14)
                button[i].setForeground(Color.RED); // =, C 빨간색으로 설정
            panel.add(button[i]); // 버튼 영역에 버튼추가
        }
    }

    public void actionPerformed(ActionEvent e) { // 버튼 클릭시 발동되는 메소드

        String input = e.getActionCommand(); // 이벤트를 발생시킨 객체의 문자열을 가져와서 input에 넣음

        if (input.equals("+")) {
            num1 = num2;
            func = "+";
            nInput = "";

        } else if (input.equals("-")) {
            num1 = num2;
            func = "-";
            nInput = "";

        } else if (input.equals("*")) {
            num1 = num2;
            func = "*";
            nInput = "";

        } else if (input.equals("÷")) {
            num1 = num2;
            func = "÷";
            nInput = "";

        } else if (input.equals("C")) { // Clear
            nInput = "";
            num2 = 0;
            num1 = 0;
            label.setText("0");

        } else if (input.equals("=")) {
            if (func.equals("+")) {
                result = num1 + num2;
                label.setText(String.valueOf(result)); // 결과값을 문자열로 반환하여 결과창에 출력
                state = true; // 결과 값이 나온 후 다음 입력이 들어왔을 때 화면에 표시된 결과 값을 지운다.

            } else if (func.equals("-")) {
                result = num1 - num2;
                label.setText(String.valueOf(result));
                state = true;

            } else if (func.equals("*")) {
                result = num1 * num2;
                label.setText(String.valueOf(result));
                state = true;

            } else if (func.equals("÷")) {
                result = num1 / num2;
                label.setText(String.valueOf(result));
                state = true;

            }

        } else {
            if (state) { // = 클릭후 버튼을 입력하면 모두 초기화
                label.setText("0");
                state = false;
                num1 = 0;
                num2 = 0;
                nInput = "";
            }

            nInput += e.getActionCommand();
            label.setText(nInput);
            num2 = Double.parseDouble(nInput); // 문자열을 실수형으로 변환

        }

    }
}