<?php 
include 'conexion.php';

$email =$_POST['email'];
$password =$_POST['password'];

$result= array();
$result['clientes'] =array();
$query ="SELECT * FROM clientes WHERE email LIKE '$email' AND password LIKE '$password' ";
$response = mysqli_query($conexion,$query);
if($row = mysqli_fetch_array($response))
{
    echo "La autenticacion ha sido correcta";
}else{
    echo "Los datos introducidos no son correctos";
}

?>