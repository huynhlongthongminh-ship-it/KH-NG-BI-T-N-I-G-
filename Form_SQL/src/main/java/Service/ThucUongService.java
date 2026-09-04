/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ThucUong;
import Repository.ThucUongRepository;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ThucUongService {

    public final ThucUongRepository repository;

    public ThucUongService() {
        this.repository = new ThucUongRepository();
    }
public boolean deleteThucUong(double maTu) {
    return repository.delete(maTu);
}
    public List<ThucUong> getAllThucUong() {
        return repository.getAll();
    }

    public boolean addThucUong(String tenGoi, String giatienStr, String ghiChu) {
        if (tenGoi == null || tenGoi.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên thức uống "
                    + "không được để trống!");
        }

        double giatien;

        try {
            giatien = Double.parseDouble(giatienStr);

            if (giatien < 0) {
                throw new IllegalArgumentException("Giá tiền "
                        + "không được nhỏ hơn 0!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Giá tiền phải "
                    + "là một số hợp lệ!");
        }

        ThucUong tc = new ThucUong(tenGoi.trim(), giatien,
                ghiChu != null ? ghiChu.trim() : "");

        return repository.insert(tc);
    }


public boolean updateThucUong(
        double maTU,
        String tengoi,
        String giatienStr,
        String ghichu) {

    if (tengoi == null || tengoi.trim().isEmpty()) {
        throw new IllegalArgumentException(
                "Tên thức uống không được để trống!"
        );
    }

    double giatien;

    try {
        giatien = Double.parseDouble(giatienStr.trim());

        if (giatien < 0) {
            throw new IllegalArgumentException(
                    "Giá tiền không được nhỏ hơn 0!"
            );
        }

    } catch (NumberFormatException e) {
        throw new IllegalArgumentException(
                "Giá tiền phải là một số hợp lệ!"
        );
    }

    ThucUong tc = new ThucUong(
            maTU,
            tengoi.trim(),
            giatien,
            ghichu != null ? ghichu.trim() : ""
    );

    return repository.update(tc);
}
    
    
}
