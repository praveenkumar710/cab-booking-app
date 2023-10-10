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
      <div id="title">VIEW CAB DRIVERS DETAILS</div>
      <div id="work1">
      	<table width="648" height="32" border="0">
  		<tr height="35" align="center" style="font-weight:bold; color:#ffffff; background-color:#800000">
        <th width="45">CAB DRIVER ID</th>
        <th width="45">CITY NAME</th>
        <th width="45">CAB TYPE</th>
        <th width="45">DRIVER NAME</th>
        <th width="70">LICENCE NO</th>
        <th width="84">CONTACT NO</th>
        <th width="110">EMAIL ID</th>
        <th width="136">DELETE</th>                                                                         
  		</tr>
        <?php	 
		error_reporting(error_reporting() & ~E_NOTICE);
 		include('dbcon.php');		
		
		$result=mysql_query("select * from cabdriver");
		while($rec = mysql_fetch_assoc($result))
		{
			 print"<tr align='center' style='color:#000000; background-color:#999999'>";
			 print"<td>";
			 echo $rec['cabdid'];
			 print"</td><td>";
			 echo $rec['cname'];
			 print"</td><td>";
			 echo $rec['cartype'];
			 print"</td><td>";	
			 echo $rec['dname'];
			 print"</td><td>";	
			 echo $rec['lno'];			 
			 print"</td><td>";
			 echo $rec['cno'];
			 print"</td><td>";
			 echo $rec['email'];	
			 print"</td><td>";				 
			 echo"
			 <form action='actionCabService.php' method='post'>
			 <input type='hidden' name='avalue' value='9'/>
			 <input type='hidden' name='cabdid' value='".$rec['cabdid']."' />
			 <input type='submit' name='Delete' value='DELETE' id='btn2'/>
			 </form>
			 ";	 	 						 		
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
