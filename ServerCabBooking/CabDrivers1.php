<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>An Efficient Android App Monitoring For Cab Booking And Servicing</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
<script language="javascript">
function validation(thisform)
{
	with(thisform)
	{	    
		if(cname.value=="")
		{ 
		alert("Please Select City Name...!")
		cname.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(cartype.value=="")
		{ 
		alert("Please Select Car Type...!")
		cartype.focus();
		return false 
		}
	}
}
</script>
</head>

<body>
<div id="header">	
</div>
<div id="content">
	<div id="colOne">
	  <div id="ihome4">
      <div id="title">ADD CAB DRIVER DETAILS</div>
      <div id="work">
      	<form action="actionCabService.php" method="post" onSubmit="return validation(this);">
        <input type="hidden" name="avalue" value="8"/>
        	<table width="194" height="112" border="0" align="center">
  <tr>
    <td>
      <div align="center">
        <select name="cname" id="txt1">
       		<option value="">City Name</option> 
            <?php	 		
 			include('dbcon.php');			
			$result=mysql_query("select * from city_name");
			while($rs = mysql_fetch_assoc($result))
			{
			?>
     		<option value="<?php echo $rs['cname']; ?>"><?php echo $rs['cname']; ?></option>      	
        	<?php
			}
			?>            
     	</select>      
      </div></td>
  </tr>
  <tr>
    <td><div align="center">
      <select name="cartype" id="txt1">
        	<option value="">Cab Type</option>
     		<option value="Hatchback">Hatchback</option> 
           	<option value="Sedan">Sedan</option> 
            <option value="Crossover">Crossover</option>
            <option value="Convertible">Convertible</option> 
        </select>
    </div></td>
  </tr> 
   <tr>
    <td>
      <div align="center">Driver Details</div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
        <input type="text" name="did" id="txt1" value="<?php echo $_POST['did']; ?>" readonly/>
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
         <input type="text" name="dname" id="txt1" value="<?php echo $_POST['name']; ?>" readonly/>
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
        <input type="text" name="lno" id="txt1" value="<?php echo $_POST['lno']; ?>" readonly/>
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
         <input type="text" name="cno" id="txt1" value="<?php echo $_POST['cno']; ?>" readonly/>
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
         <input type="text" name="email" id="txt1" value="<?php echo $_POST['email']; ?>" readonly/>
      </div></td>
  </tr>
  <tr>
    <td><div align="center">
      <input type="submit" name="Add" id="btn1" value="Add Driver">
    </div></td>
  </tr> 
</table>
        </form>
      </div>
      </div>	
	</div>
	<div id="colTwo">
    <h2>Menu</h2>				
	<ul>		
		<li><a href="Drivers.php" class="active">Drivers Details</a></li>
        <li><a href="AuthorizedDrivers.php">Authorized Drivers</a></li>
        <li><a href="CabDrivers.php">Cab Drivers</a></li>	
        <li><a href="ViewCabDrivers.php">View Cab Drivers</a></li>       	
        <li><a href="SHome.php">Back</a></li>
	</ul>	
	</div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">	
</div>
<div align=center></div></body>
</html>
