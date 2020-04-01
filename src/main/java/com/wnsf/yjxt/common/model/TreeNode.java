package com.wnsf.yjxt.common.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树的节点模型
 */
public class TreeNode {

    private Integer id; //节点id

    private String name;//节点名称

    private Integer parentId;//父几点的id

    // 子节点
    private List<TreeNode> children = new ArrayList<>();
    //节点的状态
    private Boolean state;

    private String url;
    private String icon;
    //路径
    private String path;
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state){
        this.state = state;
    }
}
