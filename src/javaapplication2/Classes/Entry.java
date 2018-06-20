package javaapplication2.Classes;

public class Entry {
    private String date;
    private int key;
    private int day;
    private int month;
    private int year;
    private double value;
    private String description;
    private boolean positiveEntry;
    
    public Entry(String date, int key, String description, boolean positiveEntry, double value) {	
        setDate(date);
        setKey(key);
        setDescription(description);
	setPositiveEntry(positiveEntry);
        setValue(value);
    }
    
    protected void setDate(String date) {
        String[] words = date.split("/");
        int day, month, year;
              
        words[0] = (words[0].length()==1) ? "0" + words[0] : words[0];
        words[1] = (words[1].length()==1) ? "0" + words[1] : words[1];
        
        this.date = words[0] + "/" + words[1] + "/" + words[2];
         
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
    
    private void setKey(int key) {
        this.key = key;
    }
    
    public int getKey() {
        return this.key;
    }
    
    protected void setDescription(String description) {
        this.description = description.isEmpty() ? description : Entry.upperCaseString(description);
    }
    
    public String getDescription() {
        return this.description;
    }
    
    protected void setValue(double value) {
        this.value = (this.getPositiveEntry()) ? value : -value;
    }
    
    public double getValue(boolean sign) {
        Double returnValue;
        
        returnValue = sign ? this.value : Math.abs(this.value);
        
        return returnValue;
    }
    
    protected void setPositiveEntry(boolean positiveEntry) {
        this.positiveEntry = positiveEntry;
    }
    
    public boolean getPositiveEntry() {
        return this.positiveEntry;
    }
    
    protected void setDay(int day) {
        this.day = day;
    }
    
    public int getDay() {
        return this.day;
    }
        
    protected void setMonth(int month) {
        this.month = month;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    protected void setYear(int year) {
        this.year = year;
    }
    
    public int getYear() {
        return this.year;
    }
    
    private static String upperCaseString(String str) {
        str = str.trim();
        char firstLetter = Character.toUpperCase(str.charAt(0));
        str = firstLetter + str.substring(1, str.length());
        return str;
    }
   
}
