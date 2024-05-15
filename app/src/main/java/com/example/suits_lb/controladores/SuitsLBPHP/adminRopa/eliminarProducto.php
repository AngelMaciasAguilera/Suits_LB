<?php 

include 'conexion.php';

$idProducto = $_POST["idProducto"];
$query = "DELETE FROM productos WHERE idProducto LIKE '$idProducto'";
$result=mysqli_query($conexion,$query);
if($result){
    echo "datos eliminados";
}else{
    echo "error";
}

mysqli_close($conexion);

?>