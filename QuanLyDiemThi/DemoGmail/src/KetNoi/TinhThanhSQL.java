/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KetNoi;

import ThongTin.TinhThanh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TinhThanhSQL {

    private Connection connection;

    public TinhThanhSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      //nạp tiến trình điều khiển kết nối
            //thiết lập kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=JavaAplication;"
                    + "username=vannam;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTinhThanh(TinhThanh tinhThanh) {
        String sql = "INSERT INTO quequan(MaTinh, TenTinh) " + "VALUES(?,?)";
        QueryInSQL(sql, tinhThanh);
    }

    public void DeleteTinhThanh(TinhThanh tinhThanh) {
        String sql = "DELETE FROM quequan WHERE MaTinh = " + tinhThanh.getMaTinh();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateTinhThanh(int matinh, TinhThanh tinhThanh) {
        String sql = "UPDATE quequan SET MaTinh = ?, TenTinh = ? WHERE MaTinh = " + matinh;
        QueryInSQL(sql, tinhThanh);
    }

    public ArrayList<TinhThanh> getListTinhThanh() {
        ArrayList<TinhThanh> list = new ArrayList<TinhThanh>();
        String sql = "SELECT * FROM quequan";
        QueryInSQLList(sql, list);
        return list;
    }

    private void QueryInSQL(String sql, TinhThanh tinhThanh) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tinhThanh.getMaTinh());
            preparedStatement.setString(2, tinhThanh.getTenTinh());
            preparedStatement.executeUpdate();
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void QueryInSQLList(String sql, ArrayList<TinhThanh> list) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //xử lý kết quả nhận về sau khi thi hành lệnh truy vấn thành công trên database
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TinhThanh tinhThanh = new TinhThanh();
                tinhThanh.setMaTinh(resultSet.getInt("MaTinh"));
                tinhThanh.setTenTinh(resultSet.getString("TenTinh"));
                list.add(tinhThanh);
            }
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
