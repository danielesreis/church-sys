/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Interfaces;
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
import javaapplication2.Classes.Entry;
import javaapplication2.Classes.EntryList;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("Código");
        defaultTableModel.addColumn("Data");
        defaultTableModel.addColumn("Descrição");
        defaultTableModel.addColumn("Entrada (R$)");
        defaultTableModel.addColumn("Saída (R$)");
        
        JTable jTable = new JTable(defaultTableModel);
        jTable.setAutoscrolls(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setRowSelectionAllowed(true);
        
        setJTable(jTable);
        
        List<Integer> years = new ArrayList<Integer>();
        setYears(years);
        
        /*leio as rows e armazeno em EntryList*/
        EntryList entryList = new EntryList(this);
        
        /*crio objeto entry de cada row do arquivo*/
        Entry entry = new Entry("10/09/1995", entryList.getEntryListSize(), "Cafeteira", false, 500);
        entryList.addEntry(entry);
        this.updateComboBoxYear(entry.getYear());
        
        entry = new Entry("11/09/1996", entryList.getEntryListSize(), "Cafeteira", false, 500);
        entryList.addEntry(entry);
        this.updateComboBoxYear(entry.getYear());
        
        entry = new Entry("12/09/1997", entryList.getEntryListSize(), "Cafeteira", false, 500);
        entryList.addEntry(entry);
        this.updateComboBoxYear(entry.getYear());
        
        entry = new Entry("11/09/1998", entryList.getEntryListSize(), "Cafeteira", false, 500);
        entryList.addEntry(entry);
        this.updateComboBoxYear(entry.getYear());
        
        entry = new Entry("12/09/1999", entryList.getEntryListSize(), "Cafeteira", false, 500);
        entryList.addEntry(entry);
        this.updateComboBoxYear(entry.getYear());
        
        entry = new Entry("10/09/2000", entryList.getEntryListSize(), "Bolão", true, 1000);
        entryList.addEntry(entry);
        this.updateComboBoxYear(entry.getYear());
        
        setEntryList(entryList);
        
        for (int i = 0; i < 6; i++)
            InsertToTable(entryList.getStringMember(i), i);
        //chamo o método do cálculo do saldo
        //updateBalance(getEntryList());
               
        this.jTable.validate();
        this.jScrollPane.getViewport().add(jTable);
        
        this.jTable.getModel().addTableModelListener(new TableModelListener() {
            
            public void tableChanged(TableModelEvent e) {
                EntryList entryList = getEntryList();
                int index = e.getFirstRow();
                switch(e.getType())
                {
                    case TableModelEvent.INSERT: 
                        updateTxt(entryList.getIn(), entryList.getOut());
                        //updateBalance(getEntryList());
                        /*atualizo .xlsx*/; break;
                        
                    case TableModelEvent.UPDATE: 
                        /*if(!getUpdated()) {
                            if(e.getColumn()!=-1) {
                                index = entryList.updateEntry(e.getFirstRow(), e.getColumn(), (Object)getJTable().getModel().getValueAt(e.getFirstRow(), e.getColumn()));
                                updateTxt(entryList.getIn(), entryList.getOut(), entryList.getTotal());
                                //updateBalance(getEntryList());
                            }
                            if(e.getColumn()==0 && !getMoved()) {
                                moveRowTable(e.getFirstRow(), index);
                            }
                            setUpdated(false);
                        }*/
                        
                        /*atualizo .xlsx*/; break;
                        
                    case TableModelEvent.DELETE:
                        updateTxt(entryList.getIn(), entryList.getOut());
                        //updateBalance(getEntryList());
                         /*atualizo .xlsx*/ break;
                    default: 
                }
            }
        });
        
        TableRowSorter sorter = new TableRowSorter<TableModel>(defaultTableModel);
        jTable.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rf = null;
        
        combobox_year.addItemListener(new ItemListener() {
           //List<Entry> searchEntryList;
            public void itemStateChanged(ItemEvent e) {
                String searchString;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int indexYearSelected, indexMonthSelected, indexDaySelected;
                    String yearSelected, monthSelected, daySelected;
                   
                    indexYearSelected = combobox_year.getSelectedIndex();
                    indexMonthSelected = combobox_month.getSelectedIndex();
                    indexDaySelected = combobox_day.getSelectedIndex();

                    if(indexYearSelected > 0 || indexMonthSelected > 0 || indexDaySelected > 0) {
                        
                        yearSelected = (indexYearSelected == 0) ? "" : (String)combobox_year.getSelectedItem();

                        monthSelected = Integer.toString(indexMonthSelected);
                        monthSelected = (indexMonthSelected == 0) ? "" : Integer.toString(combobox_month.getSelectedIndex());
                        monthSelected = (indexMonthSelected > 0 && indexMonthSelected < 10) ? "0" + monthSelected : monthSelected;

                        daySelected = (indexDaySelected == 0) ? "" : (String)combobox_day.getSelectedItem();
                        
                        searchString = daySelected.isEmpty() ? "([0-9]{2})/" : daySelected + "/";
                        searchString = monthSelected.isEmpty() ? searchString + "([0-9]{2})/" : searchString + monthSelected + "/";
                        searchString = yearSelected.isEmpty() ? searchString : searchString + yearSelected;
                        sorter.setRowFilter(rf.regexFilter(searchString, 1));

                        //searchEntryList = getEntryList().objectSearch(daySelected, monthSelected, yearSelected);
                        //updateTable(searchEntryList);
                        //updateBalance(searchEntryList);
                        
                        Double in = 0.0, out = 0.0, auxIn, auxOut;
                        
                        for (int i = 0; i < jTable.getRowCount(); i++) {
                            auxIn = jTable.getValueAt(i, 3).toString().isEmpty() ? 0 : Double.parseDouble(jTable.getValueAt(i, 3).toString().replace(",", "."));
                            auxOut = jTable.getValueAt(i, 4).toString().isEmpty() ? 0 : Double.parseDouble(jTable.getValueAt(i, 4).toString().substring(1).replace(",", "."));
                            in += auxIn;
                            out += auxOut;
                        }
                        updateTxt(in, -out);
                    }
                }
                else sorter.setRowFilter(rf.regexFilter("", 1));
           }
        });
                
        combobox_month.addItemListener(new ItemListener() {
            List<Entry> searchEntryList;
            public void itemStateChanged(ItemEvent e) {
                String searchString;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int indexYearSelected, indexMonthSelected, indexDaySelected;
                    String yearSelected, monthSelected, daySelected;
                   
                    indexYearSelected = combobox_year.getSelectedIndex();
                    indexMonthSelected = combobox_month.getSelectedIndex();
                    indexDaySelected = combobox_day.getSelectedIndex();

                    if(indexYearSelected > 0 || indexMonthSelected > 0 || indexDaySelected > 0) {
                        
                        yearSelected = (indexYearSelected == 0) ? "" : (String)combobox_year.getSelectedItem();

                        monthSelected = Integer.toString(indexMonthSelected);
                        monthSelected = (indexMonthSelected == 0) ? "" : Integer.toString(combobox_month.getSelectedIndex());
                        monthSelected = (indexMonthSelected > 0 && indexMonthSelected < 10) ? "0" + monthSelected : monthSelected;

                        daySelected = (indexDaySelected == 0) ? "" : (String)combobox_day.getSelectedItem();
                        
                        searchString = daySelected.isEmpty() ? "([0-9]{2})/" : daySelected + "/";
                        searchString = monthSelected.isEmpty() ? searchString + "([0-9]{2})/" : searchString + monthSelected + "/";
                        searchString = yearSelected.isEmpty() ? searchString : searchString + yearSelected;
                        sorter.setRowFilter(rf.regexFilter(searchString, 1));

                        //searchEntryList = getEntryList().objectSearch(daySelected, monthSelected, yearSelected);
                        //updateTable(searchEntryList);
                        //updateBalance(searchEntryList);
                        
                        Double in = 0.0, out = 0.0, auxIn, auxOut;
                        
                        for (int i = 0; i < jTable.getRowCount(); i++) {
                            auxIn = jTable.getValueAt(i, 3).toString().isEmpty() ? 0 : Double.parseDouble(jTable.getValueAt(i, 3).toString().replace(",", "."));
                            auxOut = jTable.getValueAt(i, 4).toString().isEmpty() ? 0 : Double.parseDouble(jTable.getValueAt(i, 4).toString().substring(1).replace(",", "."));
                            in += auxIn;
                            out += auxOut;
                        }
                        updateTxt(in, -out);
                    }
                }
                else sorter.setRowFilter(rf.regexFilter("", 1));
            }
        });
        
        combobox_day.addItemListener(new ItemListener() {
            List<Entry> searchEntryList;
            public void itemStateChanged(ItemEvent e) {
                String searchString;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int indexYearSelected, indexMonthSelected, indexDaySelected;
                    String yearSelected, monthSelected, daySelected;
                   
                    indexYearSelected = combobox_year.getSelectedIndex();
                    indexMonthSelected = combobox_month.getSelectedIndex();
                    indexDaySelected = combobox_day.getSelectedIndex();

                    if(indexYearSelected > 0 || indexMonthSelected > 0 || indexDaySelected > 0) {
                        
                        yearSelected = (indexYearSelected == 0) ? "" : (String)combobox_year.getSelectedItem();

                        monthSelected = Integer.toString(indexMonthSelected);
                        monthSelected = (indexMonthSelected == 0) ? "" : Integer.toString(combobox_month.getSelectedIndex());
                        monthSelected = (indexMonthSelected > 0 && indexMonthSelected < 10) ? "0" + monthSelected : monthSelected;

                        daySelected = (indexDaySelected == 0) ? "" : (String)combobox_day.getSelectedItem();

                        searchString = daySelected.isEmpty() ? "([0-9]{2})/" : daySelected + "/";
                        searchString = monthSelected.isEmpty() ? searchString + "([0-9]{2})/" : searchString + monthSelected + "/";
                        searchString = yearSelected.isEmpty() ? searchString : searchString + yearSelected;
                        sorter.setRowFilter(rf.regexFilter(searchString, 1));
                        //searchEntryList = getEntryList().objectSearch(daySelected, monthSelected, yearSelected);
                        //updateTable(searchEntryList);
                        //updateBalance(searchEntryList);
                        
                        Double in = 0.0, out = 0.0, auxIn, auxOut;
                        
                        for (int i = 0; i < jTable.getRowCount(); i++) {
                            auxIn = jTable.getValueAt(i, 3).toString().isEmpty() ? 0 : Double.parseDouble(jTable.getValueAt(i, 3).toString().replace(",", "."));
                            auxOut = jTable.getValueAt(i, 4).toString().isEmpty() ? 0 : Double.parseDouble(jTable.getValueAt(i, 4).toString().substring(1).replace(",", "."));
                            in += auxIn;
                            out += auxOut;
                        }
                        updateTxt(in, -out);
                    }
                }
                else sorter.setRowFilter(rf.regexFilter("", 1));
            }
        });
    }
    
    protected void updateTxt(Double in, Double out) {
        String txtIn, txtOut, txtTotal; 
        
        txtIn = String.format("%.2f", in);
        txtOut = String.format("%.2f", out);
        txtTotal = String.format("%.2f", in + out);
        
        txt_in.setText(txtIn);
        txt_out.setText(txtOut);
        txt_total.setText(txtTotal);
    }
    
    /*private void moveRowTable(int oldRowIndex, int newRowIndex) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.moveRow(oldRowIndex, oldRowIndex, newRowIndex);
        setMoved(true);
    }*/
    
    /*private void updateTable(List<Entry> searchEntryList) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.setRowCount(0);
        Double in = 0.0, out = 0.0, total = 0.0, value;
        Entry entry;
        Object[] rowData;
        
        for(int i = 0; i < searchEntryList.size(); i++) {
            entry = searchEntryList.get(i);
            if (entry.getPositiveEntry()) {
                value = entry.getValue(true);
                in = in + value;
            }
            else {
                value = entry.getValue(true);
                out = out + value;
            }
            total = total + value;
                        
            rowData = getEntryList().getStringMember(entry);
            defaultTableModel.insertRow(i, rowData);
        }
        updateTxt(in, out, total);
        
        getJTable().validate();
    }*/
        
    public void InsertToTable(Object[] rowData, int index) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();        
        defaultTableModel.insertRow(index, rowData);
        updateTxt(getEntryList().getIn(), getEntryList().getOut());
    }
    
    public void swapRows(int oldPos, int newPos) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        defaultTableModel.moveRow(oldPos, oldPos, newPos);
        getJTable().validate();
    }
        
    public void updateComboBoxYear(int newYear) {
        int size, pos=0, i;
        List<Integer> years = getYears();
        size = years.size();
        
        if(!years.contains(newYear)) {
            if (size >= 1){
                pos = size;
                for(i = 0; i < size; i++) {
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
    
    /*public void updateBalance(EntryList entryList) {
        int i;
        double balance = 0;
        String formattedBalance;
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        
        for(i=0; i<entryList.getEntryListSize(); i++) {
            if(i==0) setBalance(entryList.getEntryByIndex(0).getValue());
            else {
                balance = balance + entryList.getEntryByIndex(i).getValue();
                setBalance(balance);
            }
            setUpdated(true);
            formattedBalance = String.format("%.2f", getBalance());
            defaultTableModel.setValueAt(formattedBalance, i, 4);
        }
    }
    
    public void updateBalance(List<Entry> entrySearchList) {
        int i;
        double balance = 0;
        String formattedBalance;
        DefaultTableModel defaultTableModel = (DefaultTableModel)getJTable().getModel();
        
        for(i=0; i<entrySearchList.size(); i++) {
            if(i==0) setBalance(entrySearchList.get(0).getValue());
            else {
                balance = balance + entrySearchList.get(i).getValue();
                setBalance(balance);
            }
            setUpdated(true);
            formattedBalance = String.format("%.2f", getBalance());
            defaultTableModel.setValueAt(formattedBalance, i, 4);
        }
    }*/
    
    /*private void setBalance(double balance) {
        this.balance = balance;
    }
    
    private double getBalance() {
        return this.balance;
    }*/
    
    /*public void setMoved(boolean moved) {
        this.moved = moved;
    }
    
    private boolean getMoved() {
        return this.moved;
    }*/
    
    /*private void setUpdated(boolean updated) {
        this.updated = updated;
    }
    
    private boolean getUpdated() {
        return this.updated;
    }*/
    
    private void setEntryList(EntryList entryList) {
        this.entryList = entryList;
    }
    
    protected EntryList getEntryList() {
        return this.entryList;
    } 
    
    private void setJTable(JTable jTable) {
        this.jTable = jTable;
    }
    
    public JTable getJTable() {
        return this.jTable;
    }
    
    private void setYears(List<Integer> years) {
        this.years = years;
    }
    
    private List<Integer> getYears() {
        return this.years;
    }
    
    protected void setEditedRow(int editedRow) {
        this.editedRow = editedRow;
    }
    
    protected int getEditedRow() {
        return this.editedRow;
    }
    
    protected void setEditedEntryKey(int key) {
        this.key = key;
    }
    
    protected int getEditedEntryKey() {
        return this.key;
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
        btn_edit_entry = new javax.swing.JButton();
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

        btn_edit_entry.setText("Editar entrada");
        btn_edit_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_entryActionPerformed(evt);
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
                            .addComponent(combobox_day, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit_entry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_edit_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_remove_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
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
            int key;
            
            for (int i = 0; i < rowsSelected.length; i++)
            {
                key = (int)defaultTableModel.getValueAt(jTable.convertRowIndexToModel(rowsSelected[i]), 0);
                entryList.removeEntry(key);
                defaultTableModel.removeRow(jTable.convertRowIndexToModel(rowsSelected[i]));
            }
            jTable.validate();
        }
    }//GEN-LAST:event_btn_remove_entryActionPerformed

    private void btn_insert_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert_entryActionPerformed
        // TODO add your handling code here:
        combobox_year.setSelectedIndex(0);
        combobox_month.setSelectedIndex(0);
        combobox_day.setSelectedIndex(0);
        
        InsertEntryDialog insertEntryDialog = new InsertEntryDialog(getEntryList(), this, true);
        insertEntryDialog.setVisible(true);
    }//GEN-LAST:event_btn_insert_entryActionPerformed

    private void combobox_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_yearActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_combobox_yearActionPerformed

    private void combobox_yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_yearItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_yearItemStateChanged

    private void btn_edit_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_entryActionPerformed
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
            int key  = (int)getJTable().getModel().getValueAt(index, 0);
            setEditedEntryKey(key);
            EditEntryDialog editEntryDialog = new EditEntryDialog(this, true);
            editEntryDialog.setVisible(true);
        }

    }//GEN-LAST:event_btn_edit_entryActionPerformed

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
    
    private int editedRow;
    private int key;
    private double balance;
    private boolean moved = false;
    private boolean updated = false;
    private List<Integer> years;
    private JTable jTable;
    private EntryList entryList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit_entry;
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
