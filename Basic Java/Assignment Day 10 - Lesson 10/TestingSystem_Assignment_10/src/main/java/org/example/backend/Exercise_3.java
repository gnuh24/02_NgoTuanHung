package org.example.backend;

import java.sql.CallableStatement;
import java.sql.Connection;

public class Exercise_3 {
    public static void deleteDepartmentUsingProcedure(Connection connection, int id) throws Exception{
        String callProcedure = "{CALL `sp_delete_department`(?)}";
        CallableStatement callableStatement = connection.prepareCall(callProcedure);
        callableStatement.setInt(1, id);
        if (callableStatement.executeUpdate() != 0)
            System.out.println("Delete success!!");
        else System.out.println("Delete fail");
    }
}
