import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //addActionListener 에러 해결
import java.util.*;

public class sleepCalc extends JFrame {
    Container c; // 화면 창 만들기

    public sleepCalc(){
        setTitle("적정 수면 시간 계산기");
        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("언제 일어나면 좋을까?");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 30);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JButton whatTime = new JButton("나는 몇 시에 일어나야 하는데..");
        JButton nowSleep= new JButton("나는 지금 잘 껀데..");

        whatTime.setBounds(25,150,340,30);
        whatTime.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(whatTime);

        nowSleep.setBounds(25,210,340,30);
        nowSleep.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        c.add(nowSleep);

        whatTime.addActionListener(new ActionListener() { // 수면
            public void actionPerformed(ActionEvent e) {
                new whatTimeCalc();
                setVisible(false);
            }
        });

        nowSleep.addActionListener(new ActionListener() { // 수면
            public void actionPerformed(ActionEvent e) {
                new nowSleepCalc();
                setVisible(false);
            }
        });

    }
}

class whatTimeCalc extends JFrame{
    Container c;
    Integer time[] = new Integer[4];
    String Calc_result_list[] = new String[4];

    public whatTimeCalc(){
        setTitle("적정 수면 시간 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("나는 몇 시에 일어나야 하는데..");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel hour = new JLabel("hour: ");
        JLabel minute = new JLabel("minute: ");
        JTextField txthour = new JTextField(20);
        JTextField txtminute = new JTextField(20);

        hour.setBounds(80,130,130,40);
        hour.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txthour.setBounds(170, 130, 100, 40);
        txthour.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txthour.setHorizontalAlignment(JTextField.CENTER);
        c.add(hour);
        c.add(txthour);

        minute.setBounds(80,190,130,40);
        minute.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtminute.setBounds(170, 190, 100, 40);
        txtminute.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtminute.setHorizontalAlignment(JTextField.CENTER);
        c.add(minute);
        c.add(txtminute);

        JButton calc = new JButton("계산");
        calc.setBounds(150, 250, 100, 40);
        c.add(calc);

        calc.addActionListener(new ActionListener() { //계산 결과
            public void actionPerformed(ActionEvent e) {
                int h=Integer.valueOf(txthour.getText());
                int m=Integer.valueOf(txtminute.getText());
                int hm=(h*60)+m;
                time[0]=hm-540; time[1]=hm-450; time[2]=hm-360; time[3]=hm-270;  //계산 다시 빼야함!!

                for(int i=0; i<4;i++){
                    int result=time[i];
                    if(result<0){result+=1440;}
                    int resultHour = (result/60);
                    int resultMinute = (result%60);
                    Calc_result_list[i]=(resultHour)+"시 "+(resultMinute)+"분";
                }

                new ResultView(Calc_result_list, "이때 자면 좋을 것 같군요!");
                setVisible(false);
            }
        });
    }
}

class ResultView extends JFrame{
    Container c;
    String result[] = new String[4];
    ResultView(String[] r, String s){
        result=r;
        setTitle("적정 수면 시간 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        String msg=s;
        JLabel la = new JLabel(s);
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        for(int i=0; i<4; i++){
            JLabel resultView = new JLabel(result[i]);
            resultView.setBounds(130, 120+(i*40), 130, 30);
            resultView.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
            resultView.setHorizontalAlignment(JTextField.CENTER);
            c.add(resultView);
        }

        setVisible(true);
    }
}

class nowSleepCalc extends JFrame{
    Container c;
    Integer time[] = new Integer[4];
    String Calc_result_list[] = new String[4];

    public nowSleepCalc(){
        setTitle("적정 수면 시간 계산기");

        setSize(400, 400);
        setLocationRelativeTo(null);   //프레임 중앙에 배치
        setVisible(true);   //프레임이 보이도록 설정
        c=getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("나는 지금 잘 껀데..");
        Font font=new Font("Aharoni 굵게", Font.BOLD, 20);  //라벨 폰트 설정
        la.setFont(font);
        la.setBounds(-55, 0, 500, 80);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBackground(Color.GREEN);
        la.setOpaque(true);
        c.add(la,BorderLayout.NORTH);

        JLabel hour = new JLabel("hour: ");
        JLabel minute = new JLabel("minute: ");
        JTextField txthour = new JTextField(20);
        JTextField txtminute = new JTextField(20);

        hour.setBounds(80,130,130,40);
        hour.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txthour.setBounds(170, 130, 100, 40);
        txthour.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txthour.setHorizontalAlignment(JTextField.CENTER);
        c.add(hour);
        c.add(txthour);

        minute.setBounds(80,190,130,40);
        minute.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtminute.setBounds(170, 190, 100, 40);
        txtminute.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
        txtminute.setHorizontalAlignment(JTextField.CENTER);
        c.add(minute);
        c.add(txtminute);

        JButton calc = new JButton("계산");
        calc.setBounds(150, 250, 100, 40);
        c.add(calc);

        calc.addActionListener(new ActionListener() { //계산 결과
            public void actionPerformed(ActionEvent e) {
                int h=Integer.valueOf(txthour.getText());
                int m=Integer.valueOf(txtminute.getText());
                int hm=(h*60)+m;
                time[0]=hm+540; time[1]=hm+450; time[2]=hm+360; time[3]=hm+270;  //계산 다시 빼야함!!

                for(int i=0; i<4;i++){
                    int result=time[i];
                    if(result>1440){result-=1440;}
                    int resultHour = (result/60);
                    int resultMinute = (result%60);
                    Calc_result_list[i]=(resultHour)+"시 "+(resultMinute)+"분";
                }

                new ResultView(Calc_result_list, "이때 일어나면 좋을 것 같군요!");
                setVisible(false);
            }
        });
    }
}

