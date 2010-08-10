/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WinPercepcaoAmbiental.java
 *
 * Created on 09/08/2010, 17:34:18
 */

package br.com.view.pescador;

import br.com.dao.DAOPercepcaoAmbiental;
import br.com.dao.DAOPescador;
import br.com.dao.DAOPescadorDadosEmbarcacao;
import br.com.pojo.Pescador;
import br.com.pojo.PescadorPersPectiva;
import br.com.pojo.PescadorPersPectiva;
import br.com.util.MyUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 *
 * @author Elton
 */
public class WinPercepcaoAmbiental extends javax.swing.JPanel {

    /** Creates new form WinPercepcaoAmbiental */
     private List<Pescador> pescadors;
    private PescadorPersPectiva pde;
    public WinPercepcaoAmbiental() {
        initComponents();
          initComponents();

        pescadors = new DAOPescador().getListWithQuery("select * from Pescador");
        MyUtil.refresComboBox(pescadors, cbPescador);
        initAction();

    }

     private void initAction() {



        cbPescador.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbPescador.getSelectedIndex() > 0) {
                        refresh();

                    } else {
                        clear();
                        pde = null;
                    }
                }
            }
        });


        btNovo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        btCadastrar.addActionListener(getActionListener());
        btAtualizar.addActionListener(getActionListener());
      //  btExcluir.addActionListener(getActionListener());



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
            pde = getpescadorOfPanel();
            new DAOPercepcaoAmbiental().cadastrar(pde);
        } else if (cmd.equalsIgnoreCase("Excluir")) {
            pde = getpescadorOfPanel();
            new DAOPercepcaoAmbiental().excluir(pde);
        } else if (cmd.equalsIgnoreCase("Atualizar")) {
            pde = getpescadorOfPanel();
            new DAOPercepcaoAmbiental().atualizar(pde);
        }
        clear();
        cbPescador.setSelectedIndex(0);


    }

   private void setpescadorComposicaoForPanel(PescadorPersPectiva p) {

        tfQuestao1.setText(p.getQuestao1());
        tfQuestao2.setText(p.getQuestao2());
        tfQuestao3.setText(p.getQuestao3());
        tfQuestao4.setText(p.getQuestao4());
        tfQuestao5.setText(p.getQuestao5());
        tfQuestao6.setText(p.getQuestao6());
        tfQuestao7.setText(p.getQuestao7());
        tfQuestao8.setText(p.getQuestao8());
        tfQuestao9.setText(p.getQuestao9());
        tfQuestao10.setText(p.getQuestao10());
        tfQuestao11.setText(p.getQuestao11());
        tfQuestao12.setText(p.getQuestao12());
        tfQuestao13.setText(p.getQuestao13());
        tfQuestao14.setText(p.getQuestao14());
        tfQuestao15.setText(p.getQuestao15());
        tfQuestao16.setText(p.getQuestao16());
        tfQuestao17.setText(p.getQuestao17());

    }

    private PescadorPersPectiva getpescadorOfPanel() {

        String questao1 = tfQuestao1.getText();
        String questao2 = tfQuestao2.getText();
        String questao3 = tfQuestao3.getText();
        String questao4 = tfQuestao4.getText();
        String questao5 = tfQuestao5.getText();
        String questao6 = tfQuestao6.getText();
        String questao7 = tfQuestao7.getText();
        String questao8 = tfQuestao8.getText();
        String questao9 = tfQuestao9.getText();
        String questao10 = tfQuestao10.getText();
        String questao11 = tfQuestao11.getText();
        String questao12 = tfQuestao12.getText();
        String questao13 = tfQuestao13.getText();
        String questao14 = tfQuestao14.getText();
        String questao15 = tfQuestao15.getText();
        String questao16 = tfQuestao16.getText();
        String questao17 = tfQuestao17.getText();


        if (this.pde != null) {
            pde.all(questao1, questao2, questao3, questao4,
                    questao5, questao6, questao7, questao8, questao9,
                    questao10, questao11, questao12, questao13, questao14,
                    questao15, questao16, questao17, questao17, pde.getPescadorId());
            return pde;
        }

        PescadorPersPectiva pescador = new PescadorPersPectiva();
        pescador.all(questao1, questao2, questao3, questao4,
                    questao5, questao6, questao7, questao8, questao9,
                    questao10, questao11, questao12, questao13, questao14,
                    questao15, questao16, questao17, questao17,
                    pescadors.get(cbPescador.getSelectedIndex() - 1).getId());

        return pescador;
    }

    private void clear() {

        MyUtil.FieldsClear(this);


    }

    private void refresh() {

        pde = new DAOPercepcaoAmbiental().getObjectWithQuery("select * from " +
                "PescadorPersPectiva where pescadorId = " +
                pescadors.get(cbPescador.getSelectedIndex() - 1).getId());
        if (pde != null) {
            setpescadorComposicaoForPanel(pde);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tfQuestao4 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfQuestao1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfQuestao3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        panelCrudEmpresa3 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        cbPescador = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfQuestao2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tfQuestao5 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tfQuestao6 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tfQuestao7 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tfQuestao8 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tfQuestao9 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        sc = new javax.swing.JScrollPane();
        tfQuestao10 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tfQuestao11 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tfQuestao12 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tfQuestao13 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tfQuestao14 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tfQuestao15 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tfQuestao16 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tfQuestao17 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tfQuestao18 = new javax.swing.JTextArea();

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel1.setText("Existe alguma intera��o entre os pescadores em rela��o � troca ou coopera��o dos produtos?");

        tfQuestao4.setColumns(20);
        tfQuestao4.setRows(5);
        jScrollPane4.setViewportView(tfQuestao4);

        tfQuestao1.setColumns(20);
        tfQuestao1.setRows(5);
        jScrollPane1.setViewportView(tfQuestao1);

        jLabel2.setText("Qual o grau de competitividade entre os pescadores?");

        tfQuestao3.setColumns(20);
        tfQuestao3.setRows(5);
        jScrollPane3.setViewportView(tfQuestao3);

        jLabel4.setText("Voc� acredita que as mudan�as clim�ticas podem influenciar na pesca e no estoque? Como?");

        panelCrudEmpresa3.setBackground(new java.awt.Color(255, 255, 255));

        btCadastrar.setText("Cadastrar");
        btCadastrar.setToolTipText("Realiza a Confirma��o do Pagamento definindo exatamente o dia de pagamento."); // NOI18N
        btCadastrar.setFocusable(false);
        btCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCadastrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btAtualizar.setText("Atualizar");
        btAtualizar.setToolTipText("Atualiza Valor e Data de pagamento da mensalidade");

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
                                .addComponent(btAtualizar)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel19)
                                .addGap(26, 26, 26)
                                .addComponent(cbPescador, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel49))))
                .addContainerGap(566, Short.MAX_VALUE))
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
                    .addComponent(btAtualizar)
                    .addComponent(btCadastrar)
                    .addComponent(btNovo)
                    .addComponent(cbPescador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("O que voc� entende por mudan�as clim�ticas? Voc� ja ouviu falar?");

        tfQuestao2.setColumns(20);
        tfQuestao2.setRows(5);
        jScrollPane2.setViewportView(tfQuestao2);

        jLabel6.setText("Quais medidas que voc� tem tomado para se adaptar esses efeitos?");

        tfQuestao5.setColumns(20);
        tfQuestao5.setRows(5);
        jScrollPane7.setViewportView(tfQuestao5);

        jLabel7.setText("Quais os problemas ambientais que interferem na atividade da pesca na �rea em que voc� captura");

        tfQuestao6.setColumns(20);
        tfQuestao6.setRows(5);
        jScrollPane8.setViewportView(tfQuestao6);

        jLabel8.setText("O que voc� acha que deveria ser feito para solucionar?");

        tfQuestao7.setColumns(20);
        tfQuestao7.setRows(5);
        jScrollPane9.setViewportView(tfQuestao7);

        jLabel9.setText("O que est� acontecendo com o tamanho e a quantidade de pescado?");

        tfQuestao8.setColumns(20);
        tfQuestao8.setRows(5);
        jScrollPane10.setViewportView(tfQuestao8);

        jLabel10.setText("Quais os motivos responsaveis pela diminui��o?");

        tfQuestao9.setColumns(20);
        tfQuestao9.setRows(5);
        jScrollPane11.setViewportView(tfQuestao9);

        jLabel11.setText("Caso ocorra o desaparecimento do pescado, como voc� sustentaria sua familia?");

        tfQuestao10.setColumns(20);
        tfQuestao10.setRows(5);
        sc.setViewportView(tfQuestao10);

        jLabel12.setText("Existe algum tipo de tradi��o sobre captura do pescado entre os pescadores locais");

        tfQuestao11.setColumns(20);
        tfQuestao11.setRows(5);
        jScrollPane13.setViewportView(tfQuestao11);

        jLabel13.setText("Existem crian�as envolvidas nesta pesca");

        tfQuestao12.setColumns(20);
        tfQuestao12.setRows(5);
        jScrollPane14.setViewportView(tfQuestao12);

        jLabel15.setText("Voc� desejaria que seus filhos tamb�m sejam pescadores? Por que? (Perspectiva do pescador quanto ao futuro profissional dos filhos)");

        tfQuestao13.setColumns(20);
        tfQuestao13.setRows(5);
        jScrollPane15.setViewportView(tfQuestao13);

        jLabel16.setText("Existe algum conflito entre o pescador de emalhe (Pescada amarela, serra) e outros?");

        tfQuestao14.setColumns(20);
        tfQuestao14.setRows(5);
        jScrollPane16.setViewportView(tfQuestao14);

        jLabel17.setText("A produ��o possui um destino certo (Atravessador)? Caso tenha, existe um grau de deped�ncia com este atravessador");

        tfQuestao15.setColumns(20);
        tfQuestao15.setRows(5);
        jScrollPane17.setViewportView(tfQuestao15);

        jLabel18.setText("O que voc� acha que deve mudar no sistema pesqueiro para garantir a perman�ncia do estoque?");

        tfQuestao16.setColumns(20);
        tfQuestao16.setRows(5);
        jScrollPane18.setViewportView(tfQuestao16);

        jLabel20.setText("Quais as dificuldades (gargalos) encontrados para manter a tividade da venda? Quais as possiveis solu��es (demandas) para melhorar seu trabalho?");

        tfQuestao17.setColumns(20);
        tfQuestao17.setRows(5);
        jScrollPane19.setViewportView(tfQuestao17);

        jLabel21.setText("Como voc� oberva a atua��o das institui��es IBAMA, SEPAQ; Minist�rio da Pesca; Universidades e qual a sua rela��o com estas?");

        tfQuestao18.setColumns(20);
        tfQuestao18.setRows(5);
        jScrollPane20.setViewportView(tfQuestao18);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(1024, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(panelCrudEmpresa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(512, 512, 512))
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(panelCrudEmpresa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1563, Short.MAX_VALUE)))
        );

        jScrollPane6.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1798, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox cbPescador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelCrudEmpresa3;
    private javax.swing.JScrollPane sc;
    private javax.swing.JTextArea tfQuestao1;
    private javax.swing.JTextArea tfQuestao10;
    private javax.swing.JTextArea tfQuestao11;
    private javax.swing.JTextArea tfQuestao12;
    private javax.swing.JTextArea tfQuestao13;
    private javax.swing.JTextArea tfQuestao14;
    private javax.swing.JTextArea tfQuestao15;
    private javax.swing.JTextArea tfQuestao16;
    private javax.swing.JTextArea tfQuestao17;
    private javax.swing.JTextArea tfQuestao18;
    private javax.swing.JTextArea tfQuestao2;
    private javax.swing.JTextArea tfQuestao3;
    private javax.swing.JTextArea tfQuestao4;
    private javax.swing.JTextArea tfQuestao5;
    private javax.swing.JTextArea tfQuestao6;
    private javax.swing.JTextArea tfQuestao7;
    private javax.swing.JTextArea tfQuestao8;
    private javax.swing.JTextArea tfQuestao9;
    // End of variables declaration//GEN-END:variables

}