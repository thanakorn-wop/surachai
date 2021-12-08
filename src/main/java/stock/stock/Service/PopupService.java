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
import stock.stock.Request.MemberRequest;
import stock.stock.Request.PopupBorrowUser;
import stock.stock.Response.MemberResponse;

/**
 *
 * @author nueng
 */
@Service
public class PopupService {
    @Autowired
    DatabaseRepo databaserepo;
    public List<MemberResponse> PopUpAdduserdevices( )
    {
        return databaserepo.PopUpAdduserdevices();
    }
   
    public  List<PopupBorrowUser> PopUpAdduserborrowdevices(PopupBorrowUser popupborrowuser )
    {
         return databaserepo.PopUpAdduserborrowdevices(popupborrowuser);
    }
    
     public  void PopUpreturnuserborrowdevices( PopupBorrowUser popupborrowuser)
    {
          databaserepo.PopUpreturnuserborrowdevices(popupborrowuser);
    }
}
