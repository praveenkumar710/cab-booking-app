<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>An Efficient Android App Monitoring For Cab Booking And Servicing</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="header">	
</div>
<div id="content">
	<div id="colOne">
	  <div id="ihome4">
      <div id="title">VIEW CITY DETAILS</div>
      <div id="work">
      	<table width="550">
  		<tr height="35" align="center" style="font-weight:bold; color:#000; background-color:#2B95FF">
        <th width="160">CITY ID</th>
        <th width="251">CITY NAME</th> 
        <th width="123">DELETE</th>                                                                                      
  		</tr>
        <?php	 
		error_reporting(error_reporting() & ~E_NOTICE);
 		include('dbcon.php');	
		
		$result=mysql_query("select * from city_name");
		while($rec = mysql_fetch_assoc($result))
		{
			 print"<tr align='center' style='color:#000000; background-color:#ffffff'>";
			 print"<td>";
			 echo $rec['cid'];
			 print"</td><td>";	
			 echo $rec['cname'];			
			 print"</td><td>";						 
			 echo "<form action='actionCabService.php' method='post'>
			 		<input type='hidden' name='avalue' value='2'/>
					<input type='hidden' name='cid' value='".$rec['cid']."'/>
			 		<input type='submit' name='Delete' value='Delete' id='btn2'/>
					</form>";		 		
	 		 print"</td>";
	 		 print"</tr>";  
		}  
	  ?>  
		</table> 
      </div>
      </div>	
	</div>
	<div id="colTwo">
    <h2>Menu</h2>				
	<ul>		
		<li><a href="CabService.php">Add City</a></li>
        <li><a href="ViewCity.php" class="active">View City</a></li>	
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
