/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Component;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author danielesreis
 */
public class MemberListFrame extends javax.swing.JFrame{

    /**
     * Creates new form ListaMembrosFrame
     */
    public MemberListFrame() {
        initComponents();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nome");
        defaultTableModel.addColumn("Endereço");
        defaultTableModel.addColumn("Telefone");
        defaultTableModel.addColumn("Data de nascimento");
        defaultTableModel.addColumn("Cargo");
        defaultTableModel.addColumn("Cadastro");
        
        /*leio as rows do .xlsx e armazeno em um List*/
        List<Member> memberList = new ArrayList<Member>();
        
        Member member = new Member("dani", "a", "a", "a", "a", "a");
        memberList.add(member);
        setMemberList(memberList);
        
        updateTable(memberList, defaultTableModel);
        
        JTable jTable;
        jTable = new JTable(defaultTableModel);
        jTable.setAutoscrolls(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        setJTable(jTable);
        this.jTable.validate();
        
        this.jTable = jTable;
        this.jScrollPane1.getViewport().add(jTable);
        
        this.jTable.getModel().addTableModelListener(new TableModelListener() {
            
            public void tableChanged(TableModelEvent e) {
                
                switch(e.getType())
                {
                    case TableModelEvent.INSERT: /*atualizo .xlsx*/; break;
                    case TableModelEvent.UPDATE: updateList(e.getFirstRow(), e.getColumn()); /*atualizo .xlsx*/; break;
                    case TableModelEvent.DELETE: /*atualizo .xlsx*/; break;
                    default: 
                }
            }
        });
    }
    
    public void updateTable(List<Member> members, DefaultTableModel defaultTableModel) {
        defaultTableModel.setRowCount(0);
        for(int i=0; i<members.size(); i++) {
            defaultTableModel.addRow(members.get(i).getStringMember());
        }
    }
    
    public void updateList(int objectIndex, int attributeIndex) {
        List<Member> memberList = getMemberList();
        Member member = memberList.get(objectIndex);
        JTable jTable = getJTable();
        
        Object data = (Object)jTable.getModel().getValueAt(objectIndex, attributeIndex);
        member = member.updateMember(data, attributeIndex);
    }
    
    public  void insertIntoTable(Member member) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        Object[] data = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), 
                         member.getRegister()};
        defaultTableModel.addRow(data);
    }
    
    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
    
    public List<Member> getMemberList() {
        return this.memberList;
    }
  
    public  void setJTable(JTable newJTable) {
        this.jTable = newJTable;
    }
    
    public  JTable getJTable() {
        return jTable;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_insert_member = new javax.swing.JButton();
        btn_export_member = new javax.swing.JButton();
        btn_search_member = new javax.swing.JButton();
        btn_remove_member = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_insert_member.setText("Inserir membro");
        btn_insert_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insert_memberActionPerformed(evt);
            }
        });

        btn_export_member.setText("Exportar");
        btn_export_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_memberActionPerformed(evt);
            }
        });

        btn_search_member.setText("Pesquisar membro");
        btn_search_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_memberActionPerformed(evt);
            }
        });

        btn_remove_member.setText("Excluir membro");
        btn_remove_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_memberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_export_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_insert_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remove_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_insert_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_search_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_remove_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_export_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insert_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert_memberActionPerformed
        // TODO add your handling code here:
        /*InsertMemberFrame insertMemberFrame = new InsertMemberFrame();
        insertMemberFrame.setVisible(true);*/
        
        InsertMemberDialog insertMemberDialog = new InsertMemberDialog(this, true, getMemberList());
        insertMemberDialog.setVisible(true);
    }//GEN-LAST:event_btn_insert_memberActionPerformed

    private void btn_export_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_memberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_export_memberActionPerformed

    private void btn_search_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_memberActionPerformed
        // TODO add your handling code here:
        SearchMemberDialog searchMemberDialog = new SearchMemberDialog(this, true, getJTable());
        searchMemberDialog.setVisible(true);
    }//GEN-LAST:event_btn_search_memberActionPerformed

    private void btn_remove_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_memberActionPerformed
        // TODO add your handling code here:
        JTable jTable = getJTable();
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable.getModel();
        List<Member> memberList = getMemberList();
        
        int[] rowsSelected = jTable.getSelectedRows();
        for (int i=0; i<rowsSelected.length; i++)
        {
            memberList.remove(i);
            defaultTableModel.removeRow(i);
        }
        jTable.validate();
    }//GEN-LAST:event_btn_remove_memberActionPerformed

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
            java.util.logging.Logger.getLogger(MemberListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MemberListFrame memberListFrame = new MemberListFrame();
                memberListFrame.setVisible(true);
                /*
                    data = readSavedData();
                    updateTable(data);
                */
            }
        });
    }
    
    private List<Member> memberList; 
    private javax.swing.JTable jTable;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export_member;
    private javax.swing.JButton btn_insert_member;
    private javax.swing.JButton btn_remove_member;
    private javax.swing.JButton btn_search_member;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
