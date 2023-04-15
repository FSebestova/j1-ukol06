package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel kraliciLabel;
    private JLabel husyLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JTextField kraliciField;
    private JTextField husyField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setLabelFor(husyField);
        husyLabel.setDisplayedMnemonic('H');
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setLabelFor(kraliciField);
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);


        add(createButtonBar(),"span");
        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::handleVypocitat);


        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        vypocitatButton.setMnemonic('V');
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent){
        String text1 = husyField.getText();
        int husy = Integer.parseInt(text1);

        String text2 = kraliciField.getText();
        int kralici = Integer.parseInt(text2);

        int soucetHlav = husy + kralici;
        String pocetHlav = Integer.toString(soucetHlav);
        pocetHlavField.setText(pocetHlav);

        int soucetNohou = (husy*2) + (kralici*4);
        String pocetNohou = Integer.toString(soucetNohou);
        pocetNohouField.setText(pocetNohou);
    }
}
