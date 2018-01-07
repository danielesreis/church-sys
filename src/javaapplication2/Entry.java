package javaapplication2;

public class Entry implements Utilities {
    private float value;
    private String description;
    private boolean operationType;
    private String day;
    private String month;
    private String year;
    
    Entry(float value, String description, boolean operationType, String day, String month, String year) {	
        setValue(value);
	setDescription(description);
	setOperationType(operationType);
	setDay(day);
	setMonth(month);
	setYear(year);
    }
    
    public void setValue(float value) {
        this.value = Float.parseFloat(Float.toString(value).trim());
    }
    
    public float getValue() {
        return this.value;
    }
    
    public void setDescription(String description) {
        this.description = description.isEmpty() ? description : upperCaseString(description);
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setOperationType(boolean operationType) {
        this.operationType = operationType;
    }
    
    public boolean getOperationType() {
        return this.operationType;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public String getDay() {
        return this.day;
    }
    
    public void setMonth(String month) {
        this.month = month;
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
    
    public String upperCaseString(String str) {
        str = str.trim();
        char firstLetter = Character.toUpperCase(str.charAt(0));
        str = firstLetter + str.substring(1, str.length());
        return str;
    }
}
