<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$codCategoria = $_POST['codCategoria'];
$nombreCategoria = $_POST['nombreCategoria'];



$query ="UPDATE categorias SET nombreCategoria ='$nombreCategoria' WHERE codCategoria LIKE '$codCategoria'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos actualizados";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>