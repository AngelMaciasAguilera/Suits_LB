<?php 

include 'conexion.php';
$email = $_POST['email'];
$idProducto =$_POST['idProducto'];
$imagenProducto =$_POST['imagenProducto'];


// aqui escribimos codigo sql
$query ="INSERT INTO imagenesproducto(email,idProducto,imagenProducto) values('$email','$idProducto' ,'$imagenProducto') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "foto insertada";
}else{
    echo "datos error";
}
mysqli_close($conexion);

?>