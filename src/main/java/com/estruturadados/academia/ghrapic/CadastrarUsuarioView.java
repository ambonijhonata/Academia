/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.estruturadados.academia.ghrapic;

import com.estruturadados.academia.controler.CadastrarUsuarioViewController;
import com.estruturadados.academia.database.model.Usuario;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author lab202a
 */
public class CadastrarUsuarioView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarUsuarioView
     */
    private Connection connection;
    private CadastrarUsuarioViewController controller;
    private Usuario usuario;
    private boolean isEdicao = false;
    private String chaveTabela;

    public CadastrarUsuarioView(Connection connection, Usuario usuario) {
        initComponents();
        definirTeclasAtalho();

        this.usuario = usuario;
        this.connection = connection;
        controller = new CadastrarUsuarioViewController(connection);

        if (usuario != null) {
            carregarDadosEdicao(usuario);
        }
    }

    private void definirTeclasAtalho() {
        jButtonGravar.setMnemonic(KeyEvent.VK_G);
        jButtonCancelar.setMnemonic(KeyEvent.VK_C);

    }

    public void carregarDadosEdicao(Usuario usuario) {
        isEdicao = true;//na hora de clicar em gravar verificar, se for true, chama a edição no DAO.
        txtUsuario.setText(usuario.getUsuario());
        txtSenha.setText(usuario.getSenha());
        cmbPerfil.setSelectedItem(usuario.getPerfil());
        chaveTabela = usuario.getUsuario();//ao fazer um update é necessária a pk do usuário, se não guardar aqui, não da de editar, ou seja uma variável a mais sem motivo nenhum.

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTelaCadastroUsuarios = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblPerfil = new javax.swing.JLabel();
        cmbPerfil = new javax.swing.JComboBox<>();
        jButtonGravar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setTitle("Cadastrar Usuário");

        jPanelTelaCadastroUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUsuario.setText("Usuário:");

        lblSenha.setText("Senha:");

        lblPerfil.setText("Perfil:");

        cmbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cadastral", "Financeiro" }));

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTelaCadastroUsuariosLayout = new javax.swing.GroupLayout(jPanelTelaCadastroUsuarios);
        jPanelTelaCadastroUsuarios.setLayout(jPanelTelaCadastroUsuariosLayout);
        jPanelTelaCadastroUsuariosLayout.setHorizontalGroup(
            jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaCadastroUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblSenha)
                    .addComponent(lblPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtSenha)
                    .addComponent(cmbPerfil, 0, 205, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTelaCadastroUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        jPanelTelaCadastroUsuariosLayout.setVerticalGroup(
            jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaCadastroUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerfil)
                    .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTelaCadastroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGravar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTelaCadastroUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTelaCadastroUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:        
        this.getParent().requestFocus();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here:
        String txtUsuarioValue = txtUsuario.getText().trim();
        String txtSenhaValue = new String(txtSenha.getPassword());

        if (txtUsuarioValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor informe o usuário.", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtUsuario.requestFocus();
            return;
        } else if (txtSenhaValue.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor informe a senha.", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtSenha.requestFocus();
            return;
        }

        Usuario usuarioEditado = new Usuario();
        usuarioEditado.setUsuario(txtUsuarioValue);
        usuarioEditado.setSenha(txtSenhaValue);
        usuarioEditado.setPerfil(String.valueOf(cmbPerfil.getSelectedItem()));

        if (isEdicao) {
            if (controller.atualizarUsuario(usuario, usuarioEditado)) {
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (!controller.verificarUsuarioExiste(txtUsuarioValue)) {
            controller.inserirUsuario(usuarioEditado);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.", "Atenção", JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }//GEN-LAST:event_jButtonGravarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JPanel jPanelTelaCadastroUsuarios;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
