package javaapplication2;
import java.util.ArrayList;
import java.util.List;

public class EntryList implements Utilities {
    List<Entry> entryList;
    
    EntryList(){
        List<Entry> entryList = new ArrayList<Entry>();
        setEntryList(entryList);
    }
    
    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
    
    public List<Entry> getEntryList() {
        return this.entryList;
    }
    
    public void addEntry(Entry entry) {
        getEntryList().add(entry);
    }
    
    public int getEntryListSize() {
        return getEntryList().size();
    }
    
    public Entry getEntryByIndex(int index) {
        return getEntryList().get(index);
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
