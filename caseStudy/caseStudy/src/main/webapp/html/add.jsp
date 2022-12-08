<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="../style/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,500;0,700;0,900;1,300;1,500&display=swap" rel="stylesheet">
    <title>Document</title>
    <style>
        .form-group{
            margin-bottom: 10px;
        }
    </style>
</head>
<body style="display:flex ; justify-content: center; align-items: center; flex-direction: column;" >
    <h2>Add customer</h2>
    <form action="" method="post" class="form-main" style="width:50% ;" >
        <div class="form-group">
          <label for="exampleInputEmail1">Customer id</label>
          <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Customer id" name="customer-id">
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">customer type id</label>
          <input type="number" name="customer-type-id"class="form-control" id="exampleInputPassword1" placeholder="customer type id">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Customer name</label>
            <input type="text" name="customer-name" class="form-control" id="exampleInputPassword1" placeholder="customer name">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">customer birthday</label>
            <input type="date" name="customer-birthday" class="form-control"id="exampleInputPassword1" placeholder="Password" style="width: 30%;">
          </div>
         
          <div class="form-group">
            <label for="inputState">Genger</label>
            <select id="inputState" name="customer-gender" class="form-control" style="width: 30%;">
              <option selected value="0">Male</option>
              <option value="1">Female</option>
            </select>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">customer id card</label>
            <input type="number" name="customer-id-card" class="form-control"id="exampleInputPassword1" placeholder="customer-id-card" style="width: 30%;">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">customer phone</label>
            <input type="text" name="customer-phone" class="form-control"id="exampleInputPassword1" placeholder="customer phone" style="width: 50%;">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">customer email</label>
            <input type="email" name="customer-email" class="form-control"id="exampleInputPassword1" placeholder="customer email" >
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">customer address</label>
            <input type="text" name="customer-address" class="form-control"id="exampleInputPassword1" placeholder="customer address" >
          </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>