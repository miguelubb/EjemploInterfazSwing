import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EjemploJList extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton button1;
    private JButton button2;
    private JList listOrigen;
    private JList listDestino;

    public EjemploJList() {
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

        //llenado de la lista origen.
        DefaultListModel<String> modeloOrigen = new DefaultListModel<>();
        listOrigen.setModel(modeloOrigen);
        DefaultListModel<String> modeloDestino = new DefaultListModel<>();
        listDestino.setModel(modeloDestino);
        listOrigen.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listDestino.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        modeloOrigen.addElement("Calculo I");
        modeloOrigen.addElement("Calculo II");
        modeloOrigen.addElement("Calculo III");
        modeloOrigen.addElement("Quimica Genral");
        modeloOrigen.addElement("POO");
        modeloOrigen.addElement("Introducción a la programaicón");
        modeloOrigen.addElement("Álgebra I");
        modeloOrigen.addElement("Álgebra II");
        modeloOrigen.addElement("Álgebra III");
        modeloOrigen.addElement("Estructuras de datos");
        modeloOrigen.addElement("Estructuras discretas");
        modeloOrigen.addElement("Diseño y Análisis de Algoritmos");

        button1.addActionListener(e-> moverAsiganturas(listOrigen, listDestino));
        button2.addActionListener(e-> moverAsiganturas(listDestino,  listOrigen));
    }


    private void moverAsiganturas(JList origen, JList destino){
        List<String> selecionados=(List<String>)origen.getSelectedValuesList();
        DefaultListModel<String> modeloOrigen =
                (DefaultListModel<String>) origen.getModel();
        DefaultListModel<String> modeloDestino =
                (DefaultListModel<String>) destino.getModel();
        for (String asignatura : selecionados) {
            modeloOrigen.removeElement(asignatura);
            modeloDestino.addElement(asignatura);
        }
        //limpiamos la selección inválidada por la eliminación y copia anterior
        origen.getSelectionModel().clearSelection();
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void display(JDialog origen) {
        EjemploJList dialog = new EjemploJList();
        dialog.pack();
        dialog.setLocationRelativeTo(origen);
        dialog.setVisible(true);
    }
}
