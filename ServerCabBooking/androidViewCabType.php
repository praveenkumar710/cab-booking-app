<?php
	error_reporting(error_reporting() & ~E_NOTICE);

	$response = array();
	
	include('adbcon.php');	
	
	if(isset($_GET['cityname']))
	{	
		$sql=mysql_query("select * from cabdriver");
		if($rs1=mysql_fetch_assoc($sql))
		{
			$result = mysql_query("select * from cabtype where cname='".$rs1['cname']."'");		
			if(mysql_num_rows($result)>0) 
			{		
				$response['details'] = array();
					
				while($rs=mysql_fetch_assoc($result)) 
				{			
					$vpost = array();			
					$vpost['a1'] = $rs['cname'];
					$vpost['a2'] = $rs['cartype'];
				
					$sql=mysql_query("select * from cars where cartype='".$rs['cartype']."'");
					if($rs1=mysql_fetch_assoc($sql))
					{				 
						$vpost['a3'] = $rs1['carimage'];
					}
								
					$vpost['a4'] = $rs['mcharge'];	
					$vpost['a5'] = $rs['fkm'];	
					$vpost['a6'] = $rs['wcharge'];	
					$vpost['a7'] = $rs['echarge'];	
				
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
	}
	
?>