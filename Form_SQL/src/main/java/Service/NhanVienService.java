/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.NhanVien;
import Repository.NhanVienRepository;
import java.util.List;
/**
 *
 * @author VY KHANG
 */
public class NhanVienService {
    public final NhanVienRepository repository;

    public NhanVienService() {
        this.repository = new NhanVienRepository();   
    }
    
    public List<NhanVien> getAllNhanVien() {
        return repository.getAll();
    }

public boolean addNhanVien(String hoten, String quequan, String luongStr, String namsinhStr) {

    if (hoten == null || hoten.trim().isEmpty()) {
        throw new IllegalArgumentException("Họ tên không được để trống!");
    }

    if (quequan == null || quequan.trim().isEmpty()) {
        throw new IllegalArgumentException("Quê quán không được để trống!");
    }

    // Kiểm tra lương
    int luong;
    try {
        luong = Integer.parseInt(luongStr);

        if (luong < 0) {
            throw new IllegalArgumentException("Lương không được nhỏ hơn 0!");
        }

    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Lương phải là một số hợp lệ!");
    }

    // Kiểm tra năm sinh
    if (namsinhStr == null || namsinhStr.trim().isEmpty()) {
        throw new IllegalArgumentException("Năm sinh không được để trống!");
    }

    String namSinhNV = namsinhStr.trim();

    int namSinh;

    try {
        namSinh = Integer.parseInt(namSinhNV);

    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Năm sinh phải là một số hợp lệ!");
    }

    // Kiểm tra năm sinh không được âm
    if (namSinh < 0) {
        throw new IllegalArgumentException("Năm sinh không được nhỏ hơn 0!");
    }

    // Lấy năm hiện tại
    int namHienTai = java.time.Year.now().getValue();

    // Tính tuổi
    int tuoi = namHienTai - namSinh;

    // Kiểm tra tuổi lao động
    if (tuoi < 18) {
        throw new IllegalArgumentException(
            "Nhân viên chưa đủ tuổi lao động! Tuổi hiện tại: " + tuoi
        );
    }

    if (tuoi > 60) {
        throw new IllegalArgumentException(
            "Nhân viên đã quá tuổi lao động! Tuổi hiện tại: " + tuoi
        );
    }

    // Tạo nhân viên
    NhanVien nv = new NhanVien(
        hoten.trim(),
        quequan.trim(),
        luong,
        namSinhNV
    );

    return repository.insert(nv);
}
}