package com.deploy.praktikum1.model;

import lombok.Data;

@Data
public class MahasiswaResponse {
    private Long id;
    private String nim;
    private String nama;
    private String jurusan;
    private String angkatan;
    private Double ipk;
}
