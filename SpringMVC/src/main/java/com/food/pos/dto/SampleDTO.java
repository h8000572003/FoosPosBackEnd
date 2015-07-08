
package com.food.pos.dto;

import java.io.Serializable;

/**
 * 前端畫面DTO物件
 * 
 * @author Administrator 在 2012/12/6 建立
 */
public class SampleDTO implements Serializable {

    /**
     * <code>serialVersionUID</code> 的註解
     */
    private static final long serialVersionUID = -6595487017171826542L;

    private Long personId;

    private String personName;

    private String personBirthday;

    private String personPhone;

    private String personEmail;

    public SampleDTO() {
    }

    /**
     * @return 傳回 id。
     */
    public final Long getId() {
        return this.personId;
    }

    /**
     * @param id
     *            要設定的 id。
     */
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
     * @return 傳回 birdhday。
     */
    public final String getBirdhday() {
        return this.personBirthday;
    }

    /**
     * @param birdhday
     *            要設定的 birdhday。
     */
    public final void setBirdhday(final String birdhday) {
        this.personBirthday = birdhday;
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

    /**
     * @return 傳回 eMail。
     */
    public final String getEMail() {
        return this.personEmail;
    }

    /**
     * @param eMail
     *            要設定的 eMail。
     */
    public final void setEMail(final String eMail) {
        this.personEmail = eMail;
    }

}
