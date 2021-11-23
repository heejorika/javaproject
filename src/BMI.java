import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //addActionListener 에러 해결

class BMI extends JFrame {
    Container c;
    BMI () {
        setTitle("BMI 계산기");
        setSize(400, 600);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정

        c=getContentPane();
        c.setLayout(null);
        JLabel la = new JLabel("나의 체질량지수(BMI)");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 30);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel height = new JLabel("신장: ");
        JLabel cm = new JLabel("cm");
        JTextField txtheight = new JTextField(20);
        JLabel weight = new JLabel("체중: ");
        JLabel kg = new JLabel("kg");
        JTextField txtweight = new JTextField(20);
        JButton calc = new JButton("계산");

        JLabel bmindex = new JLabel("BMI 지수 : ");
        JLabel result = new JLabel("비만도 결과 : ");
        JLabel bmindexcalc = new JLabel("");
        JLabel resultcalc = new JLabel("");

        height.setBounds(80,90,100,40);
        height.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtheight.setBounds(150, 90, 100, 40);
        txtheight.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtheight.setHorizontalAlignment(JTextField.CENTER);
        cm.setBounds(260,90,100,40);
        cm.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));

        weight.setBounds(80,140,100,40);
        weight.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtweight.setBounds(150, 140, 100, 40);
        txtweight.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtweight.setHorizontalAlignment(JTextField.CENTER);
        kg.setBounds(260,140,100,40);
        kg.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));

        calc.setBounds(150,200,80,40);
        calc.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        bmindex.setBounds(50,250,80,40);
        bmindex.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        result.setBounds(50,280,120,40);
        result.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        bmindexcalc.setBounds(180,250,200,40);
        bmindexcalc.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        bmindexcalc.setForeground(Color.RED);
        resultcalc.setBounds(180,280,200,40);
        resultcalc.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        resultcalc.setForeground(Color.RED);

        c.add(height);
        c.add(txtheight);
        c.add(cm);
        c.add(weight);
        c.add(txtweight);
        c.add(kg);
        c.add(calc);
        c.add(bmindex);
        c.add(result);
        c.add(bmindexcalc);
        c.add(resultcalc);

        JLabel BMI = new JLabel("BMI");
        JLabel one = new JLabel("18.5");
        JLabel two = new JLabel("23");
        JLabel three = new JLabel("25");

        BMI.setBounds(0,350,50,50);
        c.add(BMI);
        one.setBounds(100,350,50,50);
        c.add(one);
        two.setBounds(170,350,50,50);
        c.add(two);
        three.setBounds(230,350,50,50);
        c.add(three);

        JLabel gBMI = new JLabel("저체중");
        JLabel gone = new JLabel("정상");
        JLabel gtwo = new JLabel("과체중");
        JLabel gthree = new JLabel("비만");

        gBMI.setBounds(0,380,115,50);
        gBMI.setForeground(Color.WHITE);
        gBMI.setBackground(Color.BLUE);
        gBMI.setHorizontalAlignment(JLabel.CENTER);
        gBMI.setOpaque(true);
        gBMI.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        c.add(gBMI);

        gone.setBounds(115,380,65,50);
        gone.setForeground(Color.WHITE);
        gone.setBackground(Color.GREEN);
        gone.setHorizontalAlignment(JLabel.CENTER);
        gone.setOpaque(true);
        gone.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        c.add(gone);

        gtwo.setBounds(180,380,58,50);
        gtwo.setForeground(Color.WHITE);
        gtwo.setBackground(Color.ORANGE);
        gtwo.setHorizontalAlignment(JLabel.CENTER);
        gtwo.setOpaque(true);
        gtwo.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        c.add(gtwo);

        gthree.setBounds(238,380,150,50);
        gthree.setForeground(Color.WHITE);
        gthree.setBackground(Color.RED);
        gthree.setHorizontalAlignment(JLabel.CENTER);
        gthree.setOpaque(true);
        gthree.setFont(new Font("Aharoni 굵게", Font.BOLD, 15));
        c.add(gthree);

        JLabel cpwnd = new JLabel("체중");
        cpwnd.setBounds(0,412,50,50);
        c.add(cpwnd);


        calc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dheight = txtheight.getText();
                String dweight = txtweight.getText();
                double h = Double.parseDouble(dheight);
                h=h/100;
                double w = Double.parseDouble(dweight);
                double bmi = w/(h*h);
                String sbmi= Double.toString(bmi);
                sbmi = String.format("%.2f",bmi);
                bmindexcalc.setText(sbmi);
                if(bmi>=25)
                    resultcalc.setText("비만 입니다.");
                else if(bmi>=23)
                    resultcalc.setText("과체중 입니다.");
                else if(bmi>=18.5)
                    resultcalc.setText("정상 입니다.");
                else
                    resultcalc.setText("저체중 입니다.");

            }
        });
    }
}
