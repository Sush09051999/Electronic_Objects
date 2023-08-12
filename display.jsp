<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% double total=(double)request.getAttribute("total");
int database=(int)request.getAttribute("database");
int original=(int)request.getAttribute("originalQ");
if(database>=original)
{%>
<h1> Final bill amount is <%=total %></h1>
<% 	
}
else
{%>
<h1> Out Of Stock</h1>
<% }
%>



</body>
</html>