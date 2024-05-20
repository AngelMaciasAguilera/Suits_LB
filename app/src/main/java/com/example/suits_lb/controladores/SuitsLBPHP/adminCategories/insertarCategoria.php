<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$codCategory = $_POST['codCategory'];
$nameCategory = $_POST['nameCategory'];

// aqui escribimos codigo sql
$query ="INSERT INTO categorias(codCategoria,nombreCategoria) values('$codCategory','$nameCategory') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "categoria insertada";
}else{
    echo "categoria no insertada";
}
mysqli_close($conexion);

?>