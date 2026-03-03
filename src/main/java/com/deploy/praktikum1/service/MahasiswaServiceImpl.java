package com.deploy.praktikum1.service;

import com.deploy.praktikum1.mapper.MahasiswaMapper;
import com.deploy.praktikum1.model.Mahasiswa;
import com.deploy.praktikum1.model.MahasiswaRequest;
import com.deploy.praktikum1.model.MahasiswaResponse;
import com.deploy.praktikum1.repository.MahasiswaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MahasiswaServiceImpl implements MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;
    private final MahasiswaMapper mahasiswaMapper;

    @Override
    public List<MahasiswaResponse> getSemuaMahasiswa() {
        return mahasiswaRepository.findAll()
                .stream()
                .map(mahasiswaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MahasiswaResponse getMahasiswaById(Long id) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Mahasiswa dengan id " + id + " tidak ditemukan"));
        return mahasiswaMapper.toResponse(mahasiswa);
    }

    @Override
    public MahasiswaResponse tambahMahasiswa(MahasiswaRequest request) {
        if (mahasiswaRepository.existsByNim(request.getNim())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "NIM " + request.getNim() + " sudah digunakan");
        }
        Mahasiswa mahasiswa = mahasiswaMapper.toEntity(request);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswaMapper.toResponse(mahasiswa);
    }

    @Override
    public MahasiswaResponse ubahMahasiswa(Long id, MahasiswaRequest request) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Mahasiswa dengan id " + id + " tidak ditemukan"));
        mahasiswaMapper.updateEntity(request, mahasiswa);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswaMapper.toResponse(mahasiswa);
    }

    @Override
    public void hapusMahasiswa(Long id) {
        if (!mahasiswaRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Mahasiswa dengan id " + id + " tidak ditemukan");
        }
        mahasiswaRepository.deleteById(id);
    }
}
