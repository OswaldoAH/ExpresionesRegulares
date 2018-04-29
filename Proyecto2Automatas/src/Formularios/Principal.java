/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Generar_Grafica;
import Clases.ValidarPalabra;
import com.sun.awt.AWTUtilities;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mynor
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        AWTUtilities.setWindowShape(this, forma);
        alfabeto = new ArrayList<>();
        graf = new Generar_Grafica();
        validar = new ValidarPalabra();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtExpresion = new javax.swing.JTextField();
        btnIngresarPalabra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblAlfabeto = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelGrafico = new javax.swing.JPanel();
        lblGrafico = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPalabra = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnGraficar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/13297.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1130, 10, 40, 40);

        jLabel2.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Expresiones Regulares");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 10, 290, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_portal.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 200, 86);

        txtExpresion.setBackground(new java.awt.Color(255, 255, 255));
        txtExpresion.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        txtExpresion.setForeground(new java.awt.Color(0, 102, 102));
        txtExpresion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtExpresion.setOpaque(true);
        txtExpresion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExpresionKeyTyped(evt);
            }
        });
        jPanel1.add(txtExpresion);
        txtExpresion.setBounds(10, 430, 670, 40);

        btnIngresarPalabra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checkmark.png"))); // NOI18N
        btnIngresarPalabra.setBorderPainted(false);
        btnIngresarPalabra.setContentAreaFilled(false);
        btnIngresarPalabra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresarPalabra.setEnabled(false);
        btnIngresarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPalabraActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarPalabra);
        btnIngresarPalabra.setBounds(710, 470, 60, 50);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alfabeto.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 90, 70, 40);

        lblAlfabeto.setBackground(new java.awt.Color(0, 0, 0));
        lblAlfabeto.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        lblAlfabeto.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblAlfabeto);
        lblAlfabeto.setBounds(90, 90, 1080, 40);

        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setOpaque(true);

        rSTableMetro1.setBackground(new java.awt.Color(0, 102, 102));
        rSTableMetro1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Palabra", "V"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(0, 102, 102));
        jScrollPane3.setViewportView(rSTableMetro1);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(1).setMinWidth(30);
            rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(30);
            rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(730, 130, 440, 220);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelGrafico.setBackground(new java.awt.Color(0, 102, 102));
        panelGrafico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGrafico.add(lblGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 200));

        jScrollPane1.setViewportView(panelGrafico);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 650, 220);

        jLabel5.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Expresión Regular");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 380, 670, 40);

        jLabel7.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Palabra");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(710, 380, 320, 40);

        txtPalabra.setEditable(false);
        txtPalabra.setBackground(new java.awt.Color(255, 255, 255));
        txtPalabra.setFont(new java.awt.Font("MV Boli", 3, 24)); // NOI18N
        txtPalabra.setForeground(new java.awt.Color(0, 102, 102));
        txtPalabra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPalabra.setOpaque(true);
        txtPalabra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPalabraKeyTyped(evt);
            }
        });
        jPanel1.add(txtPalabra);
        txtPalabra.setBounds(710, 430, 460, 40);

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checkmark.png"))); // NOI18N
        btnIngresar.setBorderPainted(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar);
        btnIngresar.setBounds(10, 470, 60, 50);

        btnGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload.png"))); // NOI18N
        btnGraficar.setBorderPainted(false);
        btnGraficar.setContentAreaFilled(false);
        btnGraficar.setEnabled(false);
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGraficar);
        btnGraficar.setBounds(660, 130, 60, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExpresionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpresionKeyTyped
        char c = evt.getKeyChar();
        if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            evt.consume();
        } else if ((c != '|' && c != '(' && c != ')' && c != '*') && !(c >= 'a' && c <= 'z')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtExpresionKeyTyped

    private boolean verificar() {
        String cadena=txtExpresion.getText();
        cad=cadena.toCharArray();
        for (int i = 0; i < cad.length; i++) {
            switch (cad[i]) {
                case '(':
                    cont += 1;
                    break;
                case ')':
                    cont -= 1;
                    break;
                default:
                    if (cad[i] != '*' && cad[i] != '|') {
                        if (alfabeto.isEmpty()) {
                            alfabeto.add("" + cad[i]);
                        } else {
                            boolean encontrado = false;
                            for (String alfabeto1 : alfabeto) {
                                if (alfabeto1.equals("" + cad[i])) {
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                alfabeto.add("" + cad[i]);
                            }
                        }
                    }
                    break;
            }
        }
        if (cont == 0) {
            String texto = "{ ";
            Collections.sort(alfabeto);
            texto = alfabeto.stream().map((alf) -> alf).reduce(texto, String::concat);
            texto += " }";
            lblAlfabeto.setText(texto);
            txtExpresion.setEditable(false);
            btnIngresar.setEnabled(false);
            btnIngresarPalabra.setEnabled(true);
            txtPalabra.setEditable(true);
            return true;
        } else {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Expresión regular incorrecta");
            return false;
        }
    }
    private void btnIngresarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPalabraActionPerformed

    }//GEN-LAST:event_btnIngresarPalabraActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void txtPalabraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPalabraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPalabraKeyTyped

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (txtExpresion.getText().length() != 0) {
            if (verificar()) {
                if (graf.SetER(txtExpresion.getText())) {
                    btnGraficar.setEnabled(true);
                    validar.insertar(cad);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo \"expresión regular\" está vacío.");
            txtExpresion.requestFocus();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        lblGrafico.setIcon(new ImageIcon("Automata.jpg"));
        lblGrafico.repaint();
        panelGrafico.repaint();

    }//GEN-LAST:event_btnGraficarActionPerformed
    private final ArrayList<String> alfabeto;
    private int cont = 0;
    private char cad[];
    private int x, y;
    private final Generar_Grafica graf;
    private ValidarPalabra validar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresarPalabra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAlfabeto;
    private javax.swing.JLabel lblGrafico;
    private javax.swing.JPanel panelGrafico;
    private rojerusan.RSTableMetro rSTableMetro1;
    private javax.swing.JTextField txtExpresion;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
