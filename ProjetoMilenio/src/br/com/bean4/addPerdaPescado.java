/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * addPerdaPescado.java
 *
 * Created on 16/08/2010, 17:25:38
 */

package br.com.bean4;

import br.com.Persistencia.Conexao;
import java.sql.SQLException;

/**
 *
 * @author MPA
 */
public class addPerdaPescado extends javax.swing.JFrame {

    private Conexao conexao;
    public String idd_perda_pescado;


    /** Creates new form addPerdaPescado */
    public addPerdaPescado(String id_perda_pescado) {
        initComponents();
        conexao = new Conexao();
        conexao.conecta("mil_interface");
        System.out.println("perda_pescado");
        idd_perda_pescado =id_perda_pescado;

    }

    private addPerdaPescado() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCausaPerda = new javax.swing.JComboBox();
        tfEstimativa = new javax.swing.JTextField();
        tfDestinoPeixe = new javax.swing.JTextField();
        jbPrincipaisPerdas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfOutros = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Principais Perdas de Pescado");

        jLabel2.setText("Causa da perda: ");

        jLabel3.setText("Estimativa da Perda(%):");

        jLabel4.setText("Destino do Peixe:");

        cbCausaPerda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Deterioriza��o", "Falta de Mercado", "M� conserva��o", "Transporte", "Outras Perdas" }));
        cbCausaPerda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCausaPerdaItemStateChanged(evt);
            }
        });

        jbPrincipaisPerdas.setText("Add");
        jbPrincipaisPerdas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrincipaisPerdasActionPerformed(evt);
            }
        });

        jLabel5.setText("Outros:");

        tfOutros.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfDestinoPeixe, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfOutros, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(cbCausaPerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9))))
                                .addGap(28, 28, 28)
                                .addComponent(jbPrincipaisPerdas))
                            .addComponent(tfEstimativa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCausaPerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEstimativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDestinoPeixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jbPrincipaisPerdas))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPrincipaisPerdasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrincipaisPerdasActionPerformed
            try {
            conexao.execute("select * from mercado_perdapescado");
            conexao.resultSet.first();
           // System.out.println(conexao.resultSet.getString("nome"));
        } catch (SQLException e) {
            System.out.println(e);
        }

        String sqlinsert = "insert into mercado_perdapescado" + "(id_perda_pescado,outros,causa_perda,estimativa_da_perda,destino_do_peixe_perdido) values ('" +
               idd_perda_pescado + "','" +
               tfOutros.getText()+",'"+
               tfEstimativa.getText() + ",'" +
               tfDestinoPeixe.getText() + "')";
               
        System.out.println(sqlinsert);
        conexao.salvar(sqlinsert);
    }//GEN-LAST:event_jbPrincipaisPerdasActionPerformed

    private void cbCausaPerdaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCausaPerdaItemStateChanged
        if (cbCausaPerda.getSelectedItem() == "Outras Perdas") {
            tfOutros.setEditable(true);
        } else {
            tfOutros.setEditable(false);
        }
    }//GEN-LAST:event_cbCausaPerdaItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPerdaPescado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCausaPerda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbPrincipaisPerdas;
    private javax.swing.JTextField tfDestinoPeixe;
    private javax.swing.JTextField tfEstimativa;
    private javax.swing.JTextField tfOutros;
    // End of variables declaration//GEN-END:variables

}
