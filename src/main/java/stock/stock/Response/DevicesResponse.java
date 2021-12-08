/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.stock.Response;

/**
 *
 * @author nueng
 */
public class DevicesResponse {
     private String name;
     private String lastname;
    private String amount;
    private String namedevice;
    private String status;
    private String bordate;
    private String bortime;
    private String rebordate;
    private String rebortime;
    private String id_user;

    public String getNamedevice() {
        return namedevice;
    }

    public void setNamedevice(String namedevice) {
        this.namedevice = namedevice;
    }

    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBordate() {
        return bordate;
    }

    public void setBordate(String bordate) {
        this.bordate = bordate;
    }

    public String getBortime() {
        return bortime;
    }

    public void setBortime(String bortime) {
        this.bortime = bortime;
    }

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

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    
    
}
