package tubes.models;

import tubes.models.enums.JenisKelamin;

public class Admin extends User{
    private String adminID;
    
    public Admin(String adminID, String nik, String nama, String tempatLahir, String tanggalLahir, String password, JenisKelamin jenisKelamin) {
        super(nik, nama, tempatLahir, tanggalLahir, password, jenisKelamin);
        this.adminID = adminID;
    }

    public String getAdminID() {
        return this.adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    @Override
    public String toString() {
        return "Admin ID: " + this.adminID + "\n" +
               "Nama: " + this.getNama() + "\n" +
               "NIK: " + this.getNik() + "\n" +
               "Tempat, Tanggal Lahir: " + this.getTempatTanggalLahir() + "\n" +
               "Jenis Kelamin: " + this.getJenisKelamin();
    }

    // public String getNamaAdmin() {
    //     return super.getNama();
    // }
}
