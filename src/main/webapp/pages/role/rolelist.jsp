<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.contextPath}/" />
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/list.css" />
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
	<!-- 新 Bootstrap4 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
	<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script>
		/**
		 * desc: 分页
		 */
		function pageQuery(pageNum) {
			//设置提交的请求参数
			$('#form1 p input[name=sroleName]').val($('#sroleName').val());
			$('#pageNum').val(pageNum);
			//提交表单
			$('#form1').get(0).submit();
		}
	

       //删除点击事件
	    function deleting() {
			var count =$('#form2 input[name="check"]:checked ').length;
			if (count<1){
				alert("提示","请选择要删除的数据");
				return;
			}
	    	var ids= [];
			 ids = $("input:checkbox[name='check']:checked").map(function(index,elem) {
				return $(elem).val();
			}).get().join(',');

            if(!confirm("确定要删除选择的数据？")) {
            	return;
			}
             var roleName=$("#form1 #sroleName").val();
             var pageNum=$("#form1 #pageNum").val();
			location.href = "role/delete.do?ids="+ids+"&roleName="+roleName+"&pageNum="+pageNum;
		}
		function deletone(ids) {
			if(!confirm("确定要删除选择的数据？")) {
				return;
			}
			var roleName=$("#form1 #sroleName").val();
			var pageNum=$("#form1 #pageNum").val();
			location.href = "role/delete.do?ids="+ids+"&roleName="+roleName+"&pageNum="+pageNum;

		}


		/**
		 * desc: 添加
		 */
		function  add() {
			location.href = "role/addview.do";
		}
         //全选框点击事件
		function allCheck(){
			var status=$("#allcheck").checked;
			var btn=$("#check");
			for(var i=0;i<btn.length;i++){
				btn[i].checked=status;
			}
		}
	</script>
</head>
<body>
	<header>
		<form id="form1" method="post" action="role/query.do" class="form-inline">
			<section class="form-group">
				<p><input type="text"  name="sroleName" placeholder="按角色名搜索!"  value="${param.sroleName }"
					class="form-control" /></p>
				<input type="submit" value="搜索"  class="btn btn-success"/>
					<input type="hidden" id="sroleName" value="${param.sroleName }" />
					<input type="hidden" id="pageNum" name="pageNum" value="${pageInfo.pageNum}" />
			</section>
		</form>
	</header>
	<article>
		<form id="form2" method="post" action="">
			<table class="table table-hover table-bordered">
				<tr>
					<th><input type="checkbox" id="allcheck" onclick="allCheck()" /></th>
					<th>序号</th>
					<th>角色名</th>
					<th>操作人</th>
					<th>操作时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="role" items="${list}" varStatus="status">
					<tr>
						<td><input type="checkbox" id="check" name="check" value="${role.roleId }" /></td>
						<td>${(pageInfo.pageNum-1)*pageInfo.pageSize + status.count }</td>
						<td>${role.roleName }</td>
						<td>${role.operUser }</td>
						<td><fmt:formatDate value="${role.operTime }" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
						<td>
							<a href="javascript:void(0);" ><i class="glyphicon glyphicon-edit edit"></i>
								修改</a>
							<a href="javascript:void(0);" onclick="deletone(${role.roleId})" >
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
				<button class="btn btn-primary" onclick="add()" >
					<i class="glyphicon glyphicon-plus"></i>&nbsp;添加</button>
				<button class="btn btn-danger" onclick="deleting();">
					<i class="glyphicon glyphicon-trash"></i>&nbsp;批量删除</button>
			</section>
			<section class="page-info">
				共${pageInfo.total}行, 第${pageInfo.pageNum }/
				<c:if test="${pageInfo.pages}< 1">1
				</c:if>
				${pageInfo.pages}
				页
			</section>
			<section class="page-bar">
				<c:forEach var="pageNum" items="${pageInfo.navigatepageNums }">
					<a href="javascript:void(0);" onclick="pageQuery(${pageNum});" 
						${pageNum==pageInfo.pageNum ? 'class="active"' : '' }>${pageNum }</a>
				</c:forEach>
			</section>
		</section>
	</article>
	<!-- 修改按钮：用于打开模态框 -->
	<div class="container">
		<!-- 模态框 -->
		<div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- 模态框头部 -->
					<div class="modal-header">
						<h4 class="modal-title">添加角色</h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span></button>
					</div>
					<!-- 模态框主体 -->
					<div class="modal-body">
						<form class="form-horizontal" action="role/add.do" method="post" >
							<p>
							 <label class="col-sm-2 control-label">角色名:</label>
								<input type="text" name="roleName" id="roleName" placeholder="角色名">
						</p>
							<p>
								<input type="reset" class="btn btn-danger">
								<input type="submit" value="确认添加" class="btn btn-success">
							</p>
						</form>
					</div>
					<!-- 模态框底部 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
								data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>