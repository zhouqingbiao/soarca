package com.soarca.application.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "FY_CLFHT", name = "TPE_ZRHTQD")
public class LaClfhtTpeZrhtqd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Long zrhtcode;

	@Column
	private String htbh;

	@Column
	private Long htdxid;

	@Column
	private Long fwcode;

	@Column
	private String fwzl;

	@Column
	private Double htmj;

	@Column
	private Long htje;

	@Column
	private Date htqdsj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getZrhtcode() {
		return zrhtcode;
	}

	public void setZrhtcode(Long zrhtcode) {
		this.zrhtcode = zrhtcode;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public Long getHtdxid() {
		return htdxid;
	}

	public void setHtdxid(Long htdxid) {
		this.htdxid = htdxid;
	}

	public Long getFwcode() {
		return fwcode;
	}

	public void setFwcode(Long fwcode) {
		this.fwcode = fwcode;
	}

	public String getFwzl() {
		return fwzl;
	}

	public void setFwzl(String fwzl) {
		this.fwzl = fwzl;
	}

	public Double getHtmj() {
		return htmj;
	}

	public void setHtmj(Double htmj) {
		this.htmj = htmj;
	}

	public Long getHtje() {
		return htje;
	}

	public void setHtje(Long htje) {
		this.htje = htje;
	}

	public Date getHtqdsj() {
		return htqdsj;
	}

	public void setHtqdsj(Date htqdsj) {
		this.htqdsj = htqdsj;
	}
}
