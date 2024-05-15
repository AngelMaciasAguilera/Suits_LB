<?php

include 'conexion.php';
$email =$_POST['email'];
$password =$_POST['password'];


// aqui escribimos codigo sql
$query ="INSERT INTO usuarios(email,password) values('$email' ,'$password') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "registro ok";
}else{
    echo "registro error";
}
mysqli_close($conexion);

?>