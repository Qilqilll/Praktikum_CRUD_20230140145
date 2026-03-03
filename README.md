# Praktikum CRUD - Spring Boot REST API

Proyek ini merupakan implementasi aplikasi CRUD (Create, Read, Update, Delete) menggunakan Spring Boot untuk manajemen data Mahasiswa.

## Informasi Mahasiswa

- **Nama**: Muhammad Maulana Zhafran Qilqil
- **NIM**: 20230140145
- **Mata Kuliah**: Deployment Aplikasi

## Teknologi yang Digunakan

| Teknologi | Versi |
|-----------|-------|
| Java | 21 |
| Spring Boot | 3.4.3 |
| Spring Data JPA | - |
| MySQL | 8.x |
| Lombok | - |
| MapStruct | 1.5.5 |
| Maven | - |

## Endpoint API

| Method | URL | Keterangan |
|--------|-----|------------|
| GET | `/api/mahasiswa` | Ambil semua data mahasiswa |
| GET | `/api/mahasiswa/{id}` | Ambil mahasiswa berdasarkan ID |
| POST | `/api/mahasiswa` | Tambah mahasiswa baru |
| PUT | `/api/mahasiswa/{id}` | Ubah data mahasiswa |
| DELETE | `/api/mahasiswa/{id}` | Hapus mahasiswa |

## Cara Menjalankan

### Prasyarat
- Java 21 terinstall
- MySQL berjalan di port 3309
- Database `spring` sudah dibuat

### Konfigurasi `.env`
Buat file `.env` di root project dengan isi:
```
DATABASE_URL=jdbc:mysql://localhost:3309/spring?createDatabaseIfNotExist=true
DATABASE_USERNAME=root
DATABASE_PASSWORD=password_anda
```

### Menjalankan Aplikasi
```bash
./mvnw spring-boot:run
```

Aplikasi akan berjalan di `http://localhost:8080`

## Contoh Request

### Tambah Mahasiswa (POST)
```json
{
  "nim": "20230140145",
  "nama": "Muhammad Maulana Zhafran Qilqil",
  "jurusan": "Informatika",
  "angkatan": "2023",
  "ipk": 3.85
}
```
