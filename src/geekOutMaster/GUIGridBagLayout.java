package geekOutMaster;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUIGridBagLayout extends JFrame {
    public static final String MENSAJE_AYUDA = "Bienvenido a GreekOutMaster"
            + "\nTienes máximo 5 rondas para sumar 30 puntos y ganar "
            + "\nEl Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos"
            + "\nLa Nave Espacial envía un dado no usado (de la sección dados activos) a la sección de dados inactivos."
            + "\nEl Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y colocado en su cara opuesta."
            + "\nEl corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo."
            + "\nEl Dragón es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que queda se habrán perdido todos los puntos ganados y acumulados."
            + "\n42 es la cara que permite sumar puntos al final de la ronda";

    private Header headerProject;
    private JLabel dadosActivos, dadosInactivos;
    private JPanel panelDadosActivos, panelDadosInactivos, panelDadosUtilizados;
    private ImageIcon imageDado, imageDados7;
    private JButton lanzar, ayuda, dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private JTextArea resultadosDados;
    private Escucha escucha;
    private Model Model;

    public GUIGridBagLayout() {
        initGUI();
        this.setTitle("Game Greek Out Master");
        this.setSize(200, 100);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object or Control Object

        escucha = new Escucha();
        Model = new Model();
        //Set up JComponents
        headerProject = new Header("Geek Out Master", Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        imageDados7 = new ImageIcon(getClass().getResource("/resources/Dices7.png"));
        imageDado = new ImageIcon(getClass().getResource("/resources/Dices3.png"));
        dadosActivos = new JLabel(imageDados7);
        dado1 = new JButton();
        dado1.addActionListener(escucha);
        dado2 = new JButton();
        dado2.addActionListener(escucha);
        dado3 = new JButton();
        dado3.addActionListener(escucha);
        dado4 = new JButton();
        dado4.addActionListener(escucha);
        dado5 = new JButton();
        dado5.addActionListener(escucha);
        dado6 = new JButton();
        dado6.addActionListener(escucha);
        dado7 = new JButton();
        dado7.addActionListener(escucha);
        dado8 = new JButton(imageDado);
        dado9 = new JButton();
        dado10 = new JButton();

        lanzar = new JButton("lanzar");
        lanzar.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar, constraints);

        ayuda = new JButton("Ayuda");
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);

        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(600, 310));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
                "Dados Activos", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 25), Color.BLACK));
        panelDadosActivos.setBackground(new Color(255, 255, 255, 0));
        panelDadosActivos.add(dadosActivos);
        panelDadosActivos.add(lanzar);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosActivos, constraints);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(600, 280));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
                "Dados Inactivos", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 25), Color.BLACK));
        panelDadosInactivos.setBackground(new Color(255, 255, 255, 0));
        panelDadosInactivos.add(dado8);
        panelDadosInactivos.add(dado9);
        panelDadosInactivos.add(dado10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosInactivos, constraints);

        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(500, 280));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
                "Dados Utilizados", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 25), Color.BLACK));
        panelDadosUtilizados.setBackground(new Color(255, 255, 255, 0));
        //panelDadosUtilizados.add();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosUtilizados, constraints);

        resultadosDados = new JTextArea(2, 30);
        resultadosDados.setText("Usa el botón (Ayuda) para ver la reglas del juego ");
        resultadosDados.setEditable(false);
        resultadosDados.setForeground(Color.black);
        resultadosDados.setBackground(new Color(255, 255, 255, 0));
        resultadosDados.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3),
                "Marcador de puntaje", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 18), Color.black));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(resultadosDados, constraints);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == lanzar) {
                Model.calcularTiro();
                int[] caras = Model.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[0] + ".JPG"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[1] + ".JPG"));
                dado2.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[2] + ".JPG"));
                dado3.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[3] + ".JPG"));
                dado4.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[4] + ".JPG"));
                dado5.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[5] + ".JPG"));
                dado6.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[6] + ".JPG"));
                dado7.setIcon(imageDado);
                Model.determinarJuego();
                panelDadosActivos.remove(dadosActivos);
                panelDadosActivos.remove(lanzar);
                panelDadosActivos.add(dado1);
                panelDadosActivos.add(dado2);

                panelDadosActivos.add(dado3);

                panelDadosActivos.add(dado4);

                panelDadosActivos.add(dado5);

                panelDadosActivos.add(dado6);

                panelDadosActivos.add(dado7);

                resultadosDados.setText(Model.getEstadoToString()[0]);
                revalidate();
                repaint();
            }else {if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_AYUDA);
             }else{
                if (e.getSource() == dado1) {
                    panelDadosActivos.remove(dado1);
                    repaint();
                    panelDadosActivos.add(dado1);
                }
                if (e.getSource() == dado2) {
                    panelDadosActivos.remove(dado2);
                    repaint();
                    panelDadosActivos.add(dado2);
                }
                if (e.getSource() == dado3) {
                    panelDadosActivos.remove(dado3);
                    repaint();
                    panelDadosActivos.add(dado3);
                }
                if (e.getSource() == dado4) {
                    panelDadosActivos.remove(dado4);
                    repaint();
                    panelDadosActivos.add(dado4);
                }
                if (e.getSource() == dado5) {
                    panelDadosActivos.remove(dado5);
                    repaint();
                    panelDadosActivos.add(dado5);
                }
                if (e.getSource() == dado6) {
                    panelDadosActivos.remove(dado6);
                    repaint();
                    panelDadosActivos.add(dado6);
                }
                if (e.getSource() == dado7) {
                    panelDadosActivos.remove(dado7);
                    repaint();
                    panelDadosActivos.add(dado7);
                }
             }
            }
        }
    }
}