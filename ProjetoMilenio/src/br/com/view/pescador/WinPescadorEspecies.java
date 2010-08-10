/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WinPescadorEspecies.java
 *
 * Created on 09/08/2010, 17:28:12
 */
package br.com.view.pescador;

import br.com.dao.DAOEmpresaPescador;
import br.com.dao.DAOPescador;
import br.com.dao.DAOPescadorEspecieCapturada;
import br.com.dao.DAOPescadorEspecies;
import br.com.pojo.PescadorEspecies;
import br.com.pojo.Pescador;
import br.com.pojo.PescadorEspecieCapturada;
import br.com.pojo.PescadorEspecies;
import br.com.util.MyUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elton
 */
public class WinPescadorEspecies extends javax.swing.JPanel {

    /** Creates new form WinPescadorEspecies */
    private List<Pescador> pescadors;
    private List<PescadorEspecies> especieses;
    private List<PescadorEspecieCapturada> especieCapturadas;

    public WinPescadorEspecies() {
        initComponents();
        pescadors = new DAOPescador().getListWithQuery("select * from Pescador");
        MyUtil.refresComboBox(pescadors, cbPescador);
        initAction();

    }

    private void initAction() {

        btCadastrar.addActionListener(getActionListener());
        btExcluir.addActionListener(getActionListener());
        btNovo.addActionListener(getActionListener());
        btRemove.addActionListener(getActionListenerEspecies());
        // btAtualizar.addActionListener(getActionListener());
        btAdd.addActionListener(getActionListenerEspecies());

        cbPescador.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbPescador.getSelectedIndex() > 0) {
                        refresh();
                        refreshEspecies();
                    } else {
                        clear();

                    }
                }
            }
        });


    }

    private void refreshEspecies() {
        if (cbPescador.getSelectedIndex() > 0) {
            especieses = new ArrayList<PescadorEspecies>();

            especieses = new DAOPescadorEspecies().getListWithQuery("select * from " +
                    "PescadorEspecies where pescadorId = " +
                    pescadors.get(cbPescador.getSelectedIndex() - 1).getId());

            refreshTable(especieses);
        } else {
            clear();
        }
    }

    private void refresh() {
        if (cbPescador.getSelectedIndex() > 0) {
            especieCapturadas = new ArrayList<PescadorEspecieCapturada>();

            especieCapturadas = new DAOPescadorEspecieCapturada().getListWithQuery("select * from " +
                    "PescadorEspecieCapturada where pescadorId = " +
                    pescadors.get(cbPescador.getSelectedIndex() - 1).getId());

            refreshTablePEC(especieCapturadas);
        } else {
            clear();
        }

    }

    private void refreshTablePEC(List<PescadorEspecieCapturada> list) {

        DefaultTableModel model = (DefaultTableModel) tablePec.getModel();
        tablePec.clearSelection();
        MyUtil.clearTable(tablePec);
        for (int i = 0; i < list.size(); i++) {
            PescadorEspecieCapturada e = list.get(i);
            Object[] objeto = {e.getSsp(), e.getInicioSafra(),
                e.getFimSafra()};
            model.addRow(objeto);
        }
    }

    private void refreshTable(List<PescadorEspecies> list) {

        DefaultTableModel model = (DefaultTableModel) tableEspecies.getModel();
        tableEspecies.clearSelection();
        MyUtil.clearTable(tableEspecies);
        for (int i = 0; i < list.size(); i++) {
            PescadorEspecies e = list.get(i);
            Object[] objeto = {e.getEspecie(), e.getCausaPerda(),
                e.getEstimativaPerda(), e.getDestinoPeixePerdido()};
            model.addRow(objeto);
        }
    }

    private ActionListener getActionListenerEspecies() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actionEspecies(e);
            }
        };
    }

    private ActionListener getActionListener() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        };
    }

    private void action(ActionEvent e) {

        String cmd = e.getActionCommand();
        if (cbPescador.getSelectedIndex() > 0) {
            if (cmd.equalsIgnoreCase("Cadastrar")) {
                new DAOPescadorEspecieCapturada().cadastrar(getPECofPanel());
            } else if (cmd.equalsIgnoreCase("Excluir")) {
                new DAOPescadorEspecieCapturada().excluir(getPECofTable());
            }
            refreshEspecies();
            cbPescador.setSelectedIndex(0);
            MyUtil.FieldsClear(this);

        }

    }

    private PescadorEspecieCapturada getPECofTable() {
        return especieCapturadas.get(tablePec.getSelectedRow());
    }

    private PescadorEspecieCapturada getPECofPanel() {
        PescadorEspecieCapturada pec = new PescadorEspecieCapturada();
        pec.setFimSafra(tfFimSafra.getText());
        pec.setInicioSafra(tfinicioSafra.getText());
        pec.setSsp(tfSsp.getText());
        pec.setPescadorId(pescadors.get(cbPescador.getSelectedIndex() - 1).getId());
        return pec;
    }

    private PescadorEspecies getEspeciesofTable() {
        return especieses.get(tableEspecies.getSelectedRow());
    }

    private PescadorEspecies getEspeciesofPanel() {
        PescadorEspecies edf = new PescadorEspecies();
        edf.setEspecie(tfEspecie.getText());
        edf.setCausaPerda(tfCausa.getText());
        edf.setEstimativaPerda(tfEstimativa.getText());
        edf.setDestinoPeixePerdido(tfDestino.getText());
        edf.setPescadorId(pescadors.get(cbPescador.getSelectedIndex() - 1).getId());
        return edf;
    }

    private void actionEspecies(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cbPescador.getSelectedIndex() > 0) {
            if (cmd.equalsIgnoreCase("Adicionar")) {
                new DAOPescadorEspecies().cadastrar(getEspeciesofPanel());
            } else if (cmd.equalsIgnoreCase("Remover")) {
                new DAOPescadorEspecies().excluir(getEspeciesofTable());
            }
             refreshEspecies();
        MyUtil.FieldsClear(this);
        }
    }

    private void clear() {

        MyUtil.clearTable(tableEspecies);
        MyUtil.clearTable(tablePec);
        cbPescador.setSelectedIndex(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCrudEmpresa3 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        cbPescador = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        tfCausa = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        tfEstimativa = new javax.swing.JTextField();
        tfDestino = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableEspecies = new javax.swing.JTable();
        tfEspecie = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tablePec = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        tfinicioSafra = new javax.swing.JTextField();
        tfSsp = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        tfFimSafra = new javax.swing.JTextField();

        panelCrudEmpresa3.setBackground(new java.awt.Color(255, 255, 255));

        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Realiza a Confirma��o do Pagamento definindo exatamente o dia de pagamento."); // NOI18N
        btCadastrar.setFocusable(false);
        btCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCadastrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btExcluir.setText("Excluir");

        btNovo.setText("Novo");

        cbPescador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Pescador");

        javax.swing.GroupLayout panelCrudEmpresa3Layout = new javax.swing.GroupLayout(panelCrudEmpresa3);
        panelCrudEmpresa3.setLayout(panelCrudEmpresa3Layout);
        panelCrudEmpresa3Layout.setHorizontalGroup(
            panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudEmpresa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudEmpresa3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel22)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel14))
                    .addGroup(panelCrudEmpresa3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrudEmpresa3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir)
                                .addGap(176, 176, 176)
                                .addComponent(jLabel19)
                                .addGap(26, 26, 26)
                                .addComponent(cbPescador, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel49))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        panelCrudEmpresa3Layout.setVerticalGroup(
            panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudEmpresa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel49)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrudEmpresa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btNovo)
                    .addComponent(cbPescador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(btExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel65.setText("Causa da Perda");

        jLabel64.setText("Esp�cie");

        jLabel67.setText("Destino do Peixe perdido");

        jLabel66.setText("Estimativa da Perda (%)");

        tableEspecies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Esp�cie", "Causa da Perda", "Estimativa da Perda (%)", "Destino do Peixe perdido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(tableEspecies);

        btAdd.setText("Adicionar");
        btAdd.setToolTipText("Realiza a Confirma��o do Pagamento definindo exatamente o dia de pagamento."); // NOI18N
        btAdd.setFocusable(false);
        btAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btRemove.setText("Remover");

        tablePec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Spp", "Inicio de Safra", "Fim de Safra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(tablePec);

        jLabel68.setText("Spp");

        jLabel69.setText("Inicio de Safra");

        jLabel70.setText("Fim de Safra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrudEmpresa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel68))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfinicioSafra, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSsp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFimSafra, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel64))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(tfEstimativa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdd)
                    .addComponent(btRemove))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCrudEmpresa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel70)
                            .addComponent(tfFimSafra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfinicioSafra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel66)
                            .addComponent(tfEstimativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67)
                            .addComponent(tfCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel65)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemove)))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemove;
    private javax.swing.JComboBox cbPescador;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JPanel panelCrudEmpresa3;
    private javax.swing.JTable tableEspecies;
    private javax.swing.JTable tablePec;
    private javax.swing.JTextField tfCausa;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JTextField tfEspecie;
    private javax.swing.JTextField tfEstimativa;
    private javax.swing.JTextField tfFimSafra;
    private javax.swing.JTextField tfSsp;
    private javax.swing.JTextField tfinicioSafra;
    // End of variables declaration//GEN-END:variables
}