<?php
	error_reporting(error_reporting() & ~E_NOTICE);

	$response = array();
	
	include('adbcon.php');	
	
	if(isset($_GET['cid']))
	{	
		$cid=$_GET['cid'];
	
		$result = mysql_query("select * from cabbooking where cid='$cid' AND status!='Drop'");
		
		if(mysql_num_rows($result)>0) 
		{		
			$response['details'] = array();
					
			while($rs=mysql_fetch_assoc($result)) 
			{			
				$vpost = array();			
				$vpost['a1'] = $rs['bid'];
				$vpost['a2'] = $rs['pdate'];
				$vpost['a3'] = $rs['ptime'];
				$vpost['a4'] = $rs['dname'];	
				$vpost['a5'] = $rs['dcno'];	
				$vpost['a6'] = $rs['cityname'];	
				$vpost['a7'] = $rs['parea'];
				$vpost['a8'] = $rs['bdate']."/".$rs['btime'];	
				$vpost['a9'] = $rs['status'];		
				
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
		}
	}
	
?>