<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['name'])) 
{    
    $name = $_POST['name'];	
	$gender = $_POST['gender'];			
	$cno = $_POST['cno'];
	$email = $_POST['email'];
	$city = $_POST['city'];	
	$state = $_POST['state'];	
	$address = $_POST['address'];	
	$pcode = $_POST['pcode'];
	$skey = $_POST['skey'];	
	$rdate=date("d/m/Y");
	
	$result = mysql_query("SELECT * FROM customer WHERE name='$name' OR cno='$cno' OR email='$email'");
   
	if (mysql_fetch_array($result)){
		
		$response["success"] = 2;
        $response["message"] = "Customer Already Register...!";       
        echo json_encode($response);
	}
	else{
	
		$result = mysql_query("INSERT INTO customer(name,gender,cno,email,city,state,address,pcode,skey,rdate) VALUES('$name','$gender','$cno','$email','$city','$state','$address','$pcode','$skey','$rdate')");
    
		if ($result){        
        $response["success"] = 1;
        $response["message"] = "Customer Register Successfully...!";
        
        echo json_encode($response);
		} 
		else {        
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";        
       
        echo json_encode($response);					
		}
	}			
} 
else {    
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
   
    echo json_encode($response);
}
?>