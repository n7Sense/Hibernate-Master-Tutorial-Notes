package utility;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpIdGenarator extends IdentityGenerator {

    
    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        
        String suffix = "NSense";
        int myId = 0;
        try{
            Connection connection = s.connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT EmpIdGenarator.nextval FROM DUAL  ");
            if(rs.next()){
                myId = rs.getInt(1);
            }
        }catch (SQLException se){
            return null;
        }
        return myId;
    }
}
