<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$codRopa = $_POST["codRopa"];
$query = "DELETE FROM ropa WHERE codRopa LIKE '$codRopa'";
$result=mysqli_query($conexion,$query);
if($result){
    echo "ropa eliminada";
}else{
    echo "error";
}

mysqli_close($conexion);

?>