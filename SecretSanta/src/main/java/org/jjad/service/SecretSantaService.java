package org.jjad.service;

import org.jjad.model.Member;

import java.util.*;
import java.util.stream.Stream;

public class SecretSantaService {

    private List<Member> family;
    private List<Member> familyGotSecretSantaToGift = new ArrayList<>();

    Member juan = Member.builder().id(1).name("Juan").build();
    Member nena = Member.builder().id(2).name("Nena").build();
    Member hugo = Member.builder().id(3).name("Hugo").build();
    Member adriana = Member.builder().id(4).name("Adriana").build();
    Member santi = Member.builder().id(5).name("Santi").build();
    Member huguito = Member.builder().id(6).name("Huguito").build();
    Member jose = Member.builder().id(7).name("Jose").build();
    Member lore = Member.builder().id(8).name("Lore").build();
    Member nene = Member.builder().id(9).name("Nene").build();
    Member paola = Member.builder().id(10).name("Paola").build();
    Member juanito = Member.builder().id(11).name("Juanito").build();
    Member samara = Member.builder().id(12).name("Samara").build();
    Member lulu = Member.builder().id(13).name("Lulu").build();
    Member chapo = Member.builder().id(14).name("Chapo").build();
    Member helen = Member.builder().id(15).name("Helen").build();
    Member luci = Member.builder().id(16).name("Luci").build();
    Member mia = Member.builder().id(17).name("Mia").build();

    private Member initial = jose;

    public static void main(String args[]){
        SecretSantaService service = new SecretSantaService();

        service.initFamily();
        Member initial = service.initial;
        while (service.family.size() > 0){
            Member selected = service.getFamilyToGiveGift(initial);
            System.out.println(initial + ": " + selected);
            initial = selected;
        }
    }

    public Member getFamilyToGiveGift(Member member){
        Stream<Member> stream = family.stream()
            .filter(m -> !m.equals(member))
            .filter(m -> !member.getImmediateFamily().contains(m))
            .filter(m -> !member.getFamilyFromYear(
                    Calendar.getInstance().get(Calendar.YEAR) - 3).equals(m))
            ;

        familyGotSecretSantaToGift.add(member);

        Optional<Member> selected = stream
                .filter(m -> ! familyGotSecretSantaToGift.contains(m))
                .findAny();

        if(selected.isEmpty()){
            selected = Optional.of(
                        family
                        .stream()
                        .filter(m -> !initial.equals(m))
                        .findAny()
                    .orElse(initial));
        }

        family.remove(selected.get());

        return selected.get();
    }

    void initFamily(){
        family = new ArrayList<>();


        juan.addDirectFamily(nena);
        juan.addDirectFamily(hugo);
        juan.addDirectFamily(jose);
        juan.addDirectFamily(nene);
        juan.addDirectFamily(lulu);
        nena.addDirectFamily(juan);
        nena.addDirectFamily(hugo);
        nena.addDirectFamily(jose);
        nena.addDirectFamily(nene);
        nena.addDirectFamily(lulu);

        hugo.addDirectFamily(juan);
        hugo.addDirectFamily(nena);
        hugo.addDirectFamily(adriana);
        hugo.addDirectFamily(santi);
        hugo.addDirectFamily(huguito);
        hugo.addDirectFamily(jose);
        hugo.addDirectFamily(nene);
        hugo.addDirectFamily(lulu);
        adriana.addDirectFamily(hugo);
        adriana.addDirectFamily(santi);
        adriana.addDirectFamily(huguito);
        santi.addDirectFamily(hugo);
        santi.addDirectFamily(adriana);
        santi.addDirectFamily(huguito);
        huguito.addDirectFamily(hugo);
        huguito.addDirectFamily(adriana);
        huguito.addDirectFamily(santi);

        jose.addDirectFamily(juan);
        jose.addDirectFamily(nena);
        jose.addDirectFamily(lore);
        jose.addDirectFamily(hugo);
        jose.addDirectFamily(nene);
        jose.addDirectFamily(lulu);
        lore.addDirectFamily(jose);

        nene.addDirectFamily(juan);
        nene.addDirectFamily(nena);
        nene.addDirectFamily(paola);
        nene.addDirectFamily(juanito);
        nene.addDirectFamily(samara);
        nene.addDirectFamily(hugo);
        nene.addDirectFamily(jose);
        nene.addDirectFamily(lulu);
        paola.addDirectFamily(nene);
        paola.addDirectFamily(juanito);
        paola.addDirectFamily(samara);
        juanito.addDirectFamily(nene);
        juanito.addDirectFamily(paola);
        juanito.addDirectFamily(samara);
        samara.addDirectFamily(nene);
        samara.addDirectFamily(paola);
        samara.addDirectFamily(juanito);

        lulu.addDirectFamily(juan);
        lulu.addDirectFamily(nena);
        lulu.addDirectFamily(chapo);
        lulu.addDirectFamily(hugo);
        lulu.addDirectFamily(jose);
        lulu.addDirectFamily(nene);
        lulu.addDirectFamily(helen);
        lulu.addDirectFamily(luci);
        lulu.addDirectFamily(mia);
        chapo.addDirectFamily(lulu);
        chapo.addDirectFamily(helen);
        chapo.addDirectFamily(luci);
        chapo.addDirectFamily(mia);
        helen.addDirectFamily(lulu);
        helen.addDirectFamily(chapo);
        helen.addDirectFamily(luci);
        helen.addDirectFamily(mia);
        luci.addDirectFamily(lulu);
        luci.addDirectFamily(chapo);
        luci.addDirectFamily(helen);
        luci.addDirectFamily(mia);
        mia.addDirectFamily(lulu);
        mia.addDirectFamily(chapo);
        mia.addDirectFamily(helen);
        mia.addDirectFamily(luci);

        family.add(juan);
        family.add(nena);
        family.add(hugo);
        family.add(adriana);
        family.add(santi);
        family.add(huguito);
        family.add(jose);
        family.add(lore);
        family.add(nene);
        family.add(paola);
        family.add(juanito);
        family.add(samara);
        family.add(lulu);
        family.add(chapo);
        family.add(helen);
        family.add(luci);
        family.add(mia);


    }
}
