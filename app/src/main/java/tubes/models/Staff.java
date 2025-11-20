package tubes.models;

import tubes.models.enums.JenisKelamin;
import tubes.models.enums.Zone;

public class Staff extends User{
    private String staffID;
    private Zone zone;

    public Staff(String staffID, Zone zone, String nik, String nama, String tempatLahir, String tanggalLahir, String email, String password, JenisKelamin jenisKelamin) {
        super(nik, nama, tempatLahir, tanggalLahir, email, password, jenisKelamin);
        this.staffID = staffID;
        this.zone = zone;
    }

    public Zone getZone(){
        return this.zone;
    }

    public String getStaffID(){
        return this.staffID;
    }

    @Override
    public String toString() {
        return "Staff ID: " + this.staffID + "\n" +
               "Nama: " + this.getNama() + "\n" +
               "NIK: " + this.getNik() + "\n" +
               "Tempat, Tanggal Lahir: " + this.getTempatTanggalLahir() + "\n" +
               "Jenis Kelamin: " + this.getJenisKelamin() + "\n" +
               "Zone: " + this.zone;
    }
}
