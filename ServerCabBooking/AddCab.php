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
		if(cartype.value=="")
		{ 
		alert("Please Select Car Type...!")
		cartype.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(carname.value=="")
		{ 
		alert("Please Enter Car Name...!")
		carname.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(carno.value=="")
		{ 
		alert("Please Enter Car Number...!")
		carno.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(file.value=="")
		{ 
		alert("Please Select Car Image..!")
		file.focus();
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
      <div id="title">ADD CAR DETAILS</div>
      <div id="work">
      	<form action="actionCabService.php" method="post" onSubmit="return validation(this);" enctype="multipart/form-data">
        <input type="hidden" name="avalue" value="5"/>
   <table width="194" height="112" border="0" align="center">
  <tr>
    <td>
      <div align="center">       
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
        <input type="text" name="carname" id="txt1" placeholder="Enter Car Name">
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
        <input type="text" name="carno" id="txt1" placeholder="Enter Car Number">
      </div></td>
  </tr>
   <tr>
    <td>
      <div align="center">
     <input name="file" type="file" id="txt1">
      </div></td>
  </tr>
  <tr>
    <td><div align="center">
      <input type="submit" name="Add" id="btn1" value="Add Car">
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
        <li><a href="AddCab.php" class="active">Add Cab</a></li>		
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
