/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Data.ThiSinh;
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

    public ArrayList<ThiSinh> getListThiSinh() {
        ArrayList<ThiSinh> list = new ArrayList<ThiSinh>();
        String sql = "SELECT * FROM thisinh";
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
        return list;
    }

}
