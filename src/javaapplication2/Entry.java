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
        this.date = date;
        
        String[] words = date.split("/");
        String day, month, year;
        
        if(words.length == 1)
        {
            day = month = "00";
            year = words[0];
        }
        else if (words.length == 2)
        {
            day = "00";
            month = words[0];
            year = words[1];
        }
        else
        {
            day = words[0];
            month = words[1];
            year = words[2];
        }
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
