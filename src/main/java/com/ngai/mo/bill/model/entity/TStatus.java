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
@Table(name = "t_status")
@NamedQueries({
    @NamedQuery(name = "TStatus.findAll", query = "SELECT t FROM TStatus t"),
    @NamedQuery(name = "TStatus.findByLgStatusId", query = "SELECT t FROM TStatus t WHERE t.lgStatusId = :lgStatusId"),
    @NamedQuery(name = "TStatus.findByStrexternalId", query = "SELECT t FROM TStatus t WHERE t.strexternalId = :strexternalId"),
    @NamedQuery(name = "TStatus.findByStatus", query = "SELECT t FROM TStatus t WHERE t.status = :status"),
    @NamedQuery(name = "TStatus.findByStrExternalCode", query = "SELECT t FROM TStatus t WHERE t.strExternalCode = :strExternalCode"),
    @NamedQuery(name = "TStatus.findByDtCreated", query = "SELECT t FROM TStatus t WHERE t.dtCreated = :dtCreated")})
public class TStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_status_id")
    private String lgStatusId;
    @Column(name = "str_externalId")
    private String strexternalId;
    @Column(name = "status")
    private String status;
    @Column(name = "str_external_code")
    private String strExternalCode;
    @Column(name = "dt_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @JoinColumn(name = "lg_trace_id", referencedColumnName = "lg_trace_id")
    @ManyToOne
    private TTrace lgTraceId;

    public TStatus() {
    }

    public TStatus(String lgStatusId) {
        this.lgStatusId = lgStatusId;
    }

    public String getLgStatusId() {
        return lgStatusId;
    }

    public void setLgStatusId(String lgStatusId) {
        this.lgStatusId = lgStatusId;
    }

    public String getStrexternalId() {
        return strexternalId;
    }

    public void setStrexternalId(String strexternalId) {
        this.strexternalId = strexternalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrExternalCode() {
        return strExternalCode;
    }

    public void setStrExternalCode(String strExternalCode) {
        this.strExternalCode = strExternalCode;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public TTrace getLgTraceId() {
        return lgTraceId;
    }

    public void setLgTraceId(TTrace lgTraceId) {
        this.lgTraceId = lgTraceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgStatusId != null ? lgStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TStatus)) {
            return false;
        }
        TStatus other = (TStatus) object;
        if ((this.lgStatusId == null && other.lgStatusId != null) || (this.lgStatusId != null && !this.lgStatusId.equals(other.lgStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngai.mo.bill.model.entity.TStatus[ lgStatusId=" + lgStatusId + " ]";
    }
    
}
