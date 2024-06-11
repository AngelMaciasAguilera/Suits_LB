<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$adminEmail = $_POST['adminEmail'];
$adminPassword = $_POST['adminPassword'];
$adminName = $_POST['adminName'];
$adminPhone = $_POST['adminPhone'];
$adminAge = $_POST['adminAge'];
$adminProperties = $_POST['adminProperties'];



$query ="UPDATE clientes SET nombre ='$adminName', password = '$adminPassword', telefono = '$adminPhone', edad = '$adminAge', esAdmin = '$adminProperties' WHERE email LIKE '$adminEmail'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos actualizados";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>