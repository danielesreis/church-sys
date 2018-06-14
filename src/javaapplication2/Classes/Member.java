package javaapplication2.Classes;
import java.util.List;
import java.util.ArrayList;

public class Member {
    private String name;
    private String address;
    private String number;
    private String birthDate;
    private String role;
    private String register;
    //private MemberList memberList = new MemberList();
    
    public Member(String name, String address, String number, String birthDate, String role, String register) {
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
    
    protected void setName(String name) {
        this.name = name.isEmpty() ? name : MemberList.upperCaseString(name);
    }
    
    public String getName() {
        return this.name;
    }
    
    protected void setAddress(String address) {
        this.address = address.isEmpty() ? address : MemberList.upperCaseString(address);
    }
    
    public String getAddress() {
        return this.address;
    }
    
    protected void setNumber(String number) {
        this.number = number.isEmpty() ? number : MemberList.upperCaseString(number);
    }
    
    public String getNumber() {
        return this.number;
    }
    
    protected void setBirthDate(String birthDate) {
        birthDate = birthDate.replaceAll("\\s+", "");
        this.birthDate = birthDate.isEmpty() ? birthDate : MemberList.upperCaseString(birthDate);
    }
    
    public String getBirthDate() {
        return this.birthDate;
    }
    
    protected void setRole(String role) {
        this.role = role.isEmpty() ? role : MemberList.upperCaseString(role);
    }
    
    public String getRole() {
        return this.role;
    }
    
    protected void setRegister(String register) {
        this.register = register.isEmpty() ? register : MemberList.upperCaseString(register);
    }
    
    public String getRegister() {
        return this.register;
    }
}
