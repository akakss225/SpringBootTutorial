package com.example.hellospring.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity // jpa가 관리한다는 것을 의미
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB 에서 pk를 알아서 생성해주는것을 의미
    private Long id;

    private String name;

}
