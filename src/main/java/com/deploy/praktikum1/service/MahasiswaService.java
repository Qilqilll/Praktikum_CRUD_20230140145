package com.deploy.praktikum1.service;

import com.deploy.praktikum1.model.MahasiswaRequest;
import com.deploy.praktikum1.model.MahasiswaResponse;

import java.util.List;

public interface MahasiswaService {
    List<MahasiswaResponse> getSemuaMahasiswa();
    MahasiswaResponse getMahasiswaById(Long id);
    MahasiswaResponse tambahMahasiswa(MahasiswaRequest request);
    MahasiswaResponse ubahMahasiswa(Long id, MahasiswaRequest request);
    void hapusMahasiswa(Long id);
}
