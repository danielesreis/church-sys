package javaapplication2;

public class Entry {
    private String date;
    private int day;
    private int month;
    private int year;
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
        String[] words = date.split("/");
        int day, month,  year;
        
        this.date = date;
              
        if(words[1].length()==1) {
            words[1] = "0" + words[1];
                
            if(words[0].length()==1) {
                words[0] = "0" + words[0];
            }
            this.date = words[0] + "/" + words[1] + "/" + words[2];
        } 
        day = Integer.parseInt(words[0]);
        month = Integer.parseInt(words[1]);
        year = Integer.parseInt(words[2]);
        
        setDay(day);
        setMonth(month);
        setYear(year);
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
    
    public void setValue(double value) {
        this.value = (getPositiveEntry()) ? value : -value;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void setPositiveEntry(boolean positiveEntry) {
        this.positiveEntry = positiveEntry;
    }
    
    public boolean getPositiveEntry() {
        return this.positiveEntry;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public int getDay() {
        return this.day;
    }
        
    public void setMonth(int month) {
        this.month = month;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public int getYear() {
        return this.year;
    }
}
