/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.stock.Request;

/**
 *
 * @author nueng
 */
public class PopupBorrowUser {
    private String name;
    private String lastname;
    private String devicename;
    private String date;
    private String time;
    private String amount;
    private String status;
    private String rebordate;
    private String rebortime;

    public String getRebordate() {
        return rebordate;
    }

    public void setRebordate(String rebordate) {
        this.rebordate = rebordate;
    }

    public String getRebortime() {
        return rebortime;
    }

    public void setRebortime(String rebortime) {
        this.rebortime = rebortime;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
       public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    
}
