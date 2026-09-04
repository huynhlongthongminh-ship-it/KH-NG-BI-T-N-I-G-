/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ThucUong;
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
public class ThucUongRepository {

    public List<ThucUong> getAll() {
        List<ThucUong> list = new ArrayList<>();
        String sql = "SELECT matu, tengoi, giatien, ghichu " + "FROM Thucuong";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int matu = rs.getInt("matu");
                String tengoi = rs.getString("tengoi");
                double giatien = rs.getDouble("giatien");
                String ghichu = rs.getString("ghichu");
                ThucUong tc = new ThucUong(matu, tengoi, giatien, ghichu);
                list.add(tc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

public boolean insert(ThucUong tc) {
    String sql = "INSERT INTO Thucuong (tengoi, giatien, ghichu) "
               + "VALUES (?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, tc.getTenGoi());
        pstmt.setDouble(2, tc.getGia());
        pstmt.setString(3, tc.getGhiChu());

        int result = pstmt.executeUpdate();

        return result > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


public boolean update(ThucUong tc) {
    String sql = "UPDATE thucuong SET "
               + "tengoi = ?, giatien = ?, ghichu = ? "
               + "WHERE matu = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, tc.getTenGoi());
        pstmt.setDouble(2, tc.getGia());
        pstmt.setString(3, tc.getGhiChu());
        pstmt.setInt(4, (int) tc.getMaTu());

        int result = pstmt.executeUpdate();

        return result > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
public boolean delete(double maTu) {

    String sql = "DELETE FROM thucuong WHERE matu = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setDouble(1, maTu);

        int result = pstmt.executeUpdate();

        return result > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
