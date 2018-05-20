
<html>
<head><title> Encryption with Pi </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
</head>
<body bgcolor="#bfbfbf" text="#000000">
<form action="Pi.php" method="post">
<br><br><br>
<fieldset>
<br><br><font size="6" id="renk"> Encryption app with Pi</font><br><br><br><br>
<font size="4">Your Message:  </font> <input type="text" name="message"/><br><br>
<input type="submit" name="submit" value="Encrypt" id="button" style="font-size : 17px"/>
<input type="submit" name="submit" value="Decrypt" id="button" style="font-size : 17px"/>
</fieldset>
</form class="form"></body></html>

<?php
if($_POST['submit']=='Encrypt'){

    $pi = array(1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2,3,0,7,8,1,6,4,0,6,2,8,6,2,0,8,9,9,8,6,2,8,0,3,4,8,2,5,3,4,2,1,1,7,0,6,7);
    $context = str_split($_POST['message']);
    for($i=0; $i<count($context); $i++){
        $variance = $context[$i];
        
        if($variance >= 'a' && $variance <= 'z'){
            
            $variance = ord($variance) + $pi[$i];
            
            if($variance > 122){
                $variance = $variance - 26; 
            }
            
            $context[$i] = chr($variance);
        }
        else if($variance >= 'A' && $variance <= 'Z'){
            $variance = ord($variance) + $pi[$i];
            
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
   $pi = array(1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2,3,0,7,8,1,6,4,0,6,2,8,6,2,0,8,9,9,8,6,2,8,0,3,4,8,2,5,3,4,2,1,1,7,0,6,7);
    $context = str_split($_POST['message']);
    for($i=0; $i<count($context); $i++){
        $variance = $context[$i];
        
        if($variance >= 'a' && $variance <= 'z'){
            
            $variance = ord($variance) - $pi[$i];
            
            if($variance < 97){
                $variance = $variance + 26; 
            }
            
            $context[$i] = chr($variance);
        }
        else if($variance >= 'A' && $variance <= 'Z'){
            $variance = ord($variance) - $pi[$i];
            
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