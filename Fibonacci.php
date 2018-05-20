<html>
<head><title> Encryption with Fibonacci </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
</head>
<body bgcolor="#bfbfbf" text="#000000">
<form action="Fibonacci.php" method="post">
<br><br><br>
<fieldset>
<br><br><font size="6" id="renk"> Encryption app with Fibonacci</font><br><br><br><br>
<font size="4">Your Message:  </font> <input type="text" name="message"/><br><br>
<input type="submit" name="submit" value="Encrypt" id="button" style="font-size : 17px"/>
<input type="submit" name="submit" value="Decrypt" id="button" style="font-size : 17px"/>
</fieldset>
</form class="form"></body></html>

<?php
if($_POST['submit']=='Encrypt'){

    $fibonacci = array(0,1,1,2,3,5,8,1,3,2,1,3,4,5,5,8,9,1,4,4,2,3,3,3,7,7,6,1,0,9,8,7,1,5,9,7,2,5,8,4,4,1,8,1,6,7,6,5,1,0,9,4,6);
    $context = str_split($_POST['message']);
    for($i=0; $i<count($context); $i++){
        $variance = $context[$i];
        
        if($variance >= 'a' && $variance <= 'z'){
            
            $variance = ord($variance) + $fibonacci[$i];
            
            if($variance > 122){
                $variance = $variance - 26; 
            }
            
            $context[$i] = chr($variance);
        }
        else if($variance >= 'A' && $variance <= 'Z'){
            $variance = ord($variance) + $fibonacci[$i];
            
            if($variance > 90){
                $variance = $variance - 26; 
            }
            
            $context[$i] = chr($variance);
        }
    }
    echo "Encrypted Message: ";
    for($a=0;$a<count($context);$a++){
    echo $context[$a];
    }
}
elseif ($_POST['submit']=='Decrypt') {
    $fibonacci = array(0,1,1,2,3,5,8,1,3,2,1,3,4,5,5,8,9,1,4,4,2,3,3,3,7,7,6,1,0,9,8,7,1,5,9,7,2,5,8,4,4,1,8,1,6,7,6,5,1,0,9,4,6);
    $context = str_split($_POST['message']);
    for($i=0; $i<count($context); $i++){
        $variance = $context[$i];
        
        if($variance >= 'a' && $variance <= 'z'){
            
            $variance = ord($variance) - $fibonacci[$i];
            
            if($variance < 97){
                $variance = $variance + 26; 
            }
            
            $context[$i] = chr($variance);
        }
        else if($variance >= 'A' && $variance <= 'Z'){
            $variance = ord($variance) - $fibonacci[$i];
            
            if($variance < 65){
                $variance = $variance + 26; 
            }
            
            $context[$i] = chr($variance);
        }
    }
    echo "Decrypted message: ";
    for($a=0;$a<count($context);$a++){
    echo $context[$a];
    }
}
    
?>