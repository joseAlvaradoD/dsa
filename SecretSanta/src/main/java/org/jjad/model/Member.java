package org.jjad.model;

import lombok.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {
    private int id;
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Member> immediateFamily;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Map<Integer, Member> familyThatReceivedGift;

    public void addDirectFamily(Member member){
        if(immediateFamily == null) {
            immediateFamily = new HashSet<>();
        }
        immediateFamily.add(member);
    }

    public void removeFamilyFromYear(Integer year){
        if(familyThatReceivedGift == null || familyThatReceivedGift.isEmpty()){
            return;
        }
        familyThatReceivedGift.remove(year);
    }

    public Member getFamilyFromYear(Integer year){
        if(familyThatReceivedGift == null || familyThatReceivedGift.isEmpty()){
            return new Member();
        }

        return familyThatReceivedGift.getOrDefault(year, new Member());
    }
}
