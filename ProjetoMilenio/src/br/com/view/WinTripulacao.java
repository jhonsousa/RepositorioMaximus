/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WinTripulacao.java
 *
 * Created on 09/08/2010, 10:02:26
 */
package br.com.view;

import br.com.dao.DAOEmpresa;
import br.com.dao.DAOTripulacao;
import br.com.pojo.Empresa;
import br.com.pojo.EmpresaTripulacao;
import br.com.util.JMoneyField;
import br.com.util.ToMoney;
import br.com.util.MyUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elton
 */
public class WinTripulacao extends javax.swing.JPanel {

    /** Creates new form WinTripulacao */
    private DefaultTableModel model;
    private List<Empresa> empresas;
    private List<EmpresaTripulacao> edfs;
    private EmpresaTripulacao edf;

    public WinTripulacao() {
        initComponents();
        empresas = new DAOEmpresa().getListWithQuery("select * from Empresa");
        MyUtil.refresComboBox(empresas, cbEmpresa);
        MyUtil.initiActionCmd(this);
        initAction();
    }

    private void initAction() {

        btNovo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                clear();
                edf = null;
            }
        });
        btCadastrar.addActionListener(getActionListener());
        // btAtualizar.addActionListener(getActionListener());
        btExcluir.addActionListener(getActionListener());
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                edf = getEDFofTable();

            }
        });
        cbEmpresa.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbEmpresa.getSelectedIndex() > 0) {
                        refresh();
                    } else {
                        clear();
                          edf = null;
                    }
                }
            }
        });


    }

    private void refresh() {
        if (cbEmpresa.getSelectedIndex() > 0) {
            edfs = new ArrayList<EmpresaTripulacao>();
            edfs = new DAOTripulacao().getListWithQuery("select * from " +
                    "EmpresaTripulacao where empresaId = " +
                    empresas.get(cbEmpresa.getSelectedIndex() - 1).getId());

            refreshTable(edfs);
        } else {
            clear();
        }
    }

    private void refreshTable(List<EmpresaTripulacao> list) {

        model = (DefaultTableModel) table.getModel();
        table.clearSelection();
        MyUtil.clearTable(table);
        for (int i = 0; i < list.size(); i++) {
            EmpresaTripulacao e = list.get(i);
            Object[] objeto = {e.getFrotaEspecie(), e.getFuncao(),
                e.getNumero(), "R$ "+ ToMoney.StringtoMoney(e.getSalario()),"R$ "+ ToMoney.StringtoMoney(e.getCusto()),
                "R$ "+ ToMoney.StringtoMoney(e.getLucro())};
            model.addRow(objeto);
        }
    }

    private EmpresaTripulacao getEDFofPanel() {

        if (edf != null) {
            edf.setRelacaoTrabalho(bgRelacaoTrabalho.getSelection().getActionCommand());
            edf.setFrotaEspecie(tfFrota.getText());
            edf.setFuncao(tfFuncao.getText());
            edf.setNumero(tfNumero.getText());
            edf.setCusto(tfCusto.getText());
            edf.setLucro(tfLucro.getText());
            edf.setSalario(tfSalario.getText());
            return edf;
        }
        EmpresaTripulacao edf = new EmpresaTripulacao();
        edf.setRelacaoTrabalho(bgRelacaoTrabalho.getSelection().getActionCommand());
        edf.setFrotaEspecie(tfFrota.getText());
        edf.setFuncao(tfFuncao.getText());
        edf.setNumero(tfNumero.getText());
        edf.setCusto(tfCusto.getText());
        edf.setLucro(tfLucro.getText());
        edf.setSalario(tfSalario.getText());
        edf.setEmpresaId(empresas.get(cbEmpresa.getSelectedIndex() - 1).getId());
        return edf;
    }

    private EmpresaTripulacao getEDFofTable() {

        EmpresaTripulacao e = edfs.get(table.getSelectedRow());
        MyUtil.setSelected(e.getRelacaoTrabalho(), bgRelacaoTrabalho);
        tfFrota.setText(e.getFrotaEspecie());
        tfFuncao.setText(e.getFuncao());
        tfNumero.setText(e.getNumero());
        tfCusto.setText(e.getCusto());
        tfLucro.setText(e.getLucro());
        tfSalario.setText(e.getLucro());       

        return e;
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

        if (cmd.equalsIgnoreCase("Cadastrar")) {
            edf = getEDFofPanel();
            new DAOTripulacao().cadastrar(edf);
        } else if (cmd.equalsIgnoreCase("Excluir")) {
            edf = getEDFofPanel();
            new DAOTripulacao().excluir(edf);
        } else if (cmd.equalsIgnoreCase("Atualizar")) {
            edf = getEDFofPanel();
            new DAOTripulacao().atualizar(edf);
        }
        refresh();
        clear();
        edf = null;
    }

    private void clear() {
        MyUtil.FieldsClear(this);
        bgRelacaoTrabalho.clearSelection();
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgRelacaoTrabalho = new javax.swing.ButtonGroup();
        panelCrudEmpresa1 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        cbEmpresa = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfFrota = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfFuncao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        tfCusto = new JMoneyField();
        tfLucro = new JMoneyField();
        tfSalario = new JMoneyField();

        panelCrudEmpresa1.setBackground(new java.awt.Color(255, 255, 255));

        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Realiza a Confirma��o do Pagamento definindo exatamente o dia de pagamento."); // NOI18N
        btCadastrar.setFocusable(false);
        btCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCadastrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btExcluir.setText("Excluir");

        btNovo.setText("Novo");

        cbEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Empresa");

        javax.swing.GroupLayout panelCrudEmpresa1Layout = new javax.swing.GroupLayout(panelCrudEmpresa1);
        panelCrudEmpresa1.setLayout(panelCrudEmpresa1Layout);
        panelCrudEmpresa1Layout.setHorizontalGroup(
            panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudEmpresa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudEmpresa1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel20)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel12))
                    .addGroup(panelCrudEmpresa1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrudEmpresa1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExcluir)
                                .addGap(172, 172, 172)
                                .addComponent(jLabel17)
                                .addGap(26, 26, 26)
                                .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel47))))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        panelCrudEmpresa1Layout.setVerticalGroup(
            panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudEmpresa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel47)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrudEmpresa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btNovo)
                    .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(btExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setText("Frota Especie");

        jLabel27.setText("Custo R$/Kg");

        jLabel22.setText("Numero");

        jLabel15.setText("Funcao");

        jLabel21.setText("S�lario");

        jLabel23.setText("Lucro R$/Kg");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Frota / Especie", "Funcao", "Numero", "S�lario", "Custo R$/Kg", "Lucro R$/Kg"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel52.setText("Rela��es de Trabalho");

        bgRelacaoTrabalho.add(jRadioButton5);
        jRadioButton5.setText("Sistema de Partes");

        bgRelacaoTrabalho.add(jRadioButton6);
        jRadioButton6.setText("Assalariado (Empresarial)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCrudEmpresa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(tfFrota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCrudEmpresa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel52)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfFrota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(tfCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(tfLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(349, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(176, 176, 176)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(176, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgRelacaoTrabalho;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox cbEmpresa;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCrudEmpresa1;
    private javax.swing.JTable table;
    public static javax.swing.JTextField tfCusto;
    private javax.swing.JTextField tfFrota;
    private javax.swing.JTextField tfFuncao;
    public static javax.swing.JTextField tfLucro;
    private javax.swing.JTextField tfNumero;
    public static javax.swing.JTextField tfSalario;
    // End of variables declaration//GEN-END:variables
}