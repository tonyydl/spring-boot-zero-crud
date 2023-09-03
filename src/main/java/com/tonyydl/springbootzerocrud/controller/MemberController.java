package com.tonyydl.springbootzerocrud.controller;

import com.tonyydl.springbootzerocrud.data.dto.MemberDTO;
import com.tonyydl.springbootzerocrud.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<MemberDTO> create(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.create(memberDTO));
    }

    @GetMapping("/members/{uuid}")
    public ResponseEntity<MemberDTO> readByUuid(@PathVariable Long uuid) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.readByUuid(uuid));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> readAllByAge(@RequestParam Integer age) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.readAllByAge(age));
    }

    @PatchMapping("/members")
    public ResponseEntity<MemberDTO> update(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.updateHeightByUuid(memberDTO.getUuid(), memberDTO.getHeight()));
    }

    @DeleteMapping("/members/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable Long uuid) {
        memberService.deleteByUuid(uuid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
