/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.stock.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import stock.stock.Request.DevicesRequest;
import stock.stock.Request.LoginRequest;
import stock.stock.Request.MemberRequest;
import stock.stock.Request.PopupBorrowUser;
import stock.stock.Response.DevicesResponse;
import stock.stock.Response.LoginResponse;
import stock.stock.Response.MemberResponse;

/**
 *
 * @author nueng
 */
@Repository
public class DatabaseRepo extends Basedata {

    public List<LoginResponse> login(LoginRequest loginrequest) {

        List<LoginResponse> data = new ArrayList<>();
//         List<UserData> arr = new ArrayList<>();
        List<Object> para = new ArrayList<>();
        String user;
        System.out.println(loginrequest.getUsername());
        System.out.println(loginrequest.getPassword());

        user = (" SELECT username, password FROM user WHERE username = ? AND password = ? ");
        para.add(loginrequest.getUsername());
        para.add(loginrequest.getPassword());
//         arr = jdbcTemplate.query(user,para.toArray(),FIND_MEMBER);
        data = jdbcTemplate.query(user, para.toArray(), FIND_USER);
         LoginResponse data1 = new LoginResponse();
        if (data.size() > 0) {
//             System.out.println("your username = " + data.get(0).get);
//             System.out.println("your pass = " + loginrequest.getPassword());
            System.out.println("your username = " + data.get(0).getUsername());
            System.out.println("your pass = " + data.get(0).getPassword());
             data1.setUsername(loginrequest.getUsername());
            data1.setPassword(loginrequest.getPassword());
            return data;

        } else {
            System.out.println("no data");
        }

        return null;
    }

    public List<MemberResponse> PopUpAdduserdevices() {

        List<MemberResponse> data = new ArrayList<>();
//         List<UserData> arr = new ArrayList<>();
        List<Object> para = new ArrayList<>();
        String user;
        user = (" SELECT * FROM member ");
        data = jdbcTemplate.query(user, FIND_MEMBER);
        return data;
    }

    public void PopUpreturnuserborrowdevices(PopupBorrowUser popupborrowuser) {

        List<Object> data = new ArrayList<>();
        List<Object> para = new ArrayList<>();
        List<MemberResponse> member = new ArrayList<>();
        String status = "คืนแล้ว";
        String updatedata;
        String select = (" SELECT * FROM member WHERE name = ? AND lastname = ? ");
        para.add(popupborrowuser.getName());
        para.add(popupborrowuser.getLastname());
        member = jdbcTemplate.query(select, para.toArray(), FIND_MEMBER);
        updatedata = (" UPDATE devices SET status = ?, rebortime = ? , rebordate = ? WHERE id_member = ? AND amount = ? AND name_device = ? ");
        data.add(status);
        data.add(popupborrowuser.getRebortime());
        data.add(popupborrowuser.getRebordate());
        data.add(member.get(0).getId_member());
        data.add(popupborrowuser.getAmount());
        data.add(popupborrowuser.getDevicename());
        jdbcTemplate.update(updatedata, data.toArray());

    }

