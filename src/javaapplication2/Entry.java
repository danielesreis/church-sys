package javaapplication2;

public class Entry {
    private float value;
    private String description;
    private boolean positiveEntry;
    private String day;
    private String month;
    private String year;
    
    Entry(String day, String month, String year, String description, float value, boolean positiveEntry) {	
        setDay(day);
	setMonth(month);
	setYear(year);
        setDescription(description);
        setValue(value);
	setPositiveEntry(positiveEntry);
    }
    
    public void setValue(float value) {
        this.value = Float.parseFloat(Float.toString(value).trim());
    }
    
    public float getValue() {
        return this.value;
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
    
    public boolean getPositiveEntry() {
        return this.positiveEntry;
    }
    
    public void setDay(String day) {
        day = day.trim();
        this.day = (day.length() == 1) ? "0" + day : day;
    }
    
    public String getDay() {
        return this.day;
    }
    
    public void setMonth(String month) {
        month = month.trim();
        this.month = (month.length() == 1) ? "0" + month : month;
    }
    
    public String getMonth() {
        return this.month;
    }
    
    public void setYear(String year) {
        this.year = year.trim();
    }
    
    public String getYear() {
        return this.year;
    }
}
