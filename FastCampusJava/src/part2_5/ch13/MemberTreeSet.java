package part2_5.ch13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {

    private TreeSet<Member> treeSet;

    // Comparator일 경우 구현된 객체를 지정
    // Comparable일 경우 객체 지정 X
    public MemberTreeSet(){
        treeSet = new TreeSet<Member>(new Member());
    }

    public void addMember(Member member){
        treeSet.add(member);
    }

    // 멤버 아이디를 매개변수로, 삭제 여부를 반환
    public boolean removeMember(int memberId){

        Iterator<Member> ir = treeSet.iterator();

        while(ir.hasNext()){

            Member member = ir.next();
            int tempId = member.getMemberId();
            if(tempId == memberId){
                treeSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;

    }

    public void showAllMember(){
        for (Member member : treeSet){
            System.out.println(member);
        }
        System.out.println();
    }

}
