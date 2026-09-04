/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ThucUong;
import Service.ThucUongService;
import Service.NhanVienService;
import View.ThucUongView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author DELL
 */
public class ThucUongController {

    private ThucUongView view;
    private ThucUongService service;
    private NhanVienService NVservice;

    public ThucUongController(ThucUongView view, ThucUongService service, NhanVienService NVservice) {
        this.view = view;
        this.service = service;
        this.NVservice = NVservice;
        loadData();
        this.view.ButtonListenerThem(e -> them());
        this.view.ButtonListenerThemNV(e -> themNV());
        this.view.ButtonListenerXoa(e -> Xoa());
        this.view.ButtonListenerSua(e -> Sua());

        this.view.addTableclickedLintenner(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                chonBang();
            }

        });

    }

    private void loadData() {
        
        this.view.loadDataToTable(this.service.getAllThucUong());
        this.view.loadNVDataToTable(this.NVservice.getAllNhanVien());
    }

    private void chonBang() {
        ThucUong item = this.view.thucUongDuocChonTrongBang();
        this.view.hienThiTU(item);

    }

    public void Clear() {
        this.view.setMa("");
        this.view.setName("");
        this.view.setgia("");
        this.view.setGhichu("");
    }

    public void them() {
        try {
            String tengoi = this.view.getName();
            String Gia = this.view.getGia();
            String GhiChu = this.view.getGhichu();

            service.addThucUong(tengoi, Gia, GhiChu);
            loadData();
            Clear();

        } catch (IllegalArgumentException ex) {
            this.view.DebugVoil(ex.getMessage());
        }

    }

    public void themNV() {

        try {

            String tenNV = this.view.getTennv();
            String QueNV = this.view.getQuequannv();
            String luongNv = this.view.getLuongnv();
            String namNV = this.view.getnamsinhnv();
            NVservice.addNhanVien(tenNV, QueNV, luongNv, namNV);
            loadData();
            Clear();

        } catch (IllegalArgumentException ex) {
            this.view.DebugVoil(ex.getMessage());
        }

    }

    public void Sua() {
        int index = this.view.getRow();

        if (index == -1) {
            this.view.DebugVoil("Chưa chọn dòng để sửa");
        } else {
            this.view.DebugVoil("Xác nhận");

            try {
                double matu = this.view.getMa();
                String tengoi = this.view.getName();
                String Gia = this.view.getGia();
                String GhiChu = this.view.getGhichu();

                boolean result = service.updateThucUong(
                        matu,
                        tengoi,
                        Gia,
                        GhiChu
                );

                if (result) {
                    this.view.DebugVoil("Sửa thành công");
                    loadData();
                    Clear();
                } else {
                    this.view.DebugVoil("Không sửa được");
                }

            } catch (IllegalArgumentException ex) {
                this.view.DebugVoil(ex.getMessage());
            }
        }
    }

    public void Xoa() {
        int row = this.view.getRow();
        if (row == -1) {
            this.view.DebugVoil("Chưa chọn dòng để xóa!");
            return;
        }

        try {

            if (view.Confirm("Bạn có muốn Xóa Thức uống này không?")) {
                // Người dùng chọn YES
                double maTu = this.view.getMaByRow(row);

                boolean result = service.deleteThucUong(maTu);
                if (result) {

                    // Load lại dữ liệu từ SQL
                    loadData();

                    // Xóa dữ liệu trên ô nhập
                    Clear();

                } else {
                    this.view.DebugVoil("Không tìm thấy thức uống để xóa!");
                }
               
            } else {
                // Người dùng chọn NO
                view.DebugVoil("Đã hủy ");
            }

        } catch (Exception e) {
            this.view.DebugVoil("Lỗi khi xóa: " + e.getMessage());
        }
    }

}
