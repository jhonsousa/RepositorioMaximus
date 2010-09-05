/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * winProduto.java
 *
 * Created on 16/07/2010, 15:50:37
 */

package br.com.bean2;

import br.com.bean.*;
import br.com.Persistencia.Conexao;
import br.com.util.JMoneyField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Elton
 */
public class addCProduto_MercadoLocal extends javax.swing.JFrame {

    /** Creates new form winProduto */
    private Conexao conexao;
    public String id_atravessador;
    public addCProduto_MercadoLocal(String idd_atravessador) {
        
        initComponents();
        conexao = new Conexao();
        conexao.conecta("mil_interface");
        System.out.println(idd_atravessador);
        id_atravessador = idd_atravessador;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_botoes_mercado = new javax.swing.ButtonGroup();
        tfDestino = new javax.swing.JTextField();
        tfVolume = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botao_add_mat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfOutraEspecie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPreco = new JMoneyField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbEspecie = new javax.swing.JComboBox();
        tfOutroProduto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        rbMercadoLocal = new javax.swing.JRadioButton();
        rbMercadoEstadual = new javax.swing.JRadioButton();
        rbMercadoNacional = new javax.swing.JRadioButton();
        rbMercadoInternacional = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cbUnidadeVolume = new javax.swing.JComboBox();
        tfOutroUnidadeVolume = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tfVolume.setText("0");

        jLabel1.setText("Destino.:");

        jLabel2.setText("Volume.:");

        botao_add_mat.setText("Add");
        botao_add_mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Action(evt);
            }
        });

        jLabel3.setText("Esp�cie");

        tfOutraEspecie.setEditable(false);

        jLabel4.setText("Pre�o ($).:");

        tfPreco.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Mercado Local (no mesmo munic�pio)");

        jLabel7.setText("Outra");

        cbEspecie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pescada amarela", "Gurijuba", "Tubar�es", "Outros" }));
        cbEspecie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEspecieItemStateChanged(evt);
            }
        });
        cbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecieActionPerformed(evt);
            }
        });

        tfOutroProduto.setEditable(false);

        jLabel9.setText("Outra");

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carne", "Grude seca", "Grude fresca", "Aba", "Outros" }));
        cbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutoItemStateChanged(evt);
            }
        });
        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        jLabel10.setText("Produto");

        grupo_botoes_mercado.add(rbMercadoLocal);
        rbMercadoLocal.setSelected(true);
        rbMercadoLocal.setText("Mercado Local (mesmo munic�pio)");

        grupo_botoes_mercado.add(rbMercadoEstadual);
        rbMercadoEstadual.setText("Mercado Estadual (sem o mesmo munic�pio)");

        grupo_botoes_mercado.add(rbMercadoNacional);
        rbMercadoNacional.setText("Mercado Nacional (sem o de origem)");

        grupo_botoes_mercado.add(rbMercadoInternacional);
        rbMercadoInternacional.setText("Mercado Internacional");

        jLabel5.setText("Volume em:");

        cbUnidadeVolume.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kg", "Tonelada", "Outro" }));
        cbUnidadeVolume.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUnidadeVolumeItemStateChanged(evt);
            }
        });

        tfOutroUnidadeVolume.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botao_add_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfOutroProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfOutraEspecie, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbEspecie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbMercadoNacional)
                                            .addComponent(rbMercadoLocal))
                                        .addGap(22, 22, 22)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbMercadoEstadual)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4))
                                            .addGap(31, 31, 31)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(tfVolume, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(cbUnidadeVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(tfOutroUnidadeVolume)))))
                                        .addComponent(rbMercadoInternacional))
                                    .addComponent(jLabel5)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel6)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMercadoEstadual)
                    .addComponent(rbMercadoLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMercadoNacional)
                    .addComponent(rbMercadoInternacional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOutraEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOutroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbUnidadeVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfOutroUnidadeVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)))
                .addComponent(botao_add_mat)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Action
       //Gambiarra pra pegar o nome do RadioButom Selecionado
        String rb_selecionado = "Mercado Local";
        if (rbMercadoLocal.isSelected()) {
            rb_selecionado = "Mercado Local";
        }else if (rbMercadoEstadual.isSelected()) {
                  rb_selecionado = "Mercado Estadual";
              }else if (rbMercadoNacional.isSelected()) {
                        rb_selecionado = "Mercado Nacional";
                    }else
                        rb_selecionado = "Mercado Internacional";

        System.out.println(rb_selecionado);

       /* try {
            conexao.execute("select * from atravessador_addmercado");
            conexao.resultSet.first();
            System.out.println(conexao.resultSet.getString("mercado"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/

         String sqlinsert = "insert into caminhoneiro_addmercado "
                    + "(id_caminhoneiro,mercado,especie,produto,"
                    + "destino,volume,unidade_volume,preco) values ('"+
                    id_atravessador+"','"+
                    rb_selecionado+"','"+
                    registro_especie()+"','"+
                    registro_produto()+"','"+
                    tfDestino.getText()+"','"+
                    tfVolume.getText()+"','"+
                    registro_outra_unidade_volume()+"','"+
                    tfPreco.getText()+"')";

                    System.out.println(sqlinsert);
                    if (conexao.salvar(sqlinsert)){
                        JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                        limpar();
                    }
                    //agora � hora de atualizar o resultset

                    //addMaterial.this.dispose();
    }//GEN-LAST:event_Action

    private void cbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecieActionPerformed
        
    }//GEN-LAST:event_cbEspecieActionPerformed

    private void cbEspecieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEspecieItemStateChanged
        if (cbEspecie.getSelectedItem().equals("Tubar�es")){ //selecionou tubar�es troca os itens do cbProduto
            cbProduto.removeAllItems();
            cbProduto.addItem("Aba");
        }
        else{ //selecionou outra coisa o cbProduto volta ao normal
            cbProduto.removeAllItems();
            cbProduto.addItem("Carne");
            cbProduto.addItem("Grude seca");
            cbProduto.addItem("Grude fresca");
        }

        if (cbEspecie.getSelectedItem() == "Outros"){
            tfOutraEspecie.setEditable(true);
            tfOutroProduto.setEditable(true);
            cbProduto.setEnabled(false);
        }
        else{
            tfOutraEspecie.setEditable(false);
            tfOutroProduto.setEditable(false);
            cbProduto.setEnabled(true);
        }
    }//GEN-LAST:event_cbEspecieItemStateChanged

    private void cbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProdutoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProdutoItemStateChanged

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void cbUnidadeVolumeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUnidadeVolumeItemStateChanged
        if (cbUnidadeVolume.getSelectedItem() == "Outro"){
            tfOutroUnidadeVolume.setEditable(true);
        }
        else
            tfOutroUnidadeVolume.setEditable(false);
    }//GEN-LAST:event_cbUnidadeVolumeItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCProduto_MercadoLocal("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_add_mat;
    private javax.swing.JComboBox cbEspecie;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbUnidadeVolume;
    private javax.swing.ButtonGroup grupo_botoes_mercado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbMercadoEstadual;
    private javax.swing.JRadioButton rbMercadoInternacional;
    private javax.swing.JRadioButton rbMercadoLocal;
    private javax.swing.JRadioButton rbMercadoNacional;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JTextField tfOutraEspecie;
    private javax.swing.JTextField tfOutroProduto;
    private javax.swing.JTextField tfOutroUnidadeVolume;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfVolume;
    // End of variables declaration//GEN-END:variables

    public Object registro_especie(){
                 if (tfOutraEspecie.isEditable()){
                     return tfOutraEspecie.getText();
                 }
                 else
                     return cbEspecie.getSelectedItem();
         }

    public Object registro_produto(){
                 if (tfOutroProduto.isEditable()){
                     return tfOutroProduto.getText();
                 }
                 else
                     return cbProduto.getSelectedItem();
         }

    public void limpar(){
        tfDestino.setText("");
        tfVolume.setText("0");
        tfPreco.setText("0");
        
        tfOutraEspecie.setText("");
        tfOutroProduto.setText("");
        
        cbEspecie.setSelectedIndex(0);
        cbProduto.setSelectedIndex(0);
        
    }

    private Object registro_outra_unidade_volume() {
        if (tfOutroUnidadeVolume.isEditable()){
            return tfOutroUnidadeVolume.getText();
        }
        else
            return cbUnidadeVolume.getSelectedItem();
    }

}
