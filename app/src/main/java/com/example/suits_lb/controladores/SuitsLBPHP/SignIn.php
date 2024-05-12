<?php

include 'conexion.php';
$nombre = $_POST['nombre'];
$edad = $_POST ['edad'];
$phone = $_POST['phone'];
$email =$_POST['email'];
$password =$_POST['password'];
$iconoCliente = $_POST['iconoCliente'];


// aqui escribimos codigo sql
$query ="INSERT INTO clientes(email,password,nombre,telefono,edad,iconoCliente,esAdmin) values('$email' ,'$password','$nombre','$phone','$edad','$iconoCliente','N')";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "registro ok";
}else{
    echo "registro error";
}
mysqli_close($conexion);

?>