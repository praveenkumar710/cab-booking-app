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
		if(cname.value=="")
		{ 
		alert("Please Enter City Name...!")
		cname.focus();
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
	  <div id="ihome4">
      <div id="title">ADD CITY</div>
      <div id="work">
      	<form action="actionCabService.php" method="post" onSubmit="return validation(this);">
        <input type="hidden" name="avalue" value="1"/>
        	<table width="194" height="112" border="0" align="center">
  <tr>
    <td>
      <div align="center">
        <input type="text" name="cname" id="txt1" placeholder="Enter City Name">
      </div></td>
  </tr>
  <tr>
    <td><div align="center">
      <input type="submit" name="Add" id="btn1" value="Add City">
    </div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
        </form>
        </div>
      </div>	
	</div>
	<div id="colTwo">
    <h2>Menu</h2>				
	<ul>		
		<li><a href="CabService.php" class="active">Add City</a></li>
        <li><a href="ViewCity.php">View City</a></li>
        <li><a href="AddArea.php">Add Area</a></li>	
        <li><a href="ViewArea.php">View Area</a></li>	
        <li><a href="AddCab.php">Add Cab</a></li>		
		<li><a href="ViewCab.php">View Cab</a></li>	
        <li><a href="AddCabType.php">Add Cab Type</a></li>	
        <li><a href="ViewCabType.php">View Cab Type</a></li>		
        <li><a href="SHome.php">Back</a></li>
	</ul>	
	</div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">	
</div>
<div align=center></div></body>
</html>
