import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EjemploComboBox extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox<String> cbRegion;
    private JComboBox<String> cbProvincia;

    Map<String, List<String>> regiones = new HashMap<>();

    public EjemploComboBox() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        inicializaMapRegiones();

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

        //se llena el ComboBox de regiones con las claves del mapa.
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addAll(regiones.keySet());
        cbRegion.setModel(model);
        cbRegion.addActionListener(e->actualizarProvincia());
    }

    private void actualizarProvincia() {
        String regionSleccionada = cbRegion.getSelectedItem().toString();
        cbProvincia.removeAllItems();
        DefaultComboBoxModel<String> model= new DefaultComboBoxModel<>();
        model.addAll(regiones.get(regionSleccionada));
        cbProvincia.setModel(model);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void inicializaMapRegiones() {
        regiones.put("Arica y Parinacota",
                List.of("Arica", "Parinacota"));

        regiones.put("Tarapacá",
                List.of("Iquique", "Tamarugal"));

        regiones.put("Antofagasta",
                List.of("Antofagasta", "El Loa", "Tocopilla"));

        regiones.put("Atacama",
                List.of("Copiapó", "Chañaral", "Huasco"));

        regiones.put("Coquimbo",
                List.of("Elqui", "Limarí", "Choapa"));

        regiones.put("Valparaíso",
                List.of("Valparaíso", "Isla de Pascua", "Los Andes",
                        "Petorca", "Quillota", "San Antonio",
                        "San Felipe de Aconcagua", "Marga Marga"));

        regiones.put("Metropolitana de Santiago",
                List.of("Santiago", "Cordillera", "Chacabuco",
                        "Maipo", "Melipilla", "Talagante"));

        regiones.put("Libertador General Bernardo O'Higgins",
                List.of("Cachapoal", "Cardenal Caro", "Colchagua"));

        regiones.put("Maule",
                List.of("Talca", "Cauquenes", "Curicó", "Linares"));

        regiones.put("Ñuble",
                List.of("Diguillín", "Itata", "Punilla"));

        regiones.put("Biobío",
                List.of("Concepción", "Arauco", "Biobío"));

        regiones.put("La Araucanía",
                List.of("Cautín", "Malleco"));

        regiones.put("Los Ríos",
                List.of("Valdivia", "Ranco"));

        regiones.put("Los Lagos",
                List.of("Llanquihue", "Chiloé", "Osorno",
                        "Palena"));

        regiones.put("Aysén del General Carlos Ibáñez del Campo",
                List.of("Coyhaique", "Aysén", "General Carrera",
                        "Capitán Prat"));

        regiones.put("Magallanes y de la Antártica Chilena",
                List.of("Magallanes", "Antártica Chilena",
                        "Tierra del Fuego", "Última Esperanza"));

    }

    public static void display(JDialog origen) {
        EjemploComboBox dialog = new EjemploComboBox();
        dialog.pack();
        dialog.setLocationRelativeTo(origen);
        dialog.setVisible(true);
    }
}
