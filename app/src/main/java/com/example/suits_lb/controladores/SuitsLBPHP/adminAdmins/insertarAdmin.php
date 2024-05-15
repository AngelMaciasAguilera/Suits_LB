<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$adminEmail = $_POST['adminEmail'];
$adminPassword = $_POST['adminPassword'];
$adminName = $_POST['adminName'];
$adminPhone = $_POST['adminPhone'];
$adminAge = $_POST['adminAge'];
$adminProperties = $_POST['adminProperties'];


// aqui escribimos codigo sql
$query ="INSERT INTO productos(email,password,nombre,telefono,edad,iconoCliente,esAdmin) values('$adminEmail','$adminPassword' ,'$adminName', '$adminPhone','$adminAge',NULL,'S') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos insertados";
}else{
    echo "datos no insertados";
}
mysqli_close($conexion);

?>