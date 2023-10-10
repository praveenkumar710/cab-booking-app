<?php
	error_reporting(error_reporting() & ~E_NOTICE);

	$response = array();
	
	include('adbcon.php');	
	
	if(isset($_GET['cid']))
	{	
		$cid=$_GET['cid'];
	
		$result = mysql_query("select * from cabbooking where cid='$cid' AND status='Drop' AND ccmt=''");
		
		if(mysql_num_rows($result)>0) 
		{		
			$response['details'] = array();
					
			while($rs=mysql_fetch_assoc($result)) 
			{			
				$vpost = array();			
				$vpost['a1'] = $rs['bid'];
				$vpost['a2'] = $rs['dname'];
				$vpost['a3'] = $rs['dcno'];					
				$vpost['a4'] = $rs['cityname'];	
				$vpost['a5'] = $rs['cabtype'];	
				$vpost['a6'] = $rs['parea'];
				$vpost['a7'] = $rs['pdate']."/".$rs['ptime'];
				$vpost['a8'] = $rs['darea'];	
				$vpost['a9'] =  $rs['ddate']."/".$rs['dtime'];
								
				
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