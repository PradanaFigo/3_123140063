# My Profile App

Tugas Praktikum Pertemuan 3 — Compose Multiplatform Basics  
**IF25-22017 Pengembangan Aplikasi Mobile**  
Program Studi Teknik Informatika · Institut Teknologi Sumatera

---

## Deskripsi

My Profile App adalah aplikasi multiplatform yang dibangun menggunakan **Kotlin** dan **Compose Multiplatform**. Aplikasi ini menampilkan halaman profil pengguna dengan header bergaya abu-abu elegan, informasi kontak, dan daftar keahlian.

---

## Screenshot

| Desktop |
|---------|
| <img width="868" height="988" alt="image" src="https://github.com/user-attachments/assets/f3c157a1-5707-4327-8830-ef2d15599ffe" />|

---

## Fitur

- Header profil dengan foto circular dan nama
- Bio / deskripsi singkat pengguna
- Statistik: jumlah proyek, IPK, dan semester
- Tombol Follow dengan state toggle
- List informasi kontak: Email, Telepon, Lokasi, Website/GitHub
- List keahlian dengan ikon berwarna
- Scrollable layout untuk semua platform

---

## Struktur Composable Functions

| Composable | Deskripsi |
|---|---|
| `ProfileHeader` | Header abu-abu dengan foto profil circular, nama, title, dan bio |
| `StatItem` | Kartu angka statistik yang dapat digunakan ulang |
| `InfoItem` | Satu baris informasi: icon + label + value — dipakai di kontak & keahlian |
| `ProfileCard` | Container card dengan judul seksi — dipakai untuk Kontak dan Keahlian |
| `ProfileScreen` | Halaman utama yang menyatukan semua composable |

---

## Komponen UI yang Digunakan

| Komponen | Digunakan di |
|---|---|
| `Column` | ProfileHeader, ProfileCard, InfoItem, ProfileScreen, StatItem |
| `Row` | InfoItem, baris tombol Follow, baris statistik |
| `Box` | Avatar circular, icon circle, latar header |
| `Card` | ProfileCard, stats card |
| `Text` | Nama, title, bio, label, value, statistik |
| `Button` | Tombol Follow / Following (dengan state toggle) |
| `Icon` | Avatar Person, icon Email / Phone / Location / dll |

---

## Teknologi

- **Kotlin** — bahasa pemrograman utama
- **Compose Multiplatform** — UI framework deklaratif (JetBrains)
- **Material 3** — komponen UI dan tema
- **Material Icons Extended** — library ikon

---

## Cara Menjalankan

### Desktop (JVM)

```bash
./gradlew :composeApp:run
```

### Android

1. Buka project di Android Studio
2. Pilih target **composeApp**
3. Jalankan di emulator atau perangkat fisik

---

## Dependency Tambahan

Tambahkan baris berikut di `composeApp/build.gradle.kts` pada blok `commonMain.dependencies`:

```kotlin
implementation(compose.materialIconsExtended)
```

## Struktur File

```
composeApp/
└── src/
    └── commonMain/
        └── kotlin/
            └── org/example/project/
                ├── App.kt            ← entry point, memanggil ProfileScreen()
                └── ProfileScreen.kt  ← semua composable dan logika UI
```

---

## Penulis

| |                              |
|---|------------------------------|
| **Nama** | Pradana Figo Ariasya         |
| **NIM** | 123140063                    |
| **Kelas** | Pengembangan Aplikasi Mobile RB|
| **Institusi** | Institut Teknologi Sumatera  |

---

*Tugas Praktikum 3 · Tahun Akademik Genap 2025/2026*
