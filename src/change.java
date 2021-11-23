import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class change extends JFrame {
    Container c;
    change() {
        setTitle("환율 계산기");
        setSize(400, 600);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정 

        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("환율 계산기");
        la.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel kor = new JLabel("대한민국 (KRW)");
        kor.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        kor.setBounds(20, 85, 150, 80);
        c.add(kor);

        JTextField num = new JTextField(20);
        num.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        num.setBounds(180, 105, 150, 40);
        num.setHorizontalAlignment(JTextField.RIGHT);
        c.add(num);

        JLabel won = new JLabel("원");
        won.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        won.setBounds(335, 85, 150, 80);
        c.add(won);

        JButton usa = new JButton("미국 (USD) 환율 [0.00084]");
        usa.setBounds(70,200,250,40);
        usa.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        usa.setBackground(Color.RED);
        usa.setForeground(Color.WHITE);
        usa.setOpaque(true);
        c.add(usa);

        JButton jp = new JButton("일본 (JPY) 환율 [0.0965]");
        jp.setBounds(70,250,250,40);
        jp.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        jp.setBackground(Color.ORANGE);
        jp.setOpaque(true);
        c.add(jp);

        JButton eu = new JButton("유럽연합 (EUR) 환율 [0.00075]");
        eu.setBounds(70,300,250,40);
        eu.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        eu.setBackground(Color.YELLOW);
        eu.setOpaque(true);
        c.add(eu);

        JButton cn = new JButton("중국 (CNY) 환율 [0.0054]");
        cn.setBounds(70,350,250,40);
        cn.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        cn.setBackground(Color.GREEN);
        cn.setOpaque(true);
        c.add(cn);

        JButton elg = new JButton("영국 (GBP) 환율 [0.00063]");
        elg.setBounds(70,400,250,40);
        elg.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        elg.setForeground(Color.WHITE);
        elg.setBackground(Color.BLUE);
        elg.setOpaque(true);
        c.add(elg);

        JLabel arr1 = new JLabel("▼");
        arr1.setBounds(180,150,15,15);
        c.add(arr1);
        JLabel arr2 = new JLabel("▽");
        arr2.setBounds(180,160,15,15);
        c.add(arr2);
        JLabel arr3 = new JLabel("▼");
        arr3.setBounds(180,170,15,15);
        c.add(arr3);
        JLabel arr4 = new JLabel("▽");
        arr4.setBounds(180,180,15,15);
        c.add(arr4);
        JLabel arr5 = new JLabel("▼");
        arr5.setBounds(180,440,15,15);
        c.add(arr5);
        JLabel arr6 = new JLabel("▽");
        arr6.setBounds(180,450,15,15);
        c.add(arr6);
        JLabel arr7 = new JLabel("▼");
        arr7.setBounds(180,460,15,15);
        c.add(arr7);
        JLabel arr8 = new JLabel("▽");
        arr8.setBounds(180,470,15,15);
        c.add(arr8);

        JLabel res1 = new JLabel("");
        res1.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        res1.setHorizontalAlignment(JLabel.CENTER);
        res1.setBounds(0, 485, 180, 50);
        c.add(res1);

        JLabel res2 = new JLabel("");
        res2.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        res2.setHorizontalAlignment(JLabel.CENTER);
        res2.setBounds(185, 485, 200, 50);
        c.add(res2);

        usa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res1.setText("미국 (USD)");
                res1.setBackground(Color.RED);
                res1.setForeground(Color.WHITE);
                String money = num.getText();
                double dmoney = Double.parseDouble(money);
                double cmoney = dmoney*0.00084;

                DecimalFormat df= new DecimalFormat("###,###.#####"); //De
                // cimalFormat을 이용하여 문자열 포맷정의
                String rmoney= df.format(cmoney);
                res2.setText(rmoney+" 달러");
                res2.setBackground(Color.RED);
                res2.setForeground(Color.WHITE);
                res1.setOpaque(true);res2.setOpaque(true);

            }
        });
        jp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res1.setText("일본 (JPY)");
                res1.setBackground(Color.ORANGE);
                String money = num.getText();
                double dmoney = Double.parseDouble(money);
                double cmoney = dmoney*0.0965;

                DecimalFormat df= new DecimalFormat("###,###.#####"); //DecimalFormat을 이용하여 문자열 포맷정의
                String rmoney= df.format(cmoney);
                res2.setText(rmoney+" 엔");
                res2.setBackground(Color.ORANGE);
                res1.setOpaque(true);res2.setOpaque(true);
                res1.setForeground(Color.BLACK); res2.setForeground(Color.BLACK);

            }
        });
        eu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res1.setText("유럽연합 (EUR)");
                res1.setBackground(Color.YELLOW);
                String money = num.getText();
                double dmoney = Double.parseDouble(money);
                double cmoney = dmoney*0.00075;

                DecimalFormat df= new DecimalFormat("###,###.#####"); //DecimalFormat을 이용하여 문자열 포맷정의
                String rmoney= df.format(cmoney);
                res2.setText(rmoney+" 유로");
                res2.setBackground(Color.YELLOW);
                res1.setOpaque(true);res2.setOpaque(true);
                res1.setForeground(Color.BLACK); res2.setForeground(Color.BLACK);
            }
        });
        cn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res1.setText("중국 (CNY)");
                res1.setBackground(Color.GREEN);
                String money = num.getText();
                double dmoney = Double.parseDouble(money);
                double cmoney = dmoney*0.0054;

                DecimalFormat df= new DecimalFormat("###,###.#####"); //DecimalFormat을 이용하여 문자열 포맷정의
                String rmoney= df.format(cmoney);
                res2.setText(rmoney+" 위안");
                res2.setBackground(Color.GREEN);
                res1.setOpaque(true);res2.setOpaque(true);
                res1.setForeground(Color.BLACK); res2.setForeground(Color.BLACK);

            }
        });
        elg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res1.setText("영국 (GBP)");
                res1.setForeground(Color.WHITE);
                res1.setBackground(Color.BLUE);
                String money = num.getText();
                double dmoney = Double.parseDouble(money);
                double cmoney = dmoney*0.00063;

                DecimalFormat df= new DecimalFormat("###,###.#####"); //DecimalFormat을 이용하여 문자열 포맷정의
                String rmoney= df.format(cmoney);
                res2.setText(rmoney+" 파운드");
                res2.setForeground(Color.WHITE);
                res2.setBackground(Color.BLUE);
                res1.setOpaque(true);res2.setOpaque(true);
            }
        });
    }

}