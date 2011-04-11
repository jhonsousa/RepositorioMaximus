package br.com.formulario.pescador;

import br.com.conexao.Conexao;
import br.com.util.JIntField;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Jhonathas
 */
public class pescador extends javax.swing.JFrame {

    private int navega = 0; //variavel pra saber o  bot�o clicado;

    private Conexao conexao;


    public pescador() {
        initComponents(); //Inicializa os componentes da tela
        conexao = new Conexao();
        conexao.conecta("emalhe");
              
        //Insere nomes do munic�pio no cbMunicipio
        AttCb();

        //inicia a conex�o com o bd do formul�rio
        conexao.execute("select * from pescador");

        try {
            conexao.resultSet.first();
            mostra_dados_atravessador();


        }catch (SQLException ex) {
            Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        tfIdade = new JIntField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbMunicipio = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Cadastrar = new javax.swing.JButton();
        botao_excluir = new javax.swing.JButton();
        botao_novo = new javax.swing.JButton();
        botao_primeiro = new javax.swing.JButton();
        botao_anterior = new javax.swing.JButton();
        botao_proximo = new javax.swing.JButton();
        botao_ultimo = new javax.swing.JButton();
        botao_alterar = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        tfApelido = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        tfNaturalidade = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        cbLocalMoradia = new javax.swing.JComboBox();
        lb_pescador = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        tfPqParou = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tfComposicaoFamiliar = new JIntField();
        jLabel31 = new javax.swing.JLabel();
        tfAtividadeSecundaria = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbEscolaridade = new javax.swing.JComboBox();
        cbAtividadePrincipal = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Question�rio Atravessador");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                fechar_janela(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        jLabel23.setText("Nome.:");

        jLabel22.setText("Idade.:");

        jLabel24.setText("Munic�pio");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Question�rio Pescador");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarAction(evt);
            }
        });

        botao_excluir.setText("Excluir");
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });

        botao_novo.setText("Limpar");
        botao_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_novoActionPerformed(evt);
            }
        });

        botao_primeiro.setText("<<");
        botao_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_primeiroActionPerformed(evt);
            }
        });

        botao_anterior.setText("<");
        botao_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_anteriorActionPerformed(evt);
            }
        });

        botao_proximo.setText(">");
        botao_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_proximoActionPerformed(evt);
            }
        });

        botao_ultimo.setText(">>");
        botao_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ultimoActionPerformed(evt);
            }
        });

        botao_alterar.setText("Alterar");
        botao_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botao_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_excluir)
                        .addGap(7, 7, 7)
                        .addComponent(botao_alterar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botao_primeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_proximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_ultimo)))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_primeiro)
                    .addComponent(botao_anterior)
                    .addComponent(botao_proximo)
                    .addComponent(botao_ultimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_novo)
                    .addComponent(Cadastrar)
                    .addComponent(botao_excluir)
                    .addComponent(botao_alterar))
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel25.setText("DADOS PESSOAIS:");

        jLabel27.setText("Naturalidade.:");

        jLabel26.setText("Apelido.:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jLabel28.setText("Sexo.:");

        jLabel35.setText("Local de Moradia.:");

        cbLocalMoradia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sede Municipal", "Comunidade/Vila local", "Outro Munic�pio", "Capital" }));

        lb_pescador.setText("Pescador");

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro", "Casado", "Uni�o Est�vel" }));

        jLabel32.setText("N�mero de filhos.:");

        jLabel34.setText("Porque Parou?");

        jLabel33.setText("Escolaridade.:");

        jLabel31.setText("Estado civil.:");

        jLabel29.setText("Atividade principal de renda.:");

        jLabel30.setText("Atividade secund�ria.:");

        cbEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1� S�rie fundamental", "2� S�rie fundamental", "3� S�rie fundamental", "4� S�rie fundamental", "5� S�rie fundamental", "6� S�rie fundamental", "7� S�rie fundamental", "8� S�rie fundamental", "1� S�rie m�dio", "2� S�rie m�dio", "3� S�rie m�dio", "Ensino Superior Incompleto", "Ensino Superior Completo" }));

        cbAtividadePrincipal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_pescador))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNaturalidade)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfApelido)
                                    .addComponent(cbLocalMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addGap(35, 35, 35)
                                .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbEstadoCivil, 0, 201, Short.MAX_VALUE)
                                    .addComponent(cbEscolaridade, 0, 201, Short.MAX_VALUE)
                                    .addComponent(cbAtividadePrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPqParou, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(tfComposicaoFamiliar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(tfAtividadeSecundaria, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(lb_pescador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(tfNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(tfApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLocalMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(tfAtividadeSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAtividadePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(tfComposicaoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(tfPqParou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-785)/2, (screenSize.height-471)/2, 785, 471);
    }// </editor-fold>//GEN-END:initComponents

    private void fechar_janela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fechar_janela
        conexao.desconecta();
    }//GEN-LAST:event_fechar_janela

    private void botao_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarActionPerformed
        try{
            String sql ="UPDATE pescador SET "+
                    "municipio = '"+cbMunicipio.getSelectedItem()+"',"+
                    "nome = '"+tfNome.getText()+"',"+
                    "apelido = '"+ tfApelido.getText() +"',"+
                    "naturalidade = '"+ tfNaturalidade.getText() +"',"+
                    "local_moradia = '"+ cbLocalMoradia.getSelectedItem() +"',"+
                    "sexo = '"+ cbSexo.getSelectedItem() +"',"+
                    "idade = '"+ tfIdade.getText() +"',"+
                    "atividade_principal = '"+ cbAtividadePrincipal.getSelectedItem() +"',"+
                    "atividade_secundaria = '"+ tfAtividadeSecundaria.getText() +"',"+
                    "estado_civil = '"+ cbEstadoCivil.getSelectedItem() +"',"+
                    "composicao_familiar = '"+ tfComposicaoFamiliar.getText() +"',"+
                    "escolaridade = '"+ cbEscolaridade.getSelectedItem() +"',"+
                    "pq_parou = '"+ tfPqParou.getText() +"' "+
                    



                    "where cod_pescador = "+conexao.resultSet.getString("cod_pescador");

            System.out.println(sql);
            if (conexao.update(sql)){
                JOptionPane.showMessageDialog(null,"Alterado com sucesso");
                //Atualiza Resultset
                conexao.execute("select * from pescador");
                conexao.resultSet.next();
                mostra_dados_atravessador();
            }


        }catch (Exception e){
            System.out.println(e + " Erro no bot�o alterar");
        }
}//GEN-LAST:event_botao_alterarActionPerformed

    private void botao_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ultimoActionPerformed
        try {
            conexao.resultSet.last();
            mostra_dados_atravessador();
            navega = 2;

        }catch (SQLException ex) {
            Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_botao_ultimoActionPerformed

    private void botao_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_proximoActionPerformed
            proximo();
            mostra_dados_atravessador();
            navega = 2;

}//GEN-LAST:event_botao_proximoActionPerformed

    private void botao_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_anteriorActionPerformed
            anterior();
            mostra_dados_atravessador();
            navega = 1;

}//GEN-LAST:event_botao_anteriorActionPerformed

    private void botao_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_primeiroActionPerformed
        try {
            conexao.resultSet.first();
            mostra_dados_atravessador();
            navega = 1;

        }catch (SQLException ex) {
            Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_botao_primeiroActionPerformed

    private void botao_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_novoActionPerformed
        tfNome.setText("");
        tfApelido.setText("");
        tfNaturalidade.setText("");
        tfIdade.setText("0");
        cbAtividadePrincipal.setSelectedIndex(0);
        tfAtividadeSecundaria.setText("");
        cbEstadoCivil.setSelectedIndex(0);
        tfComposicaoFamiliar.setText("");
        cbEscolaridade.setSelectedIndex(0);
        tfPqParou.setText("");
        cbMunicipio.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
        cbLocalMoradia.setSelectedIndex(0);
}//GEN-LAST:event_botao_novoActionPerformed

    private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
        String sql;
        try {
            sql = "select * from pescador Where cod_pescador =" + conexao.resultSet.getString("cod_pescador");
            conexao.execute(sql);
            conexao.resultSet.first();
            String nome = "Deletar o pesacador : "+conexao.resultSet.getString("nome")+" ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclus�o ",JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                sql = "DELETE FROM pescador Where cod_pescador ="+conexao.resultSet.getString("cod_pescador");
                if (conexao.salvar(sql)) {
                    JOptionPane.showMessageDialog(null,"Exclus�o realizada com sucesso");
                    //atualiza o ResultSet
                    conexao.execute("select * from pescador");
                    conexao.resultSet.first();
                    mostra_dados_atravessador();
                }
            } else{
                conexao.execute("select * from pescador");
                conexao.resultSet.first();
                mostra_dados_atravessador();
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao tentar excluir "+ex);
        }
}//GEN-LAST:event_botao_excluirActionPerformed

    private void CadastrarAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarAction

        try {
            String sqlinsert = "insert into pescador "
                    + "(municipio,nome,apelido,naturalidade,"
                    + "sexo,idade,atividade_principal,atividade_secundaria,"
                    + "estado_civil,composicao_familiar,escolaridade,pq_parou,"
                    + "local_moradia) values ('"+
                    cbMunicipio.getSelectedItem()+"','"+
                    tfNome.getText()+"','"+
                    tfApelido.getText()+"','"+
                    tfNaturalidade.getText()+"','"+
                    cbSexo.getSelectedItem()+"',"+
                    tfIdade.getText()+",'"+
                    cbAtividadePrincipal.getSelectedItem()+"','"+
                    tfAtividadeSecundaria.getText()+"','"+
                    cbEstadoCivil.getSelectedItem()+"','"+
                    tfComposicaoFamiliar.getText()+"','"+
                    cbEscolaridade.getSelectedItem()+"','"+
                    tfPqParou.getText()+"','"+
                    cbLocalMoradia.getSelectedItem()+"')";

            //System.out.println(sqlinsert);
            if (conexao.salvar(sqlinsert)) {
                JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
                //agora � hora de atualizar o resultset
                conexao.execute("select * from pescador");
                conexao.resultSet.first(); //1� registro
                mostra_dados_atravessador();
            }


        }catch (SQLException erro){
            System.out.println(erro);
        }
}//GEN-LAST:event_CadastrarAction

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pescador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton botao_alterar;
    private javax.swing.JButton botao_anterior;
    private javax.swing.JButton botao_excluir;
    private javax.swing.JButton botao_novo;
    private javax.swing.JButton botao_primeiro;
    private javax.swing.JButton botao_proximo;
    private javax.swing.JButton botao_ultimo;
    private javax.swing.JComboBox cbAtividadePrincipal;
    private javax.swing.JComboBox cbEscolaridade;
    private javax.swing.JComboBox cbEstadoCivil;
    private javax.swing.JComboBox cbLocalMoradia;
    private javax.swing.JComboBox cbMunicipio;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_pescador;
    private javax.swing.JTextField tfApelido;
    private javax.swing.JTextField tfAtividadeSecundaria;
    private javax.swing.JTextField tfComposicaoFamiliar;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNaturalidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPqParou;
    // End of variables declaration//GEN-END:variables


    private void mostra_dados_atravessador(){
        try {
            tfNome.setText(conexao.resultSet.getString("nome"));
            tfApelido.setText(conexao.resultSet.getString("apelido"));
            tfNaturalidade.setText(conexao.resultSet.getString("naturalidade"));
            tfIdade.setText(conexao.resultSet.getString("idade"));
            cbAtividadePrincipal.setSelectedItem(conexao.resultSet.getString("atividade_principal"));
            tfAtividadeSecundaria.setText(conexao.resultSet.getString("atividade_secundaria"));
            cbEstadoCivil.setSelectedItem(conexao.resultSet.getString("estado_civil"));
            tfComposicaoFamiliar.setText(conexao.resultSet.getString("composicao_familiar"));
            cbEscolaridade.setSelectedItem(conexao.resultSet.getString("escolaridade"));
            tfPqParou.setText(conexao.resultSet.getString("pq_parou"));
            cbMunicipio.setSelectedItem(conexao.resultSet.getString("municipio"));
            cbSexo.setSelectedItem(conexao.resultSet.getString("sexo"));
            cbLocalMoradia.setSelectedItem(conexao.resultSet.getString("local_moradia"));
            


        }catch (SQLException ex) {
            if (navega == 1){
                JOptionPane.showMessageDialog(null,"Voc� j� esta no primeiro registro");
                proximo();
            }
            else if (navega == 2){
                JOptionPane.showMessageDialog(null,"Voc� j� esta no ultimo registro");
                anterior();
            }
            else
                JOptionPane.showMessageDialog(null,"Nenhum registro encontrado "+ ex );
            navega = 0;
            //Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void anterior() {
         try {
                    conexao.resultSet.previous();
                } catch (SQLException ex1) {
                    Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex1);
                }
    }

    private void proximo() {
        try {
                    conexao.resultSet.next();
                } catch (SQLException ex1) {
                    Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex1);
                }
    }

    private void AttCb() {
        try {
            cbMunicipio.removeAllItems();
            conexao.execute("select * FROM municipios where pai='Par�' or pai='Maranh�o' or pai='Amap�' ");
            while (conexao.resultSet.next()){
                cbMunicipio.addItem(conexao.resultSet.getString("nome"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cbAtividadePrincipal.removeAllItems();
            conexao.execute("select * FROM atividade ");
            while (conexao.resultSet.next()){
                cbAtividadePrincipal.addItem(conexao.resultSet.getString("atividade"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(pescador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
