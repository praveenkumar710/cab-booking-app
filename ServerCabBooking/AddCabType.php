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
	with(thisform)
	{	    
		if(mcharge.value=="")
		{ 
		alert("Please Enter Minimum Bill Charge...!")
		mcharge.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(fkm.value=="")
		{ 
		alert("Please Enter Free KMs...!")
		fkm.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(wchagre.value=="")
		{ 
		alert("Please Enter Waiting Charge...!")
		wcharge.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(echarge.value=="")
		{ 
		alert("Please Enter Extra Charge...!")
		echarge.focus();
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
      <div id="title">ADD CAB TYPE</div>
      <div id="work">
      	<form action="actionCabService.php" method="post" onSubmit="return validation(this);">
        <input type="hidden" name="avalue" value="7"/>
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
      <div align="center">
        <input type="text" name="mcharge" id="txt1" placeholder="Minimum Bill Charge">
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
        <input type="text" name="fkm" id="txt1" placeholder="Free KMs">
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
        <input type="text" name="wcharge" id="txt1" placeholder="Waiting Charges">
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
        <input type="text" name="echarge" id="txt1" placeholder="Extra Per KM Charge">
      </div></td>
  </tr>
  <tr>
    <td><div align="center">
      <input type="submit" name="Add" id="btn1" value="Add Cab Type">
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
		<li><a href="CabService.php">Add City</a></li>
        <li><a href="ViewCity.php">View City</a></li>
        <li><a href="AddArea.php">Add Area</a></li>	
        <li><a href="ViewArea.php">View Area</a></li>	
        <li><a href="AddCab.php">Add Cab</a></li>		
		<li><a href="ViewCab.php">View Cab</a></li>	
         <li><a href="AddCabType.php" class="active">Add Cab Type</a></li>	
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
