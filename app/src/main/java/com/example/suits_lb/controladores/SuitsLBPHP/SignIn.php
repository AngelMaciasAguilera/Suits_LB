<?php

include 'conexion.php';

$email =$_POST['email'];
$password =$_POST['password'];
$nombre = $_POST['nombre'];
$phone = $_POST['phone'];
$edad = $_POST ['edad'];
$iconoCliente = $_POST['iconoCliente'];


// aqui escribimos codigo sql
$query ="INSERT INTO clientes(email,password,nombre,telefono,edad,iconoCliente,esAdmin) values('$email' ,'$password','$nombre','$phone','$edad','$iconoCliente','N')";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "Te has registrado correctamente";
}else{
    echo "registro error";
}
mysqli_close($conexion);

?>