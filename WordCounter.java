import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public WordCounter() {
        super("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea));

        wordCountLabel = new JLabel("Word Count: 0");
        add(wordCountLabel);

        countButton = new JButton("Count");
        countButton.addActionListener(this);
        add(countButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            int wordCount = countWords(text);
            wordCountLabel.setText("Word Count: " + wordCount);
        }
    }

    private int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        new WordCounter();
    }
}