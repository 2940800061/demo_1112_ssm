<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.contextPath}/" />
	<meta charset="UTF-8">
	<title>添加用戶</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/input.css" />
	<script src="js/jquery.min.js"></script>
</head>
<body>


	<header>
		<a href="javascript:history.back()"><i class="glyphicon glyphicon-chevron-left" title="返回"></i></a>
	</header>
	<article>
		<form id="form" method="post" action="user/update.do" class="form-inline">
			<dl>
				<dt style="font-size: 15px;">信息修改</dt>
				<dd hidden="hidden"><label>用戶ID:</label>
					<input type="text" id="accountId" name="accountId" value="${account.accountId}"/></dd>
				<dd><label>用戶名&ensp;:</label>
					<input type="text" id="accountName" name="accountName" placeholder="${account.accountName}"
					       required autofocus class="form-control input" /></dd>
				<dd><label>初始密码:</label>
					<input type="text" id="accountPassword" name="accountPassword" placeholder="${account.accountPassword} "
						   required autofocus class="form-control input" /></dd>
				<dd><label>用戶性别:</label>
					<input type="text" id="accountGender" name="accountGender" placeholder="${account.accountGender}"
						   required autofocus class="form-control input" /></dd>
				<dd class="btn-groups">
					<input type="submit" value="确定" class="btn btn-primary" />
					<input type="reset" value="重置" class="btn btn-success" /> 
				</dd>
			</dl>
		</form>
	</article>
</body>
</html>