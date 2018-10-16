/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.Autor;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NAutor;

/**
 *
 * @author repez
 */
public class FrmPesAutor extends javax.swing.JInternalFrame {
    
    JDesktopPane painelPrincipal;
    
    /**
     * Creates new form FrmPesAssociado
     */
    public FrmPesAutor() {
        initComponents();
        carregarTabela();
    }
    
    public FrmPesAutor(JDesktopPane painelPrincipal) {
        this();
        this.painelPrincipal = painelPrincipal;
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setTitle("Pesquisa de Autor");

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultado);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMousePressed
        try {
            int linhaSelecionada = tblResultado.getSelectedRow();
            String id = tblResultado.getValueAt(linhaSelecionada, 0).toString();

            FrmCadAutor frmCadAutor = new FrmCadAutor(painelPrincipal, id);
            painelPrincipal.add(frmCadAutor);
            frmCadAutor.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblResultadoMousePressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables
    
    private void carregarTabela() {
        
        try {
            
            Vector<String> cabecalho = new Vector();
            cabecalho.add("ID");
            cabecalho.add("Nome");
            
            NAutor na = new NAutor();
            
            Vector linhas = new Vector();
            
            for (Autor autor : na.listar()) {
                Vector<String> dados = new Vector();
                dados.add(String.valueOf(autor.getId()));
                dados.add(autor.getNome());
                
                linhas.add(dados);
            }
            
            tblResultado.setModel(new DefaultTableModel(linhas, cabecalho));            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }

}
