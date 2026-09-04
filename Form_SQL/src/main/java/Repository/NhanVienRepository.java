/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT manv, hoten, quequan, luong, namsinh " + "FROM NhanVien";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int manv = rs.getInt("manv");
                String hoten = rs.getString("hoten");
                String quequan = rs.getString("quequan");
                double luong = rs.getDouble("luong");
                String namsinh = rs.getString("namsinh");
                NhanVien tc = new NhanVien(manv, hoten, quequan, luong, namsinh);
                list.add(tc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    } 

public boolean insert(NhanVien tc) {
    String sql = "INSERT INTO NhanVien (hoten, quequan, luong, namsinh) "
               + "VALUES (?, ?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, tc.getHotenNv());
        pstmt.setString(2, tc.getQueQuanNV());
        pstmt.setDouble(3, tc.getLuongNV());
        pstmt.setString(4, tc.getNamSinhNV());

        int result = pstmt.executeUpdate();

        return result > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
