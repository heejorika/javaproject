import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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