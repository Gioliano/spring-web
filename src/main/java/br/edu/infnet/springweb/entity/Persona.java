package br.edu.infnet.springweb.entity;

import lombok.Data;

import java.util.List;

@Data
public class Persona {

    Info info;
    List<Result> results;
}
