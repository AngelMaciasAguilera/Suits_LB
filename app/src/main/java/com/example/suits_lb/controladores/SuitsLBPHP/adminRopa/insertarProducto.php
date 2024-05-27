<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$codRopa = $_POST['codRopa'];
$nomRopa =$_POST['nombreRopa'];
$descripcionRopa = $_POST['descripcionRopa'];
$precioRopa = $_POST['precioRopa'];
$catRopa = $_POST['catRopa'];
$stockRopa = $_POST['stockRopa'];
$imgRopa = $_POST['imgRopa'];
$ventaDisponibleRopa = $_POST['ventaDisponibleRopa'];


// aqui escribimos codigo sql
$query ="INSERT INTO `ropa`(`codRopa`, `nombre`, `descripcion`, `precio`, `categoria`, `stock`, `ventaDisponible`, `imgProducto`) VALUES ('$codRopa', 
'$nomRopa', 
'$descripcionRopa',
'$precioRopa',
'$catRopa',
'$stockRopa',
'$ventaDisponibleRopa', 
'$imgRopa'
)";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "ropa insertada";
}else{
    echo "ropa no insertada";
}
mysqli_close($conexion);

?>