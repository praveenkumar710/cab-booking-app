<?php
	error_reporting(error_reporting() & ~E_NOTICE);
	include('dbcon.php');
	
	$avalue=$_POST['avalue'];	
	
	switch ($avalue) 
	{
    	case "1":	
			
		$lid=$_POST['lid'];
		$lpass=$_POST['lpass'];
				
		$cmd="select * from cab_server where lid='$lid' AND lpass='$lpass'";
		$cmd1=mysql_query($cmd);		
		if($rs=mysql_fetch_array($cmd1))
    	{							
			header("location:SHome.php");	
		}		
		else
		{
			echo '<script type="text/javascript">alert("Cab Server Login ID and Password Incorrect...!");window.location=\'Server.php\';</script>';				
		}	        
        break; 	
				
		  	
    	default:
        header("location:index.php");	
	}	
	
?>
