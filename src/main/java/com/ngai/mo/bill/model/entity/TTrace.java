/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngai.mo.bill.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SOFT
 */
@Entity
@Table(name = "t_trace")
@NamedQueries({
    @NamedQuery(name = "TTrace.findAll", query = "SELECT t FROM TTrace t"),
    @NamedQuery(name = "TTrace.findByLgTraceId", query = "SELECT t FROM TTrace t WHERE t.lgTraceId = :lgTraceId"),
    @NamedQuery(name = "TTrace.findByIntAmount", query = "SELECT t FROM TTrace t WHERE t.intAmount = :intAmount"),
    @NamedQuery(name = "TTrace.findByStatus", query = "SELECT t FROM TTrace t WHERE t.status = :status"),
    @NamedQuery(name = "TTrace.findByDtCreated", query = "SELECT t FROM TTrace t WHERE t.dtCreated = :dtCreated")})
public class TTrace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_trace_id")
    private String lgTraceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "int_amount")
    private Double intAmount;
    @Column(name = "status")
    private String status;
    @Column(name = "dt_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @OneToMany(mappedBy = "lgTraceId")
    private List<TStatus> tStatusList;
    @JoinColumn(name = "lg_provider_id", referencedColumnName = "lg_provider_id")
    @ManyToOne
    private TPaymentMethods lgProviderId;

    public TTrace() {
    }

    public TTrace(String lgTraceId) {
        this.lgTraceId = lgTraceId;
    }

    public String getLgTraceId() {
        return lgTraceId;
    }

    public void setLgTraceId(String lgTraceId) {
        this.lgTraceId = lgTraceId;
    }

    public Double getIntAmount() {
        return intAmount;
    }

    public void setIntAmount(Double intAmount) {
        this.intAmount = intAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public List<TStatus> getTStatusList() {
        return tStatusList;
    }

    public void setTStatusList(List<TStatus> tStatusList) {
        this.tStatusList = tStatusList;
    }

    public TPaymentMethods getLgProviderId() {
        return lgProviderId;
    }

    public void setLgProviderId(TPaymentMethods lgProviderId) {
        this.lgProviderId = lgProviderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgTraceId != null ? lgTraceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTrace)) {
            return false;
        }
        TTrace other = (TTrace) object;
        if ((this.lgTraceId == null && other.lgTraceId != null) || (this.lgTraceId != null && !this.lgTraceId.equals(other.lgTraceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngai.mo.bill.model.entity.TTrace[ lgTraceId=" + lgTraceId + " ]";
    }
    
}
