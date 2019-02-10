package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DayClient {

    private static JTextArea textarea;
    private static JTextField textfields;
    private static BufferedReader reader;  // получение сообщение
    private static PrintWriter writer;       // отправка сообщений
    private static String login;

    public static void main(String[] args){
        login = JOptionPane.showInputDialog("введите ваше имя");
        go();
    }

    private static void go() {
        JFrame frame = new JFrame("DayMasanger 2.0");
        frame.setResizable(false); // окно нельзя растягивать
        frame.setLocationRelativeTo(null); // окно размещаем по центру экрана
        JPanel panel = new JPanel();
        JTextArea textarea = new JTextArea(15, 30);
        textarea.setLineWrap(true);  // перенос строки
        //textarea.setWrapStyleWord(true);
        textarea.setEditable(false);  // нельзя изменить пользователем
        JScrollPane scrollpane = new JScrollPane(textarea);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JTextField textfields = new JTextField(20);
        JButton buttonsend = new JButton("Отправить");
        JButton buttonreset = new JButton("Обновить");

        // отправить
        buttonsend.addActionListener(new listen());


        // обновление
        buttonreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.print("");
            }
        });

        panel.add(scrollpane);
        panel.add(textfields);
        panel.add(buttonsend);
        /*
        try {
            setNet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        setNet();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, buttonreset);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    /*
    private static void setNet() throws Exception {
        Socket socket = new Socket("127.0.0.1", 500);
    }
    */
    private static void setNet(){
        try{
            Socket socket = new Socket("127.0.0.1", 5000);
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(is);
            writer = new PrintWriter(socket.getOutputStream());
        } catch (Exception ex){}
    }
}
