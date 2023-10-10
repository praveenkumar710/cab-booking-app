<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['lid']) && $_POST['lpass']) {
    
	$lid = $_POST['lid'];
	$lpass = $_POST['lpass'];    
   
    $result = mysql_query("SELECT * FROM driver WHERE cno = '$lid'");
   
	if ($rs=mysql_fetch_array($result)) 
	{        				
		if($lpass==$rs['skey'])
		{
			$response["success"] = 1;
		
			$response["did"] = $rs['driver_id'];
			$response["dname"] = $rs['name'];		
			$response["cno"] = $rs['cno'];
			$response["email"] = $rs['email'];
			$response["lno"] = $rs['lno'];	
				
			$response["message"] = "Login Successfull...!";
        
			echo json_encode($response);
		}
		elseif($lpass=='No_Key')
		{
			$response["success"] = 2;			
				
			$response["message"] = "Account Not Activate...!";
        
			echo json_encode($response);	
		}  
		else
		{
			$response["success"] = 3;			
				
			$response["message"] = "Incorrect Password...!";
        
			echo json_encode($response);	
		}
    } 
	else 
	{        
        $response["success"] = 0;
        $response["message"] = "Login Faild...!";
       
        echo json_encode($response);
    }	
} 
else 
{   
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
   
    echo json_encode($response);
}
?>