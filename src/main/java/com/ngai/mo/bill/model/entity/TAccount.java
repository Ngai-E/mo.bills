/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngai.mo.bill.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author SOFT
 */
@Entity
@Table(name = "t_account")
@NamedQueries({
    @NamedQuery(name = "TAccount.findAll", query = "SELECT t FROM TAccount t"),
    @NamedQuery(name = "TAccount.findByLgUserId", query = "SELECT t FROM TAccount t WHERE t.lgUserId = :lgUserId"),
    @NamedQuery(name = "TAccount.findByIntCoins", query = "SELECT t FROM TAccount t WHERE t.intCoins = :intCoins"),
    @NamedQuery(name = "TAccount.findByBFreeTrial", query = "SELECT t FROM TAccount t WHERE t.bFreeTrial = :bFreeTrial"),
    @NamedQuery(name = "TAccount.findByStrRefcode", query = "SELECT t FROM TAccount t WHERE t.strRefcode = :strRefcode")})
public class TAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_user_id")
    private String lgUserId;
    @Column(name = "int_coins")
    private BigInteger intCoins;
    @Column(name = "b_free_trial")
    private Boolean bFreeTrial;
    @Column(name = "str_refcode")
    private String strRefcode;
    @OneToMany(mappedBy = "strParent")
    private List<TRefferal> tRefferalList;
    @OneToMany(mappedBy = "strChild")
    private List<TRefferal> tRefferalList1;

    public TAccount() {
    }

    public TAccount(String lgUserId) {
        this.lgUserId = lgUserId;
    }

    public String getLgUserId() {
        return lgUserId;
    }

    public void setLgUserId(String lgUserId) {
        this.lgUserId = lgUserId;
    }

    public BigInteger getIntCoins() {
        return intCoins;
    }

    public void setIntCoins(BigInteger intCoins) {
        this.intCoins = intCoins;
    }

    public Boolean getBFreeTrial() {
        return bFreeTrial;
    }

    public void setBFreeTrial(Boolean bFreeTrial) {
        this.bFreeTrial = bFreeTrial;
    }

    public String getStrRefcode() {
        return strRefcode;
    }

    public void setStrRefcode(String strRefcode) {
        this.strRefcode = strRefcode;
    }

    public List<TRefferal> getTRefferalList() {
        return tRefferalList;
    }

    public void setTRefferalList(List<TRefferal> tRefferalList) {
        this.tRefferalList = tRefferalList;
    }

    public List<TRefferal> getTRefferalList1() {
        return tRefferalList1;
    }

    public void setTRefferalList1(List<TRefferal> tRefferalList1) {
        this.tRefferalList1 = tRefferalList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgUserId != null ? lgUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAccount)) {
            return false;
        }
        TAccount other = (TAccount) object;
        if ((this.lgUserId == null && other.lgUserId != null) || (this.lgUserId != null && !this.lgUserId.equals(other.lgUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngai.mo.bill.model.entity.TAccount[ lgUserId=" + lgUserId + " ]";
    }
    
}
