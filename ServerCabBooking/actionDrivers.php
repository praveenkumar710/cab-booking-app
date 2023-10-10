<?php
	error_reporting(error_reporting() & ~E_NOTICE);
	include('dbcon.php');
	
	$avalue=$_POST['avalue'];	
	
	switch ($avalue) 
	{
    	case "1":		
		
		$did=$_POST['did'];
		$name=$_POST['name'];
		$email=$_POST['email'];	
		$skey=substr(md5(mt_rand()), 0, 10);
					
		$query="update driver set skey='$skey' where driver_id='$did'";
		if(mysql_query($query))
		{				
			//Mail
			$to = $email;
			$subject = "Cab Services:";
			$message = "Dear,".$name."\r\nYour Account is Activated."."\r\nLogin Password:".$skey;
			$from = "Cab Services:";
			$headers = "From:" . $from;
			mail($to,$subject,$message,$headers);
		
			echo '<script type="text/javascript">alert("Cab Driver Account Activate Successfully...!");window.location=\'CabDrivers.php\';</script>';
		}			
        break;	
		
		  	
    	default:
        header("location:index.php");	
	}	
	
?>
