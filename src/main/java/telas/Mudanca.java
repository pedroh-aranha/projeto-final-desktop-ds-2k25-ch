/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default. to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package telas;
 
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PecasBean;
import model.PecasDAO;
 
/**
 *
 * @author Usuario
 */
public class Mudanca extends javax.swing.JFrame {
    private int pecaEditandoId = -1;
    DefaultTableModel model;
    PecasDAO dao = new PecasDAO();
 
    /** Creates new form Formulario */
    public Mudanca() {
        initComponents();
       
    }
    private void deletarComAutenticacao() {
        if (pecaEditandoId == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma peça primeiro.");
            return;
        }

        // Campos de input
        javax.swing.JTextField txtUsuario = new javax.swing.JTextField();
        javax.swing.JPasswordField txtSenha = new javax.swing.JPasswordField();
        Object[] message = {
            "Usuário:", txtUsuario,
            "Senha:", txtSenha
        };

        int opcao = JOptionPane.showConfirmDialog(this, message, "Login Admin Requerido", JOptionPane.OK_CANCEL_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            String user = txtUsuario.getText();
            String pass = new String(txtSenha.getPassword());

            // CHAMA O DAO PARA VALIDAR NO BANCO
            if (dao.validarAdmin(user, pass)) {
                int confirm = JOptionPane.showConfirmDialog(this, "Excluir permanentemente?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    dao.deletar(pecaEditandoId);
                    JOptionPane.showMessageDialog(this, "Sucesso!");
                    new Inicio().setVisible(true);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Acesso Negado: Usuário incorreto ou sem permissão de admin.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void limparFormulario() {
        nome.setText("");
        cod.setText("");
        codorgnl.setText("");
        qntde.setText("");
        pecaEditandoId = -1;
    }
 
    public void mostrarFormulario(boolean novo) {
        limparFormulario();
        if (novo) {
            lblTituloFormulario.setText("Nova Peça");
        }
        panelFormulario.setVisible(true);
    }
 
    public void mostrarFormularioEdicao(PecasBean peca) {
        if (peca != null) {
            pecaEditandoId = peca.getId();
            lblTituloFormulario.setText("Editar Peça");
            nome.setText(peca.getNome());
            cod.setText(String.valueOf(peca.getCod()));
            codorgnl.setText(peca.getCod_orgnl());
            qntde.setText(String.valueOf(peca.getQntde()));
            panelFormulario.setVisible(true);
         }
    }
 
    private void salvarPeca() {
        String nomeStr     = nome.getText().trim();
        String codStr      = cod.getText().trim();
        String codOrgnlStr = codorgnl.getText().trim();
        String qntdeStr    = qntde.getText().trim();
 
        if (nomeStr.isEmpty() || codStr.isEmpty() || codOrgnlStr.isEmpty() || qntdeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode estar vazio", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        int codInt;
        int qntdeInt;
        try {
            codInt   = Integer.parseInt(codStr);
            qntdeInt = Integer.parseInt(qntdeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código e quantidade devem ser números inteiros", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        if (pecaEditandoId == -1) {
            PecasBean peca = new PecasBean(0, nomeStr, codInt, codOrgnlStr, qntdeInt);
            dao.inserir_peca(peca);
            JOptionPane.showMessageDialog(this, "Peça cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            PecasBean peca = new PecasBean(pecaEditandoId, nomeStr, codInt, codOrgnlStr, qntdeInt);
            dao.atualizar(peca);
            JOptionPane.showMessageDialog(this, "Peça atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
 
        limparFormulario();
        panelFormulario.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormulario = new javax.swing.JPanel();
        lblTituloFormulario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        codorgnl = new javax.swing.JTextField();
        quantidade = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        qntde = new javax.swing.JTextField();
        deletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFormulario.setBackground(new java.awt.Color(153, 153, 153));
        panelFormulario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTituloFormulario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloFormulario.setText("o que deseja fazer:");

        jLabel2.setText("codigo");

        jLabel3.setText("nome:");

        nome.setColumns(20);
        nome.setRows(4);
        jScrollPane2.setViewportView(nome);

        jLabel4.setText("cod original:");

        codorgnl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codorgnlActionPerformed(evt);
            }
        });

        quantidade.setText("quantidade");

        salvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        voltar.setBackground(new java.awt.Color(255, 0, 0));
        voltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        voltar.setText("X");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        deletar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(lblTituloFormulario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cod)
                                    .addComponent(jScrollPane2)
                                    .addComponent(codorgnl)
                                    .addComponent(qntde, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloFormulario)
                    .addComponent(voltar))
                .addGap(48, 48, 48)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(codorgnl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidade)
                    .addComponent(qntde, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        salvarPeca();
        new Inicio().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salvarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
      new Inicio().setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_voltarActionPerformed

    private void codorgnlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codorgnlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codorgnlActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        // TODO add your handling code here:
        deletarComAutenticacao();
    }//GEN-LAST:event_deletarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mudanca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cod;
    private javax.swing.JTextField codorgnl;
    private javax.swing.JButton deletar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTituloFormulario;
    private javax.swing.JTextArea nome;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JTextField qntde;
    private javax.swing.JLabel quantidade;
    private javax.swing.JButton salvar;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
