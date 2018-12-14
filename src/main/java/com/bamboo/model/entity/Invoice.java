/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamboo.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author alexander
 */
public class Invoice {

    private int id;
    private String number;
    private Date dateOfIssue;
    private Double totalToPay;
    private boolean payed;
    private Beneficiary beneficiary;
    private User debtcollector;

    public Invoice() {
    }

    public Invoice(int id, String number, Date dateOfIssue, Double totalToPay, boolean payed, Beneficiary beneficiary, User debtcollector) {
        this.id = id;
        this.number = number;
        this.dateOfIssue = dateOfIssue;
        this.totalToPay = totalToPay;
        this.payed = payed;
        this.beneficiary = beneficiary;
        this.debtcollector = debtcollector;
    }

    public Invoice(int id, String number, String dateOfIssue, Double totalToPay, boolean payed, Beneficiary beneficiary, User debtcollector) throws ParseException {
        this.id = id;
        this.number = number;
        toDate(dateOfIssue);
        this.totalToPay = totalToPay;
        this.payed = payed;
        this.beneficiary = beneficiary;
        this.debtcollector = debtcollector;
    }

    public User getDebtcollector() {
        return debtcollector;
    }

    public void setDebtcollector(User debtcollector) {
        this.debtcollector = debtcollector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) throws ParseException {
        toDate(dateOfIssue);
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(Double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setIsPayed(boolean payed) {
        this.payed = payed;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    private void toDate(String dateOfIssue) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("es_ES"));

        try {
            this.dateOfIssue = sdf.parse(dateOfIssue);
        } catch (ParseException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Invoice{"
                + "id=" + id
                + ", number='" + number + '\''
                + ", dateOfIssue=" + dateOfIssue
                + ", totalToPay=" + totalToPay
                + ", payed=" + payed
                + ", beneficiary=" + beneficiary
                + ", debtcollector=" + debtcollector
                + '}';
    }
}
