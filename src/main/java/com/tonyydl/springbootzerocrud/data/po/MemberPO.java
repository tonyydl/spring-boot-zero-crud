package com.tonyydl.springbootzerocrud.data.po;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class MemberPO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8245082464066786446L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;

    private String name;

    private String firstName;

    private String lastName;

    private Integer age;

    private Float height;
}
