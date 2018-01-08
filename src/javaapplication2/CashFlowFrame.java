/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juju-
 */
public class CashFlowFrame extends javax.swing.JFrame {

    /**
     * Creates new form CashFlowFrame
     */
    public CashFlowFrame() {
        initComponents();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Data");
        defaultTableModel.addColumn("Descrição");
        defaultTableModel.addColumn("Entrada (R$)");
        defaultTableModel.addColumn("Saída (R$)");
        defaultTableModel.addColumn("Saldo (R$)");
        
        //Entry entry = new Entry("0 9 / 1 0/1995", "ha", true, 1000.05);
        
        /*leio as rows e armazeno em EntryList*/
        EntryList entryList = new EntryList();
        
        for(int i=0; i<1; i++) {
            //entryList.addEntry(entry);
        }
        
        JTable jTable;
        jTable = new JTable(defaultTableModel);
        jTable.setAutoscrolls(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        
        setJTable(jTable);
        setEntryList(entryList);
        updateTable();
        
        this.jTable.validate();
        this.jScrollPane.getViewport().add(jTable);
        
        this.jTable.getModel().addTableModelListener(new TableModelListener() {
            
            public void tableChanged(TableModelEvent e) {
                EntryList entryList = getEntryList();
                switch(e.getType())
                {
                    case TableModelEvent.INSERT: updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal()); /*atualizo .xlsx*/; break;
                    case TableModelEvent.UPDATE: entryList.updateEntry(e.getFirstRow(), e.getColumn(),
                            (Object)getJTable().getModel().getValueAt(e.getFirstRow(), e.getColumn())); /*atualizo .xlsx*/; break;
                    case TableModelEvent.DELETE: updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal())/*atualizo .xlsx*/; break;
                    default: 
                }
            }
        });
    }
    
    public void updateTxt(Double in, Double out, Double total) {
        String txtIn, txtOut, txtTotal; 
        
        txtIn = String.format("%.2f", in);
        txtOut = String.format("%.2f", out);
        txtTotal = String.format("%.2f", total);
        
        txt_in.setText(txtIn);
        txt_out.setText(txtOut);
        txt_total.setText(txtTotal);
    }
    
    public void updateTable() {
        JTable jTable = getJTable();
        EntryList entryList = getEntryList();
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable.getModel();
        
        for(int i=0; i<entryList.getEntryListSize(); i++) {
            Object[] rowData = entryList.getStringMember(i);
            /*Color color = (rowData[2].toString().charAt(0) == '-') ? Color.RED : Color.BLUE;
            jTable = paintRowForeground(color, rowData[2].toString(), i, 2);*/
            defaultTableModel.addRow(rowData);
        }
        updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal());
        jTable.validate();
    }
    
    public void updateTable(Object[] rowData) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.addRow(rowData);
        updateTxt(getEntryList().getIn(), getEntryList().getOut(), getEntryList().getTotal());
        getJTable().validate();
    }
    
    public void setEntryList(EntryList entryList) {
        this.entryList = entryList;
    }
    
    public EntryList getEntryList() {
        return this.entryList;
    } 
    
    public void setJTable(JTable jTable) {
        this.jTable = jTable;
    }
    
    public JTable getJTable() {
        return this.jTable;
    }
    
    /*public JTable paintRowForeground(Color color, String rowValue, int rowIndex, int columnIndex) {
        JTable jTable = getJTable();
        jTable.setDefaultRenderer(Double.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent() {
                Component c = super.getTableCellRendererComponent(getJTable(), rowValue, false, false, rowIndex, columnIndex);
                c.setForeground(color);
                return c;
            }
        });
        return jTable;
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        btn_insert_entry = new javax.swing.JButton();
        btn_remove_entry = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_in = new javax.swing.JLabel();
        txt_out = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btn_insert_entry.setText("Inserir entrada");
        btn_insert_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insert_entryActionPerformed(evt);
            }
        });

        btn_remove_entry.setText("Excluir entrada");
        btn_remove_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_entryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Entrada:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Saída:");

        txt_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_in.setForeground(new java.awt.Color(0, 0, 153));
        txt_in.setText("0");

        txt_out.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_out.setForeground(new java.awt.Color(153, 0, 0));
        txt_out.setText("0");

        txt_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_total.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_insert_entry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_remove_entry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_in, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txt_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_insert_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_remove_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_in))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_out))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_total))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_remove_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_entryActionPerformed
        // TODO add your handling code here:
        JTable jTable = getJTable();
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable.getModel();
        EntryList entryList = getEntryList();
        
        int answer = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo excluir?", "Confirmar Operação", 
                JOptionPane.YES_NO_OPTION);
        
        if(answer == 0)
        {
            int[] rowsSelected = jTable.getSelectedRows();
            for (int i=0; i<rowsSelected.length; i++)
            {
                entryList.removeEntry(rowsSelected[i]-i);
                defaultTableModel.removeRow(rowsSelected[i]-i);
            }
            jTable.validate();
        }
        
    }//GEN-LAST:event_btn_remove_entryActionPerformed

    private void btn_insert_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert_entryActionPerformed
        // TODO add your handling code here:
        InsertEntryDialog insertEntryDialog = new InsertEntryDialog(getEntryList(), this, true);
        insertEntryDialog.setVisible(true);
    }//GEN-LAST:event_btn_insert_entryActionPerformed

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
            java.util.logging.Logger.getLogger(CashFlowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashFlowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashFlowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashFlowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashFlowFrame().setVisible(true);
            }
        });
    }

    private JTable jTable;
    private EntryList entryList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insert_entry;
    private javax.swing.JButton btn_remove_entry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel txt_in;
    private javax.swing.JLabel txt_out;
    private javax.swing.JLabel txt_total;
    // End of variables declaration//GEN-END:variables
}
