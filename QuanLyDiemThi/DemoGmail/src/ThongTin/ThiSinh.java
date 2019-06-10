/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

/**
 *
 * @author Admin
 */
public class ThiSinh {
    private int MaThiSinh;
    private String TenThiSinh;
    private int MaQueQuan;
    private String NgaySinh;
    private boolean GioiTinh;
    private float DiemToan;
    private float DiemLy;
    private float DiemHoa;

    public ThiSinh() {
        // TODO Auto-generated constructor stub
    }

    public ThiSinh(int maThiSinh, String tenThiSinh, int maQueQuan, String ngaySinh, boolean gioiTinh,
            float diemToan, float diemLy, float diemHoa) {
        MaThiSinh = maThiSinh;
        TenThiSinh = tenThiSinh;
        MaQueQuan = maQueQuan;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        DiemToan = diemToan;
        DiemLy = diemLy;
        DiemHoa = diemHoa;
    }

    public int getMaThiSinh() {
        return MaThiSinh;
    }

    public void setMaThiSinh(int maThiSinh) {
        MaThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return TenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        TenThiSinh = tenThiSinh;
    }

    public int getMaQueQuan() {
        return MaQueQuan;
    }

    public void setMaQueQuan(int maQueQuan) {
        MaQueQuan = maQueQuan;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String isGioiTinh() {
        if (GioiTinh == true) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public void setGioiTinh(boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public float getDiemToan() {
        return DiemToan;
    }

    public void setDiemToan(float diemToan) {
        DiemToan = diemToan;
    }

    public float getDiemLy() {
        return DiemLy;
    }

    public void setDiemLy(float diemLy) {
        DiemLy = diemLy;
    }

    public float getDiemHoa() {
        return DiemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        DiemHoa = diemHoa;
    }

}
