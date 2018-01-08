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
    
    public void addEntry(Entry entry) {
        
        int index = entryPosition();
        getEntryList().add(index, entry);
                
        if(entry.getPositiveEntry())
            setIn(entry.getValue());
        else
            setOut(entry.getValue());
    }
    
    public int entryPosition() {
        return getEntryListSize();
    }
    
    public int getEntryListSize() {
        return getEntryList().size();
    }
    
    public Entry getEntryByIndex(int index) {
        return getEntryList().get(index);
    }
    
    public void updateEntry(int entryIndex, int attributeIndex, Object attributeValue) {
        Entry entry = getEntryList().get(entryIndex);
        switch(attributeIndex) {
            case 0: entry.setDate((String)attributeValue); break;
            case 1: entry.setDescription((String)attributeValue); break;
            case 2: entry.setValue(Double.parseDouble((String)attributeValue));
                    if(entry.getPositiveEntry()) setIn(entry.getValue());
                    else setOut(entry.getValue());
        }
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
        Object[] rowData = {entry.getDate(), entry.getDescription(), Double.toString(entry.getValue())};
        return rowData;
    }
}
