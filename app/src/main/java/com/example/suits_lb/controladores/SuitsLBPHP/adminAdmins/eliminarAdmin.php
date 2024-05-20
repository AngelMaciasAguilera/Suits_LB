<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$adminEmail = $_POST["adminEmail"];
$query = "DELETE FROM clientes WHERE email LIKE '$adminEmail'";
$result=mysqli_query($conexion,$query);
if($result){
    echo "datos eliminados";
}else{
    echo "error";
}

mysqli_close($conexion);

?>