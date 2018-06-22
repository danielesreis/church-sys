package javaapplication2.Classes;
import javaapplication2.Interfaces.CashFlowFrame;
import java.util.ArrayList;
import java.util.List;

public class EntryList{
    List<Entry> entryList;
    double in;
    double out;
    CashFlowFrame cashFlowFrame;
    
    EntryList() {}
    
    public EntryList(CashFlowFrame cashFlowFrame){
        List<Entry> entryList = new ArrayList<Entry>();
        setCashFlowFrame(cashFlowFrame);
        setEntryList(entryList);
        setIn(0);
        setOut(0);
    }
    
    private void setCashFlowFrame(CashFlowFrame cashFlowFrame) {
        this.cashFlowFrame = cashFlowFrame;
    }
    
    public CashFlowFrame getCashFlowFrame() {
        return this.cashFlowFrame;
    }
    
    private void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
    
    public List<Entry> getEntryList() {
        return this.entryList;
    }
    
    private void setIn (double in) {
	this.in = this.in + in;
    }	

    public double getIn() {
	return this.in;
    }

    private void setOut (double out) {
	this.out = this.out + out;
    }

    public double getOut() {
	return this.out;
    }	
    
    public int getEntryListSize() {
        return getEntryList().size();
    }
    
    public Entry getEntryByKey(int key) {
        Entry entry = null;
        
        for(int i = 0; i < this.getEntryListSize(); i++) {
            entry = getEntryList().get(i);
            if (entry.getKey() == key) return entry;
        }
        
        return entry;
    }
    
    public int addEntry(Entry entry) {
        int index = getPosition(entry);
        getEntryList().add(index, entry);
                
        if(entry.getPositiveEntry())
            setIn(entry.getValue(true));
        else
            setOut(entry.getValue(true));
        
        return index;
    }
    
    /*what if entry is null?*/
    public void removeEntry(int key) {
        Entry entry = getEntryByKey(key);
        
        if (entry.getPositiveEntry()) setIn(-entry.getValue(true));
        else setOut(-entry.getValue(true));
        
        getEntryList().remove(entry);
    }
    
    /*what if auxEntry is null?*/
    private int getPosition(Entry newEntry) {
        int pos = 0, auxPos = 0, keep = 0, size = getEntryListSize(), newEntryYear, i;
        List<Entry> entryList = getEntryList(); 
        Entry auxEntry;
        
        if (size >= 1) {
            pos = size;
            newEntryYear = newEntry.getYear();
            
            for(i = 0; i < size; i++) {
                auxEntry = getEntryByKey(i);
                
                if(newEntryYear < auxEntry.getYear()) {
                    keep = -1;
                    pos = i;
                    break;
                }
                else if(newEntryYear == auxEntry.getYear()) {
                    keep = 1;
                    auxPos = i;
                    break;
                }
            }
            
            if(keep == 1) {
                int newEntryMonth = newEntry.getMonth();
               
                for(i = auxPos; i < size; i++) {
                    auxEntry = getEntryByKey(i);
                    
                    if (newEntryMonth < auxEntry.getMonth()) {
                        keep = -1;
                        pos = i;
                        break;
                    }
                    else if(newEntryMonth == auxEntry.getMonth()) {
                        keep = 2;
                        auxPos = i;
                        break;
                    }
                    if (newEntryYear != auxEntry.getYear()) {
                        keep = -1;
                        pos = i;
                        break;
                    }
                }
                
                if(keep == 2) {
                    int newEntryDay = newEntry.getDay();
                    
                    for(i = auxPos; i < size; i++) {
                        auxEntry = getEntryByKey(i);
                        
                        if(newEntryDay < auxEntry.getDay()) {
                            pos = i;
                            break;
                        }
                        else if (newEntryDay == auxEntry.getDay()) {
                            pos = i;
                            break;
                        }
                        if((newEntryYear != auxEntry.getYear()) || newEntryMonth != auxEntry.getMonth()) {
                            pos = i;
                            break;
                        }
                    }
                }
             }
        }
        return pos;        
    }
            
    public void updateEntry(int entryKey, int attributeKey, Object attributeValue) {
        Entry entry = getEntryList().get(entryKey);
        Entry newEntry;
        
        switch(attributeKey) {
            case 0: entry.setDate((String)attributeValue);
                    int oldPos = getEntryList().indexOf(entry), newPos;
                    newEntry = entry;
                    getEntryList().remove(entryKey);
                    newPos = addEntry(newEntry);
                    getCashFlowFrame().updateComboBoxYear(newEntry.getYear());
                    getCashFlowFrame().swapRows(oldPos, newPos);
                    break;
            case 1: entry.setDescription((String)attributeValue); 
                    break;
            case 2: if(entry.getPositiveEntry()) {
                        this.setIn(-entry.getValue(true));
                        entry.setValue((Double)attributeValue);
                        this.setIn(entry.getValue(true));
                    }
                    else {
                        this.setOut(-entry.getValue(true));
                        entry.setValue((Double)attributeValue);
                        this.setOut(entry.getValue(true));
                    }
        }
    }
    
    private static String concatDate(String day, String month, String year) {
        String date = day + "/" + month + "/" + year;
        String[] words = date.split("/");
        
        words[0] = (words[0].length() == 1) ? "0" + words[0] : words[0];
        words[1] = (words[1].length() == 1) ? "0" + words[1] : words[1];
        date = words[0] + "/" + words[1] + "/" + words[2];
        
        return date;        
    }
    
    /*what if entry is null?*/
    public Object[] getStringMember(int key) {
        Entry entry = this.getEntryByKey(key);
        String value = String.format("%.2f", entry.getValue(true));
        int valueKey;
        
        Object[] rowData = {entry.getKey(), entry.getDate(), entry.getDescription(), "", "", ""};
        valueKey = entry.getPositiveEntry() ? 3 : 4;
        rowData[valueKey] = value;
        
        return rowData;
    }
    
    /*bye?*/
    public Object[] getStringMember(Entry entry) {
        String value = String.format("%.2f", entry.getValue(true));
        int valueKey;
        
        Object[] rowData = {entry.getKey(), entry.getDate(), entry.getDescription(), "", "", ""};
        valueKey = entry.getPositiveEntry() ? 2 : 3;
        rowData[valueKey] = value;
        
        return rowData;
    }
    
    /*bye?*/ /*what if entry is null?*/
    public List<Entry> objectSearch (String day, String month, String year)
    {
        List<Entry> searchList = new ArrayList<>();
        String searchDate, auxDay, auxMonth, auxYear;
        
        for(int i=0; i<getEntryListSize(); i++) {
            Entry entry = getEntryByKey(i);
            
            auxDay = (day.isEmpty()) ? Integer.toString(entry.getDay()) : day;
            auxMonth = (month.isEmpty()) ? Integer.toString(entry.getMonth()) : month;
            auxYear = (year.isEmpty()) ? Integer.toString(entry.getYear()) : year;
            searchDate = concatDate(auxDay, auxMonth, auxYear);
            
            if (searchDate.equals((String)entry.getDate())) searchList.add(entry);
        }
        return searchList;
    }
}
