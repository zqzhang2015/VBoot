package cn.mrain22.vboot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author mrain22
 * @since 2018-08-31
 */
@TableName("vb_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 路径
     */
    private String path;
    /**
     * 需要的组件
     */
    private String component;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 图标
     */
    @TableField("iconCls")
    private String iconCls;
    /**
     * 是否是菜单（指的是在首页是不是菜单1：是；0：不是）
     */
    private Integer ismenu;
    /**
     * 是否keepAlive
     */
    @TableField("keepAlive")
    private Integer keepAlive;
    /**
     * 是否需要验证
     */
    @TableField("requireAuth")
    private Integer requireAuth;
    /**
     * 父级id
     */
    private Integer parentid;
    /**
     * 是否激活
     */
    private Integer enabled;

    /**
     * 子菜单的集合
     */
    private List<Menu> children;

    private List<Role> roles;

    private MenuMeta meta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    public Integer getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Integer keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Integer getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Integer requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "Menu{" +
        ", id=" + id +
        ", path=" + path +
        ", component=" + component +
        ", name=" + name +
        ", iconCls=" + iconCls +
        ", ismenu=" + ismenu +
        ", keepAlive=" + keepAlive +
        ", requireAuth=" + requireAuth +
        ", parentid=" + parentid +
        ", enabled=" + enabled +
        ", children=" + children +
        ", meta=" + meta +
        ", roles=" + roles +
        "}";
    }
}
