<?php
	error_reporting(error_reporting() & ~E_NOTICE);

	$response = array();
	
	include('adbcon.php');	
	
	if(isset($_GET['did']))
	{	
		$did=$_GET['did'];
		$bid=$_GET['bid'];
		$cname=$_GET['cname'];
	
		$result = mysql_query("select * from cabbooking where did='$did' AND status='Drop' AND bid='$bid' AND cname='$cname'");
		
		if(mysql_num_rows($result)>0) 
		{		
			$response['details'] = array();
					
			while($rs=mysql_fetch_assoc($result)) 
			{			
				$vpost = array();			
				$vpost['a1'] = $rs['cname'];
				$vpost['a2'] = $rs['ccmt'];												
				
				array_push($response['details'], $vpost);							
			}		
			$response['success'] = 1; 
			$response['message'] = "Record Found"; 
			
			echo json_encode($response);			
		}
		else
		{
			$response['success'] = 2; 
			$response['message'] = "Record Not Found";
			
			echo json_encode($response);	
		}
	}
	
?>