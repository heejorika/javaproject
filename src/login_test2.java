import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //addActionListener 에러 해결
import java.util.*;

/*
public class login_test1 extends JFrame {
    public login_test1() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("ID: ");
        JLabel pswrd = new JLabel("Password: ");

        JTextField txtID = new JTextField(10);
        JPasswordField txtPass = new JPasswordField(10);
        JButton logBtn = new JButton("Log In");

        panel.add(label);
        panel.add(txtID);
        panel.add(pswrd);
        panel.add(txtPass);
        panel.add(logBtn);

        logBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String id = "Administer";
                String pass = "1234";

                if (id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
                    JOptionPane.showMessageDialog(null, "Success");
                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccess");
                }
            }
        });
        add(panel);

        setVisible(true);
        setSize(350, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
*/
//t시발시발시발서ㅣㅏㅣ버ㅣ시바라라시바ㅓ리ㅏㅓ이ㅏㅓ'ㅁ나ㅣㅁㄹ이ㅏㅌㅋ

class login_test2 extends JFrame {
    Container c; // 화면 창 만들기
    static ArrayList<String> name_list = new ArrayList<String>();
    static ArrayList<String> ID_list = new ArrayList<String>();
    static ArrayList<String> PW_list = new ArrayList<String>();

    // 생성자
    login_test2() {
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
        JLabel join = new JLabel("회원이 아니신가요?");

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
        join.setBounds(80, 130, 150, 10);
        c.add(join);

        setVisible(true);

        back.addActionListener(new ActionListener() { // 뒤로가기
            public void actionPerformed(ActionEvent e) {
                new frame();
                setVisible(false);
            }
        });

        join.addMouseListener(new MouseAdapter() { // 회원가입
            public void mouseClicked(MouseEvent e) {
                new join(name_list, ID_list, PW_list);
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
                        setVisible(false);
                        new frame(name_list.get(ID_index));
                    }else{    //PW 틀림ㅋ
                        JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.");
                    }
                }
            }
        });
    }
}

class join extends JFrame{
    Container c2 = getContentPane();
    ArrayList<String> name_list;
    ArrayList<String> ID_list;
    ArrayList<String> PW_list;
    boolean ID_flag;
    boolean PW_flag;

    join(ArrayList<String> n_list, ArrayList<String> id_list, ArrayList<String> pw_list) {
        name_list=n_list;
        ID_list=id_list;
        PW_list=pw_list;

        ID_flag=false;
        PW_flag=false;
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
        pwconfirm.setBounds(210,110,70,20);
        c2.add(pwconfirm);
        Deduplication.setBounds(210, 70, 70, 20);
        c2.add(Deduplication);

        confirm.setBounds(80, 150, 150, 20);
        c2.add(confirm);

        String name_test= txtname.getText();
        name_list.add(name_test);

        //ID 중복 확인
        Deduplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ID_index = -1;
                ID_index = ID_list.indexOf(txtID.getText());

                if (ID_index==-1) {
                    JOptionPane.showMessageDialog(null, "이 아이디를 사용할 수 있습니다.");
                    String ID= txtID.getText();
                    ID_list.add(ID);
                    ID_flag=true;
                } else {
                    JOptionPane.showMessageDialog(null, "중복입니다");
                }
            }
        });

        //비밀번호 확인
        pwconfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pw_test= txtPW.getText();
                String pw_test2=txtPW2.getText();

                if(pw_test.equals(pw_test2)) {
                    JOptionPane.showMessageDialog(null, "성공입니다!");
                    String pw= txtPW.getText();
                    PW_list.add(pw);
                    PW_flag=true;
                }else {
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
                } else if(ID_flag==false) {
                    JOptionPane.showMessageDialog(null, "실패(ID Error)");
                }else {
                    JOptionPane.showMessageDialog(null, "실패(PW Error)");
                }
            }
        });
    }
}

class logout extends JFrame{
    Container c;
    logout(){
        c=getContentPane();
        setVisible(true);
        setLocationRelativeTo(null); // 프레임 중앙에 배치
        setVisible(true);
        c.setLayout(null);
        setSize(300,200);

        JLabel logout = new JLabel("로그아웃하시겠습니까?");
        JButton yes = new JButton("yes");
        JButton no = new JButton("no");

        logout.setBounds(70, 40, 150, 20); // 가로, 세로, 가로 사이즈, 세로 사이즈
        c.add(logout);
        yes.setBounds(60, 80, 70, 20); // 가로, 세로, 가로 사이즈, 세로 사이즈
        c.add(yes);
        no.setBounds(140, 80, 70, 20); // 가로, 세로, 가로 사이즈, 세로 사이즈
        c.add(no);

        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
                setVisible(false);
                new frame();
            }
        });

        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "로그아웃이 취소 되었습니다.");
                setVisible(false);
            }
        });
    }
}