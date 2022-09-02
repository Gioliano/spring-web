package br.edu.infnet.springweb.entity;

import lombok.Data;

@Data
public class Info {

    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
