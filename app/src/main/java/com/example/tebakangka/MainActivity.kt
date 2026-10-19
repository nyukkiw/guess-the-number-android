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

        // Saat tombolTebak diklik, jalankan fungsi prosesTebakan().
        tombolTebak.setOnClickListener {
            prosesTebakan()
        }

        // Saat tombolMainLagi diklik, jalankan fungsi mulaiGameBaru().
        tombolMainLagi.setOnClickListener {
            mulaiGameBaru()
        }

        // Jalankan mulaiGameBaru() sekali di sini supaya game langsung siap.
        mulaiGameBaru()
    }

    private fun mulaiGameBaru() {
        // Acak angkaRahasia antara angkaTerkecil sampai angkaTerbesar.
        // Petunjuk: (angkaTerkecil..angkaTerbesar).random()
        angkaRahasia = (angkaTerkecil..angkaTerbesar).random()

        // Kembalikan skorSekarang ke skorAwal, lalu tampilkan di teksSkor
        // dengan format "Skor: 100".
        skorSekarang = skorAwal
        teksSkor.text = "Skor: $skorSekarang"

        // Ubah teksPetunjuk jadi "Silakan mulai menebak!" dan kosongkan kolomTebakan.
        teksPetunjuk.text = "Silakan mulai menebak!"
        kolomTebakan.text.clear()

        // Aktifkan kolomTebakan dan tombolTebak (isEnabled = true).
        kolomTebakan.isEnabled = true
        tombolTebak.isEnabled = true

        // Sembunyikan tombolMainLagi (visibility = View.GONE).
        tombolMainLagi.visibility = View.GONE
    }

    private fun prosesTebakan() {
        // Ambil isi kolomTebakan lalu ubah jadi angka.
        // (hasilnya null kalau kolom kosong)
        val tebakan = kolomTebakan.text.toString().trim().toIntOrNull()

        // CEK INPUT. Kalau kosong atau di luar angkaTerkecil..angkaTerbesar,
        // tampilkan "Masukkan angka 0 sampai 100!" di teksPetunjuk lalu berhenti
        // (return). Skor TIDAK boleh berkurang di kasus ini.
        if (tebakan == null || tebakan !in angkaTerkecil..angkaTerbesar) {
            teksPetunjuk.text = "Masukkan angka 0 sampai 100!"
            return
        }

        // Kalau tebakan SAMA dengan angkaRahasia, pemain MENANG:
        // tampilkan pesan menang beserta skor, lalu jalankan akhiriGame().
        if (tebakan == angkaRahasia) {
            teksPetunjuk.text = "Tebakan benar! Skor: $skorSekarang"
            akhiriGame()
        } else {
            // Kalau tebakan SALAH, kurangi skorSekarang sebanyak
            // skorBerkurangSetiapSalah, lalu perbarui teksSkor.
            skorSekarang = maxOf(0, skorSekarang - skorBerkurangSetiapSalah)
            teksSkor.text = "Skor: $skorSekarang"

            // Beri petunjuk di teksPetunjuk:
            // "Terlalu besar!" kalau tebakan lebih besar dari angkaRahasia,
            // "Terlalu kecil!" kalau lebih kecil.
            if (tebakan > angkaRahasia) {
                teksPetunjuk.text = "Terlalu besar!"
            } else {
                teksPetunjuk.text = "Terlalu kecil!"
            }

            // Kalau skorSekarang sudah 0, pemain KALAH: tampilkan
            // "Kalah! Angkanya adalah ..." (isi dengan angkaRahasia),
            // lalu jalankan akhiriGame().
            if (skorSekarang <= 0) {
                teksPetunjuk.text = "Kalah! Angkanya adalah $angkaRahasia"
                akhiriGame()
            }
        }

        // Kosongkan kolomTebakan setelah setiap tebakan.
        kolomTebakan.text.clear()
    }

    private fun akhiriGame() {
        // Matikan kolomTebakan dan tombolTebak (isEnabled = false).
        kolomTebakan.isEnabled = false
        tombolTebak.isEnabled = false

        // Munculkan tombolMainLagi (visibility = View.VISIBLE).
        tombolMainLagi.visibility = View.VISIBLE
    }
}