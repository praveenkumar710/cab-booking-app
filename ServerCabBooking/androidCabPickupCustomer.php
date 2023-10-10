<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['bid']) && isset($_POST['did'])) 
{    
    $bid = $_POST['bid'];	
	$did = $_POST['did'];
				
	$plat = $_POST['latvalue'];
	$plong = $_POST['longvalue'];		
	
	$result = mysql_query("update cabbooking set status='Pickup',plat='$plat',plong='$plong' where bid='$bid' AND did='$did'");
   
	if ($result){        
        $response["success"] = 1;
        $response["message"] = "Customer Pickuped...!";
        
        echo json_encode($response);
		} 
	else {        
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";        
       
        echo json_encode($response);					
		}
				
} 
else {    
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
   
    echo json_encode($response);
}
?>