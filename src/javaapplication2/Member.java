package javaapplication2;
import java.util.List;
import java.util.ArrayList;

public class Member {
    private String name;
    private String address;
    private String number;
    private String birthDate;
    private String role;
    private String register;
    private MemberList memberList = new MemberList();
    
    Member(String name, String address, String number, String birthDate, String role, String register) {
        setName(name);
        setAddress(address);
        setNumber(number);
        setBirthDate(birthDate);
        setRole(role);
        setRegister(register);
    }     
   
    public String getAttribute(int attributeIndex) {
        switch(attributeIndex) {
            case 0: return getName();
            case 1: return getAddress();
            case 2: return getNumber();
            case 3: return getBirthDate();
            case 4: return getRole();
            case 5: return getRegister();
        }
        return "";
    }
    
    void setName(String name) {
        this.name = name.isEmpty() ? name : memberList.upperCaseString(name);
    }
    
    String getName() {
        return this.name;
    }
    
    void setAddress(String address) {
        this.address = address.isEmpty() ? address : memberList.upperCaseString(address);
    }
    
    String getAddress() {
        return this.address;
    }
    
    void setNumber(String number) {
        this.number = number.isEmpty() ? number : memberList.upperCaseString(number);
    }
    
    String getNumber() {
        return this.number;
    }
    
    void setBirthDate(String birthDate) {
        birthDate = birthDate.replaceAll("\\s+", "");
        this.birthDate = birthDate.isEmpty() ? birthDate : memberList.upperCaseString(birthDate);
    }
    
    String getBirthDate() {
        return this.birthDate;
    }
    
    void setRole(String role) {
        this.role = role.isEmpty() ? role : memberList.upperCaseString(role);
    }
    
    String getRole() {
        return this.role;
    }
    
    void setRegister(String register) {
        this.register = register.isEmpty() ? register : memberList.upperCaseString(register);
    }
    
    String getRegister() {
        return this.register;
    }
}
