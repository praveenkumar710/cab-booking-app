<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>An Efficient Android App Monitoring For Cab Booking And Servicing</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript">
function validation(thisform)
{
	with(thisform)
	{	    
		if(lid.value=="")
		{ 
		alert("Please Enter Server Login ID...!")
		lid.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(lpass.value=="")
		{ 
		alert("Please Enter Server Login Password...!")
		lpass.focus();
		return false 
		}
	}
}
</script>
<body>
<div id="header">
	
</div>
<div id="content">
	<div id="colOne">
	  <div id="ihome2">
	    <div id="login">
        	<div id="limg"></div>
            <div id="ltable">
            	<form action="actionServer.php" method="post" onSubmit="return validation(this);">                	
                	<input name="lid" type="text" id="txt" placeholder="Server ID">
                    <input name="lpass" type="password" id="txt" placeholder="Server Password">
                    <input type="hidden" name="avalue" value="1" />
                    <input name="Signin" type="submit" value="Signin" id="btn">
                </form>
            </div>
        </div>
	  </div>	
	</div>
	<div id="colTwo">
    <h2>Menu</h2>				
	<ul>
		<li><a href="index.php">Home</a></li>
		<li><a href="Server.php" class="active">Cab Server</a></li>		
		<li><a href="About.php">About Us</a></li>
		<li><a href="Contact.php">Contact</a></li>
	</ul>	
	</div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">	
</div>
<div align=center></div></body>
</html>
