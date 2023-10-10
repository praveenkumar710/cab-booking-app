<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['cid']) && isset($_POST['opass'])) 
{    
    $cid = $_POST['cid'];	
	$opass = $_POST['opass'];
	$npass = $_POST['npass'];
	
	$result = mysql_query("update customer set skey='$npass' where customer_id='$cid' AND skey='$opass'");
   
	if ($result){        
        $response["success"] = 1;
        $response["message"] = "Password Change Successfully...!";
        
        echo json_encode($response);
		} 
	else {        
        $response["success"] = 0;
        $response["message"] = "Old Password Incorrrect.";        
       
        echo json_encode($response);					
		}
				
} 
else {    
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
   
    echo json_encode($response);
}
?>