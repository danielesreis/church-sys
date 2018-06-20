/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Interfaces;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import java.util.List;
import java.util.ArrayList;
import javaapplication2.Classes.Member;
import javaapplication2.Classes.MemberList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author danielesreis
 */
public class MemberListFrame extends JFrame{

    /**
     * Creates new form ListaMembrosFrame
     */
    public MemberListFrame() {
        initComponents();
        setBtn(-1);
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("Nome");
        defaultTableModel.addColumn("Endereço");
        defaultTableModel.addColumn("Telefone");
        defaultTableModel.addColumn("Data de nascimento");
        defaultTableModel.addColumn("Cargo");
        defaultTableModel.addColumn("Cadastro");
        
        /*deixar isso na interface?*/
        /*leio as rows do .xlsx e armazeno em um List*/
        MemberList memberList = new MemberList();
        Member member = new Member("dani", "a", "a", "a", "a", "a");
        memberList.addMember(member);
        member = new Member("juju", "b", "b", "b", "b", "b");
        memberList.addMember(member);
        member = new Member("mamis", "c", "c", "c", "c", "c");
        memberList.addMember(member);
        setMemberList(memberList);
        
        updateTable(memberList, defaultTableModel);
        updateTxt(Integer.toString(memberList.getTotal()));
        
        JTable jTable;
        jTable = new JTable(defaultTableModel);
        jTable.setAutoscrolls(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setRowSelectionAllowed(true);
        
        setJTable(jTable);
        
        jTable.validate();
        this.jScrollPane1.getViewport().add(jTable);
        jTable.getModel().addTableModelListener(new TableModelListener() {
            
            public void tableChanged(TableModelEvent e) {
                
                switch(e.getType())
                {
                    case TableModelEvent.INSERT: updateTxt(Integer.toString(memberList.getTotal())); /*atualizo .xlsx*/ break;
                    //case TableModelEvent.UPDATE: atualizo .xlsx
                    case TableModelEvent.DELETE: updateTxt(Integer.toString(memberList.getTotal())); /*atualizo .xlsx*/ break;
                    default: 
                }
            }
        });
        
        TableRowSorter sorter = new TableRowSorter<TableModel>(defaultTableModel);
        jTable.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rf = null;
        
        radiobtn_name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiobtn_name.isSelected()) {
                    if (getBtn() == 0) {
                        setBtn(-1);
                        //sorter.setRowFilter(rf.regexFilter("", 0));
                        //updateTxt(Integer.toString(getJTable().getRowCount()));
                        //txtfield_search.setText("");
                        buttonGroup1.clearSelection();
                    }
                    else {
                        setBtn(0);
                        sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), 0));
                        updateTxt(Integer.toString(getJTable().getRowCount()));
                    }
                }
            }
        });
        
        radiobtn_address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiobtn_address.isSelected()) {
                    if (getBtn() == 1) {
                        setBtn(-1);
                        //sorter.setRowFilter(rf.regexFilter("", 0));
                        //updateTxt(Integer.toString(getJTable().getRowCount()));
                        //txtfield_search.setText("");
                        buttonGroup1.clearSelection();
                    }
                    else {
                        setBtn(1);
                        sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), 1));
                        updateTxt(Integer.toString(getJTable().getRowCount()));
                    }
                }
            }
                        
        });
        
        radiobtn_number.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiobtn_number.isSelected()) {
                    if (getBtn() == 2) {
                        setBtn(-1);
                        //sorter.setRowFilter(rf.regexFilter("", 0));
                        //updateTxt(Integer.toString(getJTable().getRowCount()));
                        //txtfield_search.setText("");
                        buttonGroup1.clearSelection();
                    }
                    else {
                        setBtn(2);
                        sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), 2));
                        updateTxt(Integer.toString(getJTable().getRowCount()));
                    }
                }
            }
            
        });
        
        radiobtn_birthdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiobtn_birthdate.isSelected()) {
                    if (getBtn() == 3) {
                        setBtn(-1);
                        sorter.setRowFilter(rf.regexFilter("", 0));
                        //updateTxt(Integer.toString(getJTable().getRowCount()));
                        //txtfield_search.setText("");
                        buttonGroup1.clearSelection();
                    }
                    else {
                        setBtn(3);
                        sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), 3));
                        updateTxt(Integer.toString(getJTable().getRowCount()));
                    }
                }
            }           
        });
        
        radiobtn_role.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiobtn_role.isSelected()) {
                    if (getBtn() == 4) {
                        setBtn(-1);
                        //sorter.setRowFilter(rf.regexFilter("", 0));
                        //updateTxt(Integer.toString(getJTable().getRowCount()));
                        //txtfield_search.setText("");
                        buttonGroup1.clearSelection();
                    }
                    else {
                        setBtn(4);
                        sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), 4));
                        updateTxt(Integer.toString(getJTable().getRowCount()));
                    }
                }
            }
            
        });
        
        radiobtn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiobtn_register.isSelected()) {
                    if (getBtn() == 5) {
                        setBtn(-1);
                        //sorter.setRowFilter(rf.regexFilter("", 0));
                        //updateTxt(Integer.toString(getJTable().getRowCount()));
                        //txtfield_search.setText("");
                        buttonGroup1.clearSelection();
                    }
                    else {
                        setBtn(5);
                        sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), 5));
                        updateTxt(Integer.toString(getJTable().getRowCount()));
                    }
                }
            }
            
        });
        
        txtfield_search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (getBtn() >= 0) {
                    sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), getBtn()));
                    updateTxt(Integer.toString(getJTable().getRowCount()));
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (getBtn() >= 0)  sorter.setRowFilter(rf.regexFilter("(?i)" + txtfield_search.getText(), getBtn()));
                else sorter.setRowFilter(rf.regexFilter("", 0));
                updateTxt(Integer.toString(getJTable().getRowCount()));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    
    private void setBtn(int btn) {
        this.btn = btn;
    }
    
    private int getBtn() {
        return this.btn;
    }
    
    protected void updateTxt(String num) {
        txt_membernumber.setText(num);
    }
    
    protected void updateTable(MemberList memberList, DefaultTableModel defaultTableModel) {
        defaultTableModel.setRowCount(0);
        for(int i=0; i<memberList.getTotal(); i++) {
            defaultTableModel.addRow(memberList.getStringMember(memberList.getMemberByIndex(i)));
        }
    }
    
    /*protected void updateTable(List<Member> searchList, DefaultTableModel defaultTableModel) {
        defaultTableModel.setRowCount(0);
        for(int i=0; i<searchList.size(); i++) {
            defaultTableModel.addRow(MemberList.getStringMember(searchList.get(i)));
        }
    }*/
    
    protected void insertIntoTable(Member member) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        Object[] data = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), 
                         member.getRegister()};
        defaultTableModel.addRow(data);
    }
    
    private void setMemberList(MemberList memberList) {
        this.memberList = memberList;
    }
    
    protected MemberList getMemberList() {
        return this.memberList;
    }
    
    private void setJTable(JTable jTable) {
        this.jTable = jTable;
    }
    
    protected JTable getJTable() {
        return jTable;
    }
    
    private void setEditedMemberReg(String editedMemberReg) {
        this.editedMemberReg = editedMemberReg;
    }
    
    protected String getEditedMemberReg() {
        return this.editedMemberReg;
    }
    
    protected void setEditedRow(int editedRow) {
        this.editedRow = editedRow;
    }
    
    protected int getEditedRow() {
        return this.editedRow;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_insert_member = new javax.swing.JButton();
        btn_edit_member = new javax.swing.JButton();
        btn_export_member = new javax.swing.JButton();
        btn_search_member = new javax.swing.JButton();
        btn_remove_member = new javax.swing.JButton();
        txt_membernumber = new javax.swing.JLabel();
        txt_membernumber_string = new javax.swing.JLabel();
        radiobtn_name = new javax.swing.JRadioButton();
        radiobtn_address = new javax.swing.JRadioButton();
        radiobtn_number = new javax.swing.JRadioButton();
        radiobtn_birthdate = new javax.swing.JRadioButton();
        radiobtn_role = new javax.swing.JRadioButton();
        radiobtn_register = new javax.swing.JRadioButton();
        txtfield_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Membros");
        setResizable(false);

        btn_insert_member.setText("Inserir membro");
        btn_insert_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insert_memberActionPerformed(evt);
            }
        });

        btn_edit_member.setText("Editar membro");
        btn_edit_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_memberActionPerformed(evt);
            }
        });

        btn_export_member.setText("Exportar");
        btn_export_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_memberActionPerformed(evt);
            }
        });

        btn_search_member.setText("Pesquisar membro");
        btn_search_member.setEnabled(false);
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

        txt_membernumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_membernumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_membernumber.setText("0");

        txt_membernumber_string.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_membernumber_string.setText("Número de membros: ");

        buttonGroup1.add(radiobtn_name);
        radiobtn_name.setText("Nome");
        radiobtn_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_nameActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobtn_address);
        radiobtn_address.setText("Endereço");
        radiobtn_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_addressActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobtn_number);
        radiobtn_number.setText("Telefone");
        radiobtn_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_numberActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobtn_birthdate);
        radiobtn_birthdate.setText("Data de nascimento");
        radiobtn_birthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_birthdateActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobtn_role);
        radiobtn_role.setText("Cargo");
        radiobtn_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_roleActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobtn_register);
        radiobtn_register.setText("Cadastro");
        radiobtn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_membernumber_string)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_membernumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_search_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_insert_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_remove_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radiobtn_name)
                                .addGap(32, 32, 32)
                                .addComponent(radiobtn_address))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radiobtn_number)
                                    .addComponent(radiobtn_role))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radiobtn_register)
                                    .addComponent(radiobtn_birthdate)))
                            .addComponent(txtfield_search, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_export_member, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btn_export_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_insert_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_edit_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_search_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_remove_member, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radiobtn_name)
                            .addComponent(radiobtn_address))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radiobtn_number)
                            .addComponent(radiobtn_birthdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radiobtn_role)
                            .addComponent(radiobtn_register))
                        .addGap(12, 12, 12)
                        .addComponent(txtfield_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_membernumber_string)
                    .addComponent(txt_membernumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insert_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert_memberActionPerformed
        // TODO add your handling code here:
        /*InsertMemberFrame insertMemberFrame = new InsertMemberFrame();
        insertMemberFrame.setVisible(true);*/
        
        InsertMemberDialog insertMemberDialog = new InsertMemberDialog(this, true);
        insertMemberDialog.setVisible(true);
    }//GEN-LAST:event_btn_insert_memberActionPerformed

    private void btn_export_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_memberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_export_memberActionPerformed

    private void btn_search_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_memberActionPerformed
        // TODO add your handling code here:
        SearchMemberDialog searchMemberDialog = new SearchMemberDialog(this, true);
        searchMemberDialog.setVisible(true);
    }//GEN-LAST:event_btn_search_memberActionPerformed

    private void btn_remove_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_memberActionPerformed
        // TODO add your handling code here:
        JTable jTable = getJTable();
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable.getModel();
        
        int answer = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo excluir?", "Confirmar operação", 
                JOptionPane.YES_NO_OPTION);
        
        if(answer == 0)
        {
            int[] rowsSelected = jTable.getSelectedRows();
            String reg;
            
            for (int i = 0; i < rowsSelected.length; i++)
            {
                reg = (String)defaultTableModel.getValueAt(jTable.convertRowIndexToModel(rowsSelected[i]), 5);
                this.getMemberList().removeMember(reg);
                defaultTableModel.removeRow(jTable.convertRowIndexToModel(rowsSelected[i]));
            }
            jTable.validate();
        }
    }//GEN-LAST:event_btn_remove_memberActionPerformed

    private void btn_edit_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_memberActionPerformed
        // TODO add your handling code here:
        JTable jTable = getJTable();
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable.getModel();
        int[] rowsSelected = jTable.getSelectedRows();
        
        if (rowsSelected.length > 1)
            JOptionPane.showMessageDialog(rootPane, "Selecione apenas UM membro para edição!", "Alerta", HEIGHT);
        else
        {
            int index = jTable.convertRowIndexToModel(rowsSelected[0]);
            setEditedRow(rowsSelected[0]);
            String reg = (String)getJTable().getModel().getValueAt(index, 5);
            setEditedMemberReg(reg);
            EditMemberDialog editMemberDialog = new EditMemberDialog(this, true);
            editMemberDialog.setVisible(true);
        }
        
    }//GEN-LAST:event_btn_edit_memberActionPerformed

    private void radiobtn_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_nameActionPerformed

    private void radiobtn_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_addressActionPerformed

    private void radiobtn_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_numberActionPerformed

    private void radiobtn_birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_birthdateActionPerformed

    private void radiobtn_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_roleActionPerformed

    private void radiobtn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_registerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_registerActionPerformed

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
    
    private MemberList memberList; 
    private javax.swing.JTable jTable;
    private String editedMemberReg;
    private int editedRow;
    private int btn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit_member;
    private javax.swing.JButton btn_export_member;
    private javax.swing.JButton btn_insert_member;
    private javax.swing.JButton btn_remove_member;
    private javax.swing.JButton btn_search_member;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radiobtn_address;
    private javax.swing.JRadioButton radiobtn_birthdate;
    private javax.swing.JRadioButton radiobtn_name;
    private javax.swing.JRadioButton radiobtn_number;
    private javax.swing.JRadioButton radiobtn_register;
    private javax.swing.JRadioButton radiobtn_role;
    private javax.swing.JLabel txt_membernumber;
    private javax.swing.JLabel txt_membernumber_string;
    private javax.swing.JTextField txtfield_search;
    // End of variables declaration//GEN-END:variables
}
