package com.epam.elena_bogomolova.FinalTest;

import java.sql.*;
import java.util.Random;

public class TestFirstTask {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        final int PRD_AMOUNT = 10;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop",
                    "root", "");

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        String addProduct = "INSERT INTO products (idproducts, name, weight, category) VALUES (?,?,?,?);";
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery("SELECT idproducts FROM products");
            String maxId = null;
            while (rs.next()) {
                maxId = rs.getString(1);
            }
            int maxID = Integer.parseInt(maxId);
            for (int i = maxID + 1; i < PRD_AMOUNT + maxID +1; i++) {
                pstmt = conn.prepareStatement(addProduct);
                pstmt.setInt(1, i);
                pstmt.setString(2, "product-" + i);
                pstmt.setInt(3, new Random().nextInt(20) + 20);
                pstmt.setString(4, "cat-" + i);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
