package javaapplication2.Classes;
import java.util.ArrayList;
import java.util.List;

public class MemberList{
    private List<Member> memberList;
    static int total;
    
    public MemberList() {
        List<Member> memberList = new ArrayList<Member>();
        setMemberList(memberList);
        setTotal(0);
    }
    
    private void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
    
    public List<Member> getMemberList() {
        return this.memberList;
    }
    
    private void setTotal(int total) {
        this.total = total;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void addMember(Member member){
        getMemberList().add(member);
        incTotal(1);
    }
    
    public void removeMember(int index) {
        getMemberList().remove(index);
        incTotal(-1);
    }
    
    public int getMemberListSize() {
        return getMemberList().size();
    }
    
    public Member getMemberByIndex(int index) {
        return getMemberList().get(index);
    }
    
    private void incTotal(int qtd) {
        setTotal(getTotal()+qtd);
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
    
    public static String upperCaseString(String str) {
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
    
    /*public Object[] getStringMember(int index) {
        Member member = getMemberByIndex(index);
        Object[] rowData = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), member.getRegister()};
        
        return rowData;
    }*/
    
    public static Object[] getStringMember(Member member) {
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
