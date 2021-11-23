import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PAY extends JFrame{
    Container c;
    PAY() {
        setTitle("급여 계산기");
        setSize(400, 600);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정 

        c=getContentPane();
        c.setLayout(null);
        JLabel la = new JLabel("급여 계산기");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 30);  //라벨 폰트 설정 
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel firsttext = new JLabel("2021년 최저시급은 8,720원 입니다.");
        firsttext.setBounds(90,85,200,20);
        c.add(firsttext);

        JLabel pay = new JLabel("시급: ");
        JTextField textpay = new JTextField(20);
        JLabel won = new JLabel("원");
        pay.setBounds(144,110,100,35);
        pay.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        textpay.setBounds(200, 110, 100, 35);
        textpay.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        textpay.setHorizontalAlignment(JTextField.CENTER);
        won.setBounds(310,110,100,35);
        won.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(pay); c.add(textpay); c.add(won);

        JLabel time = new JLabel("하루 근무시간: ");
        JTextField texttime = new JTextField(20);
        JLabel tlrks = new JLabel("시간");
        time.setBounds(55,160,160,35);
        time.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        texttime.setBounds(200, 160, 100, 35);
        texttime.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        texttime.setHorizontalAlignment(JTextField.CENTER);
        tlrks.setBounds(310,160,100,35);
        tlrks.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(time); c.add(texttime); c.add(tlrks);

        JLabel day= new JLabel("한주 근무일수: ");
        JTextField textday = new JTextField(20);
        JLabel dlf = new JLabel("일");
        day.setBounds(55,210,160,35);
        day.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        textday.setBounds(200, 210, 100, 35);
        textday.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        textday.setHorizontalAlignment(JTextField.CENTER);
        dlf.setBounds(310,210,100,35);
        dlf.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(day); c.add(textday); c.add(dlf);

        JLabel week= new JLabel("몇주 일하셨나요? ");
        JTextField textweek = new JTextField(20);
        JLabel wn = new JLabel("주");
        week.setBounds(32,260,200,35);
        week.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        textweek.setBounds(200, 260, 100, 35);
        textweek.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        textweek.setHorizontalAlignment(JTextField.CENTER);
        wn.setBounds(310,260,100,35);
        wn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(week); c.add(textweek); c.add(wn);

        JLabel hpay = new JLabel("주휴수당");
        hpay.setBounds(0,360,180,35);
        hpay.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        hpay.setBackground(Color.CYAN);
        hpay.setOpaque(true);
        hpay.setHorizontalAlignment(JLabel.CENTER);
        c.add(hpay);

        ButtonGroup g = new ButtonGroup();
        JRadioButton include = new JRadioButton("포함");
        JRadioButton notinclude = new JRadioButton("미포함");
        include.setBounds(180,360,80,35);
        include.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        include.setBackground(Color.CYAN);
        notinclude.setBackground(Color.CYAN);
        notinclude.setBounds(260,360,150,35);
        notinclude.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        include.setOpaque(true);
        notinclude.setOpaque(true);

        g.add(include);
        g.add(notinclude);
        c.add(include);
        c.add(notinclude);

        JButton calc = new JButton("계산");
        calc.setBounds(150,310,80,40);
        calc.setFont(new Font("Aharoni 굵게", Font.BOLD, 18));
        c.add(calc);

        JLabel total = new JLabel("총 근무시간 : ");
        total.setBounds(50,420,150,50);
        total.setFont(new Font("Aharoni 굵게", Font.BOLD, 18));
        c.add(total);

        JLabel salary = new JLabel("월급 : ");
        salary.setBounds(112,480,150,50);
        salary.setFont(new Font("Aharoni 굵게", Font.BOLD, 18));
        c.add(salary);

        JLabel rtotal = new JLabel("");
        rtotal.setBounds(190,420,150,50);
        rtotal.setFont(new Font("Aharoni 굵게", Font.BOLD, 18));
        rtotal.setForeground(Color.BLUE);
        c.add(rtotal);

        JLabel rsalary = new JLabel("");
        rsalary.setBounds(190,480,150,50);
        rsalary.setFont(new Font("Aharoni 굵게", Font.BOLD, 18));
        rsalary.setForeground(Color.BLUE);
        c.add(rsalary);


        calc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dtime = texttime.getText();
                String dday = textday.getText();
                String dweek = textweek.getText();
                double t = Double.parseDouble(dtime);
                double d = Double.parseDouble(dday);
                double w = Double.parseDouble(dweek);
                double total= t*d*w;
                String stotal = Double.toString(total);

                rtotal.setText(stotal+" 시간");

                String dpay = textpay.getText();
                double p = Double.parseDouble(dpay);

                double salary= p*total;

                DecimalFormat df= new DecimalFormat("###,###"); //DecimalFormat을 이용하여 문자열 포맷정의
                String ssalary= df.format(salary);

                rsalary.setText(ssalary+" 원");

                include.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if(include.isSelected()) {
                            String dtime = texttime.getText();
                            String dday = textday.getText();
                            String dweek = textweek.getText();
                            double t = Double.parseDouble(dtime);
                            double d = Double.parseDouble(dday);
                            double w = Double.parseDouble(dweek);
                            double total= t*d*w;
                            String stotal = Double.toString(total);

                            rtotal.setText(stotal+" 시간");

                            String dpay = textpay.getText();
                            double p = Double.parseDouble(dpay);
                            double hpay= p*w*t;
                            double salary= p*total+hpay;

                            DecimalFormat df= new DecimalFormat("###,###"); //DecimalFormat을 이용하여 문자열 포맷정의
                            String ssalary= df.format(salary);

                            rsalary.setText(ssalary+" 원");
                        }


                    }
                });

                notinclude.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if(notinclude.isSelected()) {
                            String dtime = texttime.getText();
                            String dday = textday.getText();
                            String dweek = textweek.getText();
                            double t = Double.parseDouble(dtime);
                            double d = Double.parseDouble(dday);
                            double w = Double.parseDouble(dweek);
                            double total= t*d*w;
                            String stotal = Double.toString(total);

                            rtotal.setText(stotal+" 시간");

                            String dpay = textpay.getText();
                            double p = Double.parseDouble(dpay);

                            double salary= p*total;

                            DecimalFormat df= new DecimalFormat("###,###"); //DecimalFormat을 이용하여 문자열 포맷정의
                            String ssalary= df.format(salary);

                            rsalary.setText(ssalary+" 원");

                        }


                    }
                });
            }
        });

    }

}