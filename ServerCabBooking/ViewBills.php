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
      <div id="title">CUSTOMERS CAB BILLING DETAILS</div>
      <div id="work1">
         <table width="648" height="32" border="0">
  		<tr height="35" align="center" style="font-weight:bold; color:#ffffff; background-color:#800000">
        <th width="45">BOOKING ID</th>
        <th width="45">CAB TYPE</th>
        <th width="129">PICKUP DATE</th>
        <th width="84">PICKUP TIME</th>
        <th width="110">CUSTOMER NAME</th>
        <th width="110">CONTACT NO</th>
        <th width="110">CITY NAME</th>
        <th width="136">AREA NAME</th> 
        <th width="136">DRIVER NAME</th> 
        <th width="136">CONTACT NO</th> 
        <th width="136">PLATVALUE</th> 
        <th width="136">PLONGVALUE</th>
        <th width="136">DLATVALUE</th> 
        <th width="136">DLONGVALUE</th> 
        <th width="136">STATUS</th> 
       </tr>
        <?php	 
		error_reporting(error_reporting() & ~E_NOTICE);
 		include('dbcon.php');		
		
		$result=mysql_query("select * from cabbooking where status='Booking' OR status='Pickup'");
		while($rec = mysql_fetch_assoc($result))
		{
			 print"<tr align='center' style='color:#000000; background-color:#999999'>";
			 print"<td>";
			 echo $rec['bid'];
			 print"</td><td>";	
			 echo $rec['cabtype'];
			 print"</td><td>";	
			 echo $rec['pdate'];
			 print"</td><td>";	
			 echo $rec['ptime'];
			 print"</td><td>";
			 echo $rec['cname'];	
			 print"</td><td>";
			 echo $rec['cno'];		 
			 print"</td><td>";
			 echo $rec['cityname'];	
			 print"</td><td>";
			 echo $rec['parea'];
			 print"</td><td>";
			 echo $rec['dname'];
			 print"</td><td>";
			 echo $rec['dcno'];
			 print"</td><td>";
			 echo $rec['plat'];
			 print"</td><td>";
			 echo $rec['plong'];
			 print"</td><td>";
			 echo $rec['dlat'];
			 print"</td><td>";
			 echo $rec['dlong'];
			 print"</td><td>";
			 echo $rec['status'];					 
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
		<li><a href="Customers.php">Customers</a></li>
        <li><a href="CabBooking.php">Cab Booking</a></li>
        <li><a href="ViewBills.php" class="active">View Bills</a></li>
        <li><a href="SHome.php">Back</a></li>
	</ul>	
	</div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">	
</div>
<div align=center></div></body>
</html>
