/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KetNoi;

import ThongTin.ThiSinh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThiSinhSQL {

    private Connection connection;

    public ThiSinhSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      //nạp tiến trình điều khiển kết nối
            //thiết lập kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=JavaAplication;"
                    + "username=vannam;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addThiSinh(ThiSinh thiSinh) {
        String sql = "INSERT INTO thisinh(MaThiSinh, TenThiSinh, MaQueQuan, NgaySinh, GioiTinh, DiemToan, DiemLy, DiemHoa) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        QueryInSQL(sql, thiSinh);
    }

    public void DeleteThiSinh(ThiSinh thiSinh) {
        String sql = "DELETE FROM thisinh WHERE MaThiSinh = " + thiSinh.getMaThiSinh();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateThiSinh(int id, ThiSinh thiSinh) {
        String sql = "UPDATE thisinh SET MaThiSinh = ?, TenThiSinh = ?, MaQueQuan = ?, NgaySinh = ?, GioiTinh = ?, DiemToan = ?, DiemLy = ?, DiemHoa = ? WHERE MaThiSinh = " + id;
        QueryInSQL(sql, thiSinh);
    }

    public ArrayList<ThiSinh> getListThiSinh() {
        ArrayList<ThiSinh> list = new ArrayList<ThiSinh>();
        String sql = "SELECT * FROM thisinh";
        QueryInSQLList(sql, list);
        return list;
    }

    private void QueryInSQL(String sql, ThiSinh thiSinh) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, thiSinh.getMaThiSinh());
            preparedStatement.setString(2, thiSinh.getTenThiSinh());
            preparedStatement.setInt(3, thiSinh.getMaQueQuan());
            preparedStatement.setString(4, thiSinh.getNgaySinh());
            if (thiSinh.isGioiTinh() == "Nam") {
                preparedStatement.setBoolean(5, true);
            } else {
                preparedStatement.setBoolean(5, false);
            }
            preparedStatement.setFloat(6, thiSinh.getDiemToan());
            preparedStatement.setFloat(7, thiSinh.getDiemLy());
            preparedStatement.setFloat(8, thiSinh.getDiemHoa());

            preparedStatement.executeUpdate();
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void QueryInSQLList(String sql, ArrayList<ThiSinh> list) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //xử lý kết quả nhận về sau khi thi hành lệnh truy vấn thành công trên database
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ThiSinh thiSinh = new ThiSinh();
                thiSinh.setMaThiSinh(resultSet.getInt("MaThiSinh"));
                thiSinh.setTenThiSinh(resultSet.getString("TenThiSinh"));
                thiSinh.setMaQueQuan(resultSet.getInt("MaQueQuan"));
                thiSinh.setNgaySinh(resultSet.getString("NgaySinh"));
                thiSinh.setGioiTinh(resultSet.getBoolean("GioiTinh"));
                thiSinh.setDiemToan(resultSet.getFloat("DiemToan"));
                thiSinh.setDiemLy(resultSet.getFloat("DiemLy"));
                thiSinh.setDiemHoa(resultSet.getFloat("DiemHoa"));

                list.add(thiSinh);
            }
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
