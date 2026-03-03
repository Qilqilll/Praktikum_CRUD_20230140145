package com.deploy.praktikum1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MahasiswaRequest {

    @NotBlank(message = "NIM tidak boleh kosong")
    private String nim;

    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @NotBlank(message = "Jurusan tidak boleh kosong")
    private String jurusan;

    @NotBlank(message = "Angkatan tidak boleh kosong")
    private String angkatan;

    @NotNull(message = "IPK tidak boleh kosong")
    private Double ipk;
}
