import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class logout extends JFrame {
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
                new frame(false);
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