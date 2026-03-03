package com.deploy.praktikum1.controller;

import com.deploy.praktikum1.model.MahasiswaRequest;
import com.deploy.praktikum1.model.MahasiswaResponse;
import com.deploy.praktikum1.service.MahasiswaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
@RequiredArgsConstructor
public class MahasiswaController {

    private final MahasiswaService mahasiswaService;

    @GetMapping
    public ResponseEntity<List<MahasiswaResponse>> getSemuaMahasiswa() {
        return ResponseEntity.ok(mahasiswaService.getSemuaMahasiswa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MahasiswaResponse> getMahasiswaById(@PathVariable Long id) {
        return ResponseEntity.ok(mahasiswaService.getMahasiswaById(id));
    }

    @PostMapping
    public ResponseEntity<MahasiswaResponse> tambahMahasiswa(
            @Valid @RequestBody MahasiswaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mahasiswaService.tambahMahasiswa(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MahasiswaResponse> ubahMahasiswa(
            @PathVariable Long id,
            @Valid @RequestBody MahasiswaRequest request) {
        return ResponseEntity.ok(mahasiswaService.ubahMahasiswa(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusMahasiswa(@PathVariable Long id) {
        mahasiswaService.hapusMahasiswa(id);
        return ResponseEntity.noContent().build();
    }
}
