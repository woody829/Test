<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE HTML>
<html>
<head>
    <title>Form表单</title>

<script type="text/javascript">
    $(function() {
        $("#form1").submit(function (){
            $('#submit').attr('disabled',"true");

            var t = "${pageContext.request.contextPath}";
            var url = t + "/DoFormServlet";
            //alert(url);
            $.ajax({
                type: 'get',
                url: url,
                cache: false,
                async: true,
                data: {
                    username: $("#username").val()
                },
                success: function (result) {
                    alert('bingo');
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    // 状态码
                    alert(XMLHttpRequest.status);
                    // 状态
                    alert(XMLHttpRequest.readyState);
                    // 错误信息
                    alert(XMLHttpRequest.responseText);
                    alert(XMLHttpRequest.statusText);
                }
            });
        });
    })
</script>
</head>

<body>
<form id="form1" action="">
    用户名：<input type="text" id="username" name="username">
    <input type="submit" value="提交" id="submit" >
</form>
</body>
</html>