<?php 

include 'conexion.php';
$email = $_POST['email'];
$idProducto =$_POST['idProducto'];
$nombre =$_POST['nombreProducto'];
$precio =$_POST['precio'];


// aqui escribimos codigo sql
$query ="INSERT INTO productos(email,idProducto,nombreProducto,precio) values('$email','$idProducto' ,'$nombre', '$precio') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos insertados";
}else{
    echo "datos no insertados";
}
mysqli_close($conexion);

?>