    public List<PopupBorrowUser> PopUpAdduserborrowdevices(PopupBorrowUser popupborrowuser) {

//        List<MemberResponse> data = new ArrayList<>();
//         List<UserData> arr = new ArrayList<>();
        List<PopupBorrowUser> responsedata_list = new ArrayList<>();
        PopupBorrowUser responsedata = new PopupBorrowUser();
        String user;
//        LocalTime myObj = LocalTime.now();
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
//        System.out.println(myObj);
//        String formattedDate = myObj.format(myFormatObj);
//        System.out.println("After formatting: " + formattedDate);

        try {
            List<Object> paramember = new ArrayList<>();
            List<MemberResponse> allmember = new ArrayList<>();
            System.out.println("name = " + popupborrowuser.getName());
            System.out.println("lastname = " + popupborrowuser.getLastname());

            String select = (" SELECT * FROM member WHERE name = ? AND lastname = ? ");
            paramember.add(popupborrowuser.getName());
            paramember.add(popupborrowuser.getLastname());

            allmember = jdbcTemplate.query(select, paramember.toArray(), FIND_MEMBER);
            if (allmember.size() > 0) {
                System.out.println("more than zero ");
            } else {
                System.out.println("less than zero ");
            }

            if (popupborrowuser.getAmount() != null && popupborrowuser.getDate() != null && popupborrowuser.getDevicename() != null) {
                System.out.println("check");
                String date = popupborrowuser.getDate();
                String replace = date.replace("/", "-");
                List<Object> para = new ArrayList<>();
                String adduserborrow;
                String status = "กำลังยืม";
                adduserborrow = (" INSERT INTO devices(name_device,amount,bordate,bortime,status,id_member) VALUES(?,?,?,?,?,?) ");
                para.add(popupborrowuser.getDevicename());
                para.add(popupborrowuser.getAmount());
                para.add(popupborrowuser.getDate());
                para.add(popupborrowuser.getRebortime());
                para.add(status);
                para.add(allmember.get(0).getId_member());
                System.out.println("check id = " + allmember.get(0).getId_member());
                responsedata.setName(popupborrowuser.getName());
                responsedata.setLastname(popupborrowuser.getLastname());
                responsedata.setDevicename(popupborrowuser.getDevicename());
                responsedata.setAmount(popupborrowuser.getAmount());
                responsedata.setDate(popupborrowuser.getDate());
                responsedata.setTime(popupborrowuser.getRebortime());
                responsedata.setStatus(status);
                responsedata_list.add(responsedata);

                jdbcTemplate.update(adduserborrow, para.toArray());
//                data = jdbcTemplate.update(,ADD_BORROWUSER );

            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return responsedata_list;
    }

    public List<DevicesResponse> Showuserborrowdevices() {
        List<DevicesResponse> data = new ArrayList<>();
        String member = (" SELECT devices.name_device,devices.amount,devices.bordate,devices.bortime,devices.rebordate,devices.rebortime,devices.status,member.name,member.lastname,devices.id_member FROM `devices` JOIN `member` ON devices.id_member = member.id_member ");
        data = jdbcTemplate.query(member, SHOW_BORROWUSER);

        return data;
    }

    public List<MemberResponse> showmember() {
        List<MemberResponse> data = new ArrayList<>();
        String member = (" SELECT * FROM member ");
        data = jdbcTemplate.query(member, FIND_MEMBER);

        return data;
    }

     public void editinfouser(MemberRequest memberreques) {
        List<Object> data = new ArrayList<>();
         //List<Object> para = new ArrayList<>();
         String para = "";
        para += (" UPDATE member SET id_member = ? ");
        data.add(memberreques.getId_member());
       if(memberreques.getName() != null)
       {
            para += (",name = ? ");
             data.add(memberreques.getName());
            
       }
        if(memberreques.getLastname() != null)
       {
            para+= (",lastname = ? ");
            data.add(memberreques.getLastname());
            
       }
        if(memberreques.getNickname() != null)
       {
            para += (",nickname = ? ");
             data.add(memberreques.getNickname());
            
       }
        if(memberreques.getPhone() != null)
       {
            para += (",phone = ? ");
            
              data.add(memberreques.getPhone());
            
       }
        if(memberreques.getPosition() != null)
       {
            para+= (",position = ? ");
             data.add(memberreques.getPosition());
            
       }
      
      para+= ("WHERE id_member = ? ");
      
       
        data.add(memberreques.getId_member());
        
        jdbcTemplate.update(para.toString(), data.toArray());

    }
    public void deletemember(MemberRequest memberreques) {
        List<Object> data = new ArrayList<>();
        String member = (" DELETE  FROM member WHERE name = ? AND lastname = ? ");
        data.add(memberreques.getName());
        data.add(memberreques.getLastname());
        jdbcTemplate.update(member, data.toArray());

    }
    
    
    
    
     public void deleteborrowreturn(DevicesRequest devicesrequest ) {
        List<Object> data = new ArrayList<>();
        String member = (" DELETE  FROM devices WHERE name_device = ? AND amount= ? AND status = ? AND bordate  = ? AND rebordate = ? AND id_member = ? ");
        data.add(devicesrequest.getName());
        data.add(devicesrequest.getAmount());
        data.add(devicesrequest.getStatus());
        data.add(devicesrequest.getBordate());
        data.add(devicesrequest.getRebordate());
        data.add(devicesrequest.getId_user());
            
        jdbcTemplate.update(member, data.toArray());

    }

    public void addmember(MemberRequest memberrequest) {
        List<Object> data = new ArrayList<>();
        String member = (" INSERT INTO member(name,lastname,nickname,phone,position) VALUES(?,?,?,?,?) ");
        data.add(memberrequest.getName());
        data.add(memberrequest.getLastname());
        data.add(memberrequest.getNickname());
        data.add(memberrequest.getPhone());
        data.add(memberrequest.getPosition());
        jdbcTemplate.update(member, data.toArray());

//        return data;
    }

    private final RowMapper<LoginResponse> FIND_USER = new RowMapper<LoginResponse>() {
        public LoginResponse mapRow(ResultSet rs, int index) throws SQLException {
//            newdata newdata = new newdata();
            LoginResponse data = new LoginResponse();
//            data.setName(rs.getString("name"));
            data.setUsername(rs.getString("username"));

            data.setPassword(rs.getString("password"));
            return data;
        }
    };

//     MemberRequest memberrequest 
    private final RowMapper<MemberResponse> FIND_MEMBER = new RowMapper<MemberResponse>() {
        public MemberResponse mapRow(ResultSet rs, int index) throws SQLException {
//            newdata newdata = new newdata();

            MemberResponse data = new MemberResponse();
            data.setName(rs.getString("name"));
            data.setLastname(rs.getString("lastname"));
            data.setNickname(rs.getString("nickname"));
            data.setPhone(rs.getString("phone"));
            data.setPosition(rs.getString("position"));
            data.setId_member(rs.getInt("id_member"));
//            data.setPhone(phone);
//          
//            data.setPassword(rs.getString("password"));
            return data;
        }
    };

    private final RowMapper<DevicesResponse> SHOW_BORROWUSER = new RowMapper<DevicesResponse>() {
        public DevicesResponse mapRow(ResultSet rs, int index) throws SQLException {
//            newdata newdata = new newdata();

            DevicesResponse data = new DevicesResponse();
            data.setName(rs.getString("name"));
            data.setLastname(rs.getString("lastname"));
            data.setId_user(rs.getString("id_member"));
            data.setNamedevice(rs.getString("name_device"));
            data.setAmount(rs.getString("amount"));
            data.setBordate(rs.getString("bordate"));
            data.setBortime(rs.getString("bortime"));
            data.setRebordate(rs.getString("rebordate"));
            data.setRebortime(rs.getString("rebortime"));
            data.setStatus(rs.getString("status"));
//            data.setAmount(rs.getString("amount"));
//            data.setDate(rs.getString("bordate"));
//            data.setTime(rs.getString("bortime"));
//            data.setName(rs.getString("name_device"));
//            data.setStatus(rs.getString("status"));
//            data.se
//           
//            data.setLastname(rs.getString("lastname"));
//           
//            data.setPassword(rs.getString("password"));
            return data;
        }
    };

}
