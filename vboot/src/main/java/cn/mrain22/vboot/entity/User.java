package cn.mrain22.vboot.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author mrain22
 * @since 2018-08-30
 */
@TableName("vb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 用户名（用于登录，不能为空）
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 地址
     */
    private String address;
    /**
     * 是否过期（1：true；0：false）
     */
    private Integer expired;
    /**
     * 是否锁定
     */
    private Integer locked;
    /**
     * 是否激活
     */
    private Integer enabled;
    /**
     * 是否删除
     */
    private Integer delete;
    /**
     * 创建人
     */
    private String createbyid;
    /**
     * 创建时间
     */
    private Date createdate;
    /**
     * 修改人id
     */
    private String updatebyid;
    /**
     * 修改时间
     */
    private Date updatedate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getCreatebyid() {
        return createbyid;
    }

    public void setCreatebyid(String createbyid) {
        this.createbyid = createbyid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUpdatebyid() {
        return updatebyid;
    }

    public void setUpdatebyid(String updatebyid) {
        this.updatebyid = updatebyid;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", name=" + name +
        ", username=" + username +
        ", password=" + password +
        ", address=" + address +
        ", expired=" + expired +
        ", locked=" + locked +
        ", enabled=" + enabled +
        ", delete=" + delete +
        ", createbyid=" + createbyid +
        ", createdate=" + createdate +
        ", updatebyid=" + updatebyid +
        ", updatedate=" + updatedate +
        "}";
    }
}
