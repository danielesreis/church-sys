package javaapplication2;

public class Entry {
    private String date;
    private String day;
    private String month;
    private String year;
    private double value;
    private String description;
    private boolean positiveEntry;
    
    Entry(String date, String description, boolean positiveEntry, double value) {	
        setDate(date);
        setDescription(description);
	setPositiveEntry(positiveEntry);
        setValue(value);
    }
    
    public void setDate(String date) {
        date = date.replaceAll("\\s+", "");
        this.date = date;
        
        String[] words = date.split("/");
        setDay(words[0]);
        setMonth(words[1]);
        setYear(words[2]);
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setDescription(String description) {
        EntryList entryList = new EntryList();
        this.description = description.isEmpty() ? description : entryList.upperCaseString(description);
    }
    
    public String getDescription() {
        return this.description;
    }
       
    public void setPositiveEntry(boolean positiveEntry) {
        this.positiveEntry = positiveEntry;
    }
    
    public void setValue(double value) {
        value = Float.parseFloat(Double.toString(value).trim());
        this.value = (getPositiveEntry()) ? value : -value;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public boolean getPositiveEntry() {
        return this.positiveEntry;
    }
    
    public void setDay(String day) {
        this.day = (day.length() == 1) ? "0" + day : day;
    }
    
    public String getDay() {
        return this.day;
    }
    
    public void setMonth(String month) {
        this.month = (month.length() == 1) ? "0" + month : month;
    }
    
    public String getMonth() {
        return this.month;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getYear() {
        return this.year;
    }
}
