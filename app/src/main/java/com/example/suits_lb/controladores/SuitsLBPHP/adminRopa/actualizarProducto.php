<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$codRopa =$_POST['codRopa'];
$nombreRopa =$_POST['nombreRopa'];
$descripcionRopa =$_POST['descripcionRopa'];
$codCategoria =$_POST['codCategoria'];
$availableSale =$_POST['availableSale'];
$stockProduct =$_POST['stockProduct'];
$priceProduct =$_POST['priceProduct'];
$imageProduct =$_POST['imageProduct'];


$query ="UPDATE ropa SET nombre ='$nombreRopa', descripcion ='$descripcionRopa', categoria = '$codCategoria',precio = '$priceProduct',stock = '$stockProduct',
                     ventaDisponible = '$availableSale', imgProducto = '$imageProduct'
         WHERE codRopa LIKE '$codRopa'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "ropa actualizada";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>