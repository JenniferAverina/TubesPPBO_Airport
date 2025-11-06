package tubes.models;

import tubes.models.enums.JenisKelamin;

public abstract class User {
    private String nik;
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private String password;
    private JenisKelamin jenisKelamin;

    public User(String nik, String nama, String tempatLahir, String tanggalLahir, String password, JenisKelamin jenisKelamin) {
        this.nik = nik;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNik() {
        return this.nik;
    }

    public String getNama() {
        return this.nama;
    }

    public String getTempatLahir() {
        return this.tempatLahir;
    }

    public String getTanggalLahir() {
        return this.tanggalLahir;
    }

    public String getTempatTanggalLahir() {
        return this.tempatLahir + ", " + this.tanggalLahir;
    }

    public String getPassword() {
        return this.password;
    }

    public JenisKelamin getJenisKelamin() {
        return this.jenisKelamin;
    }

    public abstract String toString();
}
