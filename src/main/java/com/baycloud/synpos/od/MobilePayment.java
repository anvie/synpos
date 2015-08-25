package com.baycloud.synpos.od;

import com.baycloud.synpos.xt.StoreDB;

import java.sql.ResultSet;

/**
 * <p>Title: synPOS</p>
 *
 * <p>Description: synPOS is a desktop POS (Point Of Sale) client for online
 * ERP, eCommerce, and CRM systems. Released under the GNU General Public
 * License. Absolutely no warranty. Use at your own risk.</p>
 *
 * <p>Copyright: Copyright (c) 2006 synPOS.com</p>
 *
 * <p>Website: www.synpos.com</p>
 *
 * @author Robin Sy
 * @version 0.9.1
 */
public class MobilePayment implements Payment {
    private String fromAddress;
    private double paid;
    private String signature;
    private long timestamp;

    public MobilePayment(String fromAddress, double paid, String signature, long timestamp) {
        this.fromAddress = fromAddress;
        this.paid = paid;
        this.signature = signature;
        this.timestamp = timestamp;
    }

    public MobilePayment(int payId) {
        try {
            StoreDB db = new StoreDB();
            ResultSet rs = db.query(
                    "select * from payments_mobile where payments_mobile_id = " +
                    payId);
            if (rs.next()) {
                paid = rs.getDouble("payments_mobile_paid");
            }
            //db.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getPaid() {
        return paid;
    }
    public String getFromAddress(){ return fromAddress; }

    public String getPaymentType() {
        return "Mobile NFC";
    }

    public int insertDB(int orderId) {
        try {
            StoreDB db = new StoreDB();
            db.update("insert into payments_mobile values(NULL, " + orderId +
                      ", " +
                      paid + ", true)");
            int payId = db.insertID();
            //db.shutdown();
            return payId;
        } catch (Exception e) {
        }

        return -1;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
