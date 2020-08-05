package com.octohub.pil4u.Model;

public class Banks {

    String rateOfInterest;
    String processingFee;
    String tenure;
    String bankName;
    int bankLogos;


    public Banks(String rateOfInterest, String processingFee, String tenure, String bankName, int bankLogos) {
        this.rateOfInterest = rateOfInterest;
        this.processingFee = processingFee;
        this.tenure = tenure;
        this.bankName = bankName;
        this.bankLogos = bankLogos;
    }

    public String getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(String rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(String processingFee) {
        this.processingFee = processingFee;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankLogos() {
        return bankLogos;
    }

    public void setBankLogos(int bankLogos) {
        this.bankLogos = bankLogos;
    }
}
