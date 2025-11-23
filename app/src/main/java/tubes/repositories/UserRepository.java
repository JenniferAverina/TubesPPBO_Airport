package tubes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<User> getUser() {
        String sql = "SELECT u.*, a.adminID FROM users u INNER JOIN admin a ON u.userID = a.userID";
        List<User> users = new ArrayList<>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JenisKelamin jenisKelamin = rs.getString("jenisKelamin").equalsIgnoreCase("PRIA") ? JenisKelamin.PRIA : JenisKelamin.WANITA;
                users.add(new Admin(rs.getString("adminID"), rs.getString("nik"), rs.getString("nama"), rs.getString("tempatLahir"), rs.getString("tanggalLahir"), rs.getString("email"), rs.getString("passwords"), jenisKelamin));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
