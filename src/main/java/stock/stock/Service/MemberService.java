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
import stock.stock.Request.DevicesRequest;
import stock.stock.Request.MemberRequest;
import stock.stock.Response.MemberResponse;

/**
 *
 * @author nueng
 */
@Service
public class MemberService {
    @Autowired
    DatabaseRepo databaserepo;
    public List<MemberResponse> showmember()
    {
        return databaserepo.showmember();
    }
    
    public void addmember(MemberRequest memberrequest)
    {
         databaserepo.addmember(memberrequest);
    }
    
     public void editinfouser(MemberRequest memberrequest)
    {
         databaserepo.editinfouser(memberrequest);
    }
     public void deletemember(MemberRequest memberrequest)
    {
         databaserepo.deletemember(memberrequest);
    }

   
    
}
