<?php
	error_reporting(error_reporting() & ~E_NOTICE);
	include('dbcon.php');
	
	$avalue=$_POST['avalue'];	
	
	switch ($avalue) 
	{
    	case "1":		
		
		$cname=$_POST['cname'];			
		
		$cmd="select * from city_name where cname='$cname'";
		$cmd1=mysql_query($cmd);
		if($rs=mysql_fetch_array($cmd1))
		{
			echo '<script type="text/javascript">alert("City Name Already Added...!");window.location=\'CabService.php\';</script>';
		}
		else 
		{			
			$query="insert into city_name(cname) values('$cname')";
			if(mysql_query($query))
			{				
				echo '<script type="text/javascript">alert("City Name Add Successfully...!");window.location=\'ViewCity.php\';</script>';
			}			
		}	
        break;	
		
		case "2":		
		
		$cid=$_POST['cid'];			
		$query="delete from city_name where cid='$cid'";
		if(mysql_query($query))
		{				
			header("location:ViewCity.php");	
		}	
		
		case "3":		
		
		$cname=$_POST['cname'];	
		$aname=$_POST['aname'];			
		
		$cmd="select * from area_name where cname='$cname' AND aname='$aname'";
		$cmd1=mysql_query($cmd);
		if($rs=mysql_fetch_array($cmd1))
		{
			echo '<script type="text/javascript">alert("Area Name Already Added...!");window.location=\'AddArea.php\';</script>';
		}
		else 
		{			
			$query="insert into area_name(cname,aname) values('$cname','$aname')";
			if(mysql_query($query))
			{				
				echo '<script type="text/javascript">alert("Area Name Add Successfully...!");window.location=\'ViewArea.php\';</script>';
			}			
		}	
        break;	
		
		case "4":		
		
		$aid=$_POST['aid'];			
		$query="delete from area_name where aid='$aid'";
		if(mysql_query($query))
		{				
			header("location:ViewArea.php");	
		}			
        break;
		
		case "5":		
		
		$ctype=$_POST['cartype'];	
		$cname=$_POST['carname'];	
		$cno=$_POST['carno'];
		
		$file=$_FILES['file']['tmp_name'];
		$data= addslashes(file_get_contents($_FILES['file']['tmp_name']));
		$data_name= addslashes($_FILES['file']['name']);
		move_uploaded_file($_FILES["file"]["tmp_name"],"Cab/" . $_FILES["file"]["name"]);
		$location="Cab/" . $_FILES["file"]["name"];			
		
		$cmd="select * from cars where cartype='$ctype'";
		$cmd1=mysql_query($cmd);
		if($rs=mysql_fetch_array($cmd1))
		{
			echo '<script type="text/javascript">alert("Car Details Already Added...!");window.location=\'AddCab.php\';</script>';
		}
		else 
		{			
			$query="insert into cars(cartype,carname,carno,carimage) values('$ctype','$cname','$cno','$location')";
			if(mysql_query($query))
			{				
				echo '<script type="text/javascript">alert("Car Details Add Successfully...!");window.location=\'ViewCab.php\';</script>';
			}			
		}	
        break;
		
		case "6":		
		
		$carid=$_POST['carid'];			
		$query="delete from cars where carid='$carid'";
		if(mysql_query($query))
		{				
			header("location:ViewCab.php");	
		}			
        break;	
		
		case "7":		
		
		$cname=$_POST['cname'];	
		$cartype=$_POST['cartype'];	
		$mcharge=$_POST['mcharge'];	
		$fkm=$_POST['fkm'];	
		$wcharge=$_POST['wcharge'];	
		$echarge=$_POST['echarge'];			
		
		$cmd="select * from cabtype where cname='$cname' AND cartype='$cartype'";
		$cmd1=mysql_query($cmd);
		if($rs=mysql_fetch_array($cmd1))
		{
			echo '<script type="text/javascript">alert("Cab Type Already Added...!");window.location=\'AddCabType.php\';</script>';
		}
		else 
		{			
			$query="insert into cabtype(cname,cartype,mcharge,fkm,wcharge,echarge) values('$cname','$cartype','$mcharge','$fkm','$wcharge','$echarge')";
			if(mysql_query($query))
			{				
				echo '<script type="text/javascript">alert("Cab Type Add Successfully...!");window.location=\'ViewCabType.php\';</script>';
			}			
		}	
        break;	
		
		case "7":		
		
		$cabid=$_POST['cabid'];	
				
		$query="delete from cabtype where cabid='$cabid'";
		if(mysql_query($query))
		{				
			header("location:ViewCabType.php");	
		}			
        break;
		
		case "8":		
		
		$cname=$_POST['cname'];	
		$cartype=$_POST['cartype'];	
		$did=$_POST['did'];	
		$dname=$_POST['dname'];	
		$lno=$_POST['lno'];	
		$cno=$_POST['cno'];	
		$email=$_POST['email'];			
		
		$cmd="select * from cabdriver where did='$did'";
		$cmd1=mysql_query($cmd);
		if($rs=mysql_fetch_array($cmd1))
		{
			echo '<script type="text/javascript">alert("Cab Driver Already Added...!");window.location=\'CabDrivers.php\';</script>';
		}
		else 
		{			
			$query="insert into cabdriver(cname,cartype,did,dname,lno,cno,email) values('$cname','$cartype','$did','$dname','$lno','$cno','$email')";
			if(mysql_query($query))
			{				
				echo '<script type="text/javascript">alert("Cab Driver Add Successfully...!");window.location=\'ViewCabDrivers.php\';</script>';
			}			
		}	
        break;	
		
		case "9":		
		
		$cabdid=$_POST['cabdid'];	
				
		$query="delete from cabdriver where cabdid='$cabdid'";
		if(mysql_query($query))
		{				
			header("location:ViewCabDrivers.php");	
		}			
        break;
				
		  	
    	default:
        header("location:index.php");	
	}	
	
?>
