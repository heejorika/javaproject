import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //addActionListener 에러 해결
import java.util.ArrayList;

public class DDay extends JFrame{
    Container c;

    DDay() {
        setTitle("D-Day 계산기");
        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("D-Day");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 30);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JButton theday = new JButton("그 날까지 며칠...");
        JButton today= new JButton("오늘부터 00일 뒤..");

        theday.setBounds(25,150,340,30);
        theday.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(theday);

        today.setBounds(25,210,340,30);
        today.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(today);

        theday.addActionListener(new ActionListener() { // 수면
            public void actionPerformed(ActionEvent e) {
                new thedayCalc();
                setVisible(false);
            }
        });

        today.addActionListener(new ActionListener() { // 수면
            public void actionPerformed(ActionEvent e) {
                new todayCalc();
                setVisible(false);
            }
        });
    }
}

class thedayCalc extends JFrame{
    Container c;
    Integer month_list[] ={31,28,31,30,31,30,31,31,30,31,30,31};

    thedayCalc(){
        setTitle("D-Day 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("그 날까지 며칠...");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        //오늘 날짜 입력받기
        JLabel month = new JLabel("startmonth: ");
        JLabel day = new JLabel("startday: ");
        JTextField txtmonth = new JTextField(30);
        JTextField txtday = new JTextField(30);

        //start month
        month.setBounds(80,110,130,20);
        month.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtmonth.setBounds(200, 110, 100, 30);
        txtmonth.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtmonth.setHorizontalAlignment(JTextField.CENTER);
        c.add(month);
        c.add(txtmonth);

        //start day
        day.setBounds(80,150,130,32);
        day.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtday.setBounds(200, 150, 100, 30);
        txtday.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtday.setHorizontalAlignment(JTextField.CENTER);
        c.add(day);
        c.add(txtday);

        //그날 날짜 입력받기
        JLabel month2 = new JLabel("endmonth: ");
        JLabel day2 = new JLabel("endday: ");
        JTextField txtmonth2 = new JTextField(30);
        JTextField txtday2 = new JTextField(30);

        //end month
        month2.setBounds(80,190,130,20);
        month2.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtmonth2.setBounds(200, 190, 100, 30);
        txtmonth2.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtmonth2.setHorizontalAlignment(JTextField.CENTER);
        c.add(month2);
        c.add(txtmonth2);

        //end day
        day2.setBounds(80,230,130,20);
        day2.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtday2.setBounds(200, 230, 100, 30);
        txtday2.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtday2.setHorizontalAlignment(JTextField.CENTER);
        c.add(day2);
        c.add(txtday2);

        JButton calc = new JButton("계산");
        calc.setBounds(150, 280, 100, 30);
        c.add(calc);
        calc.addActionListener(new ActionListener() { //계산 결과
            public void actionPerformed(ActionEvent e) {
                int start_total=0;
                int end_total=0;
                for(int i=0; i<(Integer.valueOf(txtmonth.getText())-1);i++)
                    start_total+=month_list[i];
                start_total+=Integer.valueOf(txtday.getText());

                for(int i=0; i<(Integer.valueOf(txtmonth2.getText())-1);i++)
                    end_total+=month_list[i];
                end_total+=Integer.valueOf(txtday2.getText());

                if(end_total>start_total) new d_day_View(end_total-start_total);
                else new d_day_View((365-start_total)+end_total);
            }
        });
    }
}

class todayCalc extends JFrame{
    Container c;
    Integer month_list[] ={31,28,31,30,31,30,31,31,30,31,30,31};
    int m31[] ={1,3,5,7,8,10,12};
    int m30[] ={4,6,9,11};

    ArrayList<Integer> month31 = new ArrayList<Integer>();
    ArrayList<Integer> month30 = new ArrayList<Integer>();

    todayCalc(){
        for (int i=0; i<m31.length; i++) month31.add(m31[i]);
        for (int i=0; i<m30.length; i++) month30.add(m30[i]);

        setTitle("D-Day 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("오늘부터 00일 뒤..");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        //오늘 날짜 입력받기
        JLabel month = new JLabel("startmonth: ");
        JLabel day = new JLabel("startday: ");
        JTextField txtmonth = new JTextField(30);
        JTextField txtday = new JTextField(30);

        //start month
        month.setBounds(80,130,130,20);
        month.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtmonth.setBounds(200, 130, 100, 30);
        txtmonth.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtmonth.setHorizontalAlignment(JTextField.CENTER);
        c.add(month);
        c.add(txtmonth);

        //start day
        day.setBounds(80,170,130,32);
        day.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtday.setBounds(200, 170, 100, 30);
        txtday.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtday.setHorizontalAlignment(JTextField.CENTER);
        c.add(day);
        c.add(txtday);

        //며칠 뒤
        JLabel afterDay = new JLabel("afterDay : ");
        JTextField txtafterDay = new JTextField(30);

        afterDay.setBounds(80,210,130,20);
        afterDay.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        txtafterDay.setBounds(200, 210, 100, 30);
        txtafterDay.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        txtafterDay.setHorizontalAlignment(JTextField.CENTER);
        c.add(afterDay);
        c.add(txtafterDay);

        JButton calc = new JButton("계산");
        calc.setBounds(150, 280, 100, 30);
        c.add(calc);
        calc.addActionListener(new ActionListener() { //계산 결과
            public void actionPerformed(ActionEvent e) {
                int total=0;
                int resultMonth=0; int resultDay=0;
                for(int i=0; i<(Integer.valueOf(txtmonth.getText())-1);i++)
                    total+=month_list[i];
                total+=Integer.valueOf(txtday.getText());
                total+=Integer.valueOf(txtafterDay.getText());

                //total 날짜를 month와 day로 변경
                if(total>365) total-=365;
                int m=1; int d=0;
                for(int i=0; ; i++, m++) {
                    if (m != 2 && total <= 28) break;  //2월이 아닌데 28일보다 작을 때
                    else if (month30.contains(m) && total <= 30) break;
                    else if (month31.contains(m) && total <= 31) break;
                    total-=month_list[i];
                }
                d=total;

                new d_day_View(m, d);
            }
        });
    }
}

class d_day_View extends JFrame{
    Container c;

    public d_day_View(int day){
        int d_day=day;
        setTitle("D-Day 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("그날까지 이만큼 남았네요!");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel resultView = new JLabel(String.valueOf(d_day));
        resultView.setBounds(130, 120, 130, 30);
        resultView.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        resultView.setHorizontalAlignment(JTextField.CENTER);
        c.add(resultView);

        setVisible(true);
    }

    public d_day_View(int m, int d){
        int month=m;
        int day=d;
        setTitle("D-Day 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("그날의 날짜는 이렇네요!");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel monthView = new JLabel(String.valueOf(month)+"월 "+String.valueOf(day)+"일 ");
        monthView.setBounds(130, 120, 130, 30);
        monthView.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        monthView.setHorizontalAlignment(JTextField.CENTER);
        c.add(monthView);

        setVisible(true);
    }
}
