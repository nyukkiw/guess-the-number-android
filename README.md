# Tebak Angka (Android)

Tugas UTS: aplikasi game tebak angka di Android (Kotlin + XML).

## Deskripsi
Aplikasi menyimpan angka rahasia acak 0 sampai 100 selama game berjalan. Pemain menebak angka tersebut. Skor awal 100 dan berkurang 10 setiap tebakan salah. Skor 0 berarti kalah.

## Aturan Game
1. Angka rahasia diacak 0 sampai 100 saat game dimulai.
2. Skor awal 100.
3. Tebakan salah: skor dikurangi 10, muncul petunjuk "terlalu besar" atau "terlalu kecil".
4. Tebakan benar: pemain menang.
5. Skor 0: pemain kalah dan angka rahasia ditampilkan.
6. Input kosong atau di luar 0 sampai 100 ditolak tanpa mengurangi skor.
7. Tombol "Main Lagi" muncul setelah game selesai.

## Tabel ID View
| ID | Jenis | Fungsi |
|---|---|---|
| `tvJudul` | TextView | Judul aplikasi |
| `tvAturan` | TextView | Penjelasan singkat aturan |
| `tvSkor` | TextView | Menampilkan skor, format `Skor: 100` |
| `etTebakan` | EditText | Input angka tebakan |
| `btnTebak` | Button | Memproses tebakan |
| `tvPetunjuk` | TextView | Pesan petunjuk, menang, kalah, atau error input |
| `btnMainLagi` | Button | Mengulang game (awalnya tersembunyi) |

## Alur Logika
```
mulaiGameBaru -> acak angka rahasia, skor = 100
prosesTebakan:
  input tidak valid -> pesan error, skor tetap
  tebakan == angka rahasia -> menang -> akhiriGame
  tebakan != angka rahasia -> skor -= 10, beri petunjuk
      skor == 0 -> kalah -> akhiriGame
akhiriGame -> nonaktifkan input, tampilkan "Main Lagi"
```

## Pembagian Tugas
| Anggota                       | Bagian |
|-------------------------------|---|
| Valentino Banyu Ampar Paraya  | Tampilan (`activity_main.xml`), README, pengujian |
| Gerardo Mayella               | Logika (`MainActivity.kt`) |

