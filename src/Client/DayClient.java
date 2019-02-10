package Client;

import javax.swing.*;

public class DayClient {


    public static void main(String[] args){
        go();
    }

    private static void go() {
        JFrame frame = new JFrame("DayMasanger 2.0");
        frame.setResizable(false); // окно нельзя растягивать
        frame.setLocationRelativeTo(null); // окно размещаем по центру экрана
        JPanel panel = new JPanel();
        JTextArea textarea = new JTextArea(15, 30);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(textarea);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JTextField textfields = new JTextField(20);
        JButton buttonsend = new JButton("Отправить");
        JButton buttonreset = new JButton("Обновить");
    }
}
