package org.example.Entity;

public class Siswa {
    private Integer id;
    private Integer nim;
    private String nama;
    private String alamat;

    public Siswa() {
    }

    public Siswa(Integer nim, String nama, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
    }

    public Siswa(Integer id, Integer nim, String nama, String alamat) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
