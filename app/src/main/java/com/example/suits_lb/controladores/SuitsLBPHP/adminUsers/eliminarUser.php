<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$userEmail = $_POST["userEmail"];
$query = "DELETE FROM clientes WHERE email LIKE '$userEmail'";
$result=mysqli_query($conexion,$query);
if($result){
    echo "datos eliminados";
}else{
    echo "error";
}

mysqli_close($conexion);

?>