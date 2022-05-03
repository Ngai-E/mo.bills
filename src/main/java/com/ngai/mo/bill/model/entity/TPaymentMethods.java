/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngai.mo.bill.model.entity;

import java.io.Serializable;
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
@Table(name = "t_payment_methods")
@NamedQueries({
    @NamedQuery(name = "TPaymentMethods.findAll", query = "SELECT t FROM TPaymentMethods t"),
    @NamedQuery(name = "TPaymentMethods.findByLgProviderId", query = "SELECT t FROM TPaymentMethods t WHERE t.lgProviderId = :lgProviderId"),
    @NamedQuery(name = "TPaymentMethods.findByIntMinAmountDeposit", query = "SELECT t FROM TPaymentMethods t WHERE t.intMinAmountDeposit = :intMinAmountDeposit"),
    @NamedQuery(name = "TPaymentMethods.findByIntMaxAmountDeposit", query = "SELECT t FROM TPaymentMethods t WHERE t.intMaxAmountDeposit = :intMaxAmountDeposit")})
public class TPaymentMethods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_provider_id")
    private Integer lgProviderId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "int_min_amount_deposit")
    private Double intMinAmountDeposit;
    @Column(name = "int_max_amount_deposit")
    private Double intMaxAmountDeposit;
    @OneToMany(mappedBy = "lgProviderId")
    private List<TTrace> tTraceList;

    public TPaymentMethods() {
    }

    public TPaymentMethods(Integer lgProviderId) {
        this.lgProviderId = lgProviderId;
    }

    public Integer getLgProviderId() {
        return lgProviderId;
    }

    public void setLgProviderId(Integer lgProviderId) {
        this.lgProviderId = lgProviderId;
    }

    public Double getIntMinAmountDeposit() {
        return intMinAmountDeposit;
    }

    public void setIntMinAmountDeposit(Double intMinAmountDeposit) {
        this.intMinAmountDeposit = intMinAmountDeposit;
    }

    public Double getIntMaxAmountDeposit() {
        return intMaxAmountDeposit;
    }

    public void setIntMaxAmountDeposit(Double intMaxAmountDeposit) {
        this.intMaxAmountDeposit = intMaxAmountDeposit;
    }

    public List<TTrace> getTTraceList() {
        return tTraceList;
    }

    public void setTTraceList(List<TTrace> tTraceList) {
        this.tTraceList = tTraceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgProviderId != null ? lgProviderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPaymentMethods)) {
            return false;
        }
        TPaymentMethods other = (TPaymentMethods) object;
        if ((this.lgProviderId == null && other.lgProviderId != null) || (this.lgProviderId != null && !this.lgProviderId.equals(other.lgProviderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngai.mo.bill.model.entity.TPaymentMethods[ lgProviderId=" + lgProviderId + " ]";
    }
    
}
