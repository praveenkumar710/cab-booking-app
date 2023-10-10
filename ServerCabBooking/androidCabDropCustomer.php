<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['bid']) && isset($_POST['did'])) 
{    
    $bid = $_POST['bid'];	
	$did = $_POST['did'];
	
	$tkm = $_POST['tkm'];
	$twcharge = $_POST['twcharge'];
	
	
	$sql=mysql_query("select * from cabbooking where bid='$bid' AND did='$did'");
	if($rs=mysql_fetch_assoc($sql))
	{
		$tkm1=$tkm*$rs['echarge'];
		$twcharge1=$twcharge*$rs['wcharge'];
		$tamount=$rs['mcharge']+$tkm1+$twcharge1;
	}
				
	$dlat = $_POST['latvalue'];
	$dlong = $_POST['longvalue'];	
	
	$ddate=date('Y-m-d');	
	date_default_timezone_set('Asia/Kolkata');
	$dtime=date('h:i:s A',time());	
	
	$result = mysql_query("update cabbooking set tkm='$tkm',twcharge='$twcharge',tamount='$tamount',status='Drop',dlat='$dlat',dlong='$dlong',ddate='$ddate',dtime='$dtime' where bid='$bid' AND did='$did'");
   
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