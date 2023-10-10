<?php
include_once 'adbcon.php';

$response = array();

if (isset($_POST['cid'])) 
{    
    $cid = $_POST['cid'];	
	$cname = $_POST['cname'];			
	$cno = $_POST['cno'];
	$email = $_POST['email'];
	
	$cityname = $_POST['cityname'];	
	$cabtype = $_POST['cabtype'];
	
	$mcharge="";
	$fkm="";
	$wcharge="";
	$echarge="";	
	
	$sql= mysql_query("SELECT * FROM cabtype WHERE cname='$cityname' AND cartype='$cabtype'");   
	if ($rs=mysql_fetch_array($sql))
	{
		$mcharge=$rs['mcharge'];
		$fkm=$rs['fkm'];
		$wcharge=$rs['wcharge'];
		$echarge=$rs['echarge'];
	}
	
	$did="";
	$dname="";
	$dcno="";
	$demail="";
	
	$sql1= mysql_query("SELECT * FROM cabdriver WHERE cname='$cityname' AND cartype='$cabtype'");   
	if ($rs1=mysql_fetch_array($sql1))
	{
		$did=$rs1['did'];
		$dname=$rs1['dname'];
		$dcno=$rs1['cno'];
		$demail=$rs1['email'];
	}
		
	$parea = $_POST['parea'];	
	$darea = $_POST['darea'];
	$pdate = $_POST['pdate'];	
	$ptime = $_POST['ptime'];
	
	$bdate=date('Y-m-d');	
	date_default_timezone_set('Asia/Kolkata');
	$btime=date('h:i:s A',time());	
	
	$result = mysql_query("SELECT * FROM cabbooking WHERE cid='$cid' OR cno='$cno' AND cityname='$cityname' AND cabtype='$cabtype' AND status='Booking'");
   
	if (mysql_fetch_array($result)){
		
		$response["success"] = 2;
        $response["message"] = "Cab Already Booking...!";       
        echo json_encode($response);
	}
	else{
	
		$result = mysql_query("INSERT INTO cabbooking(cid,cname,cno,cemail,cityname,cabtype,mcharge,fkm,wcharge,echarge,did,dname,dcno,demail,parea,darea,pdate,ptime,tkm,twcharge,tamount,bdate,btime,status) VALUES('$cid','$cname','$cno','$email','$cityname','$cabtype','$mcharge','$fkm','$wcharge','$echarge','$did','$dname','$dcno','$demail','$parea','$darea','$pdate','$ptime','','','','$bdate','$btime','Booking')");
    
		if ($result){        
        $response["success"] = 1;
        $response["message"] = "Cab Booking Successfully...!";
        
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