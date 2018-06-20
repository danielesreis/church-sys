/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Interfaces;
import javaapplication2.Interfaces.CashFlowFrame;
import java.awt.Frame;
import javaapplication2.Classes.Entry;
import javaapplication2.Classes.EntryList;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;
/**
 *
 * @author DaniR
 */
public class InsertEntryDialog extends javax.swing.JDialog {

    /**
     * Creates new form InsertEntryDialog
     */
    public InsertEntryDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public InsertEntryDialog (EntryList entryList, Frame parent, boolean modal) {
        super(parent, modal);
        setParentFrame(parent);
        setEntryList(entryList);
        initComponents();
    }
    
    public void setParentFrame(Frame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    public Frame getParentFrame() {
        return this.parentFrame;
    }
    
    public void setEntryList(EntryList entryList) {
        this.entryList = entryList;
    }
    
    public EntryList getEntryList() {
        return this.entryList;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtfield_date = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfield_value = new javax.swing.JTextField();
        radiobtn_in = new javax.swing.JRadioButton();
        radiobtn_out = new javax.swing.JRadioButton();
        btn_insert = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea_description = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir registro");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(549, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DATA (dd/mm/aaaa)");

        txtfield_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_dateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DESCRIÇÃO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("R$");

        txtfield_value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_valueActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobtn_in);
        radiobtn_in.setText("Entrada");

        buttonGroup1.add(radiobtn_out);
        radiobtn_out.setText("Saída");
        radiobtn_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn_outActionPerformed(evt);
            }
        });

        btn_insert.setText("Inserir");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        textarea_description.setColumns(20);
        textarea_description.setLineWrap(true);
        textarea_description.setRows(5);
        textarea_description.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textarea_description);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("VALOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(jLabel3)
                            .addGap(10, 10, 10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radiobtn_in)
                                .addGap(32, 32, 32)
                                .addComponent(radiobtn_out))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_insert)
                        .addComponent(txtfield_value, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfield_date, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfield_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfield_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radiobtn_in)
                            .addComponent(radiobtn_out)
                            .addComponent(btn_insert)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfield_valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_valueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_valueActionPerformed

    private void txtfield_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_dateActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        // TODO add your handling code here:
        String date, description, value;
        boolean positiveEntry, error;
        int index;
        
        date = txtfield_date.getText().replaceAll("\\s+", "");
        value = txtfield_value.getText().replaceAll("\\s+", "");
        description = textarea_description.getText();
        positiveEntry = radiobtn_in.isSelected();
        
        error = checkError(date, value);
        
        if(!error) {
            EntryList entryList = getEntryList();
            Entry entry = new Entry(date, entryList.getEntryListSize(), description, positiveEntry, Double.parseDouble(value.replace(",", ".")));
            index = entryList.addEntry(entry);
            CashFlowFrame cashFlowFrame = (CashFlowFrame)getParentFrame();
            cashFlowFrame.updateTable(entryList.getStringMember(index), index);
            cashFlowFrame.updateComboBoxYear(entry.getYear());
        }
    }//GEN-LAST:event_btn_insertActionPerformed

    private void radiobtn_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn_outActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtn_outActionPerformed

    private boolean checkError(String date, String value) {
        boolean error = false;
        
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Insira o valor!", "Alerta", HEIGHT);
            error = true;
        }
        
        if (!value.matches("[0-9]+([,.][0-9]{2})?")) {
            JOptionPane.showMessageDialog(parentFrame, "Formato do valor incorreto!", "Alerta", HEIGHT);
            error = true;
        }
        
        if(!date.matches("\\d{1,2}/{1}\\d{1,2}/{1}\\d{4}")) {
            JOptionPane.showMessageDialog(parentFrame, "Formato de data incorreto!", "Alerta", HEIGHT);
            error = true;
        }
        
        if(!radiobtn_in.isSelected() && !radiobtn_out.isSelected()) {
            JOptionPane.showMessageDialog(parentFrame, "Selecione o tipo de operação!", "Alerta", HEIGHT);
            error = true;
        }
        
        return error;
    }
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
            java.util.logging.Logger.getLogger(InsertEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InsertEntryDialog dialog = new InsertEntryDialog(new javax.swing.JFrame(), true);
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
    private EntryList entryList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_insert;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radiobtn_in;
    private javax.swing.JRadioButton radiobtn_out;
    private javax.swing.JTextArea textarea_description;
    private javax.swing.JTextField txtfield_date;
    private javax.swing.JTextField txtfield_value;
    // End of variables declaration//GEN-END:variables
}
