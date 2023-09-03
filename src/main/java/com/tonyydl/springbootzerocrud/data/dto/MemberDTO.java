package com.tonyydl.springbootzerocrud.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long uuid;

    private String name;

    private Integer age;

    private Float height;
}
