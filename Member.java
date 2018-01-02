package javaapplication2;

public class Member {
    private String name;
    private String address;
    private String number;
    private String birthDate;
    private String role;
    private int id;
    
    Member(String name) {
        setName(name);
    }
            
    void setName(String name) { 
        this.name = name.toUpperCase();
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
    
    void setRole(String role) {
        this.role = role;
    }
    
    String getRole() {
        return this.role;
    }
    
    void setId(int id) {
        this.id = id;
    }
    
    int getId() {
        return this.id;
    }
}
