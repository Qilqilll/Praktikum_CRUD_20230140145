package com.deploy.praktikum1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "NIM tidak boleh kosong")
    @Column(unique = true, nullable = false, length = 20)
    private String nim;

    @NotBlank(message = "Nama tidak boleh kosong")
    @Column(nullable = false, length = 100)
    private String nama;

    @NotBlank(message = "Jurusan tidak boleh kosong")
    @Column(nullable = false, length = 100)
    private String jurusan;

    @NotBlank(message = "Angkatan tidak boleh kosong")
    @Column(nullable = false, length = 4)
    private String angkatan;

    @NotNull(message = "IPK tidak boleh kosong")
    @Column(nullable = false)
    private Double ipk;
}
