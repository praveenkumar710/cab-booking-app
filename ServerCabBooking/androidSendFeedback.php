<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['bid']) && isset($_POST['dname']) && isset($_POST['cid'])) 
{    
    $bid = $_POST['bid'];	
	$dname = $_POST['dname'];
	$dcno = $_POST['dcno'];
	$cid = $_POST['cid'];
	$ccmt = $_POST['ccmt'];
	
	$result = mysql_query("update cabbooking set ccmt='$ccmt' where bid='$bid' AND dname='$dname' AND cid='$cid'");
   
	if ($result){        
        $response["success"] = 1;
        $response["message"] = "Customer Droped...!";
        
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