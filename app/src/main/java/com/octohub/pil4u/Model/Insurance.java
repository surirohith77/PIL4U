package com.octohub.pil4u.Model;

public class Insurance {

    String policyNo;
    String paymentDate;
    String Premium;


    public Insurance(String policyNo, String paymentDate, String premium) {
        this.policyNo = policyNo;
        this.paymentDate = paymentDate;
        Premium = premium;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPremium() {
        return Premium;
    }

    public void setPremium(String premium) {
        Premium = premium;
    }


}
