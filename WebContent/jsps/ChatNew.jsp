<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Chat</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type"
			content="text/html; charset=ISO-8859-1">

		<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

	</head>








	<frameset rows="65%,35%" frameborder='0' framespacing='0'>
		<noframes>
			sorry,you need frames to use chat.
		</noframes>

		<frame name="_display"
			src="<%=request.getContextPath() + "./Chat.jsp?t=1"%>">
		<frame name="_data" src="<%=request.getContextPath() + "./Chat.jsp"%>">
		<frame name="_data"
			src="<%=request.getContextPath()
					+ "./AlreadyStartedforum.jsp"%>">


	</frameset>
	<p>
		<input type="button" name="button" id="button" value="back"
			onclick="javascript:history.back(-1)" />
	</p>
	<body>
	</body>
</html>
