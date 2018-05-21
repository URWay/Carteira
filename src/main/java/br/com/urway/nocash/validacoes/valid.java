package br.com.urway.nocash.validacoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.urway.nocash.dao.DAOJDBC;

public class valid extends DAOJDBC {
    

    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        
    public static boolean isEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isUniqueEmail(String email){
        /*String sql = "SELECT emailCliente FROM cliente WHERE emailCliente = " + email;
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        
        }*/
        
        return true;
    }

}
