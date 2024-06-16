<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$codRopa = $_POST['codRopa'];
$nomRopa = $_POST['nombreRopa'];
$descripcionRopa = $_POST['descripcionRopa'];
$precioRopa = $_POST['precioRopa'];
$catRopa = $_POST['catRopa'];
$imgRopa = $_POST['imgRopa'];
$ventaDisponibleRopa = $_POST['ventaDisponibleRopa'];

// Comprobar si el código de ropa ya está insertado
$checkQuery = "SELECT * FROM ropa WHERE codRopa = '$codRopa'";
$checkResult = mysqli_query($conexion, $checkQuery);

if(mysqli_num_rows($checkResult) > 0){
    echo "El código de ropa ya está insertado";
} else {
    // Si el código de ropa no existe, insertar los datos
    $query = "INSERT INTO `ropa`(`codRopa`, `nombre`, `descripcion`, `precio`, `categoria`, `ventaDisponible`, `imgProducto`) VALUES ('$codRopa', 
    '$nomRopa', 
    '$descripcionRopa',
    '$precioRopa',
    '$catRopa',
    '$ventaDisponibleRopa', 
    '$imgRopa'
    )";
    $resultado = mysqli_query($conexion, $query);

    if($resultado){
        echo "ropa insertada";
    } else {
        echo "Ropa no insertada";
    }
}

mysqli_close($conexion);

?>
