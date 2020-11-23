<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/list.css"/>
    <script src="js/jquery.min.js"></script>
    <script>
        /**
         * desc: 分页
         */
        function pageQuery(pageNum) {
            //设置提交的请求参数
            $('#form1 p input[name=accountName]').val($('#accountName').val());
            $('#pageNum').val(pageNum);
            //提交表单
            $('#form1').get(0).submit();
        }

        //删除点击事件
        function deleting() {
            var count = $('#form2 input[name="check"]:checked ').length;
            if (count < 1) {
                alert("请选择要删除的数据");
                return;
            }
            var ids = [];
            ids = $("input:checkbox[name='check']:checked").map(function (index, elem) {
                return $(elem).val();
            }).get().join(',');

            if (!confirm("确定要删除选择的数据？")) {
                return;
            }
            var accountName = $("#form1 #accountName").val();
            var pageNum = $("#form1 #pageNum").val();
            location.href = "user/delete.do?ids=" + ids + "&accountName=" + accountName + "&pageNum=" + pageNum;
        }

        function deletone(ids) {
            if (!confirm("确定要删除选择的数据？")) {
                return;
            }
            var accountName = $("#form1 #accountName").val();
            var pageNum = $("#form1 #pageNum").val();
            location.href = "user/delete.do?ids=" + ids + "&accountName=" + accountName + "&pageNum=" + pageNum;

        }

        function add() {
            location.href = "user/addview.do";
        }
    </script>
</head>
<body>
<header>
    <form id="form1" method="post" action="user/query.do" class="form-inline">
        <section class="form-group">
            <p><input type="text" name="accountName" placeholder="按用户名搜索!" value="${param.accountName}"
                      class="form-control"/></p>
            <input type="submit" value="搜索" class="btn btn-success"/>
            <input type="hidden" id="accountName" value="${param.accountName }"/>
            <input type="hidden" id="pageNum" name="pageNum" value="${pageInfo.pageNum}"/>
        </section>
    </form>
</header>
<article>
    <form id="form2" method="post">
        <table class="table table-hover table-bordered">
            <tr>
                <th><input type="checkbox" id="allcheck"/></th>
                <th>序号</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>性别</th>
                <th>操作时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="ac" items="${list}" varStatus="status">
                <tr>
                    <td><input type="checkbox" id="check" name="check" value="${ac.accountId }"/></td>
                    <td>${(pageInfo.pageNum-1)*pageInfo.pageSize + status.count }</td>
                    <td>${ac.accountName }</td>
                    <td>${ac.accountPassword }</td>
                    <td>${ac.accountGender }</td>
                    <td><fmt:formatDate value="${ac.operTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                    <td>
                        <a href="user/updateview.do?id=${ac.accountId}">
                            <i class="glyphicon glyphicon-edit edit"></i>修改</a>
                        <a href="javascript:void(0);" onclick="deletone(${ac.accountId})">
                            <i class="glyphicon glyphicon-remove remove"></i>删除</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${requestScope.list.size()==0 }">
                <tr>
                    <td colspan="6">未查找到数据!</td>
                </tr>
            </c:if>
        </table>
    </form>
    <section>
        <section class="btn-groups">
            <button class="btn btn-primary" onclick="add()">
                <i class="glyphicon glyphicon-plus"></i>&nbsp;添加
            </button>
            <button class="btn btn-danger" onclick="deleting()">
                <i class="glyphicon glyphicon-trash"></i>&nbsp;批量删除
            </button>
        </section>
        <section class="page-info">
            共${pageInfo.total}行, 第${pageInfo.pageNum }/
            <c:if test="${pageInfo.pages}< 1">1
            </c:if>
            ${pageInfo.pages}
        </section>
        <section class="page-bar">
            <c:forEach var="pageNum" items="${pageInfo.navigatepageNums }">
                <a href="javascript:void(0);" onclick="pageQuery(${pageNum});"
                    ${pageNum==pageInfo.pageNum ? 'class="active"' : '' }>${pageNum }</a>
            </c:forEach>
        </section>
    </section>
</article>
</body>
</html>