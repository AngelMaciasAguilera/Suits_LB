<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$codCategory = $_POST["codCategory"];
$query = "DELETE FROM categorias WHERE codCategoria LIKE '$codCategory'";
$result=mysqli_query($conexion,$query);
if($result){
    echo "datos eliminados";
}else{
    echo "error";
}

mysqli_close($conexion);

?>