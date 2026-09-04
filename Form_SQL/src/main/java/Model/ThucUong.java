package Model;

public class ThucUong {

    private double maTu;
    private String tenGoi;
    private double gia;
    private String ghiChu;

    // Constructor đầy đủ
    public ThucUong(double maTu, String tenGoi, double gia, String ghiChu) {
        this.maTu = maTu;
        this.tenGoi = tenGoi;
        this.gia = gia;
        this.ghiChu = ghiChu;
    }

    // Constructor không có mã
    public ThucUong(String tenGoi, double gia, String ghiChu) {
        this.tenGoi = tenGoi;
        this.gia = gia;
        this.ghiChu = ghiChu;
    }

    public double getMaTu() {
        return maTu;
    }

    public String getTenGoi() {
        return tenGoi;
    }

    public double getGia() {
        return gia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaTu(double maTu) {
        this.maTu = maTu;
    }

    public void setTenGoi(String tenGoi) {
        this.tenGoi = tenGoi;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}