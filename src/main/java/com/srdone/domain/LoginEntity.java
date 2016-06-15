package com.srdone.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by lszakacs on 0008, June 08, 2016.
 */
@Entity
@Table(name = "LOGIN", schema = "MEMODEV", catalog = "B2077B7W")
public class LoginEntity {
    private int loginId;
    private String userId;
    private String password;
    private int attempts;
    private String reserved;
    private Date lastSignOnDate;
    private Time lastSignOnTime;

    @Id
    @Column(name = "LOGIN_ID", nullable = false)
    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ATTEMPTS", nullable = false)
    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Basic
    @Column(name = "RESERVED", nullable = true, length = 100)
    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    @Basic
    @Column(name = "LAST_SIGN_ON_DATE", nullable = true)
    public Date getLastSignOnDate() {
        return lastSignOnDate;
    }

    public void setLastSignOnDate(Date lastSignOnDate) {
        this.lastSignOnDate = lastSignOnDate;
    }

    @Basic
    @Column(name = "LAST_SIGN_ON_TIME", nullable = true)
    public Time getLastSignOnTime() {
        return lastSignOnTime;
    }

    public void setLastSignOnTime(Time lastSignOnTime) {
        this.lastSignOnTime = lastSignOnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEntity that = (LoginEntity) o;

        if (loginId != that.loginId) return false;
        if (attempts != that.attempts) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (reserved != null ? !reserved.equals(that.reserved) : that.reserved != null) return false;
        if (lastSignOnDate != null ? !lastSignOnDate.equals(that.lastSignOnDate) : that.lastSignOnDate != null)
            return false;
        if (lastSignOnTime != null ? !lastSignOnTime.equals(that.lastSignOnTime) : that.lastSignOnTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + attempts;
        result = 31 * result + (reserved != null ? reserved.hashCode() : 0);
        result = 31 * result + (lastSignOnDate != null ? lastSignOnDate.hashCode() : 0);
        result = 31 * result + (lastSignOnTime != null ? lastSignOnTime.hashCode() : 0);
        return result;
    }
}
