<?php
$clientId = "AdDDdD1z9U_RgaS7cE93k8D_ZKogQU0DLmLv9xVCuTQ9KMNxr_kPHeYjQBTj7hmQGt_DEdKSuvghBflB";
$secret = "EHJW2NqLrWnLZC4z3n_Lc2lMVKFMPDltzQPgkrE0F_2jlWI645A4h_xWAEqCHDvFpu83rG759X0QNEIa";

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "https://api.sandbox.paypal.com/v1/oauth2/token");
curl_setopt($ch, CURLOPT_HEADER, false);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); 
curl_setopt($ch, CURLOPT_USERPWD, $clientId.":".$secret);
curl_setopt($ch, CURLOPT_POSTFIELDS, "grant_type=client_credentials");

$response = curl_exec($ch);
if(empty($response)) die("Error: No response.");
$json = json_decode($response);
$accessToken = $json->access_token;
curl_close($ch);

// Datos de la transacción
$totalPrice = $_POST['totalPrice'];
$email = $_POST['email'];
$address = $_POST['address'];

// Crear el pago
$paymentData = json_encode(array(
    "intent" => "sale",
    "redirect_urls" => array(
        "return_url" => "nativexo://paypalpay",
        "cancel_url" => "nativexo://paypalpay"
    ),
    "payer" => array(
        "payment_method" => "paypal",
        "payer_info" => array(
            "email" => $email
        )
    ),
    "transactions" => array(array(
        "amount" => array(
            "total" => $totalPrice,
            "currency" => "EUR" // Moneda en euros
        ),
        "description" => "Compra TFG",
        "item_list" => array(
            "shipping_address" => array(
                "recipient_name" => "Comprador",
                "line1" => $address,
                "city" => "Ciudad",
                "state" => "Estado",
                "postal_code" => "Código Postal",
                "country_code" => "ES" // País España
            )
        )
    ))
));

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "https://api.sandbox.paypal.com/v1/payments/payment");
curl_setopt($ch, CURLOPT_HEADER, false);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); 
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    "Authorization: Bearer ".$accessToken,
    "Content-Type: application/json"
));
curl_setopt($ch, CURLOPT_POSTFIELDS, $paymentData);

$response = curl_exec($ch);
curl_close($ch);

$json = json_decode($response);

echo $json;
?>