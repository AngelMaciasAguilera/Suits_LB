<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$emailUser = $_POST['emailUser'];
$mensaje = $_POST['mensaje'];

// aqui escribimos codigo sql
$query ="INSERT INTO `notificaciones`(`email`, `mensaje`) VALUES ('$emailUser','$mensaje')";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "notificacion insertada";
}else{
    echo "notificacion no insertada";
}
mysqli_close($conexion);

?>