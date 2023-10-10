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
		if(fdate.value=="")
		{ 
		alert("Please Select From Date...!")
		fdate.focus();
		return false 
		}
	}
	with(thisform)
	{	    
		if(tdate.value=="")
		{ 
		alert("Please Select To Date...!")
		tdate.focus();
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
      <div id="title">CAB BOOKING REPORT</div>
      <div id="sreport">
      	<form action="" method="post" onSubmit="return validation(this);">
        	<table width="367" border="0">
  <tr>
    <td width="62"><input type="date" name="fdate" id="txt1"></td>
    <td width="62"><input type="date" name="tdate" id="txt1"></td>
    <td width="166"><input type="submit" name="Add" id="btn1" value="View Report"></td>
  </tr>
</table>

        </form>
      </div>
      <div id="work1">
       <table width="648" height="32" border="0">
  		<tr height="35" align="center" style="font-weight:bold; color:#ffffff; background-color:#800000">
        <th width="45">BOOKING ID</th>
        <th width="129">BOOKING DATE</th>
        <th width="45">CAB TYPE</th>
        <th width="129">PICKUP DATE</th>
        <th width="84">PICKUP TIME</th>
        <th width="110">CUSTOMER NAME</th>
        <th width="110">CONTACT NO</th>
        <th width="110">CITY NAME</th>
        <th width="136">AREA NAME</th> 
        <th width="136">DRIVER NAME</th> 
        <th width="136">CONTACT NO</th> 
        <th width="136">DROP DATE</th> 
        <th width="136">DROP TIME</th>         
       </tr>
        <?php	 
		error_reporting(error_reporting() & ~E_NOTICE);
 		include('dbcon.php');		
		
		$result=mysql_query("select * from cabbooking where bdate between '".$_POST['fdate']."' AND '".$_POST['tdate']."'");
		while($rec = mysql_fetch_assoc($result))
		{
			 print"<tr align='center' style='color:#000000; background-color:#999999'>";
			 print"<td>";
			 echo $rec['bid'];
			 print"</td><td>";	
			 echo $rec['bdate'];
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
			 echo $rec['ddate'];
			 print"</td><td>";
			 echo $rec['dtime'];
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
		<li><a href="ServiceReport.php" class="active">Cab Booking Report</a></li>
        <li><a href="CabBillingReport.php">Cab Billing Report</a></li>
        <li><a href="SHome.php">Back</a></li>
	</ul>	
	</div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">	
</div>
<div align=center></div></body>
</html>
