/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngai.mo.bill.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SOFT
 */
@Entity
@Table(name = "t_refferal")
@NamedQueries({
    @NamedQuery(name = "TRefferal.findAll", query = "SELECT t FROM TRefferal t"),
    @NamedQuery(name = "TRefferal.findByLgReferralId", query = "SELECT t FROM TRefferal t WHERE t.lgReferralId = :lgReferralId"),
    @NamedQuery(name = "TRefferal.findByDtCreated", query = "SELECT t FROM TRefferal t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "TRefferal.findByStrCode", query = "SELECT t FROM TRefferal t WHERE t.strCode = :strCode"),
    @NamedQuery(name = "TRefferal.findByIntAmount", query = "SELECT t FROM TRefferal t WHERE t.intAmount = :intAmount"),
    @NamedQuery(name = "TRefferal.findByIntAmtChild", query = "SELECT t FROM TRefferal t WHERE t.intAmtChild = :intAmtChild"),
    @NamedQuery(name = "TRefferal.findByIntAmtParent", query = "SELECT t FROM TRefferal t WHERE t.intAmtParent = :intAmtParent")})
public class TRefferal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_referral_id")
    private String lgReferralId;
    @Column(name = "dt_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "str_code")
    private String strCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "int_amount")
    private Double intAmount;
    @Column(name = "int_amt_child")
    private Double intAmtChild;
    @Column(name = "int_amt_parent")
    private Double intAmtParent;
    @JoinColumn(name = "str_parent", referencedColumnName = "lg_user_id")
    @ManyToOne
    private TAccount strParent;
    @JoinColumn(name = "str_child", referencedColumnName = "lg_user_id")
    @ManyToOne
    private TAccount strChild;

    public TRefferal() {
    }

    public TRefferal(String lgReferralId) {
        this.lgReferralId = lgReferralId;
    }

    public String getLgReferralId() {
        return lgReferralId;
    }

    public void setLgReferralId(String lgReferralId) {
        this.lgReferralId = lgReferralId;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public Double getIntAmount() {
        return intAmount;
    }

    public void setIntAmount(Double intAmount) {
        this.intAmount = intAmount;
    }

    public Double getIntAmtChild() {
        return intAmtChild;
    }

    public void setIntAmtChild(Double intAmtChild) {
        this.intAmtChild = intAmtChild;
    }

    public Double getIntAmtParent() {
        return intAmtParent;
    }

    public void setIntAmtParent(Double intAmtParent) {
        this.intAmtParent = intAmtParent;
    }

    public TAccount getStrParent() {
        return strParent;
    }

    public void setStrParent(TAccount strParent) {
        this.strParent = strParent;
    }

    public TAccount getStrChild() {
        return strChild;
    }

    public void setStrChild(TAccount strChild) {
        this.strChild = strChild;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgReferralId != null ? lgReferralId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRefferal)) {
            return false;
        }
        TRefferal other = (TRefferal) object;
        if ((this.lgReferralId == null && other.lgReferralId != null) || (this.lgReferralId != null && !this.lgReferralId.equals(other.lgReferralId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngai.mo.bill.model.entity.TRefferal[ lgReferralId=" + lgReferralId + " ]";
    }
    
}
