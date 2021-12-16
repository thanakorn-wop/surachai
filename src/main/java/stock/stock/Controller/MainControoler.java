/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.stock.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stock.stock.Request.DevicesRequest;
import stock.stock.Request.LoginRequest;
import stock.stock.Request.MemberRequest;
import stock.stock.Request.PopupBorrowUser;
import stock.stock.Response.DevicesResponse;
import stock.stock.Response.LoginResponse;
import stock.stock.Response.MemberResponse;
import stock.stock.Service.BorrowUserReturn;
import stock.stock.Service.LoginService;
import stock.stock.Service.MemberService;
import stock.stock.Service.PopupService;

/**
 *
 * @author nueng
 */
@RestController
@CrossOrigin
public class MainControoler {
    
    @Autowired
    LoginService loginservice;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginResponse login(@RequestBody  LoginRequest loginrequest)
    {   
        System.out.println("check = "+loginrequest);
//        HolldayRequest qq = new HolldayRequest();
//        String name = rquest.getName();
//        qq.setName(name);
//        database.Data(qq.getName());
//        
//         System.out.println("check1 "+name);
//        data.save(name);

        
       
        return loginservice.login(loginrequest);
    }
    @Autowired
    PopupService popupservice;
     @RequestMapping(value = "/PopUpAdduserdevices",method = RequestMethod.GET)
    public List<MemberResponse> PopUpAdduserdevices( )
    {
        return popupservice.PopUpAdduserdevices();
                
    }
   
     @RequestMapping(value = "/PopUpAdduserborrowdevices",method = RequestMethod.POST)
    public  List<PopupBorrowUser> PopUpAdduserborrowdevices(@RequestBody PopupBorrowUser popupborrowuser )
    {
        return popupservice.PopUpAdduserborrowdevices(popupborrowuser);
                
    }
   
      @RequestMapping(value = "/returnitem",method = RequestMethod.POST)
    public  void PopUpreturnuserborrowdevices(@RequestBody PopupBorrowUser popupborrowuser )
    {
        popupservice.PopUpreturnuserborrowdevices(popupborrowuser);
                
    }
    
    @Autowired
    BorrowUserReturn borrowuserreturn;
     @RequestMapping(value = "/Page-borrow-return-user",method = RequestMethod.GET)
    public  List<DevicesResponse> Showuserborrowdevices( )
    {
        return borrowuserreturn.Showuserborrowdevices();
                
    }
    
      @Autowired
      MemberService memberservice;
     @RequestMapping(value = "/showmember",method = RequestMethod.GET)
     public  List<MemberResponse> showmember( )
    {
        return memberservice.showmember();
                
    }
    
//      @Autowired
//      MemberService memberservice;
     @RequestMapping(value = "/addmember",method = RequestMethod.POST)
    public  void addmember(@RequestBody MemberRequest memberrequest )
    {
        memberservice.addmember(memberrequest);
                
    }
    
    @RequestMapping(value = "/editinfouser",method = RequestMethod.POST)
    public  void editinfouser(@RequestBody MemberRequest memberrequest )
    {
        memberservice.editinfouser(memberrequest);
                
    }
    
      @RequestMapping(value = "/deletemember",method = RequestMethod.POST)
    public  void deletemember(@RequestBody MemberRequest memberrequest )
    {
        memberservice.deletemember(memberrequest);
                
    }
   
   
     @RequestMapping(value = "/deleteborrow-return",method = RequestMethod.POST)
    public  void deleteborrowreturn(@RequestBody DevicesRequest devicesrequest )
    {
        borrowuserreturn.deleteborrowreturn(devicesrequest);
                
    }
     @RequestMapping(value = "/test",method = RequestMethod.GET)
    public  MemberResponse deleteborrowreturn( )
    {
       MemberResponse data = new MemberResponse();
       data.setName("heeek");
       return data;
                
    }
    
    
//      @RequestMapping(value = "/testlogin",method = RequestMethod.POST)
//     public ResponseEntity <List<LoginResponse>> test(@RequestBody  LoginRequest loginrequest)
//     {   
//         System.out.println("check = "+loginrequest);
// //        List<LoginResponse> data = new ArrayList<>();
// //        LoginResponse aa = new LoginResponse();
// //        aa.setUsername(loginrequest.getUsername());
// //        aa.setPassword(loginrequest.getPassword());
// //       data.add(aa);
                
// //        HolldayRequest qq = new HolldayRequest();
// //        String name = rquest.getName();
// //        qq.setName(name);
// //        database.Data(qq.getName());
// //        
// //         System.out.println("check1 "+name);
// //        data.save(name);

        
       
//         return new ResponseEntity<>(loginservice.login(loginrequest),HttpStatus.OK);
//     }
    
    

}
