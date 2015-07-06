package com.food.pos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "PERSON")
public class SamplePO implements Comparable<SamplePO> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long personId;

	@Column(name = "NAME")
	private String personName;

	@Column(name = "PHONE")
	private String personPhone;

	public SamplePO() {
	}

	public final Long getId() {
		return this.personId;
	}

	public final void setId(final Long id) {
		this.personId = id;
	}

	/**
	 * @return 傳回 name。
	 */
	public final String getName() {
		return this.personName;
	}

	/**
	 * @param name
	 *            要設定的 name。
	 */
	public final void setName(final String name) {
		this.personName = name;
	}

	/**
	 * @return 傳回 phone。
	 */
	public final String getPhone() {
		return this.personPhone;
	}

	/**
	 * @param phone
	 *            要設定的 phone。
	 */
	public final void setPhone(final String phone) {
		this.personPhone = phone;
	}

	@Override
	public final int compareTo(final SamplePO o) {
		return this.getId().compareTo(o.getId());
	}

	@Override
	public final boolean equals(final Object obj) {
		return true;
	}

	@Override
	public final int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
