import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //addActionListener 에러 해결
import java.util.*;

class login_test2 extends JFrame {
    Container c; // 화면 창 만들기
    static ArrayList<String> name_list;
    static ArrayList<String> ID_list;
    static ArrayList<String> PW_list;

    // 생성자
    login_test2(ArrayList<String> n_list, ArrayList<String> id_list, ArrayList<String> pw_list) {
        name_list = n_list;
        ID_list = id_list;
        PW_list = pw_list;
        c = getContentPane();
        setSize(300, 200);
        setLocationRelativeTo(null); // 프레임 중앙에 배치
        setVisible(true);
        c.setLayout(null); // 레이아웃 설정

        JLabel label = new JLabel("ID: ");
        JLabel pw = new JLabel("PW: ");
        JTextField txtID = new JTextField(10);
        JPasswordField txtPW = new JPasswordField(10);
        JButton logBtn = new JButton("LogIn");
        JButton back = new JButton("back");

        label.setBounds(60, 40, 50, 20); // 가로, 세로, 가로 사이즈, 세로 사이즈
        c.add(label);
        pw.setBounds(60, 60, 50, 20);
        c.add(pw);
        txtID.setBounds(110, 40, 100, 20);
        c.add(txtID);
        txtPW.setBounds(110, 60, 100, 20);
        c.add(txtPW);
        logBtn.setBounds(140, 100, 70, 20);
        c.add(logBtn);
        back.setBounds(50, 100, 70, 20);
        c.add(back);

        setVisible(true);

        back.addActionListener(new ActionListener() { // 뒤로가기
            public void actionPerformed(ActionEvent e) {
                new frame(false);
                setVisible(false);
            }
        });

        logBtn.addActionListener(new ActionListener() { // 로그인
            public void actionPerformed(ActionEvent e) {
                int ID_index = -1;
                ID_index = ID_list.indexOf(txtID.getText());
                if (ID_index == -1) {    //회원가입을 안 한 경우
                    JOptionPane.showMessageDialog(null, "없는 회원입니다.");
                }else{
                    String pw= txtPW.getText();
                    if (pw.equals(PW_list.get(ID_index))){   //ID와 pw가 일치
                        JOptionPane.showMessageDialog(null, "로그인 성공!");
                        new frame(true);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.");
                    }
                }
            }
        });
    }
}



