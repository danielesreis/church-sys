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
    
    public void removeMember(String reg) {
        int size = this.getMemberListSize();
        Member member;
                
        for(int i=0; i<size; i++) {
            member = getMemberList().get(i);
            if (member.getRegister().equals(reg)){
                getMemberList().remove(i);
                incTotal(-1);
                break;
            }
        }
    }
    
    public int getMemberListSize() {
        return getMemberList().size();
    }
    
    /*optimize this*/
    public Member getMemberByRegister(String register) {
        int size = this.getMemberListSize();
        Member member;
        
        for(int i=0; i<size; i++) {
            member = getMemberList().get(i);
            if (member.getRegister().equals(register)) return member;
        }
        return null;
    }
    
    public Member getMemberByIndex(int index) {
        return getMemberList().get(index);
    }
    
    private void incTotal(int qtd) {
        setTotal(getTotal()+qtd);
    }
    
    public void updateMember(String reg, int attributeIndex, Object attributeValue) {
        Member member = this.getMemberByRegister(reg);
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
    
    /*public Object[] getStringMember(int index) {
        Member member = getMemberByIndex(index);
        Object[] rowData = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), member.getRegister()};
        
        return rowData;
    }*/
    
    public static Object[] getStringMember(Member member) {
        Object[] rowData = {member.getName(), member.getAddress(), member.getNumber(), member.getBirthDate(), member.getRole(), member.getRegister()};
        
        return rowData;
    }
    
    /*exceptions...*/
    public List<Member> objectSearch (int attributeIndex, String searchString)
    {
        List<Member> searchList = new ArrayList<Member>();
        String attributeValue;
        
        for(int i=0; i<getMemberListSize(); i++) {
            Member member = this.getMemberList().get(i);
            attributeValue = member.getAttribute(attributeIndex);
            attributeValue = attributeValue.toLowerCase();
                       
            if (attributeValue.contains(searchString.toLowerCase())) searchList.add(member);
        }
        return searchList;
    }  
}
