package com.example.tebakangka

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * LOGIKA GAME TEBAK ANGKA
 *
 * Tampilan sudah jadi di activity_main.xml.
 * Tugas: isi semua TODO
 * dari atas ke bawah. Jangan ubah ID di file XML.
 *
 * Aturan game:
 * - Komputer menyimpan satu angka rahasia (acak 0 sampai 100).
 * - Skor awal 100. Setiap tebakan salah, skor berkurang 10.
 * - Tebakan benar = menang.
 * - Skor habis (0) = kalah.
 */
class MainActivity : AppCompatActivity() {

    private val skorAwal = 100
    private val skorBerkurangSetiapSalah = 10
    private val angkaTerkecil = 0
    private val angkaTerbesar = 100

    // Data game yang berubah selama permainan.
    private var angkaRahasia = 0
    private var skorSekarang = skorAwal

    // Komponen tampilan (disambungkan ke XML di onCreate di bawah).
    private lateinit var teksSkor: TextView
    private lateinit var teksPetunjuk: TextView
    private lateinit var kolomTebakan: EditText
    private lateinit var tombolTebak: Button
    private lateinit var tombolMainLagi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teksSkor = findViewById(R.id.tvSkor)
        teksPetunjuk = findViewById(R.id.tvPetunjuk)
        kolomTebakan = findViewById(R.id.etTebakan)
        tombolTebak = findViewById(R.id.btnTebak)
        tombolMainLagi = findViewById(R.id.btnMainLagi)

        // TODO 1: Saat tombolTebak diklik, jalankan fungsi prosesTebakan().
        // TODO 2: Saat tombolMainLagi diklik, jalankan fungsi mulaiGameBaru().
        // TODO 3: Jalankan mulaiGameBaru() sekali di sini supaya game langsung siap.
    }

    private fun mulaiGameBaru() {
        // TODO 4: Acak angkaRahasia antara angkaTerkecil sampai angkaTerbesar.
        //         Petunjuk: (angkaTerkecil..angkaTerbesar).random()
        // TODO 5: Kembalikan skorSekarang ke skorAwal, lalu tampilkan di teksSkor
        //         dengan format "Skor: 100".
        // TODO 6: Ubah teksPetunjuk jadi "Silakan mulai menebak!" dan kosongkan kolomTebakan.
        // TODO 7: Aktifkan kolomTebakan dan tombolTebak (isEnabled = true).
        // TODO 8: Sembunyikan tombolMainLagi (visibility = View.GONE).
    }

    private fun prosesTebakan() {
        // TODO 9: Ambil isi kolomTebakan lalu ubah jadi angka.
        //         Petunjuk: kolomTebakan.text.toString().toIntOrNull()
        //         (hasilnya null kalau kolom kosong)
        // TODO 10: CEK INPUT. Kalau kosong atau di luar angkaTerkecil..angkaTerbesar,
        //          tampilkan "Masukkan angka 0 sampai 100!" di teksPetunjuk lalu berhenti
        //          (return). Skor TIDAK boleh berkurang di kasus ini.
        // TODO 11: Kalau tebakan SAMA dengan angkaRahasia, pemain MENANG:
        //          tampilkan pesan menang beserta skor, lalu jalankan akhiriGame().
        // TODO 12: Kalau tebakan SALAH, kurangi skorSekarang sebanyak
        //          skorBerkurangSetiapSalah, lalu perbarui teksSkor.
        // TODO 13: Beri petunjuk di teksPetunjuk:
        //          "Terlalu besar!" kalau tebakan lebih besar dari angkaRahasia,
        //          "Terlalu kecil!" kalau lebih kecil.
        // TODO 14: Kalau skorSekarang sudah 0, pemain KALAH: tampilkan
        //          "Kalah! Angkanya adalah ..." (isi dengan angkaRahasia),
        //          lalu jalankan akhiriGame().
        // TODO 15: Kosongkan kolomTebakan setelah setiap tebakan.
    }

    private fun akhiriGame() {
        // TODO 16: Matikan kolomTebakan dan tombolTebak (isEnabled = false).
        // TODO 17: Munculkan tombolMainLagi (visibility = View.VISIBLE).
    }
}