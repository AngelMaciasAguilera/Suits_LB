<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$userEmail = $_POST["userEmail"];
$query = "DELETE FROM notificaciones WHERE email = '$userEmail'";
$result=mysqli_query($conexion,$query);
if($result){
    echo "datos eliminados";
}else{
    echo "error";
}

mysqli_close($conexion);

?>