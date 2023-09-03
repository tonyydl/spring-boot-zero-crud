package com.tonyydl.springbootzerocrud.service;

import com.tonyydl.springbootzerocrud.data.dto.MemberDTO;
import com.tonyydl.springbootzerocrud.data.po.MemberPO;
import com.tonyydl.springbootzerocrud.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDTO create(MemberDTO memberDTO) {
        return toDTO(memberRepository.save(toPO(memberDTO)));
    }

    public MemberDTO readByUuid(Long id) {
        return memberRepository
                .findById(id)
                .map(this::toDTO)
                .orElseThrow(RuntimeException::new);
    }

    public List<MemberDTO> readAllByAge(Integer age) {
        return memberRepository
                .findAllByAge(age)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // 查
    // 改
    // 存
    public MemberDTO updateHeightByUuid(Long uuid, Float height) {
        MemberPO memberPO = memberRepository.findById(uuid).orElseThrow(RuntimeException::new);
        memberPO.setHeight(height);
        return toDTO(memberRepository.save(memberPO));
    }

    public void deleteByUuid(Long id) {
        memberRepository.deleteById(id);
    }

    private MemberPO toPO(MemberDTO memberDTO) {
        return MemberPO
                .builder()
                .firstName(memberDTO.getName().split(",")[0].trim())
                .lastName(memberDTO.getName().split(",")[1].trim())
                .age(memberDTO.getAge())
                .height(memberDTO.getHeight())
                .build();
    }

    private MemberDTO toDTO(MemberPO memberPO) {
        return MemberDTO
                .builder()
                .uuid(memberPO.getUuid())
                .name(memberPO.getFirstName() + ", " + memberPO.getLastName())
                .age(memberPO.getAge())
                .height(memberPO.getHeight())
                .build();
    }
}
