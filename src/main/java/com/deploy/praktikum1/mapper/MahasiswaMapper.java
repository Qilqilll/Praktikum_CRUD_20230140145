package com.deploy.praktikum1.mapper;

import com.deploy.praktikum1.model.Mahasiswa;
import com.deploy.praktikum1.model.MahasiswaRequest;
import com.deploy.praktikum1.model.MahasiswaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MahasiswaMapper {

    MahasiswaResponse toResponse(Mahasiswa mahasiswa);

    Mahasiswa toEntity(MahasiswaRequest request);

    void updateEntity(MahasiswaRequest request, @MappingTarget Mahasiswa mahasiswa);
}
