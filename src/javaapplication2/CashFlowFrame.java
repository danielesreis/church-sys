/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import javax.swing.JComboBox;

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
        
        JTable jTable = new JTable(defaultTableModel);
        jTable.setAutoscrolls(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        
        setJTable(jTable);
        
        List<Integer> years = new ArrayList<Integer>();
        setYears(years);
        
        /*leio as rows e armazeno em EntryList*/
        EntryList entryList = new EntryList();
        for(int i=0; i<0; i++) {
            /*crio objeto entry de cada row do arquivo*/
            //entryList.addEntry(entry);
            updateTable(entryList.getStringMember(i), i);
        }
        
        setEntryList(entryList);
        
        this.jTable.validate();
        this.jScrollPane.getViewport().add(jTable);
        
        this.jTable.getModel().addTableModelListener(new TableModelListener() {
            
            public void tableChanged(TableModelEvent e) {
                EntryList entryList = getEntryList();
                int index = e.getFirstRow();
                switch(e.getType())
                {
                    case TableModelEvent.INSERT: 
                        updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal());
                        /*atualizo .xlsx*/; break;
                        
                    case TableModelEvent.UPDATE: 
                        if(e.getColumn()!=-1) {
                            index = entryList.updateEntry(e.getFirstRow(), e.getColumn(), (Object)getJTable().getModel().getValueAt(e.getFirstRow(), e.getColumn()));
                            updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal());
                        }
                        if(e.getColumn()==0 && !getMoved()) {
                            moveRowTable(e.getFirstRow(), index);
                        }
                        /*atualizo .xlsx*/; break;
                        
                    case TableModelEvent.DELETE: 
                        updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal());
                         /*atualizo .xlsx*/ break;
                    default: 
                }
            }
        });
        
        combobox_year.addItemListener(new ItemListener() {
           List<Entry> searchEntryList;
           public void itemStateChanged(ItemEvent e) {
               
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    int indexYearSelected, indexMonthSelected, indexDaySelected;
                    String yearSelected, monthSelected, daySelected;
                   
                    indexYearSelected = combobox_year.getSelectedIndex();
                    indexMonthSelected = combobox_month.getSelectedIndex();
                    indexDaySelected = combobox_day.getSelectedIndex();

                    if(indexYearSelected>0 || indexMonthSelected>0 || indexDaySelected>0) {
                        
                        yearSelected = (indexYearSelected == 0) ? "" : (String)combobox_year.getSelectedItem();

                        monthSelected = Integer.toString(indexMonthSelected);
                        monthSelected = (indexMonthSelected == 0) ? "" : Integer.toString(combobox_month.getSelectedIndex());
                        monthSelected = (indexMonthSelected > 0 && indexMonthSelected < 9) ? "0" + monthSelected : monthSelected;

                        daySelected = (indexDaySelected == 0) ? "" : (String)combobox_day.getSelectedItem();

                        searchEntryList = getEntryList().objectSearch(daySelected, monthSelected, yearSelected);
                        System.out.println(searchEntryList.size());
                        updateTable(searchEntryList);
                    }
                    else updateTable(getEntryList().getEntryList());
                }
           }
        });
        
        combobox_month.addItemListener(new ItemListener() {
            List<Entry> searchEntryList;
            public void itemStateChanged(ItemEvent e) {
                
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    int indexYearSelected, indexMonthSelected, indexDaySelected;
                    String yearSelected, monthSelected, daySelected;
                   
                    indexYearSelected = combobox_year.getSelectedIndex();
                    indexMonthSelected = combobox_month.getSelectedIndex();
                    indexDaySelected = combobox_day.getSelectedIndex();

                    if(indexYearSelected>0 || indexMonthSelected>0 || indexDaySelected>0) {
                        
                        yearSelected = (indexYearSelected == 0) ? "" : (String)combobox_year.getSelectedItem();

                        monthSelected = Integer.toString(indexMonthSelected);
                        monthSelected = (indexMonthSelected == 0) ? "" : Integer.toString(combobox_month.getSelectedIndex());
                        monthSelected = (indexMonthSelected > 0 && indexMonthSelected < 9) ? "0" + monthSelected : monthSelected;

                        daySelected = (indexDaySelected == 0) ? "" : (String)combobox_day.getSelectedItem();

                        searchEntryList = getEntryList().objectSearch(daySelected, monthSelected, yearSelected);
                        System.out.println(searchEntryList.size());
                        updateTable(searchEntryList);
                    }
                    else updateTable(getEntryList().getEntryList());
                }
            }
        });
        
        combobox_day.addItemListener(new ItemListener() {
            List<Entry> searchEntryList;
            public void itemStateChanged(ItemEvent e) {
                
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    int indexYearSelected, indexMonthSelected, indexDaySelected;
                    String yearSelected, monthSelected, daySelected;
                   
                    indexYearSelected = combobox_year.getSelectedIndex();
                    indexMonthSelected = combobox_month.getSelectedIndex();
                    indexDaySelected = combobox_day.getSelectedIndex();

                    if(indexYearSelected>0 || indexMonthSelected>0 || indexDaySelected>0) {
                        
                        yearSelected = (indexYearSelected == 0) ? "" : (String)combobox_year.getSelectedItem();

                        monthSelected = Integer.toString(indexMonthSelected);
                        monthSelected = (indexMonthSelected == 0) ? "" : Integer.toString(combobox_month.getSelectedIndex());
                        monthSelected = (indexMonthSelected > 0 && indexMonthSelected < 9) ? "0" + monthSelected : monthSelected;

                        daySelected = (indexDaySelected == 0) ? "" : (String)combobox_day.getSelectedItem();

                        searchEntryList = getEntryList().objectSearch(daySelected, monthSelected, yearSelected);
                        System.out.println(searchEntryList.size());
                        updateTable(searchEntryList);
                    }
                    else updateTable(getEntryList().getEntryList());
                    
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
    
    public void moveRowTable(int oldRowIndex, int newRowIndex) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.moveRow(oldRowIndex, oldRowIndex, newRowIndex);
        setMoved(true);
    }
    
    public void updateTable(List<Entry> searchEntryList) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.setRowCount(0);
        Object[] rowData;
        
        for(int i=0; i<searchEntryList.size(); i++) {
            rowData = getEntryList().getStringMember(searchEntryList.get(i));
            defaultTableModel.insertRow(i, rowData);
        }
        updateTxt(getEntryList().getIn(), getEntryList().getOut(), getEntryList().getTotal());
        getJTable().validate();
    }
        
    public void updateTable(Object[] rowData, int index) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.insertRow(index, rowData);
        updateTxt(getEntryList().getIn(), getEntryList().getOut(), getEntryList().getTotal());
        getJTable().validate();
    }
        
    public void updateComboBoxYear(int newYear) {
        int size, pos=0, i;
        List<Integer> years = getYears();
        size = years.size();
        
        if(!years.contains(newYear)) {
            if (size >= 1){
                pos = size;
                for(i=0; i<size; i++) {
                    if (newYear > years.get(i)) {
                        pos = i;
                        break;
                    }
                }
            }
            years.add(pos, newYear);
            combobox_year.insertItemAt(Integer.toString(newYear), pos+1);
            combobox_year.setSelectedIndex(0);
        }
    }
        
    /*public void deleteFromComboBoxYear(int itemIndex) {
        List<Integer> years = getYears();
        years.remove(itemIndex);
        combobox_year.removeItem(itemIndex);
        JOptionPane.showMessageDialog(rootPane, "Removendo o errado");
    }*/
    
    public static void setMoved(boolean moved) {
        moved = moved;
    }
    
    public static boolean getMoved() {
        return moved;
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
    
    public void setYears(List<Integer> years) {
        this.years = years;
    }
    
    public List<Integer> getYears() {
        return this.years;
    }
    
                
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
        combobox_year = new javax.swing.JComboBox<>();
        combobox_month = new javax.swing.JComboBox<>();
        combobox_day = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fluxo de Caixa");
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

        combobox_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano" }));
        combobox_year.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_yearItemStateChanged(evt);
            }
        });
        combobox_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_yearActionPerformed(evt);
            }
        });

        combobox_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        combobox_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

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
                            .addComponent(btn_remove_entry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_year, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_month, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_day, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_insert_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_remove_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combobox_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combobox_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combobox_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void combobox_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_yearActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_combobox_yearActionPerformed

    private void combobox_yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_yearItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_yearItemStateChanged

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

    private static boolean moved = false;
    private List<Integer> years;
    private JTable jTable;
    private EntryList entryList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insert_entry;
    private javax.swing.JButton btn_remove_entry;
    private javax.swing.JComboBox<String> combobox_day;
    private javax.swing.JComboBox<String> combobox_month;
    private javax.swing.JComboBox<String> combobox_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel txt_in;
    private javax.swing.JLabel txt_out;
    private javax.swing.JLabel txt_total;
    // End of variables declaration//GEN-END:variables
}
