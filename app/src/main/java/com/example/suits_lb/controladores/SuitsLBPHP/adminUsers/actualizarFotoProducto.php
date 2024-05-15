<?php 

include 'conexion.php';

$idProducto =$_POST['idProducto'];
$foto=$_POST['foto'];


$query ="UPDATE imagenesProducto SET imagenProducto ='$foto' WHERE idProducto LIKE '$idProducto'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos actualizados";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>