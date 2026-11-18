import javax.swing.*;
import java.awt.event.*;

public class EjemploRadioButtom extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton cristobalColónRadioButton;
    private JRadioButton américoRadioButton;
    private JRadioButton bernardoOHigginsRadioButton;
    private JRadioButton a1492RadioButton;
    private JRadioButton a1942RadioButton;
    private JRadioButton a1429RadioButton;
    private JRadioButton otraFechaRadioButton;

    public EjemploRadioButtom() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
       boolean esColon=cristobalColónRadioButton.isSelected();
       boolean esFecha=a1492RadioButton.isSelected();
       if(esColon && esFecha){
           JOptionPane.showMessageDialog(this,
                   "Ambas respuestas son correctas. Felicitaciones!!!",
                   "Informacion",
                   JOptionPane.INFORMATION_MESSAGE);
       }else if(esColon || esFecha){
           //al menos una
           JOptionPane.showMessageDialog(this,
                   "Solo una respuesta es correcta. Ánimo, sigue estudiando!!!",
                   "Atención", JOptionPane.WARNING_MESSAGE);
       }else{
           //ninguna respuesta correcta
           JOptionPane.showMessageDialog(this,
                   "Lamentablemente, ninguna respuesta es correcta",
                   "Error", JOptionPane.ERROR_MESSAGE);

       }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void display(JDialog origen) {
        EjemploRadioButtom dialog = new EjemploRadioButtom();
        dialog.pack();
        dialog.setLocationRelativeTo(origen);
        dialog.setVisible(true);
    }
}
