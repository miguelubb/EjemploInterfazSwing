import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class EjemploJTable extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable miTabla;
    private JButton btEditar;
    private JButton btEliminar;
    private DefaultTableModel model;

    public EjemploJTable() {
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
        String[] columnas={"Rut","Nombre", "Edad"};
        String[][] data={
                {"11.111.111-1","Juan Segura Segura", "50"},
                {"22.222.222-2","Ana Aedo","25"},
                {"33.333.333-3","Marcela Mora","18"}
        };
        model=new DefaultTableModel(data,columnas);
        miTabla.setModel(model);
        actualizarTabla();
        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEdit();
            }
        });
        btEliminar.addActionListener(e -> onEliminar());
    }

    private void onEliminar() {
        int i=miTabla.getSelectedRow();
        model.removeRow(i);
    }

    private void onEdit() {
        CreaOEditaPersona dialogo=new CreaOEditaPersona();
        int i=miTabla.getSelectedRow();
        String rut=model.getValueAt(i,0).toString();
        String nombre=model.getValueAt(i,1).toString();
        String edad=model.getValueAt(i,2).toString();

        dialogo.display(this, "Editar Persona", rut,nombre, edad);

        model.setValueAt(dialogo.getRut(),i,0);
        model.setValueAt(dialogo.getNombre(),i,1);
        model.setValueAt(dialogo.getEdad(),i,2);

        dialogo.dispose();
    }

    private void actualizarTabla() {
        model.addRow(new Object[]{"44.444.444-4", "Roberto Cediño", "45"});
    }

    private void onOK() {
        // add your code here
       //llamar al diálogo de CreaOEditaPersona
        CreaOEditaPersona dialogo=new CreaOEditaPersona();
        dialogo.display(this, "Crear Persona", "","", "");
        String[] nuevaFila={dialogo.getRut(), dialogo.getNombre(),dialogo.getEdad()};
        model.addRow(nuevaFila);
        dialogo.dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void display(JDialog origen) {
        EjemploJTable dialog = new EjemploJTable();
        dialog.pack();
        dialog.setLocationRelativeTo(origen);
        dialog.setVisible(true);
    }
}
