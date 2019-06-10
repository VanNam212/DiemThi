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
public class TinhThanh {

    private String TenTinh;
    private int MaTinh;

    public TinhThanh() {
        // TODO Auto-generated constructor stub
    }

    public TinhThanh(String tenTinh, int maTinh) {
        TenTinh = tenTinh;
        MaTinh = maTinh;
    }

    public String getTenTinh() {
        return TenTinh;
    }

    public void setTenTinh(String tenTinh) {
        TenTinh = tenTinh;
    }

    public int getMaTinh() {
        return MaTinh;
    }

    public void setMaTinh(int maTinh) {
        MaTinh = maTinh;
    }
}
