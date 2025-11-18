package tubes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tubes.database.Database;
import tubes.models.Admin;
import tubes.models.User;
import tubes.models.enums.JenisKelamin;

public class UserRepository {
    private static final Connection conn;
    
    static{
        conn = Database.connect();
    }

    // Login
    public User getUserLogin(String adminID, String password) {
        String sql = "SELECT u.*, a.adminID FROM users u INNER JOIN admin a ON u.userID = a.userID WHERE a.adminID = ? AND u.passwords = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminID);
            pstmt.setString(1, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                JenisKelamin jenisKelamin = rs.getString("jenisKelamin").equalsIgnoreCase("PRIA") ? JenisKelamin.PRIA : JenisKelamin.WANITA;
                return new Admin(rs.getString("adminID"), rs.getString("nik"), rs.getString("nama"), rs.getString("tempatLahir"), rs.getString("tanggalLahir"), rs.getString("passwords"), jenisKelamin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
