<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['did']) && isset($_POST['opass'])) 
{    
    $did = $_POST['did'];	
	$opass = $_POST['opass'];
	$npass = $_POST['npass'];
	
	$result = mysql_query("update driver set skey='$npass' where driver_id='$did' AND skey='$opass'");
   
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