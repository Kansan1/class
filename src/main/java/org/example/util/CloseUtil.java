package org.example.util;

import java.sql.Connection;
import java.sql.SQLException;

public class CloseUtil {
    public void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
