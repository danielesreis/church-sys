package javaapplication2;

public class Member {
    private String name;
    private String address;
    private String number;
    private String birthDate;
    private String role;
    private String register;
    
    Member(String name, String address, String number, String birthDate, String role, String register) {
        setName(name);
        setAddress(address);
        setNumber(number);
        setBirthDate(birthDate);
        setRole(role);
        setRegister(register);
    }
    
    /*throw exception in case the string is empty or null*/
    void setName(String name) { 
        
        if(name.isEmpty() || name == null)
            System.out.println("error setName");
        
        this.name = upperCaseString(name);
    }
    
    String getName() {
        return this.name;
    }
    
    void setAddress(String address) {
        this.address = address;
    }
    
    String getAddress() {
        return this.address;
    }
    
    void setNumber(String number) {
        this.number = number;
    }
    
    String getNumber() {
        return this.number;
    }
    
    void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    String getBirthDate() {
        return this.birthDate;
    }
    
    /*throw exception*/
    void setRole(String role) {
        
        if(role.isEmpty() || role == null)
            System.out.println("error setRole");
        
        this.role = upperCaseString(role);
    }
    
    String getRole() {
        return this.role;
    }
    
    void setRegister(String register) {
        this.register = register;
    }
    
    String getregister() {
        return this.register;
    }
    
    String upperCaseString(String str) {
        
        String[] words = str.split("\\s+");
        
        str = "";
        for(int i = 0; i < words.length; i++) {
            char firstLetter = Character.toUpperCase(words[i].charAt(0));
            words[i] = firstLetter + words[i].substring(1);
            
            str = str + words[i];
            str = str + " ";
        }
        return str;
    }
}
