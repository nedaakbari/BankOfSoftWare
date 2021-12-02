package ir.maktab.HW14.ataAccess;

import ir.maktab.HW14.model.Disc;
import ir.maktab.HW14.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscDao extends BaseDao {
    public DiscDao() {
    }


    public int updateQuantity(int number, String discName) throws SQLException {
            if (connection != null) {
                String sql = "UPDATE disc SET available  = ? WHERE discName = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, number);
                statement.setString(2, discName);
                int i = statement.executeUpdate();
                return i;
            }
            return 0;
        }
}

