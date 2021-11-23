import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class join extends JFrame {
    Container c2 = getContentPane();
    ArrayList<String> name_list;
    ArrayList<String> ID_list;
    ArrayList<String> PW_list;
    boolean ID_flag;
    boolean PW_flag;

    join(ArrayList<String> n_list, ArrayList<String> id_list, ArrayList<String> pw_list) {
        name_list = n_list;
        ID_list = id_list;
        PW_list = pw_list;

        ID_flag = false;
        PW_flag = false;
        setSize(340, 260);
        setLocationRelativeTo(null); // 프레임 중앙에 배치
        setVisible(true);
        c2.setLayout(null); // 레이아웃 설정

        JLabel name = new JLabel("name: ");
        JLabel ID = new JLabel("ID: ");
        JLabel pw = new JLabel("PW: ");
        JLabel pw2 = new JLabel("PW: ");
        JTextField txtname = new JTextField(20);
        JTextField txtID = new JTextField(20);
        JPasswordField txtPW = new JPasswordField(20);
        JPasswordField txtPW2 = new JPasswordField(20);
        JButton Deduplication = new JButton("중복");
        JButton pwconfirm = new JButton("확인");
        JButton confirm = new JButton("확인");

        name.setBounds(50, 50, 50, 20);
        c2.add(name);
        txtname.setBounds(100, 50, 100, 20);
        c2.add(txtname);
        ID.setBounds(70, 70, 50, 20);
        c2.add(ID);
        pw.setBounds(70, 90, 50, 20);
        c2.add(pw);
        pw2.setBounds(70, 110, 50, 20);
        c2.add(pw2);
        txtID.setBounds(100, 70, 100, 20);
        c2.add(txtID);
        txtPW.setBounds(100, 90, 100, 20);
        c2.add(txtPW);
        txtPW2.setBounds(100, 110, 100, 20);
        c2.add(txtPW2);
        pwconfirm.setBounds(210, 110, 70, 20);
        c2.add(pwconfirm);
        Deduplication.setBounds(210, 70, 70, 20);
        c2.add(Deduplication);

        confirm.setBounds(80, 150, 150, 20);
        c2.add(confirm);

        String name_test = txtname.getText();
        name_list.add(name_test);

        //ID 중복 확인
        Deduplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ID_index = -1;
                ID_index = ID_list.indexOf(txtID.getText());

                if (ID_index == -1) {
                    JOptionPane.showMessageDialog(null, "이 아이디를 사용할 수 있습니다.");
                    String ID = txtID.getText();
                    ID_list.add(ID);
                    ID_flag = true;
                } else {
                    JOptionPane.showMessageDialog(null, "중복입니다");
                }
            }
        });

        //비밀번호 확인
        pwconfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pw_test = txtPW.getText();
                String pw_test2 = txtPW2.getText();

                if (pw_test.equals(pw_test2)) {
                    JOptionPane.showMessageDialog(null, "성공입니다!");
                    String pw = txtPW.getText();
                    PW_list.add(pw);
                    PW_flag = true;
                } else {
                    JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
                }

            }
        });

        //최종 확인
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ID_flag && PW_flag) {
                    JOptionPane.showMessageDialog(null, "성공입니다!");
                    setVisible(false);
                    new frame(false);
                } else if (ID_flag == false) {
                    JOptionPane.showMessageDialog(null, "실패(ID Error)");
                } else {
                    JOptionPane.showMessageDialog(null, "실패(PW Error)");
                }
            }
        });
    }
}
