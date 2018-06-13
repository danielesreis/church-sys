/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Interfaces;

import java.awt.Frame;
import java.awt.TextField;
import javaapplication2.Classes.Member;
import javax.swing.JTextField;

/**
 *
 * @author juju-
 */
public class EditMemberDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditMemberDialog
     */
    public EditMemberDialog(java.awt.Frame parentFrame, boolean modal) {
        super(parentFrame, modal);
        setParentFrame(parentFrame);
        
        initComponents();
        
        Member member = ((MemberListFrame)parentFrame).getMemberList().getMemberByIndex(((MemberListFrame)parentFrame).getEditedRow());
        txtfield_name.setText(member.getName());
        txtfield_address.setText(member.getAddress());
        txtfield_number.setText(member.getNumber());
        txtfield_birthdate.setText(member.getBirthDate());
        txtfield_role.setText(member.getRole());
        txtfield_register.setText(member.getRegister());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void setParentFrame(Frame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    private Frame getParentFrame() {
        return this.parentFrame;
    }
    
    private JTextField getTxtFieldByNumber(byte number) {
        switch (number){
            case 0: return txtfield_name; 
            case 1: return txtfield_address;
            case 2: return txtfield_number;
            case 3: return txtfield_birthdate;
            case 4: return txtfield_role;
            case 5: return txtfield_register;
            default: /*throw exc*/
        }
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfield_name = new javax.swing.JTextField();
        txtfield_address = new javax.swing.JTextField();
        txtfield_number = new javax.swing.JTextField();
        txtfield_birthdate = new javax.swing.JTextField();
        txtfield_role = new javax.swing.JTextField();
        txtfield_register = new javax.swing.JTextField();
        btn_edit_member = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NOME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ENDEREÇO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TELEFONE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("DATA DE NASCIMENTO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CARGO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CADASTRO");

        txtfield_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_nameActionPerformed(evt);
            }
        });

        txtfield_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_addressActionPerformed(evt);
            }
        });

        txtfield_number.setToolTipText("(XX) XXXXX-XXXX");
        txtfield_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_numberActionPerformed(evt);
            }
        });

        txtfield_birthdate.setToolTipText("XX/XX/XXXX");
        txtfield_birthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_birthdateActionPerformed(evt);
            }
        });

        txtfield_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_roleActionPerformed(evt);
            }
        });

        txtfield_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_registerActionPerformed(evt);
            }
        });

        btn_edit_member.setText("OK");
        btn_edit_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_memberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_edit_member, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtfield_role, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield_birthdate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield_number, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield_address, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield_register, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfield_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfield_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfield_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfield_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfield_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfield_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_edit_member, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfield_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_nameActionPerformed

    private void txtfield_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_addressActionPerformed

    private void txtfield_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_numberActionPerformed

    private void txtfield_birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_birthdateActionPerformed

    private void txtfield_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_roleActionPerformed

    private void txtfield_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_registerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_registerActionPerformed

    private void btn_edit_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_memberActionPerformed
        // TODO add your handling code here:
        String name, birthDate, address, number, register, role;
        
        name = txtfield_name.getText();
        address = txtfield_address.getText();
        number = txtfield_number.getText();
        birthDate = txtfield_birthdate.getText();
        role = txtfield_role.getText();
        register = txtfield_register.getText();
        
        MemberListFrame frame = (MemberListFrame)getParentFrame();
        byte editedRow = frame.getEditedRow();
        byte columnCount = (byte)frame.getJTable().getColumnCount();
            
        for (byte column=0; column<columnCount; column++)
        {
            Object value = getTxtFieldByNumber(column).getText();
            frame.getMemberList().updateMember(editedRow, column, value);
            frame.getJTable().setValueAt(value, editedRow, column);
        }
    }//GEN-LAST:event_btn_edit_memberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditMemberDialog dialog = new EditMemberDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private Frame parentFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit_member;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtfield_address;
    private javax.swing.JTextField txtfield_birthdate;
    private javax.swing.JTextField txtfield_name;
    private javax.swing.JTextField txtfield_number;
    private javax.swing.JTextField txtfield_register;
    private javax.swing.JTextField txtfield_role;
    // End of variables declaration//GEN-END:variables
}
