<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception handling</title>
</head>
<body>
<h1>${errormsg }</h1>
<h3>返回
<a href=${address }  style="width:80px;height:35px;line-height:35px;font-size:1rem">
<% if(request.getAttribute("address").equals("logreg.jsp")){
    out.print("返回Home页面");
    }else{
        out.print("返回index页面");
    } %></a>

</h3></body>
</html>