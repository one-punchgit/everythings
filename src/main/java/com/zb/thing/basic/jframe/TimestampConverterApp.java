package com.zb.thing.basic.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampConverterApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("时间转换");
        frame.setSize(900,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel inputLabel1 = new JLabel("enter timestamp");
        JTextField inputField1 = new JTextField(15);
        JButton convertButton1 = new JButton("convert to date");

        JLabel inputLabel2 = new JLabel("enter date");
        JTextField inputField2 = new JTextField(15);
        JButton convertButton2 = new JButton("convert to timestamp");

        JTextArea resultTextAreal1 = new JTextArea(5, 30);
        resultTextAreal1.setEditable(false);
        JTextArea resultTextAreal2 = new JTextArea(5, 30);
        resultTextAreal2.setEditable(false);



        panel.add(inputLabel1);
        panel.add(inputField1);
        panel.add(convertButton1);
        panel.add(inputLabel2);
        panel.add(inputField2);
        panel.add(convertButton2);


        JScrollPane scrollPane1 = new JScrollPane(resultTextAreal1);
        JScrollPane scrollPane2 = new JScrollPane(resultTextAreal2);

        panel.add(scrollPane1);
        panel.add(scrollPane2);

        frame.add(panel);

        convertButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long timestamp = Long.parseLong(inputField1.getText());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = simpleDateFormat.format(new Date(timestamp));
                    resultTextAreal1.setText(format);
                    StringSelection selection = new StringSelection(format);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
                }catch (Exception ex){
                    resultTextAreal1.append("error");
                }
            }
        });

        convertButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputDateStr = (inputField2.getText());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = simpleDateFormat.parse(inputDateStr);
                    resultTextAreal2.setText(date.getTime() +"");
                    StringSelection selection = new StringSelection(String.valueOf(date.getTime()));
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
                }catch (Exception ex){
                    resultTextAreal2.append("error");
                }
            }
        });
        frame.setVisible(true);
    }
}
