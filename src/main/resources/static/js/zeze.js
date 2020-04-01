/**
 * 啧啧封装的一些方法
 */
var zeze = function () {};

/**
 *  构建zTree
 * @param{string} ztreeId
 * @param{string}url   请求的路径
 * @param{string} data 用户的id
 */
zeze.zTree=function(ztreeId,url,data){
    //拼接url
    if (zeze.isEmpty(data)){
        url=url;
    }else{
        url=url+'/'+data;
    }
    var control = $('#' + ztreeId);
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        check: {
            enable: true,//是否每个节点上显示选择框
            chkStyle: "checkbox",//复选框类型
            idKey: "id",
            pIdKey: "pid",
        },
        //简单json格式
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    $(document).ready(function () {
        //复选框树的初始化
        $.ajax({
            url: url,
            async: false,
            type: "get",
            success: function (data) {
                var nodes = data;
                // 3、创建树
                $.fn.zTree.init(control, setting, nodes);
            }
        });

    });

}

/**
 *  关闭layer
 * @param{String} data 返回的的数据
 * @param{String} tableId 刷新的表格id字符串
 */
zeze.layermsg=function(data,tableId){
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
    parent.layer.msg(data, {icon: 1, time: 1000,offset:'100px'})
    parent.$('#'+tableId).bootstrapTable('refresh');//表格刷新
}

/**
 * 获取zTree选中的节点数组
 * @param zTreeId
 * @returns {[]}
 */
zeze.getRoleIds=function getRoleIds(zTreeId){
    //获取zTree对象
    var treeObj = $.fn.zTree.getZTreeObj(zTreeId);
    //获取选中的节点
    var nodes = treeObj.getCheckedNodes(true);
    //选中的id
    var roleIds=[];
    for (var i=0;i<nodes.length;i++) {
        roleIds.push(nodes[i].id);
    }
    return roleIds;
}
/**
 *
 * @param title 标题
 * @param url 请求的地址
 * @param width 宽度
 * @param height
 */
zeze.open_add = function (title,url,width, height,) {
    if (zeze.isMobile()){
        width = 'auto';
        height = 'auto';
    }
    if (zeze.isEmpty(width)){
        width = 800;
    }
    if(zeze.isEmpty(height)){
        height = ($(window).height() - 50);
    }
     layer.open({
             id: 'LAY_layuipro', //设定一个id，防止重复弹出
            type: 2,
            title: title,
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: [width+'px', height+'px'],
            content: url,
            btn: ['确定', '关闭'],
            yes: function(index, layero){
                var body = layer.getChildFrame('body', index); //得到iframe页面层的BODY
                var iframeBtn = body.find('#save');//得到iframe页面层的提交按钮
                iframeBtn.click();//模拟iframe页面层的提交按钮点击
            },
        });

}
// 判断移动端
zeze.isMobile=function () {
    return navigator.userAgent.match(/(Android|iPhone|SymbianOS|Windows Phone|iPad|iPod)/i);
}
// 判断字符串是否为空
zeze.isEmpty=function (value) {
    if (value == null||zeze.trim(value)=='') {
        return true;
    }
    return false;
}
// 空格截取
zeze.trim= function (value) {
    if (value == null) {
        return "";
    }
    return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
}