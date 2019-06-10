/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Data.Gmail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Van Nam
 */
public class GmailSQL {

    private Connection connection;

    public GmailSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      //nạp tiến trình điều khiển kết nối
            //thiết lập kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=AppGmail;"
                    + "username=vannam;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Gmail> getListGmail() {
        ArrayList<Gmail> list = new ArrayList<>();
        String sql = "SELECT * FROM gmail";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //xử lý kết quả nhận về sau khi thi hành lệnh truy vấn thành công trên database
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Gmail gmail = new Gmail();
                gmail.setEmail(resultSet.getString("email"));
                gmail.setPassword(resultSet.getString("password"));

                list.add(gmail);
            }
            connection.close();     //đóng kết nối và giải phóng tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
