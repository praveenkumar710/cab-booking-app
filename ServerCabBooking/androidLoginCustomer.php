<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['lid']) && $_POST['lpass']) {
    
	$lid = $_POST['lid'];
	$lpass = $_POST['lpass'];    
   
    $result = mysql_query("SELECT * FROM customer WHERE cno = '$lid' AND skey = '$lpass' ");
   
	if ($rs=mysql_fetch_array($result)) 
	{        				
        $response["success"] = 1;
		
		$response["cid"] = $rs['customer_id'];
		$response["cname"] = $rs['name'];		
		$response["cno"] = $rs['cno'];
		$response["email"] = $rs['email'];
				
        $response["message"] = "Login Successfull...!";
        
        echo json_encode($response);
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