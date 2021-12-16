/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.stock.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock.stock.Repository.DatabaseRepo;
import stock.stock.Request.LoginRequest;
import stock.stock.Response.LoginResponse;

/**
 *
 * @author nueng
 */
@Service
public class LoginService {
    @Autowired
    DatabaseRepo databaserepo;
    
    public LoginResponse login(LoginRequest loginrequest)
    {
        return databaserepo.login(loginrequest);
    }
}
