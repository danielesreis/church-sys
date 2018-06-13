package javaapplication2.Classes;
import java.util.ArrayList;
import java.util.List;

public class MemberList implements Utilities{
    private List<Member> memberList;
    static int total;
    
    public MemberList() {
        List<Member> memberList = new ArrayList<Member>();
        setMemberList(memberList);
        setTotal(0);
    }
    
    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
    
    public List<Member> getMemberList() {
        return this.memberList;
    }
    
    public void setTotal(int total) {
        this.total = this.total + total;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void addMember(Member member){
        getMemberList().add(member);
        setTotal(1);
    }
    
    public void removeMember(int index) {
        getMemberList().remove(index);
        setTotal(-1);
    }
    
    public int getMemberListSize() {
        return getMemberList().size();
    }
    
    public Member getMemberByIndex(int index) {
        return getMemberList().get(index);
    }
    
    public void updateMember(int memberIndex, int attributeIndex, Object attributeValue) {
        Member member = getMemberList().get(memberIndex);
        switch(attributeIndex) {
            case 0: member.setName((String)attributeValue); break;
            case 1: member.setAddress((String)attributeValue); break;
            case 2: member.setNumber((String)attributeValue); break;
            case 3: member.setBirthDate((String)attributeValue); break;
            case 4: member.setRole((String)attributeValue); break;
            case 5: member.setRegister((String)attributeValue); break;
            default: /*throw smth*/
        }
    }
    
    public String upperCaseString(String str) {
        str = str.trim();
        String[] words = str.split("\\s+");
        char firstLetter;
        
        str = "";
        for(int i = 0; i < words.length; i++) {
            firstLetter = Character.toUpperCase(words[i].charAt(0));
            words[i] = firstLetter + words[i].substring(1);
            
            str = str + words[i];
            str = str + " ";
        }
        return str.substring(0, str.length()-1);
    }
    
    public Object[] getStringMember(int index) {
        Member member = getMemberByIndex(index);
        Object[] rowData = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), member.getRegister()};
        
        return rowData;
    }
    
    public Object[] getStringMember(Member member) {
        Object[] rowData = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), member.getRegister()};
        
        return rowData;
    }
    
    public List<Member> objectSearch (int attributeIndex, String searchString)
    {
        List<Member> searchList = new ArrayList<Member>();
        String attributeValue;
        
        for(int i=0; i<getMemberListSize(); i++) {
            Member member = getMemberByIndex(i);
            attributeValue = member.getAttribute(attributeIndex);
            attributeValue = attributeValue.toLowerCase();
                       
            if (attributeValue.contains(searchString.toLowerCase())) searchList.add(member);
        }
        return searchList;
    }  
}
