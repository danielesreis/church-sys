package javaapplication2;
import java.util.ArrayList;
import java.util.List;

public class EntryList implements Utilities {
    List<Entry> entryList;
    double in;
    double out;
    double total;
    
    EntryList(){
        List<Entry> entryList = new ArrayList<Entry>();
        setEntryList(entryList);
        setIn(0);
        setOut(0);
        setTotal(0);
    }
    
    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
    
    public List<Entry> getEntryList() {
        return this.entryList;
    }
    
    public void setIn (double in) {
	this.in = this.in + in;
        setTotal(in);
    }	

    public double getIn() {
	return this.in;
    }

    public void setOut (double out) {
	this.out = this.out + out;
        setTotal(out);
    }

    public double getOut() {
	return this.out;
    }	

    public void setTotal (double total) {
    	this.total = this.total + total;
    }
	
    public double getTotal() {
        return this.total;
    }
    
    public int addEntry(Entry entry) {
        
        int index = position(entry);
        getEntryList().add(index, entry);
                
        if(entry.getPositiveEntry())
            setIn(entry.getValue());
        else
            setOut(entry.getValue());
        
        return index;
    }
    
    public void removeEntry(int index) {
        Entry entry = getEntryByIndex(index);
        
        if (entry.getPositiveEntry()) setIn(-entry.getValue());
        else setOut(-entry.getValue());
        
        getEntryList().remove(index);
    }
    
    public int position(Entry newEntry) {
        int pos = 0, auxPos=0, i, size = getEntryListSize(), auxYear, newEntryYear;
        List<Entry> entryList = getEntryList(); 
        Entry auxEntry;
        int keep = 0;
        
        if (size >= 1) {
            pos = size;
            newEntryYear = newEntry.getYear();
            
            for(i=0; i<size; i++) {
                auxEntry = getEntryByIndex(i);
                
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
               
                for(i=auxPos; i<size; i++) {
                    auxEntry = getEntryByIndex(i);
                    
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
                    
                    for(i=auxPos; i<size; i++) {
                        auxEntry = getEntryByIndex(i);
                        
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
        
    public int getEntryListSize() {
        return getEntryList().size();
    }
    
    public Entry getEntryByIndex(int index) {
        return getEntryList().get(index);
    }
    
    public int updateEntry(int entryIndex, int attributeIndex, Object attributeValue) {
        Entry entry = getEntryList().get(entryIndex);
        Entry newEntry;
        int index=0;
        
        switch(attributeIndex) {
            case 0: entry.setDate((String)attributeValue); 
                    newEntry = entry;
                    getEntryList().remove(entryIndex);
                    index = addEntry(newEntry);
                    CashFlowFrame.setMoved(false);
                    break;
            case 1: entry.setDescription((String)attributeValue); break;
            case 2: setIn(-entry.getValue());
                    entry.setValue(Double.parseDouble((String)attributeValue));
                    setIn(entry.getValue());
                    break;
            case 3: setOut(-entry.getValue());
                    entry.setValue(Double.parseDouble((String)attributeValue));
                    setOut(entry.getValue());
        }
        return index;
    }
    
    public void print() {
        for(int i=0; i<getEntryListSize(); i++)
            System.out.println(getEntryByIndex(i).getDate());
    }
    
    public static String concatDate(String day, String month, String year) {
        return (day + "/" + month + "/" + year);
    }
    
    public String upperCaseString(String str) {
        str = str.trim();
        char firstLetter = Character.toUpperCase(str.charAt(0));
        str = firstLetter + str.substring(1, str.length());
        return str;
    }
    
    public Object[] getStringMember(int index) {
        Entry entry = getEntryByIndex(index);
        String value = String.format("%.2f", entry.getValue());
        int valueIndex;
        
        Object[] rowData = {entry.getDate(), entry.getDescription(), "", ""};
        valueIndex = entry.getPositiveEntry() ? 2 : 3;
        rowData[valueIndex] = value;
        
        return rowData;
    }
}
