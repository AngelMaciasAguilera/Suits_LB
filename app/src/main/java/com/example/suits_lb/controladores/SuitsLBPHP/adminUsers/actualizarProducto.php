<?php 

include 'conexion.php';

$idProducto =$_POST['idProducto'];
$nombre =$_POST['nombre'];
$precio =$_POST['precio'];


$query ="UPDATE productos SET nombreProducto ='$nombre', precio ='$precio' WHERE idProducto LIKE '$idProducto'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos actualizados";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>